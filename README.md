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
