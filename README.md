package com.kotak.smartmessageprocessorservice.smartmessageprocessor.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotak.plutus.common.consumer.GenericAvroConsumer;
import com.kotak.smartmessageprocessorservice.smartmessageprocessor.entity.PlutusDto;
import com.kotak.smartmessageprocessorservice.smartmessageprocessor.entity.PlutusFinacleDataDTO;
import com.kotak.smartmessageprocessorservice.smartmessageprocessor.entity.PlutusFinacleDataEntity;
import com.kotak.smartmessageprocessorservice.smartmessageprocessor.model.PlutusFinacleData;
import com.kotak.smartmessageprocessorservice.smartmessageprocessor.producer.JsonKafkaProducer;
import com.kotak.smartmessageprocessorservice.smartmessageprocessor.repository.SmpDataRepository;
import com.kotak.smartmessageprocessorservice.smartmessageprocessor.validator.PlutusDataValidator;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Service
public class KafkaEventConsumer extends GenericAvroConsumer<PlutusFinacleData> {

    private final JsonKafkaProducer jsonKafkaProducer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaEventConsumer(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @Override
    protected void handleMessage(PlutusFinacleData plutusFinacleData, ConsumerRecord<String, PlutusFinacleData> consumerRecord) {
        // Convert Avro to DTO
        PlutusFinacleDataDTO dto = mapToDTO(plutusFinacleData);

        // Wrap in PlutusDto
        PlutusDto wrapped = new PlutusDto(dto);

        try {
            // Optional: Log JSON for debug
            String json = objectMapper.writeValueAsString(wrapped);
            System.out.println("Converted JSON: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // or use proper logger
        }

        // Send to JSON Kafka topic
        jsonKafkaProducer.send(wrapped);
    }

    private PlutusFinacleDataDTO mapToDTO(PlutusFinacleData avro) {
        PlutusFinacleDataDTO dto = new PlutusFinacleDataDTO();
        dto.setForacid(get(avro.getForacid()));
        dto.setAcctName(get(avro.getAcctName()));
        dto.setLastTranDateCr(get(avro.getLastTranDateCr()));
        dto.setTranDate(get(avro.getTranDate()));
        dto.setTranId(get(avro.getTranId()));
        dto.setPartTranSrlNum(get(avro.getPartTranSrlNum()));
        dto.setDelFlg(get(avro.getDelFlg()));
        dto.setTranType(get(avro.getTranType()));
        dto.setTranSubType(get(avro.getTranSubType()));
        dto.setPartTranType(get(avro.getPartTranType()));
        dto.setGlSubHeadCode(get(avro.getGlSubHeadCode()));
        dto.setAcid(get(avro.getAcid()));
        dto.setValueDate(get(avro.getValueDate()));
        dto.setTranAmt(avro.getTranAmt());
        dto.setTranParticular(get(avro.getTranParticular()));
        dto.setEntryDate(get(avro.getEntryDate()));
        dto.setPstdDate(get(avro.getPstdDate()));
        dto.setRefNum(get(avro.getRefNum()));
        dto.setInstrmntType(get(avro.getInstrmntType()));
        dto.setInstrmntDate(get(avro.getInstrmntDate()));
        dto.setInstrmntNum(get(avro.getInstrmntNum()));
        dto.setTranRmks(get(avro.getTranRmks()));
        dto.setCustId(get(avro.getCustId()));
        dto.setBrCode(get(avro.getBrCode()));
        dto.setCrncyCode(get(avro.getCrncyCode()));
        dto.setTranCrncyCode(get(avro.getTranCrncyCode()));
        dto.setRefAmt(avro.getRefAmt());
        dto.setSolId(get(avro.getSolId()));
        dto.setBankCode(get(avro.getBankCode()));
        dto.setTreaRefNum(get(avro.getTreaRefNum()));
        dto.setReversalDate(get(avro.getReversalDate()));
        return dto;
    }

    private String get(Object avroField) {
        return avroField != null ? avroField.toString() : null;
    }
}


/*    private final SmpDataRepository repository;
    private final PlutusDataValidator plutusDataValidator;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaEventConsumer(SmpDataRepository repository, PlutusDataValidator plutusDataValidator) {
        this.repository = repository;
        this.plutusDataValidator = plutusDataValidator;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "plutus-finacle-group")
    public void listen(ConsumerRecord<String, PlutusFinacleData> record) {
        consume(record);
    }


    @Override
    protected void handleMessage(PlutusFinacleData data, ConsumerRecord<String, PlutusFinacleData> consumerRecord) {

            try {
                // Validate mandatory fields
                plutusDataValidator.validate(data);

                PlutusFinacleDataEntity entity = new PlutusFinacleDataEntity();
                entity.setTranId(toStr(data.getTranId()));
                entity.setTranDate(toStr(data.getTranDate()));
                entity.setTranAmt(data.getTranAmt());
                entity.setAcid(toStr(data.getAcid()));
                entity.setForacid(toStr(data.getForacid()));
                entity.setRefNum(toStr(data.getRefNum()));
                entity.setReceivedAt(LocalDateTime.now());

                // Build rawData with all remaining fields (except the 6 already used above)
                Map<String, Object> rawMap = new HashMap<>();

                rawMap.put("acctName", toStr(data.getAcctName()));
                rawMap.put("lastTranDateCr", toStr(data.getLastTranDateCr()));
                rawMap.put("partTranSrlNum", toStr(data.getPartTranSrlNum()));
                rawMap.put("delFlg", toStr(data.getDelFlg()));
                rawMap.put("tranType", toStr(data.getTranType()));
                rawMap.put("tranSubType", toStr(data.getTranSubType()));
                rawMap.put("partTranType", toStr(data.getPartTranType()));
                rawMap.put("glSubHeadCode", toStr(data.getGlSubHeadCode()));
                rawMap.put("valueDate", toStr(data.getValueDate()));
                rawMap.put("tranParticular", toStr(data.getTranParticular()));
                rawMap.put("entryDate", toStr(data.getEntryDate()));
                rawMap.put("pstdDate", toStr(data.getPstdDate()));
                rawMap.put("instrmntType", toStr(data.getInstrmntType()));
                rawMap.put("instrmntDate", toStr(data.getInstrmntDate()));
                rawMap.put("instrmntNum", toStr(data.getInstrmntNum()));
                rawMap.put("tranRmks", toStr(data.getTranRmks()));
                rawMap.put("custId", toStr(data.getCustId()));
                rawMap.put("brCode", toStr(data.getBrCode()));
                rawMap.put("crncyCode", toStr(data.getCrncyCode()));
                rawMap.put("tranCrncyCode", toStr(data.getTranCrncyCode()));
                rawMap.put("refAmt", data.getRefAmt());
                rawMap.put("solId", toStr(data.getSolId()));
                rawMap.put("bankCode", toStr(data.getBankCode()));
                rawMap.put("treaRefNum", toStr(data.getTreaRefNum()));
                rawMap.put("reversalDate", toStr(data.getReversalDate()));

                entity.setRawData(objectMapper.writeValueAsString(rawMap));

                repository.save(entity);
                System.out.println(" Saved PlutusFinacleData to DB, tranId: {}"+ entity.getTranId());

            } catch (IllegalArgumentException e) {
                System.out.println(" Validation failed: {}"+ e.getMessage());
            } catch (Exception e) {
                System.out.println(" Error saving record: {}"+ e.getMessage()+ e);
            }

    }

    private String toStr(CharSequence input) {
        return input != null ? input.toString() : null;
    }*/




org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'kafkaEventConsumer' defined in file [/Users/SnehalGamare/IdeaProjects/smart-message-processor-service/target/classes/com/kotak/smartmessageprocessorservice/smartmessageprocessor/consumer/KafkaEventConsumer.class]: Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'jsonKafkaProducer': Injection of autowired dependencies failed
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:795) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:237) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1355) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1192) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:562) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:522) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:975) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:962) ~[spring-context-6.1.6.jar:6.1.6]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:624) ~[spring-context-6.1.6.jar:6.1.6]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.5.jar:3.2.5]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:754) ~[spring-boot-3.2.5.jar:3.2.5]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:456) ~[spring-boot-3.2.5.jar:3.2.5]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.5.jar:3.2.5]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1354) ~[spring-boot-3.2.5.jar:3.2.5]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1343) ~[spring-boot-3.2.5.jar:3.2.5]
	at com.kotak.smartmessageprocessorservice.smartmessageprocessor.SmartmessageprocessorApplication.main(SmartmessageprocessorApplication.java:10) ~[classes/:na]
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'jsonKafkaProducer': Injection of autowired dependencies failed
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:514) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1419) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:522) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:254) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1443) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1353) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:904) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:782) ~[spring-beans-6.1.6.jar:6.1.6]
	... 19 common frames omitted
Caused by: java.lang.IllegalArgumentException: Could not resolve placeholder 'spring.kafka.producer.topic' in value "${spring.kafka.producer.topic}"
	at org.springframework.util.PropertyPlaceholderHelper.parseStringValue(PropertyPlaceholderHelper.java:180) ~[spring-core-6.1.6.jar:6.1.6]
	at org.springframework.util.PropertyPlaceholderHelper.replacePlaceholders(PropertyPlaceholderHelper.java:126) ~[spring-core-6.1.6.jar:6.1.6]
	at org.springframework.core.env.AbstractPropertyResolver.doResolvePlaceholders(AbstractPropertyResolver.java:239) ~[spring-core-6.1.6.jar:6.1.6]
	at org.springframework.core.env.AbstractPropertyResolver.resolveRequiredPlaceholders(AbstractPropertyResolver.java:210) ~[spring-core-6.1.6.jar:6.1.6]
	at org.springframework.context.support.PropertySourcesPlaceholderConfigurer.lambda$processProperties$0(PropertySourcesPlaceholderConfigurer.java:200) ~[spring-context-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.resolveEmbeddedValue(AbstractBeanFactory.java:953) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1374) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1353) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.resolveFieldValue(AutowiredAnnotationBeanPostProcessor.java:784) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:767) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:145) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:508) ~[spring-beans-6.1.6.jar:6.1.6]
	... 31 common frames omitted


Process finished with exit code 1
