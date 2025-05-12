@Data
public class PlutusDto {
    PlutusFinacleDataDTO plutusFinacleDataDTO;
}


package com.example.consumer;

import com.example.dto.PlutusDto;
import com.example.dto.PlutusFinacleDataDTO;
import com.example.producer.JsonKafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotak.plutus.common.schema.PlutusFinacleData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

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

