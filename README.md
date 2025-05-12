package com.kotak.orchestrator.orchestrator.consumer;

import com.kotak.orchestrator.orchestrator.dto.PlutusFinacleData;
import com.kotak.orchestrator.orchestrator.entity.PlutusFinacleDataEntity;
import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.plutus.common.consumer.ConsumerConfiguration;
import com.kotak.plutus.common.consumer.GenericAvroConsumer;
import com.kotak.plutus.common.consumer.MetricUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.time.LocalDateTime;

@Slf4j
public class PlutusFinacleDataConsumer extends GenericAvroConsumer<PlutusFinacleData> {

    private final PlutusFinacleDataRepository repository;

    public PlutusFinacleDataConsumer(
            ConsumerConfiguration<PlutusFinacleData> config,
            MetricUtil metricUtil,
            PlutusFinacleDataRepository repository
    ) {
        super(config, metricUtil);
        this.repository = repository;
    }

    @Override
    protected void handleMessage(PlutusFinacleData data, ConsumerRecord<String, PlutusFinacleData> record) {
        PlutusFinacleDataEntity entity = new PlutusFinacleDataEntity();

        entity.setTranId(toStr(data.getTranId()));
        entity.setForacid(toStr(data.getForacid()));
        entity.setAcctName(toStr(data.getAcctName()));
        entity.setLastTranDateCr(toStr(data.getLastTranDateCr()));
        entity.setTranDate(toStr(data.getTranDate()));
        entity.setPartTranSrlNum(toStr(data.getPartTranSrlNum()));
        entity.setDelFlg(toStr(data.getDelFlg()));
        entity.setTranType(toStr(data.getTranType()));
        entity.setTranSubType(toStr(data.getTranSubType()));
        entity.setPartTranType(toStr(data.getPartTranType()));
        entity.setGlSubHeadCode(toStr(data.getGlSubHeadCode()));
        entity.setAcid(toStr(data.getAcid()));
        entity.setValueDate(toStr(data.getValueDate()));
        entity.setTranAmt(data.getTranAmt());
        entity.setTranParticular(toStr(data.getTranParticular()));
        entity.setEntryDate(toStr(data.getEntryDate()));
        entity.setPstdDate(toStr(data.getPstdDate()));
        entity.setRefNum(toStr(data.getRefNum()));
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

        repository.save(entity);
        log.info("Saved PlutusFinacleData to DB, tranId: {}", entity.getTranId());
    }

    private String toStr(Object value) {
        return value != null ? value.toString() : null;
    }
}
