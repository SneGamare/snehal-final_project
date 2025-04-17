Validation , transformation , saved    transformation ->   before saving the data we need to validate the data mandatory fileds   transform into plates format   Enrichment -> virtual apache table  h2 DB mai table create then   connection with REF_NUM 

Then saved db in H2   row data we need to manage in JSON   only finacle_upi we need to store 
  UPI _data store -> DTO we need to discuss     



 

ACID
ID
pp_ID
TRAN_DATE
TRAN_ID
ACID
TRAN_AMT
FORACID
REF_NUM
PP_cr_dt
Raw_Data
PP_cr_dt
Create_date
Modified_date




entity.setTranId(toStr(data.getTranId()));
        entity.setTranDate(toStr(data.getTranDate()));
        entity.setTranAmt(data.getTranAmt());
        entity.setAcid(toStr(data.getAcid()));
        entity.setForacid(toStr(data.getForacid()));
        entity.setRefNum(toStr(data.getRefNum()));

        // Other fields
        entity.setAcctName(toStr(data.getAcctName()));
        entity.setLastTranDateCr(toStr(data.getLastTranDateCr()));
        entity.setPartTranSrlNum(toStr(data.getPartTranSrlNum()));
        entity.setDelFlg(toStr(data.getDelFlg()));
        entity.setTranType(toStr(data.getTranType()));
        entity.setTranSubType(toStr(data.getTranSubType()));
        entity.setPartTranType(toStr(data.getPartTranType()));
        entity.setGlSubHeadCode(toStr(data.getGlSubHeadCode()));
        entity.setValueDate(toStr(data.getValueDate()));
        entity.setTranParticular(toStr(data.getTranParticular()));
        entity.setEntryDate(toStr(data.getEntryDate()));
        entity.setPstdDate(toStr(data.getPstdDate()));
        entity.setInstrmntType(toStr(data.getInstrmntType()));
        entity.setInstrmntDate(toStr(data.getInstrmntDate()));
        entity.setInstrmntNum(toStr(data.getInstrmntNum()));
        entity.setTranRmks(toStr(data.getTranRmks()));
        entity.setCustId(toStr(data.getCustId()));
        entity.setBrCode(toStr(data.getBrCode()));
        entity.setCrncyCode(toStr(data.getCrncyCode()));
        entity.setTranCrncyCode(toStr(data.getTranCrncyCode()));
        entity.setRefAmt(data.getRefAmt());
        entity.setSolId(toStr(data.getSolId()));
        entity.setBankCode(toStr(data.getBankCode()));
        entity.setTreaRefNum(toStr(data.getTreaRefNum()));
        entity.setReversalDate(toStr(data.getReversalDate()));
        entity.setReceivedAt(LocalDateTime.now());
Created_by
Modified_by
SourceSystem
PP_txn_dt![image](https://github.com/user-attachments/assets/02ae98ca-fcfd-40e3-972c-9f20da6a3126)









error :




error saving record:Not an array: {"type":"record","name":"PlutusFinacleData","namespace":"com.kotak.orchestrator.orchestrator.dto","fields":[{"name":"foracid","type":["null","string"],"default":null},{"name":"acctName","type":["null","string"],"default":null},{"name":"lastTranDateCr","type":["null","string"],"default":null},{"name":"tranDate","type":["null","string"],"default":null},{"name":"tranId","type":["null","string"],"default":null},{"name":"partTranSrlNum","type":["null","string"],"default":null},{"name":"delFlg","type":["null","string"],"default":null},{"name":"tranType","type":["null","string"],"default":null},{"name":"tranSubType","type":["null","string"],"default":null},{"name":"partTranType","type":["null","string"],"default":null},{"name":"glSubHeadCode","type":["null","string"],"default":null},{"name":"acid","type":["null","string"],"default":null},{"name":"valueDate","type":["null","string"],"default":null},{"name":"tranAmt","type":["null","double"],"default":null},{"name":"tranParticular","type":["null","string"],"default":null},{"name":"entryDate","type":["null","string"],"default":null},{"name":"pstdDate","type":["null","string"],"default":null},{"name":"refNum","type":["null","string"],"default":null},{"name":"instrmntType","type":["null","string"],"default":null},{"name":"instrmntDate","type":["null","string"],"default":null},{"name":"instrmntNum","type":["null","string"],"default":null},{"name":"tranRmks","type":["null","string"],"default":null},{"name":"custId","type":["null","string"],"default":null},{"name":"brCode","type":["null","string"],"default":null},{"name":"crncyCode","type":["null","string"],"default":null},{"name":"tranCrncyCode","type":["null","string"],"default":null},{"name":"refAmt","type":["null","double"],"default":null},{"name":"solId","type":["null","string"],"default":null},{"name":"bankCode","type":["null","string"],"default":null},{"name":"treaRefNum","type":["null","string"],"default":null},{"name":"reversalDate","type":["null","string"],"default":null}]} (through reference chain: com.kotak.orchestrator.orchestrator.dto.PlutusFinacleData["schema"]->org.apache.avro.Schema$RecordSchema["elementType"])

com.fasterxml.jackson.databind.JsonMappingException: Not an array: {"type":"record","name":"PlutusFinacleData","namespace":"com.kotak.orchestrator.orchestrator.dto","fields":[{"name":"foracid","type":["null","string"],"default":null},{"name":"acctName","type":["null","string"],"default":null},{"name":"lastTranDateCr","type":["null","string"],"default":null},{"name":"tranDate","type":["null","string"],"default":null},{"name":"tranId","type":["null","string"],"default":null},{"name":"partTranSrlNum","type":["null","string"],"default":null},{"name":"delFlg","type":["null","string"],"default":null},{"name":"tranType","type":["null","string"],"default":null},{"name":"tranSubType","type":["null","string"],"default":null},{"name":"partTranType","type":["null","string"],"default":null},{"name":"glSubHeadCode","type":["null","string"],"default":null},{"name":"acid","type":["null","string"],"default":null},{"name":"valueDate","type":["null","string"],"default":null},{"name":"tranAmt","type":["null","double"],"default":null},{"name":"tranParticular","type":["null","string"],"default":null},{"name":"entryDate","type":["null","string"],"default":null},{"name":"pstdDate","type":["null","string"],"default":null},{"name":"refNum","type":["null","string"],"default":null},{"name":"instrmntType","type":["null","string"],"default":null},{"name":"instrmntDate","type":["null","string"],"default":null},{"name":"instrmntNum","type":["null","string"],"default":null},{"name":"tranRmks","type":["null","string"],"default":null},{"name":"custId","type":["null","string"],"default":null},{"name":"brCode","type":["null","string"],"default":null},{"name":"crncyCode","type":["null","string"],"default":null},{"name":"tranCrncyCode","type":["null","string"],"default":null},{"name":"refAmt","type":["null","double"],"default":null},{"name":"solId","type":["null","string"],"default":null},{"name":"bankCode","type":["null","string"],"default":null},{"name":"treaRefNum","type":["null","string"],"default":null},{"name":"reversalDate","type":["null","string"],"default":null}]} (through reference chain: com.kotak.orchestrator.orchestrator.dto.PlutusFinacleData["schema"]->org.apache.avro.Schema$RecordSchema["elementType"])
	at com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(JsonMappingException.java:402) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(JsonMappingException.java:361) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.fasterxml.jackson.databind.ser.std.StdSerializer.wrapAndThrow(StdSerializer.java:323) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:780) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:772) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:479) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:318) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4719) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3964) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.kotak.orchestrator.orchestrator.consumer.PlutusFinacleDataConsumer.handleMessage(PlutusFinacleDataConsumer.java:117) ~[classes/:na]
	at com.kotak.orchestrator.orchestrator.consumer.PlutusFinacleDataConsumer.handleMessage(PlutusFinacleDataConsumer.java:20) ~[classes/:na]
	at com.kotak.orchestrator.orchestrator.consumer.GenericAvroConsumer.consume(GenericAvroConsumer.java:18) ~[classes/:na]
	at com.kotak.orchestrator.orchestrator.consumer.PlutusFinacleDataConsumer.listen(PlutusFinacleDataConsumer.java:36) ~[classes/:na]
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
	at org.springframework.messaging.handler.invocation.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:169) ~[spring-messaging-6.1.2.jar:6.1.2]
	at org.springframework.messaging.handler.invocation.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:119) ~[spring-messaging-6.1.2.jar:6.1.2]
	at org.springframework.kafka.listener.adapter.HandlerAdapter.invoke(HandlerAdapter.java:56) ~[spring-kafka-3.1.1.jar:3.1.1]
	at org.springframework.kafka.listener.adapter.MessagingMessageListenerAdapter.invokeHandler(MessagingMessageListenerAdapter.java:376) ~[spring-kafka-3.1.1.jar:3.1.1]
	at org.springframework.kafka.listener.adapter.RecordMessagingMessageListenerAdapter.onMessage(RecordMessagingMessageListenerAdapter.java:92) ~[spring-kafka-3.1.1.jar:3.1.1]
	at org.springframework.kafka.listener.adapter.RecordMessagingMessageListenerAdapter.onMessage(RecordMessagingMessageListenerAdapter.java:53) ~[spring-kafka-3.1.1.jar:3.1.1]
	at org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer.doInvokeOnMessage(KafkaMessageListenerContainer.java:2848) ~[spring-kafka-3.1.1.jar:3.1.1]
	at org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer.invokeOnMessage(KafkaMessageListenerContainer.java:2826) ~[spring-kafka-3.1.1.jar:3.1.1]
	at org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer.lambda$doInvokeRecordListener$56(KafkaMessageListenerContainer.java:2744) ~[spring-kafka-3.1.1.jar:3.1.1]
	at io.micrometer.observation.Observation.observe(Observation.java:565) ~[micrometer-observation-1.12.1.jar:1.12.1]
	at org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer.doInvokeRecordListener(KafkaMessageListenerContainer.java:2742) ~[spring-kafka-3.1.1.jar:3.1.1]
	at org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer.doInvokeWithRecords(KafkaMessageListenerContainer.java:2595) ~[spring-kafka-3.1.1.jar:3.1.1]
	at org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer.invokeRecordListener(KafkaMessageListenerContainer.java:2481) ~[spring-kafka-3.1.1.jar:3.1.1]
	at org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer.invokeListener(KafkaMessageListenerContainer.java:2123) ~[spring-kafka-3.1.1.jar:3.1.1]
	at org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer.invokeIfHaveRecords(KafkaMessageListenerContainer.java:1478) ~[spring-kafka-3.1.1.jar:3.1.1]
	at org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer.pollAndInvoke(KafkaMessageListenerContainer.java:1442) ~[spring-kafka-3.1.1.jar:3.1.1]
	at org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer.run(KafkaMessageListenerContainer.java:1313) ~[spring-kafka-3.1.1.jar:3.1.1]
	at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804) ~[na:na]
	at java.base/java.lang.Thread.run(Thread.java:1583) ~[na:na]
Caused by: org.apache.avro.AvroRuntimeException: Not an array: {"type":"record","name":"PlutusFinacleData","namespace":"com.kotak.orchestrator.orchestrator.dto","fields":[{"name":"foracid","type":["null","string"],"default":null},{"name":"acctName","type":["null","string"],"default":null},{"name":"lastTranDateCr","type":["null","string"],"default":null},{"name":"tranDate","type":["null","string"],"default":null},{"name":"tranId","type":["null","string"],"default":null},{"name":"partTranSrlNum","type":["null","string"],"default":null},{"name":"delFlg","type":["null","string"],"default":null},{"name":"tranType","type":["null","string"],"default":null},{"name":"tranSubType","type":["null","string"],"default":null},{"name":"partTranType","type":["null","string"],"default":null},{"name":"glSubHeadCode","type":["null","string"],"default":null},{"name":"acid","type":["null","string"],"default":null},{"name":"valueDate","type":["null","string"],"default":null},{"name":"tranAmt","type":["null","double"],"default":null},{"name":"tranParticular","type":["null","string"],"default":null},{"name":"entryDate","type":["null","string"],"default":null},{"name":"pstdDate","type":["null","string"],"default":null},{"name":"refNum","type":["null","string"],"default":null},{"name":"instrmntType","type":["null","string"],"default":null},{"name":"instrmntDate","type":["null","string"],"default":null},{"name":"instrmntNum","type":["null","string"],"default":null},{"name":"tranRmks","type":["null","string"],"default":null},{"name":"custId","type":["null","string"],"default":null},{"name":"brCode","type":["null","string"],"default":null},{"name":"crncyCode","type":["null","string"],"default":null},{"name":"tranCrncyCode","type":["null","string"],"default":null},{"name":"refAmt","type":["null","double"],"default":null},{"name":"solId","type":["null","string"],"default":null},{"name":"bankCode","type":["null","string"],"default":null},{"name":"treaRefNum","type":["null","string"],"default":null},{"name":"reversalDate","type":["null","string"],"default":null}]}
	at org.apache.avro.Schema.getElementType(Schema.java:363) ~[avro-1.11.0.jar:1.11.0]
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:688) ~[jackson-databind-2.15.3.jar:2.15.3]
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:772) ~[jackson-databind-2.15.3.jar:2.15.3]
	... 33 common frames omitted



 
