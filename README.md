[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 1.095 s <<< FAILURE! -- in com.kotak.orchestrator.orchestrator.OrchestratorServiceApplicationTest
[ERROR] com.kotak.orchestrator.orchestrator.OrchestratorServiceApplicationTest -- Time elapsed: 1.095 s <<< ERROR!
java.lang.ExceptionInInitializerError
	at java.base/jdk.internal.misc.Unsafe.ensureClassInitialized0(Native Method)
	at java.base/jdk.internal.misc.Unsafe.ensureClassInitialized(Unsafe.java:1160)
	at java.base/java.lang.reflect.Constructor.acquireConstructorAccessor(Constructor.java:549)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:486)
	at java.base/java.util.Optional.orElseGet(Optional.java:364)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: org.testcontainers.containers.ContainerFetchException: Can't get Docker image: RemoteDockerImage(imageName=confluentinc/cp-kafka:confluentinc/cp-kafka:7.5.2, imagePullPolicy=DefaultPullPolicy(), imageNameSubstitutor=org.testcontainers.utility.ImageNameSubstitutor$LogWrappedImageNameSubstitutor@3451fc88)
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
16:58:24.922 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest]: KafkaIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
16:58:24.992 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration com.kotak.orchestrator.orchestrator.OrchestratorServiceApplication for test class com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest
16:58:25.055 [main] INFO tc.confluentinc/cp-kafka:7.5.2 -- Creating container for image: confluentinc/cp-kafka:7.5.2
16:58:25.055 [main] WARN tc.confluentinc/cp-kafka:7.5.2 -- Reuse was requested but the environment does not support the reuse of containers
To enable reuse of containers, you must set 'testcontainers.reuse.enable=true' in a file located at /Users/SnehalGamare/.testcontainers.properties
16:58:25.102 [main] INFO tc.confluentinc/cp-kafka:7.5.2 -- Container confluentinc/cp-kafka:7.5.2 is starting: 7c19ce9f2f8360f062effcf4ff3f8de33d38fc65d178464cf74066255c74ac92
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.563 s <<< FAILURE! -- in com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest
[ERROR] com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest -- Time elapsed: 0.563 s <<< ERROR!
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
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.023 s -- in com.kotak.orchestrator.orchestrator.consumer.ConsumerConfigurationTest
[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Errors: 
[ERROR]   OrchestratorServiceApplicationTest » ExceptionInInitializer
[ERROR]   KafkaIntegrationTest.setup:28 » NoClassDefFound org/apache/commons/lang3/ArrayFill
