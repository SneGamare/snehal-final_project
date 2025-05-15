[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 1.443 s <<< FAILURE! -- in com.kotak.orchestrator.orchestrator.consumer.GenericReactiveConsumerTest
[ERROR] com.kotak.orchestrator.orchestrator.consumer.GenericReactiveConsumerTest -- Time elapsed: 1.443 s <<< ERROR!
java.lang.NoClassDefFoundError: org/apache/commons/lang3/ArrayFill
        at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.writeEOFRecord(TarArchiveOutputStream.java:677)
        at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.finish(TarArchiveOutputStream.java:421)
        at org.testcontainers.containers.ContainerState.copyFileToContainer(ContainerState.java:356)
        at org.testcontainers.containers.KafkaContainer.containerIsStarting(KafkaContainer.java:199)
        at org.testcontainers.containers.GenericContainer.containerIsStarting(GenericContainer.java:712)
        at org.testcontainers.containers.GenericContainer.tryStart(GenericContainer.java:489)
        at org.testcontainers.containers.GenericContainer.lambda$doStart$0(GenericContainer.java:354)
        at org.rnorth.ducttape.unreliables.Unreliables.retryUntilSuccess(Unreliables.java:81)
        at org.testcontainers.containers.GenericContainer.doStart(GenericContainer.java:344)
        at org.testcontainers.containers.GenericContainer.start(GenericContainer.java:330)
        at com.kotak.orchestrator.orchestrator.integration.config.ContainerConfig.kafkaContainer(ContainerConfig.java:37)
        at com.kotak.orchestrator.orchestrator.integration.testutils.KafkaTestBase.setUpBeforeClass(KafkaTestBase.java:25)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        Suppressed: java.lang.NoClassDefFoundError: org/apache/commons/lang3/ArrayFill
                at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.writeEOFRecord(TarArchiveOutputStream.java:677)
                at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.finish(TarArchiveOutputStream.java:421)
                at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.close(TarArchiveOutputStream.java:303)
                at org.testcontainers.containers.ContainerState.copyFileToContainer(ContainerState.java:363)
                ... 11 more
        Caused by: java.lang.ClassNotFoundException: org.apache.commons.lang3.ArrayFill
                ... 15 more
Caused by: java.lang.ClassNotFoundException: org.apache.commons.lang3.ArrayFill
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:528)
        ... 14 more

[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Errors: 
[ERROR]   GenericReactiveConsumerTest>KafkaTestBase.setUpBeforeClass:25 » NoClassDefFound org/apache/commons/lang3/ArrayFill
[ERROR]   PlutusFinacleDataConsumerTest.testProcess:36 Mockito 
Mockito cannot mock this class: class reactor.kafka.receiver.ReceiverRecord.

If you're not sure why you're getting this error, please open an issue on GitHub.


Java               : 23
JVM vendor name    : Oracle Corporation
JVM vendor version : 23.0.1+11-39
JVM name           : OpenJDK 64-Bit Server VM
JVM version        : 23.0.1+11-39
JVM info           : mixed mode, sharing
OS name            : Mac OS X
OS version         : 15.4.1


You are seeing this disclaimer because Mockito is configured to create inlined mocks.
You can learn about inline mocks and their limitations under item #39 of the Mockito class javadoc.

Underlying exception : org.mockito.exceptions.base.MockitoException: Could not modify all classes [class java.lang.Object, class reactor.kafka.receiver.ReceiverRecord, class org.apache.kafka.clients.consumer.ConsumerRecord]
[INFO] 
[ERROR] Tests run: 8, Failures: 0, Errors: 2, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.244 s
[INFO] Finished at: 2025-05-15T15:25:47+05:30
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.1.2:test (default-test) on project orchestrator-service: 
[ERROR] 
[ERROR] Please refer to /Users/SnehalGamare/IdeaProjects/orchestrator-service/target/surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
