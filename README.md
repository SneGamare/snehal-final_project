[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 1.059 s <<< FAILURE! -- in com.kotak.orchestrator.orchestrator.OrchestratorServiceApplicationTest
[ERROR] com.kotak.orchestrator.orchestrator.OrchestratorServiceApplicationTest -- Time elapsed: 1.059 s <<< ERROR!
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
16:50:19.583 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest]: KafkaIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
16:50:19.662 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration com.kotak.orchestrator.orchestrator.OrchestratorServiceApplication for test class com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.213 s <<< FAILURE! -- in com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest
[ERROR] com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest -- Time elapsed: 0.213 s <<< ERROR!
org.testcontainers.containers.ContainerFetchException: Can't get Docker image: RemoteDockerImage(imageName=confluentinc/cp-kafka:confluentinc/cp-kafka, imagePullPolicy=DefaultPullPolicy(), imageNameSubstitutor=org.testcontainers.utility.ImageNameSubstitutor$LogWrappedImageNameSubstitutor@3451fc88)
	at org.testcontainers.containers.GenericContainer.getDockerImageName(GenericContainer.java:1364)
	at org.testcontainers.containers.GenericContainer.doStart(GenericContainer.java:359)
	at org.testcontainers.containers.GenericContainer.start(GenericContainer.java:330)
	at com.kotak.orchestrator.orchestrator.integration.config.KafkaIntegrationTest.setup(KafkaIntegrationTest.java:28)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
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
	... 5 more
