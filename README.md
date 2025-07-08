package com.kotak.orchestrator.orchestrator.config;

import com.kotak.orchestrator.orchestrator.consumer.ConsumerConfiguration;
import com.kotak.orchestrator.orchestrator.consumer.GenericReactiveConsumer;
import com.kotak.orchestrator.orchestrator.consumer.PlutusDtdBusinessEventConsumer;
import com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler;
import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.orchestrator.orchestrator.schema.DtdGamBusinessEvent;
import com.kotak.orchestrator.orchestrator.serializer.PlutusDtdDeserializer;
import com.kotak.orchestrator.orchestrator.utils.MetricUtil;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlutusDtdConsumerConfig {

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
            @Value("${spring.kafka.consumer.dlq-config.security-protocol}") String dlqSecurityProtocol,
            @Value("${spring.kafka.consumer.dlq-config.sasl-scram-username:}") String dlqSaslUsername,
            @Value("${spring.kafka.consumer.dlq-config.sasl-scram-password:}") String dlqSaslPassword
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
                        // No AWS IAM props for DLQ
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







# Consumer MSK Cluster
spring.kafka.consumer.bootstrap-servers=b-1.uatrosmsk.x7g3kf.c4.kafka.ap-south-1.amazonaws.com:9098,b-2.uatrosmsk.x7g3kf.c4.kafka.ap-south-1.amazonaws.com:9098
spring.kafka.consumer.group-id=plutus-consumer-group
spring.kafka.consumer.topic=dtd-gam-business-event
spring.kafka.consumer.max-poll-records=500
spring.kafka.consumer.processor-thread-pool-name=plutus_application
spring.kafka.consumer.security-protocol=AWS_MSK_IAM
spring.kafka.consumer.aws-role-arn=arn:aws:iam::381492193153:role/role-plutus-kafka-ingestor-cross-acc-uat
spring.kafka.consumer.aws-sts-session-name=plutus-kafka-dev-session
spring.kafka.consumer.aws-sts-region=ap-south-1
spring.kafka.consumer.commit.batch-size=100
spring.kafka.consumer.commit.interval-millis=5000
spring.kafka.consumer.commit.max-deferred-commits=10
spring.kafka.consumer.in-memory-partitions=3

# DLQ MSK Cluster
spring.kafka.consumer.dlq-config.dlq-topic=dtd-gam-business-event-dlq
spring.kafka.consumer.dlq-config.bootstrap-servers=b-1.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9092,b-2.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9092
spring.kafka.consumer.dlq-config.value-serializer=com.kotak.orchestrator.orchestrator.serializer.PlutusAvroSerializer
spring.kafka.consumer.dlq-config.security-protocol=AWS_MSK_IAM

# If using SCRAM fallback for DLQ, uncomment and set these:
# spring.kafka.consumer.dlq-config.sasl-scram-username=your-username
# spring.kafka.consumer.dlq-config.sasl-scram-password=your-password

