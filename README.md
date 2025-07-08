2025-07-08T10:25:30.836Z  INFO 1 --- [s_application-3] c.k.o.o.failurehandler.DlqHandler        : DlqHandler publishing event to DLQ topic: dtd-gam-dlq
2025-07-08T10:25:30.836Z  INFO 1 --- [s_application-3] c.k.o.o.failurehandler.DlqHandler        : DLQ config - topic: dtd-gam-dlq, serializer: class com.kotak.orchestrator.orchestrator.serializer.PlutusAvroSerializer, bootstrapServers: b-1.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9092,b-2.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9092, securityProtocol: AWS_MSK_IAM
2025-07-08T10:25:30.836Z  WARN 1 --- [s_application-3] c.k.o.o.failurehandler.DlqHandler        : Already retried count: 0
2025-07-08T10:25:30.837Z ERROR 1 --- [s_application-3] c.k.o.o.failurehandler.DlqHandler        : Error publishing message to DLQ [dtd-gam-dlq]

java.lang.NullPointerException: null
        at java.base/java.util.concurrent.ConcurrentHashMap.putVal(ConcurrentHashMap.java:1011) ~[na:na]
        at java.base/java.util.concurrent.ConcurrentHashMap.put(ConcurrentHashMap.java:1006) ~[na:na]
        at java.base/java.util.Properties.put(Properties.java:1346) ~[na:na]
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.publishMessage(DlqHandler.java:67) ~[!/:0.0.1]
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.handle(DlqHandler.java:105) ~[!/:0.0.1]
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

2025-07-08T10:25:30.837Z ERROR 1 --- [s_application-3] c.k.o.o.c.GenericReactiveConsumer        : DLQ handling also failed. Message will be retried.

java.lang.RuntimeException: DLQ publishing failed
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.handle(DlqHandler.java:124) ~[!/:0.0.1]
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
        at com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler.handle(DlqHandler.java:105) ~[!/:0.0.1]
