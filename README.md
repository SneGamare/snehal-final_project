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

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "plutus-finacle-group")
    public void listen(ConsumerRecord<String, PlutusFinacleData> record) {
        consume(record);
    }

    @Override
    protected void handleMessage(PlutusFinacleData plutusFinacleData, ConsumerRecord<String, PlutusFinacleData> consumerRecord) {
        // Convert Avro to DTO
        PlutusFinacleDataDTO dto = mapToDTO(plutusFinacleData);

        // Wrap in PlutusDto
        PlutusDto wrapped = new PlutusDto(dto);

        System.out.println("Converted JSON: " + wrapped);

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
