
	at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:126)
	at org.hibernate.internal.NonContextualJdbcConnectionAccess.obtainConnection(NonContextualJdbcConnectionAccess.java:46)
	at org.hibernate.resource.jdbc.internal.LogicalConnectionManagedImpl.acquireConnectionIfNeeded(LogicalConnectionManagedImpl.java:126)
	... 61 more
Caused by: java.net.ConnectException: Connection refused
	at java.base/sun.nio.ch.Net.pollConnect(Native Method)
	at java.base/sun.nio.ch.Net.pollConnectNow(Net.java:682)
	at java.base/sun.nio.ch.NioSocketImpl.timedFinishConnect(NioSocketImpl.java:542)
	at java.base/sun.nio.ch.NioSocketImpl.connect(NioSocketImpl.java:592)
	at java.base/java.net.SocksSocketImpl.connect(SocksSocketImpl.java:327)
	at java.base/java.net.Socket.connect(Socket.java:751)
	at org.postgresql.core.PGStream.createSocket(PGStream.java:260)
	at org.postgresql.core.PGStream.<init>(PGStream.java:121)
	at org.postgresql.core.v3.ConnectionFactoryImpl.tryConnect(ConnectionFactoryImpl.java:140)
	at org.postgresql.core.v3.ConnectionFactoryImpl.openConnectionImpl(ConnectionFactoryImpl.java:268)
	... 75 more

[INFO] Running com.kotak.distributionmanager.datadistributionmanager.OdsVirtualApacDataCustomRepositoryImplTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.016 s -- in com.kotak.distributionmanager.datadistributionmanager.OdsVirtualApacDataCustomRepositoryImplTest
[INFO] Running com.kotak.distributionmanager.datadistributionmanager.TransactionServiceImplTest
2025-05-29T09:22:06.149Z  INFO 2054 --- [           main] c.k.d.d.s.impl.TransactionServiceImpl    : Handling CMS request for client: ClientA, requestId: 12345678
2025-05-29T09:22:06.151Z  WARN 2054 --- [           main] c.k.d.d.s.impl.TransactionServiceImpl    : No configuration found for client: ClientA
2025-05-29T09:22:06.151Z  WARN 2054 --- [           main] c.k.d.d.s.impl.TransactionServiceImpl    : No configuration  for client: ClientA
2025-05-29T09:22:06.155Z  INFO 2054 --- [           main] c.k.d.d.s.impl.TransactionServiceImpl    : Handling CMS request for client: ClientB, requestId: 123
2025-05-29T09:22:06.156Z  INFO 2054 --- [           main] c.k.d.d.s.impl.TransactionServiceImpl    : Returning response for requestId: 123, total records: 1
2025-05-29T09:22:06.160Z  INFO 2054 --- [           main] c.k.d.d.s.impl.TransactionServiceImpl    : Handling CMS request for client: ClientC, requestId: 987654
2025-05-29T09:22:06.160Z  INFO 2054 --- [           main] c.k.d.d.s.impl.TransactionServiceImpl    : Returning response for requestId: 987654, total records: 2
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.256 s -- in com.kotak.distributionmanager.datadistributionmanager.TransactionServiceImplTest
[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Errors: 
[ERROR]   DatadistributionmanagerApplicationTests.contextLoads » IllegalState Failed to load ApplicationContext for [WebMergedContextConfiguration@7b57587e testClass = com.kotak.distributionmanager.datadistributionmanager.DatadistributionmanagerApplicationTests, locations = [], classes = [com.kotak.distributionmanager.datadistributionmanager.DataDistributionManagerApplication], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = ["org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true"], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@267dc982, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@1c26273d, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@38b8b6c0, org.springframework.boot.test.web.reactor.netty.DisableReactorResourceFactoryGlobalResourcesContextCustomizerFactory$DisableReactorResourceFactoryGlobalResourcesContextCustomizerCustomizer@3240b2a4, org.springframework.boot.test.autoconfigure.OnFailureConditionReportContextCustomizerFactory$OnFailureConditionReportContextCustomizer@7dbe2ebf, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@29a98d9f, org.springframework.test.context.support.DynamicPropertiesContextCustomizer@0, org.springframework.boot.test.context.SpringBootTestAnnotation@367808e5], resourceBasePath = "src/main/webapp", contextLoader = org.springframework.boot.test.context.SpringBootContextLoader, parent = null]
[INFO] 
