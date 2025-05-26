package com.kotak.orchestrator.orchestrator.consumer;

import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.orchestrator.orchestrator.entity.PlutusFinacleDataEntity;
import com.kotak.orchestrator.orchestrator.schema.BusinessEvent;
import com.kotak.orchestrator.orchestrator.schema.DtdGamBusinessEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.ReceiverRecord;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlutusDtdBusinessEventConsumer implements MessageConsumer<DtdGamBusinessEvent> {

    private final PlutusFinacleDataRepository repository;

    @Override
    public void process(ReceiverRecord<String, DtdGamBusinessEvent> receiverRecord) {
        BusinessEvent data = receiverRecord.value().getEvent();

        if (data == null) {
            log.warn("️ Received null BusinessEvent.");
            return;
        }

        try {
            PlutusFinacleDataEntity entity = mapToEntity(data);
            repository.save(entity);

            log.info(" Saved DTD Event with TRAN_ID: {}", toStr(data.getTRANID()));
            receiverRecord.receiverOffset().acknowledge();

        } catch (Exception e) {
            log.error(" Error while saving DTD Event: {}", e.getMessage(), e);
        }
    }

    @Override
    public String partitionKey(DtdGamBusinessEvent data) {
        return toStr(data.getEvent() != null ? data.getEvent().getTRANID() : null);
    }

    private String toStr(Object obj) {
        return obj != null ? obj.toString() : null;
    }

    private PlutusFinacleDataEntity mapToEntity(BusinessEvent data) {
        PlutusFinacleDataEntity entity = new PlutusFinacleDataEntity();

        entity.setEffective_bal(data.getEFFECTIVEBAL());
        entity.setClr_bal(data.getCLRBALAMT());
        entity.setForacid(data.getFORACID() != null ? data.getFORACID().array() : null);
        entity.setLast_bal_updated_date(data.getLASTBALUPDATEDDATE());
        entity.setSchm_code(data.getSCHMCODE().array());
        entity.setCif_id(data.getCIFID().array());
        entity.setAcct_name(data.getACCTNAME().array());
        entity.setTran_amt(data.getTRANAMT());
        entity.setTran_date(data.getTRANDATE().toString());
        entity.setTran_id(data.getTRANID().array());
        entity.setTran_particular(data.getTRANPARTICULAR().array());
        entity.setAcid(data.getACID().array());
        entity.setValue_date((String) data.getVALUEDATE());
        entity.setReversal_date((String) data.getREVERSALDATE());
        entity.setTran_type(data.getTRANTYPE().array());
        entity.setTran_sub_type(data.getTRANSUBTYPE().array());
        entity.setPart_tran_type(data.getPARTTRANTYPE().array());
        entity.setGl_sub_head_code(data.getGLSUBHEADCODE().array());
        entity.setRef_num(data.getREFNUM().array());
        entity.setRef_amt(data.getREFAMT());
        entity.setCust_id(data.getCUSTID().array());
        entity.setBr_code(data.getBRCODE().array());
        entity.setCrncy_code(data.getCRNCYCODE().array());
        entity.setTran_crncy_code(data.getTRANCRNCYCODE().array());
        entity.setSol_id(data.getSOLID().array());
        entity.setBank_code(data.getBANKCODE().array());
        entity.setTrea_ref_num(data.getTREAREFNUM().array());
        entity.setTran_rmks(data.getTRANRMKS().array());
        entity.setTran_particular_2(data.getTRANPARTICULAR2().array());
        entity.setAcct_balance(data.getACCTBALANCE());
        entity.setAvailable_amt(data.getAVAILABLEAMT());

        return entity;
    }
}



package com.kotak.orchestrator.orchestrator.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "plutus_finacle_transaction_details")
public class PlutusFinacleDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Primary Account Fields
    @Column(name = "foracid")
    private String foracid;

    @Column(name = "acct_cls_flg")
    private String acctClsFlg;

    @Column(name = "acct_crncy_code")
    private String acctCrncyCode;

    @Column(name = "acct_name")
    private String acctName;

    @Column(name = "acct_ownership")
    private String acctOwnership;

    @Column(name = "acct_opn_date")
    private String acctOpnDate;

    @Column(name = "acct_type")
    private String acctType;

    @Column(name = "acct_bal")
    private Double acctBal;

    @Column(name = "avail_bal")
    private Double availBal;

    // Transaction Fields
    @Column(name = "tran_amt")
    private Double tranAmt;

    @Column(name = "tran_date")
    private String tranDate;

    @Column(name = "tran_particular")
    private String tranParticular;

    @Column(name = "tran_time")
    private String tranTime;

    @Column(name = "tran_type")
    private String tranType;

    @Column(name = "txn_code")
    private String txnCode;

    @Column(name = "txn_sub_type")
    private String txnSubType;

    // Reference and Narration Fields
    @Column(name = "ref_num")
    private String refNum;

    @Column(name = "ref_doc_num")
    private String refDocNum;

    @Column(name = "narrative")
    private String narrative;

    @Column(name = "part_tran_type")
    private String partTranType;

    // Linked/Counterparty Fields
    @Column(name = "linked_acc_no")
    private String linkedAccNo;

    @Column(name = "linked_branch_code")
    private String linkedBranchCode;

    @Column(name = "linked_crncy_code")
    private String linkedCrncyCode;

    @Column(name = "linked_name")
    private String linkedName;

    // Timestamp Fields
    @Column(name = "msg_ts")
    private String msgTs;

    // Add a created timestamp (optional)
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and setters below

    // ... (use Lombok or generate them manually)
}
