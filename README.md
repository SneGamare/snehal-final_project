17:07:34.241 [main] INFO org.testcontainers.DockerClientFactory -- ✔︎ Docker server version should be at least 1.6.0
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 2.831 s <<< FAILURE! -- in com.kotak.orchestrator.orchestrator.OrchestratorServiceApplicationTest
[ERROR] com.kotak.orchestrator.orchestrator.OrchestratorServiceApplicationTest -- Time elapsed: 2.831 s <<< ERROR!
java.lang.ExceptionInInitializerError
	at java.base/jdk.internal.misc.Unsafe.ensureClassInitialized0(Native Method)
	at java.base/jdk.internal.misc.Unsafe.ensureClassInitialized(Unsafe.java:1160)
	at java.base/java.lang.reflect.Constructor.acquireConstructorAccessor(Constructor.java:549)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:486)
	at java.base/java.util.Optional.orElseGet(Optional.java:364)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: org.testcontainers.containers.ContainerFetchException: Can't get Docker image: RemoteDockerImage(imageName=confluentinc/cp-kafka:confluentinc/cp-kafka:7.5.2, imagePullPolicy=DefaultPullPolicy(), imageNameSubstitutor=org.testcontainers.utility.ImageNameSubstitutor$LogWrappedImageNameSubstitutor@78d6c244)
	at org.testcontainers.containers.GenericContainer.getDockerImageName(GenericContainer.java:1364)
	at org.testcontainers.containers.GenericContainer.doStart(GenericContainer.java:359)
	at org.testcontainers.containers.GenericContainer.start(GenericContainer.java:330)
	at com.kotak.orchestrator.orchestrator.OrchestratorServiceApplicationTest.<clinit>(OrchestratorServiceApplicationTest.java:24)
	... 7 more
Caused by: com.github.dockerjava.api.exception.BadRequestException: Status 400: {"message":"invalid reference format"}

	at org.testcontainers.shaded.com.github.dockerjava.core.DefaultInvocationBuilder.execute(DefaultInvocationBuilder.java:237)
	at org.testcontainers.shaded.com.github.dockerjava.core.DefaultInvocationBuilder.get(DefaultInvocationBuilder.java:202)
	at org.testcontainers.shaded.com.github.dockerjava.core.DefaultInvocationBuilder.get(DefaultInvocationBuilder.java:74)
	at org.testcontainers.shaded.com.github.dockerjava.core.exec.InspectImageCmdExec.execute(InspectImageCmdExec.java:28)
	at org.testcontainers.shaded.com.github.dockerjava.core.exec.InspectImageCmdExec.execute(InspectImageCmdExec.java:13)
	at org.testcontainers.shaded.com.github.dockerjava.core.exec.AbstrSyncDockerCmdExec.exec(AbstrSyncDockerCmdExec.java:21)
	at org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd.exec(AbstrDockerCmd.java:33)
	at org.testcontainers.shaded.com.github.dockerjava.core.command.InspectImageCmdImpl.exec(InspectImageCmdImpl.java:39)
	at org.testcontainers.images.LocalImagesCache.refreshCache(LocalImagesCache.java:42)
	at org.testcontainers.images.AbstractImagePullPolicy.shouldPull(AbstractImagePullPolicy.java:24)
	at org.testcontainers.images.RemoteDockerImage.resolve(RemoteDockerImage.java:70)
	at org.testcontainers.images.RemoteDockerImage.resolve(RemoteDockerImage.java:28)
	at org.testcontainers.utility.LazyFuture.getResolvedValue(LazyFuture.java:20)
	at org.testcontainers.utility.LazyFuture.get(LazyFuture.java:41)
	at org.testcontainers.containers.GenericContainer.getDockerImageName(GenericContainer.java:1362)
	... 10 more

[INFO] Running com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest
17:07:34.328 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest]: KafkaIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
17:07:34.396 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration com.kotak.orchestrator.orchestrator.OrchestratorServiceApplication for test class com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest
17:07:34.464 [main] INFO tc.confluentinc/cp-kafka:7.5.2 -- Creating container for image: confluentinc/cp-kafka:7.5.2
17:07:34.464 [main] WARN tc.confluentinc/cp-kafka:7.5.2 -- Reuse was requested but the environment does not support the reuse of containers
To enable reuse of containers, you must set 'testcontainers.reuse.enable=true' in a file located at /Users/SnehalGamare/.testcontainers.properties
17:07:34.529 [main] INFO tc.confluentinc/cp-kafka:7.5.2 -- Container confluentinc/cp-kafka:7.5.2 is starting: b7ce228c2d18430b68ffb467e34049cfbd542d66110d04dbbf21fe2ae2c85eb4
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.624 s <<< FAILURE! -- in com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest
[ERROR] com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest -- Time elapsed: 0.624 s <<< ERROR!
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
	at com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest.setup(KafkaIntegrationTest.java:28)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	Suppressed: java.lang.NoClassDefFoundError: org/apache/commons/lang3/ArrayFill
		at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.writeEOFRecord(TarArchiveOutputStream.java:677)
		at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.finish(TarArchiveOutputStream.java:421)
		at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.close(TarArchiveOutputStream.java:303)
		at org.testcontainers.containers.ContainerState.copyFileToContainer(ContainerState.java:363)
		... 10 more
	Caused by: java.lang.ClassNotFoundException: org.apache.commons.lang3.ArrayFill
		... 14 more
Caused by: java.lang.ClassNotFoundException: org.apache.commons.lang3.ArrayFill
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526)
	... 13 more

[INFO] Running com.kotak.orchestrator.orchestrator.consumer.ConsumerConfigurationTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.018 s -- in com.kotak.orchestrator.orchestrator.consumer.ConsumerConfigurationTest
[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Errors: 
[ERROR]   OrchestratorServiceApplicationTest » ExceptionInInitializer
[ERROR]   KafkaIntegrationTest.setup:28 » NoClassDefFound org/apache/commons/lang3/ArrayFill
[INFO] 
[ERROR] Tests run: 6, Failures: 0, Errors: 2, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  12.123 s
[INFO] Finished at: 2025-05-30T17:07:34+05:30
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.1.2:test (default-test) on project orchestrator-service: 
[ERROR] 
[ERROR] Please refer to /Users/SnehalGamare/IdeaProjects/orchestrator-service/target/surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException

Process finished with exit code 1
