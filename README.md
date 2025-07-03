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

b-2.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9098,b-1.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9098
