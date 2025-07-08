2025-07-08T05:38:16.096Z ERROR 1 --- [s_application-1] c.k.o.o.c.GenericReactiveConsumer        : DLQ handling also failed. Message will be retried.

java.lang.RuntimeException: DLQ publishing failed
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.handle(DlqHandler.java:104) ~[!/:0.0.1]
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
Caused by: org.apache.kafka.common.KafkaException: Failed to construct kafka producer
        at org.apache.kafka.clients.producer.KafkaProducer.<init>(KafkaProducer.java:459) ~[kafka-clients-3.6.2.jar!/:na]
        at org.apache.kafka.clients.producer.KafkaProducer.<init>(KafkaProducer.java:287) ~[kafka-clients-3.6.2.jar!/:na]
        at org.apache.kafka.clients.producer.KafkaProducer.<init>(KafkaProducer.java:314) ~[kafka-clients-3.6.2.jar!/:na]
        at org.apache.kafka.clients.producer.KafkaProducer.<init>(KafkaProducer.java:299) ~[kafka-clients-3.6.2.jar!/:na]
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.publishMessage(DlqHandler.java:67) ~[!/:0.0.1]
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.handle(DlqHandler.java:85) ~[!/:0.0.1]
        ... 15 common frames omitted
Caused by: org.apache.kafka.common.KafkaException: Failed to create new NetworkClient
        at org.apache.kafka.clients.ClientUtils.createNetworkClient(ClientUtils.java:245) ~[kafka-clients-3.6.2.jar!/:na]
        at org.apache.kafka.clients.ClientUtils.createNetworkClient(ClientUtils.java:159) ~[kafka-clients-3.6.2.jar!/:na]
        at org.apache.kafka.clients.producer.KafkaProducer.newSender(KafkaProducer.java:507) ~[kafka-clients-3.6.2.jar!/:na]
        at org.apache.kafka.clients.producer.KafkaProducer.<init>(KafkaProducer.java:448) ~[kafka-clients-3.6.2.jar!/:na]
        ... 20 common frames omitted
Caused by: java.lang.IllegalArgumentException: Could not find a 'KafkaClient' entry in the JAAS configuration. System property 'java.security.auth.login.config' is not set
        at org.apache.kafka.common.security.JaasContext.defaultContext(JaasContext.java:150) ~[kafka-clients-3.6.2.jar!/:na]
        at org.apache.kafka.common.security.JaasContext.load(JaasContext.java:103) ~[kafka-clients-3.6.2.jar!/:na]
        at org.apache.kafka.common.security.JaasContext.loadClientContext(JaasContext.java:87) ~[kafka-clients-3.6.2.jar!/:na]
        at org.apache.kafka.common.network.ChannelBuilders.create(ChannelBuilders.java:167) ~[kafka-clients-3.6.2.jar!/:na]
        at org.apache.kafka.common.network.ChannelBuilders.clientChannelBuilder(ChannelBuilders.java:81) ~[kafka-clients-3.6.2.jar!/:na]
        at org.apache.kafka.clients.ClientUtils.createChannelBuilder(ClientUtils.java:117) ~[kafka-clients-3.6.2.jar!/:na]
        at org.apache.kafka.clients.ClientUtils.createNetworkClient(ClientUtils.java:217) ~[kafka-clients-3.6.2.jar!/:na]
        ... 23 common frames omitted




# Logging Configuration
logging.level.root=info

# Kafka Consumer Configuration
spring.kafka.consumer.bootstrap-servers=b-1.uatrosmsk.x7g3kf.c4.kafka.ap-south-1.amazonaws.com:9098,b-2.uatrosmsk.x7g3kf.c4.kafka.ap-south-1.amazonaws.com:9098
spring.kafka.consumer.group-id=plutus-consumer-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=com.kotak.orchestrator.orchestrator.serializer.PlutusDtdDeserializer
spring.kafka.consumer.enable-auto-commit=true
spring.kafka.consumer.fetch-min-size=1024
spring.kafka.consumer.max-poll-records=500
spring.kafka.consumer.metrics.enabled=true
spring.kafka.consumer.topic=dtd-gam-business-event
spring.kafka.consumer.processor-thread-pool-name=plutus_application

# AWS IAM Authentication for MSK
spring.kafka.consumer.security-protocol=AWS_MSK_IAM
spring.kafka.consumer.aws-role-arn=arn:aws:iam::381492193153:role/role-plutus-kafka-ingestor-cross-acc-uat
spring.kafka.consumer.aws-sts-session-name=plutus-kafka-dev-session
spring.kafka.consumer.aws-sts-region=ap-south-1


#DlQ Properties

# DLQ Configuration (Fixed and Cleaned)
spring.kafka.consumer.dlq-config.bootstrap-servers=b-2.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9092,b-1.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9092
spring.kafka.consumer.dlq-config.dlq-topic=dtd-gam-business-event-dlq
spring.kafka.consumer.dlq-config.value-serializer=com.kotak.orchestrator.orchestrator.serializer.PlutusAvroSerializer
spring.kafka.consumer.dlq-config.security-protocol=AWS_MSK_IAM
spring.kafka.consumer.dlq-config.aws-role-arn=arn:aws:iam::977098984058:role/iam-role-plutus-msk-dev-01
spring.kafka.consumer.dlq-config.aws-sts-session-name=plutus-session
spring.kafka.consumer.dlq-config.aws-sts-region=ap-south-1

#spring.kafka.consumer.dlq-config.sasl-scram-username=your-username
#spring.kafka.consumer.dlq-config.sasl-scram-password=your-password


spring.kafka.consumer.dlq.awsRoleArn=arn:aws:iam::977098984058:role/iam-role-plutus-msk-dev-01
spring.kafka.consumer.dlq.awsRoleSessionName=plutus-session
spring.kafka.consumer.dlq.awsStsRegion=ap-south-1
spring.kafka.consumer.dlq.valueSerializer=com.kotak.orchestrator.orchestrator.serializer.PlutusAvroSerializer

#dlq-test.spring.kafka.consumer.aws-role-arn=arn:aws:iam::977098984058:role/iam-role-plutus-msk-dev-01
spring.kafka.consumer.commit.batch-size=100
spring.kafka.consumer.commit.interval-millis=5000
spring.kafka.consumer.commit.max-deferred-commits=10
spring.kafka.consumer.in-memory-partitions=3



# Kafka Producer Configuration
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=com.kotak.orchestrator.orchestrator.serializer.PlutusFinacleSerializer
spring.kafka.producer.topic=dtd-business-event

# JPA & Database Configuration
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# AWS Secrets Manager
spring.datasource.url=jdbc:postgresql://plutus-rds-aurora-postgres-dev.cluster-cnmg44oeipzz.ap-south-1.rds.amazonaws.com:5433/plutusdb_dev
aws.secret.name=secret-plutus-dev-nonprod-01
aws.region=ap-south-1
spring.datasource.driver-class-name=org.postgresql.Driver

# Optional Database Configurations (Commented Out)

# PostgreSQL
#spring.datasource.url=jdbc:postgresql://plutus-rds-aurora-postgres-dev.cluster-cnmg44oeipzz.ap-south-1.rds.amazonaws.com:5433/plutusdb_dev
#spring.datasource.username=plutus_app_user_dev
#spring.datasource.password=Plutus@123
#spring.datasource.driver-class-name=org.postgresql.Driver

# H2 (In-Memory)
#spring.datasource.url=jdbc:h2:mem:testdb
#spring.datasource.driverClassName=org.h2.Driver
#spring.datasource.username=sa
#spring.datasource.password=
#spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
#spring.h2.console.enabled=true
#spring.h2.console.path=/h2-console
