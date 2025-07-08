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
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class PlutusDtdConsumerConfig  {

    private final PlutusFinacleDataRepository repository;
    private final ClientConfigCacheService clientConfigCacheService;

    public PlutusDtdConsumerConfig(
            PlutusFinacleDataRepository repository,
            ClientConfigCacheService clientConfigCacheService) {
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
                .valueDeserializer(PlutusDtdDeserializer.class)
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
                .build();
    }

    @Bean
    @Qualifier("gamDlqKafkaConfig")
    public ConsumerConfiguration<DtdGamBusinessEvent> gamDlqKafka(
            PlutusDtdBusinessEventConsumer consumer,
            DlqHandler<DtdGamBusinessEvent> failureHandler,
            @Value("${spring.kafka.consumer.bootstrap-servers}") String bootstrapServers,
            @Value("${spring.kafka.consumer.group-id}") String groupId,
            @Value("${spring.kafka.consumer.topic}") String topic,
            @Value("${spring.kafka.consumer.max-poll-records}") int maxPollRecords,
            @Value("${spring.kafka.consumer.processor-thread-pool-name}") String threadPoolName,
            @Value("${spring.kafka.consumer.security-protocol}") String securityProtocol,
            @Value("${spring.kafka.consumer.aws-role-arn}") String awsRoleArn,
            @Value("${spring.kafka.consumer.aws-sts-session-name}") String awsStsSessionName,
            @Value("${spring.kafka.consumer.aws-sts-region}") String awsStsRegion,
            @Value("${spring.kafka.consumer.commit.batch-size}") int commitBatchSize,
            @Value("${spring.kafka.consumer.commit.interval-millis}") int commitIntervalMillis,
            @Value("${spring.kafka.consumer.commit.max-deferred-commits}") int maxDeferredCommits,
            @Value("${spring.kafka.consumer.in-memory-partitions}") int inMemoryPartitions,
            @Value("${spring.kafka.consumer.dlq-config.dlq-topic}") String dlqTopic,
            @Value("${spring.kafka.consumer.dlq-config.bootstrap-servers}") String dlqBootstrapServers,
            @Value("${spring.kafka.consumer.dlq-config.value-serializer}") Class<? extends Serializer> dlqValueSerializer,
            @Value("${spring.kafka.consumer.dlq-config.security-protocol}") String dlqSecurityProtocol
    ) {
        return ConsumerConfiguration.<DtdGamBusinessEvent>builder()
                .bootstrapServers(bootstrapServers)
                .groupId(groupId)
                .topic(topic)
                .valueDeserializer(PlutusDtdDeserializer.class)
                .maxPollRecords(maxPollRecords)
                .processor(consumer)
                .failureHandler(failureHandler)
                .deferredCommitConfig(new ConsumerConfiguration.DeferredCommitConfiguration(
                        maxDeferredCommits,
                        commitIntervalMillis,
                        commitBatchSize
                ))
                .inMemoryPartitions(inMemoryPartitions)
                .securityProtocol(securityProtocol)
                .awsRoleArn(awsRoleArn)
                .awsStsRegion(awsStsRegion)
                .awsStsSessionName(awsStsSessionName)
                .processorThreadPoolName(threadPoolName)
                .dlqConfig(ConsumerConfiguration.DlqConfiguration.<DtdGamBusinessEvent>builder()
                        .dlqTopic(dlqTopic)
                        .bootstrapServers(dlqBootstrapServers)
                        .valueSerializer(dlqValueSerializer)
                        .securityProtocol(dlqSecurityProtocol)
                        .awsRoleArn(awsRoleArn)          // ✅ IAM Role for DLQ
                        .awsStsRegion(awsStsRegion)
                        .awsStsSessionName(awsStsSessionName)
                        .build())
                .build();
    }

    @Bean
    @Qualifier("gamConsumer")
    public GenericReactiveConsumer<DtdGamBusinessEvent> gamConsumer(
            @Qualifier("gamDlqKafkaConfig") ConsumerConfiguration<DtdGamBusinessEvent> config,
            MetricUtil metricUtil) {
        System.out.println("Config: " + config);
        System.out.println("MetricUtil: " + metricUtil);
        var consumer = new GenericReactiveConsumer<>(config, metricUtil);
        consumer.start();
        return consumer;
    }
}

/*
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
                .build();
    }

    @Bean
    @Qualifier("gamDlqKafkaConfig")
    public ConsumerConfiguration<DtdGamBusinessEvent> gamDlqKafka(
            PlutusDtdBusinessEventConsumer consumer,
            DlqHandler<DtdGamBusinessEvent> failureHandler,
            @Value("${spring.kafka.consumer.bootstrap-servers}") String bootstrapServers,
            @Value("${spring.kafka.consumer.group-id}") String groupId,
            @Value("${spring.kafka.consumer.topic}") String topic,
            @Value("${spring.kafka.consumer.max-poll-records}") int maxPollRecords,
            @Value("${spring.kafka.consumer.processor-thread-pool-name}") String threadPoolName,
            @Value("${spring.kafka.consumer.security-protocol}") String securityProtocol,
            @Value("${spring.kafka.consumer.aws-role-arn}") String awsRoleArn,
            @Value("${spring.kafka.consumer.aws-sts-session-name}") String awsStsSessionName,
            @Value("${spring.kafka.consumer.aws-sts-region}") String awsStsRegion,
            @Value("${spring.kafka.consumer.commit.batch-size}") int commitBatchSize,
            @Value("${spring.kafka.consumer.commit.interval-millis}") int commitIntervalMillis,
            @Value("${spring.kafka.consumer.commit.max-deferred-commits}") int maxDeferredCommits,
            @Value("${spring.kafka.consumer.in-memory-partitions}") int inMemoryPartitions,
            @Value("${spring.kafka.consumer.dlq-config.dlq-topic}") String dlqTopic,
            @Value("${spring.kafka.consumer.dlq-config.bootstrap-servers}") String dlqBootstrapServers,
            @Value("${spring.kafka.consumer.dlq-config.value-serializer}") Class<? extends Serializer> dlqValueSerializer,
            @Value("${spring.kafka.consumer.dlq-config.security-protocol}") String dlqSecurityProtocol,
            @Value("${spring.kafka.consumer.dlq-config.sasl-scram-username}") String dlqSaslUsername,
            @Value("${spring.kafka.consumer.dlq-config.sasl-scram-password}") String dlqSaslPassword
    ) {
        return ConsumerConfiguration.<DtdGamBusinessEvent>builder()
                .bootstrapServers(bootstrapServers)
                .groupId(groupId)
                .topic(topic)
                .valueDeserializer(PlutusDtdDeserializer.class)
                .maxPollRecords(maxPollRecords)
                .processor(consumer)
                .failureHandler(failureHandler)
                .deferredCommitConfig(new ConsumerConfiguration.DeferredCommitConfiguration(
                        maxDeferredCommits,
                        commitIntervalMillis,
                        commitBatchSize
                ))
                .inMemoryPartitions(inMemoryPartitions)
                .securityProtocol(securityProtocol)
                .awsRoleArn(awsRoleArn)
                .awsStsRegion(awsStsRegion)
                .awsStsSessionName(awsStsSessionName)
                .processorThreadPoolName(threadPoolName)
                .dlqConfig(ConsumerConfiguration.DlqConfiguration.<DtdGamBusinessEvent>builder()
                        .dlqTopic(dlqTopic)
                        .bootstrapServers(dlqBootstrapServers)
                        .valueSerializer(dlqValueSerializer)
                        .securityProtocol(dlqSecurityProtocol)
                        .saslScramUsername(dlqSaslUsername)
                        .saslScramPassword(dlqSaslPassword)
                        .build())
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
*/
