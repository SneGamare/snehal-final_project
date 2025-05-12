package com.kotak.plutus.common.consumer;

import lombok.extern.slf4j.Slf4j;

import io.micrometer.observation.ObservationRegistry;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.utils.Scheduler;
import reactor.core.Disposable;
import reactor.core.observability.micrometer.Micrometer;
import reactor.core.scheduler.Schedulers;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.ReceiverRecord;
import reactor.kafka.receiver.internals.ConsumerFactory;
import reactor.kafka.receiver.observation.KafkaReceiverObservation;
import reactor.util.retry.Retry;

import io.micrometer.core.instrument.binder.kafka.KafkaClientMetrics;

import static org.slf4j.helpers.Reporter.error;

@Slf4j
public class GenericAvroConsumer<T> extends Thread implements AutoCloseable {

    private final ConsumerConfiguration<T> config;
    private final KafkaReceiver<String, T> receiver;
    protected MetricUtil metricUtil;
    private Disposable flux;

    public GenericAvroConsumer(ConsumerConfiguration<T> config, MetricUtil metricUtil) {
        this.config = config;
        this.metricUtil = metricUtil;

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
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
            props.put(SaslConfigs.SASL_MECHANISM, "AWS_MSK_IAM");
            props.put(SaslConfigs.SASL_JAAS_CONFIG, "software.amazon.msk.auth.iam.IAMLoginModule required;");
            props.put(SaslConfigs.SASL_CLIENT_CALLBACK_HANDLER_CLASS, "software.amazon.msk.auth.iam.IAMClientCallbackHandler");
        }

        var registry = ObservationRegistry.create();

        var options = ReceiverOptions.<String, T>create(props)
                .subscription(List.of(config.getTopic()))
                .commitInterval(Duration.ofMillis(config.getDeferredCommitConfig().getCommitIntervalMillis()))
                .maxDeferredCommits(config.getDeferredCommitConfig().getMaxDeferredCommits())
                .commitBatchSize(config.getDeferredCommitConfig().getCommitBatchSize())
                .withObservation(registry, KafkaReceiverObservation.DefaultKafkaReceiverObservationConvention.INSTANCE);


        this.receiver = KafkaReceiver.create(new ReactiveConsumerFactory(), options);
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
        var scheduler = scheduler();
        flux = receiver.receive()
                .doOnError(e -> error("Error receiving event in Kafka consumer. Will retry", e))
                .retryWhen(Retry.fixedDelay(60L, Duration.ofMinutes(1)))
                .groupBy(r -> config.getProcessor().partitionKey(r.value()))
                .flatMap(pf -> pf.publishOn((reactor.core.scheduler.Scheduler) scheduler).map(this::processRecord))
                .subscribe();
    }

    private ReceiverRecord<String, T> processRecord(ReceiverRecord<String, T> message) {
        try (var timeIt = metricUtil.timeIt("MessageProcessingLatency")) {
            var currInstant = Instant.now();
            var kafkaTimestamp = Instant.ofEpochMilli(message.timestamp());
            var klag = Duration.between(kafkaTimestamp, currInstant);
            timeIt.emitTimeMetric("ConsumptionLag." + config.getTopic(), klag.toMillis());

            try {
                config.getProcessor().process(message);
            } catch (Exception e) {
                if (config.getFailureHandler() != null) {
                    config.getFailureHandler().handle(config.getBootstrapServers(), config.getDlqConfig(), config.getSecurityProtocol(), message);
                } else {
                }
            }

            message.receiverOffset().acknowledge();
            return message;
        }
    }

    private Scheduler scheduler() {
        var scheduler = Schedulers.newBoundedElastic(
                config.getInMemoryPartitions(),
                Schedulers.DEFAULT_BOUNDED_ELASTIC_QUEUESIZE,
                config.getProcessorThreadPoolName());
        return (Scheduler) Micrometer.timedScheduler(scheduler, metricUtil.getRegistry(), config.getTopic() + "-consumers.scheduler");
    }

    @Override
    public void close() {
        try {
            this.flux.dispose();
        } catch (Exception ignored) {
        }
    }
}
