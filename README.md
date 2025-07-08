2025-07-08T06:51:21.550Z ERROR 1 --- [s_application-1] c.k.o.o.c.GenericReactiveConsumer        : DLQ handling also failed. Message will be retried.

java.lang.RuntimeException: DLQ publishing failed
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.handle(DlqHandler.java:98) ~[!/:0.0.1]
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
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.publishMessage(DlqHandler.java:63) ~[!/:0.0.1]
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.handle(DlqHandler.java:81) ~[!/:0.0.1]
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
