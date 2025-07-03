package com.kotak.orchestrator.orchestrator.consumer;

import com.kotak.orchestrator.orchestrator.failurehandler.FailureHandler;
import lombok.*;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;


/**
 * Configuration class for Kafka Consumers handling events of generic type {@code T}.
 *
 * <p>
 * This class encapsulates the configuration parameters required for setting up a Kafka consumer to
 * receive events in Avro format. It provides flexibility by allowing the specification of the
 * generic type for the deserialization of event values.
 *
 * <p>
 * Properties:
 * - {@code bootstrapServers}: The Kafka bootstrap servers' addresses.
 * - {@code topic}: The Kafka topic from which events will be consumed.
 * - {@code groupId}: The consumer group ID.
 * - {@code valueDeserializer}: The class of the deserializer for decoding Avro-encoded values.
 * - {@code processor}: The {@link MessageConsumer} responsible for processing the received events.
 * - {@Code securityProtocol}: Security protocol for msk authentication.
 *
 * @param <T> The generic type representing the deserialized value type of Kafka events.
 *            <p>
 *            Usage: - This class is used to configure a Kafka consumer with specific parameters for
 *            consuming Avro-encoded events. - The properties are set through the constructor or
 *            appropriate setter methods. - It is intended for use in conjunction with a Kafka
 *            consumer implementation, such as {@link GenericReactiveConsumer}, to handle the
 *            reception and processing of events.
 * @see GenericReactiveConsumer
 * @see MessageConsumer
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerConfiguration<T> {

    private String bootstrapServers;
    private String topic;
    private String groupId;
    private String awsRoleArn;
    private String awsStsRegion;
    private String awsStsSessionName;
    private String saslScramUsername;
    private String saslScramPassword;
    private Class<? extends Deserializer<T>> valueDeserializer;
    private int inMemoryPartitions;
    private int maxPollRecords;
    private String processorThreadPoolName;
    private MessageConsumer<T> processor;
    private DeferredCommitConfiguration deferredCommitConfig;
    private String securityProtocol;
    private FailureHandler<T> failureHandler;
    private DlqConfiguration<T> dlqConfig;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeferredCommitConfiguration {

        /**
         * Maximum number of messages that are not yet committed after which we pause the consumer to
         * apply backpressure.
         */
        private int maxDeferredCommits;

        /**
         * Frequency of committing the earliest contiguous offset (if possible) since the last commit
         * for a partition.
         * <p>
         * A commit is triggered (if possible) when either the commitIntervalMillis timer expires or the
         * batch size is exceeded.
         */
        private long commitIntervalMillis;

        /**
         * Maximum batch size after which the earliest contiguous offset (if possible) since the last
         * commit for a partition is committed.
         */
        private int commitBatchSize;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DlqConfiguration<T> {
        /**
         * dead-letter queue topic name, The failed consumer events will be published to.
         */
        private String dlqTopic;

        /**
         * Class to use for Serializing a Kafka message before publishing to
         */
        private Class<? extends Serializer> valueSerializer;
        private String awsRoleArn;
        private String awsRoleSessionName;
        private String awsStsRegion;
    }
}




package com.kotak.orchestrator.orchestrator.consumer;

import com.kotak.orchestrator.orchestrator.utils.MetricUtil;
import io.micrometer.core.instrument.binder.kafka.KafkaClientMetrics;
import io.micrometer.observation.ObservationRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import reactor.core.Disposable;
import reactor.core.observability.micrometer.Micrometer;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.ReceiverRecord;
import reactor.kafka.receiver.internals.ConsumerFactory;
import reactor.kafka.receiver.observation.KafkaReceiverObservation;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.kotak.orchestrator.orchestrator.utils.PartitionUtils.inMemoryPartitionId;


@Slf4j
public class GenericReactiveConsumer<T> extends Thread implements AutoCloseable {

    private final ConsumerConfiguration<T> config;
    private final KafkaReceiver<String, T> receiver;
    private final MetricUtil metricUtil;
    private Disposable flux;

    public GenericReactiveConsumer(ConsumerConfiguration<T> config, MetricUtil metricUtil) {
        log.info("Initializing GenericReactiveConsumer with config: {}", config);
        validateConfig(config);
        this.config = config;
        this.metricUtil = metricUtil;

        Properties props = buildKafkaProperties(config);
        ReceiverOptions<String, T> options = buildReceiverOptions(props, config);
        this.receiver = KafkaReceiver.create(new ReactiveConsumerFactory(), options);
        log.info("KafkaReceiver created");
    }

    private void validateConfig(ConsumerConfiguration<T> config) {
        if (config.getBootstrapServers() == null || config.getGroupId() == null ||
                config.getValueDeserializer() == null || config.getTopic() == null ||
                config.getDeferredCommitConfig() == null) {
            throw new IllegalArgumentException("Required configuration properties are missing");
        }
    }

    private Properties buildKafkaProperties(ConsumerConfiguration<T> config) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapServers());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, config.getGroupId());
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, "false");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, config.getMaxPollRecords());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, config.getValueDeserializer().getName());

        if ("AWS_MSK_IAM".equals(config.getSecurityProtocol())) {
            props.putAll(buildAwsSecurityProps(config));
        }

        return props;
    }

    private Map<String, Object> buildAwsSecurityProps(ConsumerConfiguration<T> config) {
        Map<String, Object> awsProps = new HashMap<>();
        String saslJaasConfig = String.format(
                "software.amazon.msk.auth.iam.IAMLoginModule required awsRoleArn=\"%s\" awsRoleSessionName=\"%s\" awsStsRegion=\"%s\";",
                config.getAwsRoleArn(), config.getAwsStsSessionName(), config.getAwsStsRegion()
        );
        awsProps.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
        awsProps.put(SaslConfigs.SASL_MECHANISM, "AWS_MSK_IAM");
        awsProps.put(SaslConfigs.SASL_JAAS_CONFIG, saslJaasConfig);
        awsProps.put(SaslConfigs.SASL_CLIENT_CALLBACK_HANDLER_CLASS, "software.amazon.msk.auth.iam.IAMClientCallbackHandler");
        return awsProps;
    }

    private ReceiverOptions<String, T> buildReceiverOptions(Properties props, ConsumerConfiguration<T> config) {
        var registry = ObservationRegistry.create();
        return ReceiverOptions.<String, T>create(props)
                .subscription(List.of(config.getTopic()))
                .commitInterval(Duration.ofMillis(config.getDeferredCommitConfig().getCommitIntervalMillis()))
                .maxDeferredCommits(config.getDeferredCommitConfig().getMaxDeferredCommits())
                .commitBatchSize(config.getDeferredCommitConfig().getCommitBatchSize())
                .withObservation(registry, KafkaReceiverObservation.DefaultKafkaReceiverObservationConvention.INSTANCE);
    }

    class ReactiveConsumerFactory extends ConsumerFactory {

        @Override
        public <K, V> Consumer<K, V> createConsumer(ReceiverOptions<K, V> config) {
            var consumer = super.createConsumer(config);
            var kmetrics = new KafkaClientMetrics(consumer);
            kmetrics.bindTo(metricUtil.getRegistry());
            return consumer;
        }
    }

    @Override
    public void run() {
        log.info("CROS Kafka consumer started successfully for topic: {}.", config.getTopic());
        var scheduler = scheduler();
        flux = receiver.receive()
                .doOnError(e -> log.error("Error receiving event in Kafka consumer. Will retry", e))
                .retryWhen(Retry.fixedDelay(60L, Duration.ofMinutes(1)))
                .groupBy(r -> inMemoryPartitionId(config.getProcessor().partitionKey(r.value()),
                        config.getInMemoryPartitions()))
                .flatMap(pf -> pf.publishOn(scheduler).map(this::processRecord))
                .subscribe();
        log.info("Kafka consumer stopped for topic: {}", config.getTopic());
    }

    private ReceiverRecord<String, T> processRecord(ReceiverRecord<String, T> message) {
        try (var timeIt = metricUtil.timeIt("MessageProcessingLatency")) {
            log.debug("Processing message: {} from topic: {}", message, config.getTopic());
            var startTime = System.nanoTime();
            boolean acked = false;
            boolean dlqAttempted = false;
            try {
                var currInstant = Instant.now();
                // This timestamp is set by either the producer or Kafka
                var kafkaTimestamp = Instant.ofEpochMilli(message.timestamp());
                var klag = Duration.between(kafkaTimestamp, currInstant);
                timeIt.emitTimeMetric("ConsumptionLag." + config.getTopic(), klag.toMillis());
                //process the message
                config.getProcessor().process(message);

                //successful processing
                message.receiverOffset().acknowledge();
                acked = true;
                log.debug("Message Successfully processed and acknowledged");

            } catch (Exception e) {
                log.error(
                        "Error processing event with key: {}, value: {} from topic: {}",
                        message.key(),
                        message.value(),
                        config.getTopic(),
                        e);
                // Attempt DLQ Handling
                if (config.getFailureHandler() != null) {
                    dlqAttempted = true;
                    try {
                        config.getFailureHandler()
                                .handle(
                                        config.getBootstrapServers(),
                                        config.getDlqConfig(),
                                        config.getSecurityProtocol(),
                                        message);
                        //DLQ Success - ACKNOWLEDGE
                        message.receiverOffset().acknowledge();
                        acked = true;
                        log.info("Successfully published to DLQ and acknowledged offset.");
                    } catch (Exception dlqex) {
                        log.error("DLQ  handling also failed. Message will be retried", dlqex);
                    }

                } else {
                    // TODO : not to acknowledge message in case of failed to push in DLQ topic.
                    log.error("DLQ Failure Handler is not configured for topic: {}", config.getTopic());
                }
            }

            if (!acked) {
                // Neither processing nor DLQ succeeded

                log.warn("message with key :{} could not be processed or sent to DLQ. it will remain unacknowledged for retry.", message.key());

                timeIt.emitTimeMetric("Latency." + config.getTopic(), 1);
            }

            message.receiverOffset().acknowledge();
            var endTime = System.nanoTime();
            var totalTimeMillis = (endTime - startTime) / 1000_000L;
            timeIt.emitTimeMetric("Latency." + config.getTopic(), totalTimeMillis);
            log.trace("Finished processing message: {} from topic: {}", message, config.getTopic());
            return message;
        }
    }


    private Scheduler scheduler() {
        var scheduler = Schedulers.newBoundedElastic(
                config.getInMemoryPartitions(),
                Schedulers.DEFAULT_BOUNDED_ELASTIC_QUEUESIZE,
                config.getProcessorThreadPoolName());
        return Micrometer.timedScheduler(scheduler, metricUtil.getRegistry(),
                config.getTopic() + "-consumers.scheduler");
    }

    @Override
    public void close() {
        log.info("Closing Kafka consumer");
        try {
            this.flux.dispose();
        } catch (Exception e) {
            log.error("Error disposing Kafka consumer", e);
        }
    }
}











@Bean
    @ConfigurationProperties(prefix = "spring.kafka.consumer")
    @Qualifier("gamKafka")
    public ConsumerConfiguration<DtdGamBusinessEvent> gamKafka(
            PlutusDtdBusinessEventConsumer consumer,
            DlqHandler<DtdGamBusinessEvent> failureHandler) {
        return ConsumerConfiguration.<DtdGamBusinessEvent>builder()
                .bootstrapServers("b-1.uatrosmsk.x7g3kf.c4.kafka.ap-south-1.amazonaws.com:9098,b-2.uatrosmsk.x7g3kf.c4.kafka.ap-south-1.amazonaws.com:9098\n")
                .groupId("plutus-consumer-group")
                .topic("dtd-gam-business-event")
                .valueDeserializer(PlutusDtdDeserializer.class)
                .maxPollRecords(1000)
                .processor(consumer)
                .failureHandler(failureHandler)
                .deferredCommitConfig(new ConsumerConfiguration.DeferredCommitConfiguration(1000, 10, 100))
                .inMemoryPartitions(10) // Default values
                .build();
    }
