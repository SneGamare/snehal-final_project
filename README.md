
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
            try {
                var currInstant = Instant.now();
                // This timestamp is set by either the producer or Kafka
                var kafkaTimestamp = Instant.ofEpochMilli(message.timestamp());
                var klag = Duration.between(kafkaTimestamp, currInstant);
                timeIt.emitTimeMetric("ConsumptionLag." + config.getTopic(), klag.toMillis());
                config.getProcessor().process(message);

            } catch (Exception e) {
                log.error(
                        "Error processing event with key: {}, value: {} from topic: {}",
                        message.key(),
                        message.value(),
                        config.getTopic(),
                        e);
                if (config.getFailureHandler() != null) {
                    config.getFailureHandler()
                            .handle(
                                    config.getBootstrapServers(),
                                    config.getDlqConfig(),
                                    config.getSecurityProtocol(),
                                    message);
                } else {
                    // TODO : not to acknowledge message in case of failed to push in DLQ topic.
                    log.error("DLQ Failure Handler is not configured for topic: {}", config.getTopic());
                }
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
