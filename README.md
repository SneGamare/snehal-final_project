package com.kotak.orchestrator.orchestrator.consumer;

import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.orchestrator.orchestrator.entity.PlutusFinacleDataEntity;
import com.kotak.orchestrator.orchestrator.schema.BusinessEvent;
import com.kotak.orchestrator.orchestrator.schema.DtdGamBusinessEvent;
import com.kotak.orchestrator.orchestrator.util.CbsUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.ReceiverRecord;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlutusDtdBusinessEventConsumer implements MessageConsumer<DtdGamBusinessEvent> {

    private final PlutusFinacleDataRepository repository;

    @Override
    public void process(ReceiverRecord<String, DtdGamBusinessEvent> receiverRecord) {
        BusinessEvent data = receiverRecord.value().getEvent();

        if (data == null) {
            log.warn("Received null BusinessEvent.");
            return;
        }

        try {
            PlutusFinacleDataEntity entity = mapToEntity(data);
            repository.save(entity);

            log.info("Saved DTD Event with TRAN_ID: {}", CbsUtils.byteBufferToStr(data.getTRANID()));
            receiverRecord.receiverOffset().acknowledge();
        } catch (Exception e) {
            log.error("Error while saving DTD Event: {}", e.getMessage(), e);
        }
    }

    @Override
    public String partitionKey(DtdGamBusinessEvent data) {
        return CbsUtils.byteBufferToStr(data.getEvent() != null ? data.getEvent().getTRANID() : null);
    }

    private PlutusFinacleDataEntity mapToEntity(BusinessEvent data) {
        PlutusFinacleDataEntity entity = new PlutusFinacleDataEntity();

        entity.setForacid(CbsUtils.byteBufferToStr(data.getFORACID()));
        entity.setAcctCrncyCode(CbsUtils.byteBufferToStr(data.getCRNCYCODE()));
        entity.setAcctName(CbsUtils.byteBufferToStr(data.getACCTNAME()));
        entity.setAcctBal(CbsUtils.doubleToBigDecimal(data.getACCTBALANCE()) != null ? CbsUtils.doubleToBigDecimal(data.getACCTBALANCE()).doubleValue() : null);
        entity.setAvailBal(CbsUtils.doubleToBigDecimal(data.getAVAILABLEAMT()) != null ? CbsUtils.doubleToBigDecimal(data.getAVAILABLEAMT()).doubleValue() : null);
        entity.setTranAmt(CbsUtils.doubleToBigDecimal(data.getTRANAMT()) != null ? CbsUtils.doubleToBigDecimal(data.getTRANAMT()).doubleValue() : null);
        entity.setTranDate(CbsUtils.charSeqToStr(data.getTRANDATE()));
        entity.setTranParticular(CbsUtils.byteBufferToStr(data.getTRANPARTICULAR()));
        entity.setTranType(CbsUtils.byteBufferToStr(data.getTRANTYPE()));
        entity.setTxnSubType(CbsUtils.byteBufferToStr(data.getTRANSUBTYPE()));
        entity.setPartTranType(CbsUtils.byteBufferToStr(data.getPARTTRANTYPE()));
        entity.setRefNum(CbsUtils.byteBufferToStr(data.getREFNUM()));
        entity.setTxnCode(CbsUtils.byteBufferToStr(data.getGLSUBHEADCODE()));
        entity.setLinkedAccNo(CbsUtils.byteBufferToStr(data.getACID()));
        entity.setLinkedBranchCode(CbsUtils.byteBufferToStr(data.getBRCODE()));
        entity.setLinkedCrncyCode(CbsUtils.byteBufferToStr(data.getTRANCRNCYCODE()));
        entity.setLinkedName(CbsUtils.byteBufferToStr(data.getBANKCODE()));
        entity.setNarrative(CbsUtils.byteBufferToStr(data.getTRANRMKS()));
        entity.setTranTime(null); // Populate if available
        entity.setMsgTs(LocalDateTime.now().toString());
        entity.setCreatedAt(LocalDateTime.now());

        return entity;
    }
}
