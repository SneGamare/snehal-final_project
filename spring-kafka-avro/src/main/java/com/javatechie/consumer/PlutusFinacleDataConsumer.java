package com.javatechie.consumer;

import com.javatechie.dto.PlutusFinacleData;
import com.javatechie.entity.PlutusFinacleDataEntity;
import com.javatechie.repository.PlutusFinacleDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlutusFinacleDataConsumer {

    @Autowired
    private PlutusFinacleDataRepository repository;
    
    @Value("${topic.plutus-finacle:plutus-finacle-topic}")
    private String topicName;

    @KafkaListener(topics = "${topic.plutus-finacle:plutus-finacle-topic}", groupId = "plutus-finacle-group")
    public void consume(ConsumerRecord<String, PlutusFinacleData> record) {
        String key = record.key();
        PlutusFinacleData data = record.value();
        log.info("Received PlutusFinacleData with key: {} and value: {}", key, data);

        // Convert Avro DTO to Entity
        PlutusFinacleDataEntity entity = convertToEntity(data);
        
        // Save to database
        repository.save(entity);
        log.info("Saved PlutusFinacleData to database with tranId: {}", entity.getTranId());
    }

    private PlutusFinacleDataEntity convertToEntity(PlutusFinacleData data) {
        PlutusFinacleDataEntity entity = new PlutusFinacleDataEntity();
        
        entity.setTranId(data.getTranId() != null ? data.getTranId().toString() : null);
        entity.setForacid(data.getForacid() != null ? data.getForacid().toString() : null);
        entity.setAcctName(data.getAcctName() != null ? data.getAcctName().toString() : null);
        entity.setLastTranDateCr(data.getLastTranDateCr() != null ? data.getLastTranDateCr().toString() : null);
        entity.setTranDate(data.getTranDate() != null ? data.getTranDate().toString() : null);
        entity.setPartTranSrlNum(data.getPartTranSrlNum() != null ? data.getPartTranSrlNum().toString() : null);
        entity.setDelFlg(data.getDelFlg() != null ? data.getDelFlg().toString() : null);
        entity.setTranType(data.getTranType() != null ? data.getTranType().toString() : null);
        entity.setTranSubType(data.getTranSubType() != null ? data.getTranSubType().toString() : null);
        entity.setPartTranType(data.getPartTranType() != null ? data.getPartTranType().toString() : null);
        entity.setGlSubHeadCode(data.getGlSubHeadCode() != null ? data.getGlSubHeadCode().toString() : null);
        entity.setAcid(data.getAcid() != null ? data.getAcid().toString() : null);
        entity.setValueDate(data.getValueDate() != null ? data.getValueDate().toString() : null);
        entity.setTranAmt(data.getTranAmt() != null ? data.getTranAmt() : null);
        entity.setTranParticular(data.getTranParticular() != null ? data.getTranParticular().toString() : null);
        entity.setEntryDate(data.getEntryDate() != null ? data.getEntryDate().toString() : null);
        entity.setPstdDate(data.getPstdDate() != null ? data.getPstdDate().toString() : null);
        entity.setRefNum(data.getRefNum() != null ? data.getRefNum().toString() : null);
        entity.setInstrmntType(data.getInstrmntType() != null ? data.getInstrmntType().toString() : null);
        entity.setInstrmntDate(data.getInstrmntDate() != null ? data.getInstrmntDate().toString() : null);
        entity.setInstrmntNum(data.getInstrmntNum() != null ? data.getInstrmntNum().toString() : null);
        entity.setTranRmks(data.getTranRmks() != null ? data.getTranRmks().toString() : null);
        entity.setCustId(data.getCustId() != null ? data.getCustId().toString() : null);
        entity.setBrCode(data.getBrCode() != null ? data.getBrCode().toString() : null);
        entity.setCrncyCode(data.getCrncyCode() != null ? data.getCrncyCode().toString() : null);
        entity.setTranCrncyCode(data.getTranCrncyCode() != null ? data.getTranCrncyCode().toString() : null);
        entity.setRefAmt(data.getRefAmt() != null ? data.getRefAmt() : null);
        entity.setSolId(data.getSolId() != null ? data.getSolId().toString() : null);
        entity.setBankCode(data.getBankCode() != null ? data.getBankCode().toString() : null);
        entity.setTreaRefNum(data.getTreaRefNum() != null ? data.getTreaRefNum().toString() : null);
        entity.setReversalDate(data.getReversalDate() != null ? data.getReversalDate().toString() : null);
        
        return entity;
    }
} 