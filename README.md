package com.kotak.orchestrator.orchestrator.failurehandler;

import com.kotak.orchestrator.orchestrator.consumer.ConsumerConfiguration.DlqConfiguration;
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
            String serializer,
            String securityProtocol,
            String key,
            T message,
            Iterable<Header> headers,
            String saslScramUsername,
            String saslScramPassword
            // REMOVED: awsRoleArn, awsStsSessionName, awsStsRegion
    ) throws InterruptedException, ExecutionException {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializer);
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, "5000");
        props.put(ProducerConfig.ACKS_CONFIG, "all");

        if ("AWS_MSK_IAM".equalsIgnoreCase(securityProtocol)) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
            props.put(SaslConfigs.SASL_MECHANISM, "AWS_MSK_IAM");
            props.put("sasl.client.callback.handler.class", "software.amazon.msk.auth.iam.IAMClientCallbackHandler");
            // REMOVED: aws.msk.iam.* properties
        } else {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
            props.put(SaslConfigs.SASL_MECHANISM, "SCRAM-SHA-512");
            props.put(SaslConfigs.SASL_JAAS_CONFIG,
                    "org.apache.kafka.common.security.scram.ScramLoginModule required username=\""
                            + saslScramUsername + "\" password=\"" + saslScramPassword + "\";");
        }

        try (KafkaProducer<String, T> producer = new KafkaProducer<>(props)) {
            ProducerRecord<String, T> record = new ProducerRecord<>(topic, null, key, message, headers);
            producer.send(record).get();
            log.info("Message published to DLQ {}", topic);
        }
    }

    @Override
    public void handle(String bootstrapServer, DlqConfiguration<T> dlqConfig, String securityProtocol,
                       ReceiverRecord<String, T> event) {
        try {
            log.info("DlqHandler publishing event: {} to DLQ topic: {}", event.value(), dlqConfig.getDlqTopic());
            int retryAttemptCount = getRetryAttemptCount(event.headers());
            if (retryAttemptCount < 5) {
                log.warn("Already retried count: {}", retryAttemptCount);
                List<Header> headers = new ArrayList<>();
                headers.add(new RecordHeader(retryAttemptCountHeaderKey, String.valueOf(retryAttemptCount + 1).getBytes()));

                publishMessage(
                        dlqConfig.getBootstrapServers(),
                        dlqConfig.getDlqTopic(),
                        dlqConfig.getValueSerializer().getName(),
                        securityProtocol,
                        event.key(),
                        event.value(),
                        headers,
                        dlqConfig.getSaslScramUsername(),
                        dlqConfig.getSaslScramPassword()
                        // REMOVED: aws params
                );
            } else {
                log.warn("Retries exhausted: {} | event : {}", retryAttemptCount, event.key());
            }
        } catch (Exception e) {
            log.error("Error while publishing message to DLQ topic [{}]", dlqConfig.getDlqTopic(), e);
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
