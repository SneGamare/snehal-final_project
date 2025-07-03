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



package com.kotak.orchestrator.orchestrator.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotak.orchestrator.orchestrator.consumer.ConsumerConfiguration;
import com.kotak.orchestrator.orchestrator.consumer.GenericReactiveConsumer;
import com.kotak.orchestrator.orchestrator.consumer.PlutusDtdBusinessEventConsumer;
import com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler;
import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.orchestrator.orchestrator.schema.DtdGamBusinessEvent;
import com.kotak.orchestrator.orchestrator.serializer.PlutusDtdDeserializer;
import com.kotak.orchestrator.orchestrator.service.ClientConfigCacheService;
import com.kotak.orchestrator.orchestrator.utils.MetricUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlutusDtdConsumerConfig {

    private final PlutusFinacleDataRepository repository;

    private final ClientConfigCacheService clientConfigCacheService;


    public PlutusDtdConsumerConfig(PlutusFinacleDataRepository repository, ClientConfigCacheService clientConfigCacheService, ObjectMapper objectMapper) {
        this.repository = repository;
        this.clientConfigCacheService = clientConfigCacheService;
    }

    @Bean
    public PlutusDtdBusinessEventConsumer plutusDtdBusinessEventConsumer() {
        return new PlutusDtdBusinessEventConsumer(repository, clientConfigCacheService);
    }


    @Bean
    @Qualifier("gamKafka")
    public ConsumerConfiguration<DtdGamBusinessEvent> gamKafka(
            PlutusDtdBusinessEventConsumer consumer,
            DlqHandler<DtdGamBusinessEvent> failureHandler,
            GamConsumerProperties props) {

        return ConsumerConfiguration.<DtdGamBusinessEvent>builder()
                .bootstrapServers(props.getBootstrapServers())
                .groupId(props.getGroupId())
                .topic(props.getTopic())
                .valueDeserializer(PlutusDtdDeserializer.class) // Direct reference
                .maxPollRecords(props.getMaxPollRecords())
                .processor(consumer)
                .failureHandler(failureHandler)
                .deferredCommitConfig(new ConsumerConfiguration.DeferredCommitConfiguration(
                        props.getDeferredCommit().getMaxDeferredCommits(),
                        props.getDeferredCommit().getCommitIntervalMillis(),
                        props.getDeferredCommit().getCommitBatchSize()
                ))
                .inMemoryPartitions(props.getInMemoryPartitions())
                .securityProtocol(props.getSecurityProtocol())
                .awsRoleArn(props.getAwsRoleArn())
                .awsStsRegion(props.getAwsStsRegion())
                .awsStsSessionName(props.getAwsStsSessionName())
                .processorThreadPoolName(props.getProcessorThreadPoolName())
                .dlqConfig(ConsumerConfiguration.DlqConfiguration.<String>builder().dlqTopic("my-topic").valueSerializer(org.apache.kafka.common.serialization.StringSerializer.class).awsRoleArn("arn:aws:Iam::977098984058:role/msk-plutus-dev-access-role").awsRoleSessionName("plutus-session").awsStsRegion("ap-south-1").build())
                .build();
    }


    @Bean
    @Qualifier("gamConsumer")
    public GenericReactiveConsumer<DtdGamBusinessEvent> gamConsumer(
            @Qualifier("gamKafka") ConsumerConfiguration<DtdGamBusinessEvent> config,
            MetricUtil metricUtil) {
        System.out.println("Config: " + config);
        System.out.println("MetricUtil: " + metricUtil);
        var consumer = new GenericReactiveConsumer<>(config, metricUtil);
        consumer.start();
        return consumer;
    }
}
