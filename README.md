package com.kotak.orchestrator.orchestrator.consumer;

import com.kotak.orchestrator.orchestrator.entity.PlutusFinacleDataEntity;
import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.plutus.common.consumer.MessageConsumer;
import com.kotak.schemas.finacle.PlutusFinacleData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.ReceiverRecord;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlutusFinacleDataConsumer implements MessageConsumer<PlutusFinacleData> {

    private final PlutusFinacleDataRepository repository;

    @Override
    public void process(ReceiverRecord<String, PlutusFinacleData> receiverRecord) {
        PlutusFinacleData data = receiverRecord.value();

        try {
            PlutusFinacleDataEntity entity = new PlutusFinacleDataEntity();
            entity.setTranId(toStr(data.getTranId()));
            entity.setForacid(toStr(data.getForacid()));
            entity.setPartTranType(toStr(data.getPartTranType()));
            entity.setTranAmt(toStr(data.getTranAmt()));
            entity.setTransactionType(toStr(data.getTransactionType()));
            entity.setValueDt(toStr(data.getValueDt()));
            entity.setTranParticular(toStr(data.getTranParticular()));
            entity.setRefNo(toStr(data.getRefNo()));
            entity.setPostedDate(toStr(data.getPostedDate()));
            entity.setRawJson(data.toString()); // Optionally serialize to JSON
            entity.setReceivedAt(LocalDateTime.now());

            repository.save(entity);
            log.info("✅ Saved Finacle transaction with tranId: {}", entity.getTranId());

            receiverRecord.receiverOffset().acknowledge();
        } catch (Exception e) {
            log.error("❌ Error while processing Finacle data: {}", e.getMessage(), e);
            // Optional: DLQ logic or alerting can go here
        }
    }

    @Override
    public String partitionKey(PlutusFinacleData data) {
        return toStr(data.getTranId()); // Group by transaction ID or similar field
    }

    private String toStr(Object obj) {
        return obj != null ? obj.toString() : null;
    }
}
