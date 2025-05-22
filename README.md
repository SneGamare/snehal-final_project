package com.kotak.orchestrator.orchestrator.consumer;

import com.kotak.orchestrator.orchestrator.entity.DtdBusinessEventEntity;
import com.kotak.orchestrator.orchestrator.schema.BusinessEvent;
import com.kotak.orchestrator.orchestrator.schema.DtdGamBusinessEvent;
import com.kotak.orchestrator.orchestrator.service.DtdBusinessEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.ReceiverRecord;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlutusDtdBusinessEventConsumer implements MessageConsumer<DtdGamBusinessEvent> {

    private final DtdBusinessEventService service;

    @Override
    public void process(ReceiverRecord<String, DtdGamBusinessEvent> receiverRecord) {
        BusinessEvent data = receiverRecord.value().getEvent();

        if (data == null) {
            log.warn("⚠️ Received null BusinessEvent.");
            return;
        }

        try {
            DtdBusinessEventEntity entity = mapToEntity(data);
            service.save(entity);

            log.info("✅ Saved DTD Event with TRAN_ID: {}", toStr(data.getTRANID()));
            receiverRecord.receiverOffset().acknowledge();

        } catch (Exception e) {
            log.error("❌ Error while saving DTD Event: {}", e.getMessage(), e);
        }
    }

    @Override
    public String partitionKey(DtdGamBusinessEvent data) {
        return toStr(data.getEvent() != null ? data.getEvent().getTRANID() : null);
    }

    private String toStr(Object obj) {
        return obj != null ? obj.toString() : null;
    }

    private DtdBusinessEventEntity mapToEntity(BusinessEvent data) {
        DtdBusinessEventEntity entity = new DtdBusinessEventEntity();

        entity.setEffective_bal(data.getEFFECTIVEBAL());
        entity.setClr_bal(data.getCLRBAL());
        entity.setForacid(data.getFORACID());
        entity.setLast_bal_updated_date(data.getLASTBALUPDATEDDATE());
        entity.setSchm_code(data.getSCHMCODE());
        entity.setCif_id(data.getCIFID());
        entity.setAcct_name(data.getACCTNAME());
        entity.setTran_amt(data.getTRANAMT());
        entity.setTran_date(data.getTRANDATE());
        entity.setTran_id(data.getTRANID());
        entity.setTran_particular(data.getTRANPARTICULAR());
        entity.setAcid(data.getACID());
        entity.setValue_date(data.getVALUEDATE());
        entity.setReversal_date(data.getREVERSALDATE());
        entity.setTran_type(data.getTRANTYPE());
        entity.setTran_sub_type(data.getTRANSUBTYPE());
        entity.setPart_tran_type(data.getPARTTRANTYPE());
        entity.setGl_sub_head_code(data.getGLSUBHEADCODE());
        entity.setRef_num(data.getREFNUM());
        entity.setRef_amt(data.getREFAMT());
        entity.setCust_id(data.getCUSTID());
        entity.setBr_code(data.getBRCODE());
        entity.setCrncy_code(data.getCRNCYCODE());
        entity.setTran_crncy_code(data.getTRANCRNCYCODE());
        entity.setSol_id(data.getSOLID());
        entity.setBank_code(data.getBANKCODE());
        entity.setTrea_ref_num(data.getTREAREFNUM());
        entity.setTran_rmks(data.getTRANRMKS());
        entity.setTran_particular_2(data.getTRANPARTICULAR2());
        entity.setAcct_balance(data.getACCTBALANCE());
        entity.setAvailable_amt(data.getAVAILABLEAMT());

        return entity;
    }
}
