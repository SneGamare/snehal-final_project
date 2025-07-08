package com.kotak.orchestrator.orchestrator.failurehandler;

import com.kotak.orchestrator.orchestrator.consumer.ConsumerConfiguration.DlqConfiguration;
import com.kotak.orchestrator.orchestrator.serializer.PlutusAvroSerializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.ReceiverRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
@Component
public class DlqHandler<T> implements FailureHandler<T> {

    private static final String retryAttemptCountHeaderKey = "retryAttemptCount";

    private void publishMessage(
            String bootstrapServer,
            String topic,
            Class<?> valueSerializerClass,
            String securityProtocol,
            String key,
            T message,
            Iterable<Header> headers,
            String saslScramUsername,
            String saslScramPassword,
            String awsRoleArn,
            String awsStsSessionName,
            String awsStsRegion
    ) throws InterruptedException, ExecutionException {

        if (valueSerializerClass == null) {
            throw new IllegalArgumentException("DLQ valueSerializerClass is null. Please configure it.");
        }

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializerClass.getName());
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, "5000");
        props.put(ProducerConfig.ACKS_CONFIG, "all");

        if ("SASL_SSL".equalsIgnoreCase(securityProtocol)) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
            props.put(SaslConfigs.SASL_MECHANISM, "SCRAM-SHA-512");
            props.put(SaslConfigs.SASL_JAAS_CONFIG,
                    "org.apache.kafka.common.security.scram.ScramLoginModule required username=\""
                            + saslScramUsername + "\" password=\"" + saslScramPassword + "\";");
        } else if ("AWS_MSK_IAM".equalsIgnoreCase(securityProtocol)) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
            props.put(SaslConfigs.SASL_MECHANISM, "AWS_MSK_IAM");
            props.put("sasl.client.callback.handler.class", "software.amazon.msk.auth.iam.IAMClientCallbackHandler");
            props.put("aws.msk.iam.role.arn", awsRoleArn);
            props.put("aws.msk.iam.session.name", awsStsSessionName);
            props.put("aws.msk.iam.region", awsStsRegion);
        } else if ("PLAINTEXT".equalsIgnoreCase(securityProtocol)) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "PLAINTEXT");
        } else {
            throw new IllegalArgumentException("Unknown security protocol: " + securityProtocol);
        }

        props.forEach((k, v) -> System.out.println("DLQ KAFKA PRODUCER CONFIG " + k + " = " + v));

        try (KafkaProducer<String, T> producer = new KafkaProducer<>(props)) {
            ProducerRecord<String, T> record = new ProducerRecord<>(topic, null, key, message, headers);
            producer.send(record).get();
            log.info("Message published to DLQ topic: {}", topic);
        }
    }

    @Override
    public void handle(String bootstrapServer, DlqConfiguration<T> dlqConfig, String securityProtocol,
                       ReceiverRecord<String, T> event) {
        try {
            log.info("DlqHandler publishing event to DLQ topic: {}", dlqConfig.getDlqTopic());
            log.info("DLQ config serializer ",dlqConfig.getValueSerializer());
            int retryAttemptCount = getRetryAttemptCount(event.headers());
            if (retryAttemptCount < 5) {
                log.warn("Already retried count: {}", retryAttemptCount);
                List<Header> headers = new ArrayList<>();
                headers.add(new RecordHeader(retryAttemptCountHeaderKey,
                        String.valueOf(retryAttemptCount + 1).getBytes()));

                // Null safety check
                if (dlqConfig.getValueSerializer() == null) {
                    throw new IllegalArgumentException("DLQ valueSerializer is null. Please configure it.");
                }

                publishMessage(
                        dlqConfig.getBootstrapServers(),
                        dlqConfig.getDlqTopic(),
                        PlutusAvroSerializer.class,
                        securityProtocol,
                        event.key(),
                        event.value(),
                        headers,
                        dlqConfig.getSaslScramUsername(),
                        dlqConfig.getSaslScramPassword(),
                        dlqConfig.getAwsRoleArn(),
                        dlqConfig.getAwsStsSessionName(),
                        dlqConfig.getAwsStsRegion()
                );
            } else {
                log.warn("Retries exhausted ({}). Skipping message with key: {}", retryAttemptCount, event.key());
            }
        } catch (Exception e) {
            log.error("Error publishing message to DLQ [{}]", dlqConfig.getDlqTopic(), e);
            throw new RuntimeException("DLQ publishing failed", e);
        }
    }

    private int getRetryAttemptCount(Headers headers) {
        for (Header header : headers) {
            if (retryAttemptCountHeaderKey.equals(header.key())) {
                return Integer.parseInt(new String(header.value()));
            }
        }
        return 0;
    }
}



2025-07-08T10:11:09.118Z  INFO 1 --- [s_application-2] c.k.o.o.failurehandler.DlqHandler        : DlqHandler publishing event to DLQ topic: dtd-gam-dlq
2025-07-08T10:11:09.118Z  INFO 1 --- [s_application-2] c.k.o.o.failurehandler.DlqHandler        : DLQ config serializer
2025-07-08T10:11:09.118Z  WARN 1 --- [s_application-2] c.k.o.o.failurehandler.DlqHandler        : Already retried count: 0
2025-07-08T10:11:09.118Z ERROR 1 --- [s_application-2] c.k.o.o.failurehandler.DlqHandler        : Error publishing message to DLQ [dtd-gam-dlq]

java.lang.NullPointerException: null
        at java.base/java.util.concurrent.ConcurrentHashMap.putVal(ConcurrentHashMap.java:1011) ~[na:na]
        at java.base/java.util.concurrent.ConcurrentHashMap.put(ConcurrentHashMap.java:1006) ~[na:na]
        at java.base/java.util.Properties.put(Properties.java:1346) ~[na:na]
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.publishMessage(DlqHandler.java:67) ~[!/:0.0.1]
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.handle(DlqHandler.java:103) ~[!/:0.0.1]
        at com.kotak.orchestrator.orchestrator.consumer.GenericReactiveConsumer.processRecord(GenericReactiveConsumer.java:137) ~[!/:0.0.1]
        at reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.onNext(FluxMapFuseable.java:113) ~[reactor-core-3.6.5.jar!/:3.6.5]
        at reactor.core.publisher.FluxPublishOn$PublishOnSubscriber.runAsync(FluxPublishOn.java:446) ~[reactor-core-3.6.5.jar!/:3.6.5]
        at reactor.core.publisher.FluxPublishOn$PublishOnSubscriber.run(FluxPublishOn.java:533) ~[reactor-core-3.6.5.jar!/:3.6.5]
        at io.micrometer.core.instrument.AbstractTimer.record(AbstractTimer.java:247) ~[micrometer-core-1.12.5.jar!/:1.12.5]
        at io.micrometer.core.instrument.Timer.lambda$wrap$0(Timer.java:193) ~[micrometer-core-1.12.5.jar!/:1.12.5]
        at io.micrometer.core.instrument.LongTaskTimer.record(LongTaskTimer.java:184) ~[micrometer-core-1.12.5.jar!/:1.12.5]
        at reactor.core.observability.micrometer.TimedScheduler$TimedRunnable.run(TimedScheduler.java:265) ~[reactor-core-micrometer-1.2.0.jar!/:1.2.0]
        at reactor.core.scheduler.WorkerTask.call(WorkerTask.java:84) ~[reactor-core-3.6.5.jar!/:3.6.5]
        at reactor.core.scheduler.WorkerTask.call(WorkerTask.java:37) ~[reactor-core-3.6.5.jar!/:3.6.5]
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317) ~[na:na]
        at java.base/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:304) ~[na:na]
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144) ~[na:na]
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642) ~[na:na]
        at java.base/java.lang.Thread.run(Thread.java:1583) ~[na:na]

2025-07-08T10:11:09.119Z ERROR 1 --- [s_application-2] c.k.o.o.c.GenericReactiveConsumer        : DLQ handling also failed. Message will be retried.

java.lang.RuntimeException: DLQ publishing failed
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.handle(DlqHandler.java:122) ~[!/:0.0.1]
        at com.kotak.orchestrator.orchestrator.consumer.GenericReactiveConsumer.processRecord(GenericReactiveConsumer.java:137) ~[!/:0.0.1]
        at reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.onNext(FluxMapFuseable.java:113) ~[reactor-core-3.6.5.jar!/:3.6.5]
        at reactor.core.publisher.FluxPublishOn$PublishOnSubscriber.runAsync(FluxPublishOn.java:446) ~[reactor-core-3.6.5.jar!/:3.6.5]
        at reactor.core.publisher.FluxPublishOn$PublishOnSubscriber.run(FluxPublishOn.java:533) ~[reactor-core-3.6.5.jar!/:3.6.5]
        at io.micrometer.core.instrument.AbstractTimer.record(AbstractTimer.java:247) ~[micrometer-core-1.12.5.jar!/:1.12.5]
        at io.micrometer.core.instrument.Timer.lambda$wrap$0(Timer.java:193) ~[micrometer-core-1.12.5.jar!/:1.12.5]
        at io.micrometer.core.instrument.LongTaskTimer.record(LongTaskTimer.java:184) ~[micrometer-core-1.12.5.jar!/:1.12.5]
        at reactor.core.observability.micrometer.TimedScheduler$TimedRunnable.run(TimedScheduler.java:265) ~[reactor-core-micrometer-1.2.0.jar!/:1.2.0]
        at reactor.core.scheduler.WorkerTask.call(WorkerTask.java:84) ~[reactor-core-3.6.5.jar!/:3.6.5]
        at reactor.core.scheduler.WorkerTask.call(WorkerTask.java:37) ~[reactor-core-3.6.5.jar!/:3.6.5]
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317) ~[na:na]
        at java.base/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:304) ~[na:na]
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144) ~[na:na]
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642) ~[na:na]
        at java.base/java.lang.Thread.run(Thread.java:1583) ~[na:na]
Caused by: java.lang.NullPointerException: null
        at java.base/java.util.concurrent.ConcurrentHashMap.putVal(ConcurrentHashMap.java:1011) ~[na:na]
        at java.base/java.util.concurrent.ConcurrentHashMap.put(ConcurrentHashMap.java:1006) ~[na:na]
        at java.base/java.util.Properties.put(Properties.java:1346) ~[na:na]
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.publishMessage(DlqHandler.java:67) ~[!/:0.0.1]
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.handle(DlqHandler.java:103) ~[!/:0.0.1]
        ... 15 common frames omitted


DLQ config serializer its not getting printed 

