package com.kotak.orchestrator.orchestrator.consumer;

import com.kotak.orchestrator.orchestrator.schema.BusinessEvent;
import com.kotak.orchestrator.orchestrator.schema.DtdGamBusinessEvent;
import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.orchestrator.orchestrator.service.PlutusFinacleDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.ReceiverRecord;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlutusDtdBusinessEventConsumer implements MessageConsumer<DtdGamBusinessEvent> {

    private final PlutusFinacleDataRepository repository;


    @Autowired
    private PlutusFinacleDataService service;

    @Override
    public void process(ReceiverRecord<String, DtdGamBusinessEvent> receiverRecord) {
        var data = receiverRecord.value().getEvent();

        try {
            PlutusFinacleDataEntity entity = getPlutusFinacleDataEntity(data);

            service.saveData(entity);

            log.info("✅ Saved Finacle transaction with tran_id: {}", entity.getTran_id());
            receiverRecord.receiverOffset().acknowledge();

        } catch (Exception e) {
            log.error("❌ Error while processing Finacle data: {}", e.getMessage(), e);
        }
    }

    private static PlutusFinacleDataEntity getPlutusFinacleDataEntity(BusinessEvent data) {
        PlutusFinacleDataEntity entity = new PlutusFinacleDataEntity();
        entity.setEffective_bal(data.getEFFECTIVEBAL());
        entity.setClr_bal(data.getCLRBAL());
        entity.setForacid(data.getFORACID());
        entity.setTran_id(data.getTRANID());
        entity.setTran_amt(data.getTRANAMT());
        entity.setTran_particular(data.getTRANPARTICULAR());
        entity.setAcct_name(data.getACCTNAME());
        entity.setAcct_balance(data.getACCTBALANCE());
        entity.setAvailable_amt(data.getAVAILABLEAMT());
        entity.setTran_date(data.getTRANDATE());
        entity.setValue_date(data.getVALUEDATE());
        entity.setReversal_date(data.getREVERSALDATE());
        entity.setTran_type(data.getTRANTYPE());
        entity.setTran_sub_type(data.getTRANSUBTYPE());
        entity.setPart_tran_type(data.getPARTTRANTYPE());
        entity.setGl_sub_head_code(data.getGLSUBHEADCODE());
        entity.setAcid(data.getACID());
        entity.setRef_amt(data.getREFAMT());
        entity.setRef_num(data.getREFNUM());
        entity.setCust_id(data.getCUSTID());
        entity.setBr_code(data.getBRCODE());
        entity.setCrncy_code(data.getCRNCYCODE());
        entity.setTran_crncy_code(data.getTRANCRNCYCODE());
        entity.setSol_id(data.getSOLID());
        entity.setBank_code(data.getBANKCODE());
        entity.setTrea_ref_num(data.getTREAREFNUM());
        entity.setTran_rmks(data.getTRANRMKS());
        entity.setTran_particular_2(data.getTRANPARTICULAR2());
        return entity;
    }


    @Override
    public String partitionKey(DtdGamBusinessEvent data) {
        return toStr(data.getEvent().getTRANID()); // Group by transaction ID or similar field
    }

    private String toStr(Object obj) {
        return obj != null ? obj.toString() : null;
    }
}
