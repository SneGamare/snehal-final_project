package com.kotak.orchestrator.orchestrator.failurehandler;

import com.kotak.orchestrator.orchestrator.consumer.ConsumerConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.ReceiverRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
@Component
public class DlqHandler<T> implements FailureHandler<T> {



    private void publishMessage(String bootstrapServer, String topic, String serializer, String securityProtocol,
                                String key, T message) throws InterruptedException, ExecutionException
    {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializer);
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, "5000");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        if ("AWS_MSK_IAM".equals(securityProtocol)) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
            props.put(SaslConfigs.SASL_MECHANISM, "AWS_MSK_IAM");
            props.put(SaslConfigs.SASL_JAAS_CONFIG, "software.amazon.msk.auth.iam.IAMLoginModule required;");
            props.put(SaslConfigs.SASL_CLIENT_CALLBACK_HANDLER_CLASS,
                    "software.amazon.msk.auth.iam.IAMClientCallbackHandler");
        }

        try (KafkaProducer<String, T> producer = new KafkaProducer<>(props)) {
            var record = new ProducerRecord<>(topic, key, message);
            producer.send(record).get();
            System.out.println("Message published to DLQ {}"+ topic);
        }
    }

    @Override
    public void handle(String bootstrapServer, ConsumerConfiguration.DlqConfiguration<T> dlqConfig, String securityProtocol,
                       ReceiverRecord<String, T> event)
    {
        try {
            System.out.println("DlqHandler publishing event: {} to dlq: {}"+ event.value()+ dlqConfig.getDlqTopic());
            publishMessage(bootstrapServer, dlqConfig.getDlqTopic(), dlqConfig.getValueSerializer().getName(),
                    securityProtocol, event.key(), event.value());
        } catch (Exception e) {
            //TODO : Implement mechanism with ReactiveKafkaConsumer in case of failure,
            // so that we receive failed event again.
            System.out.println("Exception in Failure handler "+ e);
        }
    }
}


public interface FailureHandler<T> {
    /**
     * usecase : To handle events which failed in message processing.
     *
     * @param bootstrapServers kafka server endpoints
     * @param dlqConfiguration has properties related to publishing to dlq.
     * @param securityProtocol used for SSL
     * @param message          record received by consumer.
     */
    void handle(
            String bootstrapServers,
            ConsumerConfiguration.DlqConfiguration<T> dlqConfiguration,
            String securityProtocol,
            ReceiverRecord<String, T> message
    );
}



package com.kotak.orchestrator.orchestrator.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DLQ configuration to be used by FailureHandler.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DlqConfiguration<T> {
    private String dlqTopic;
    private Class<?> valueSerializer;
    private String awsRoleArn;
    private String awsRoleSessionName;
    private String awsStsRegion;
}



package com.kotak.orchestrator.orchestrator.failurehandler;

import com.kotak.orchestrator.orchestrator.consumer.ConsumerConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.ReceiverRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
@Component
public class DlqHandler<T> implements FailureHandler<T> {

    private void publishMessage(
            String bootstrapServers,
            String topic,
            String valueSerializer,
            String securityProtocol,
            String key,
            T message,
            String awsRoleArn,
            String awsRoleSessionName,
            String awsStsRegion
    ) throws InterruptedException, ExecutionException {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, "5000");

        if ("AWS_MSK_IAM".equalsIgnoreCase(securityProtocol)) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
            props.put(SaslConfigs.SASL_MECHANISM, "AWS_MSK_IAM");

            String jaasConfig = String.format(
                "software.amazon.msk.auth.iam.IAMLoginModule required " +
                "awsRoleArn=\"%s\" awsRoleSessionName=\"%s\" awsStsRegion=\"%s\";",
                awsRoleArn,
                awsRoleSessionName,
                awsStsRegion
            );
            props.put(SaslConfigs.SASL_JAAS_CONFIG, jaasConfig);
            props.put(
                SaslConfigs.SASL_CLIENT_CALLBACK_HANDLER_CLASS,
                "software.amazon.msk.auth.iam.IAMClientCallbackHandler"
            );
        }

        try (KafkaProducer<String, T> producer = new KafkaProducer<>(props)) {
            ProducerRecord<String, T> record = new ProducerRecord<>(topic, key, message);
            producer.send(record).get();
            log.info("Message published to DLQ topic: {}", topic);
        }
    }

    @Override
    public void handle(
            String bootstrapServers,
            ConsumerConfiguration.DlqConfiguration<T> dlqConfig,
            String securityProtocol,
            ReceiverRecord<String, T> event
    ) {
        try {
            log.info("Publishing failed event to DLQ topic: {}. Event: {}", dlqConfig.getDlqTopic(), event.value());
            publishMessage(
                bootstrapServers,
                dlqConfig.getDlqTopic(),
                dlqConfig.getValueSerializer().getName(),
                securityProtocol,
                event.key(),
                event.value(),
                dlqConfig.getAwsRoleArn(),
                dlqConfig.getAwsRoleSessionName(),
                dlqConfig.getAwsStsRegion()
            );
        } catch (Exception e) {
            log.error("Error while publishing message to DLQ topic: {}", dlqConfig.getDlqTopic(), e);
            throw new RuntimeException("DLQ publishing failed", e);
        }
    }
}



b-2.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9098,b-1.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9098

b-2.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9098,b-1.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9098

arn:aws:kafka:ap-south-1:977098984058:cluster/msk-plutus-dev-01/4824fa47-6b3b-42e6-8b9c-db241b55f242-2 this is my arn 
