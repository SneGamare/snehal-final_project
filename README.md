SELECT * 
FROM information_schema.tables 
WHERE table_schema = 'plutus_ecollection' 
  AND table_name = 'plutus_finacle_transaction_details';




ALTER TABLE public.plutus_finacle_transaction_details
SET SCHEMA plutus_ecollection;



GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO your_user;


CREATE ROLE app_user WITH LOGIN PASSWORD 'your_password';
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO app_user;




-- Create the user if not already present
CREATE ROLE plutus_app_user WITH LOGIN PASSWORD 'your_password';

-- Grant access to the schema and tables
GRANT USAGE ON SCHEMA plutus_ecollection TO plutus_app_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO plutus_app_user;

-- Run as admin or schema owner
GRANT USAGE ON SCHEMA plutus_ecollection TO plutus_app_user_dev;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO plutus_app_user_dev;





Processing record: ConsumerRecord(topic = dtd-gam-business-event, partition = 1, leaderEpoch = null, offset = 1288, CreateTime = 1748333779240, serialized key size = 0, serialized value size = 775, headers = RecordHeaders(headers = [], isReadOnly = false), key = , value = {"source_scn": "8116547708012", "pos": "00000003470011597105", "table_op_ts": "2025-05-23 12:16:55.985037", "ros_op_ts": "2025-05-27 13:46:19", "Event": {"EFFECTIVE_BAL": 7.744072413673922E13, "FORACID": "08200050000449", "ACCT_CLS_FLG": null, "ACCT_CLS_DATE": null, "ACCT_CRNCY_CODE": null, "ACCT_NAME": "NAME OF 30328159", "ACCT_SHORT_NAME": null, "ACCT_OPN_DATE": null, "ACTIVE_STATUS": null, "ADHOC_LIM": null, "ALLOW_SWEEPS": null, "CIF_ID": "30328159", "CLEAN_ADHOC_LIM": null, "CLEAN_SINGLE_TRAN_LIM": null, "CLEAN_EMER_ADVN": null, "CLR_BAL_AMT": -2.252732962113564E13, "DACC_LIM": null, "DAFA_LIM": null, "DRWNG_POWER": null, "EMER_ADVN": null, "ENTITY_CRE_FLG": null, "FFD_CONTRIB_TO_ACCT": null, "ACCT_NUM": null, "FREZ_CODE": null, "FREZ_REASON_CODE": null, "FREZ_REASON_CODE_2": null, "FREZ_REASON_CODE_3": null, "FREZ_REASON_CODE_4": null, "FREZ_REASON_CODE_5": null, "FX_CLR_BAL_AMT": null, "FUTURE_OC_TOD_AMT": null, "LAST_MODIFIED_DATE": null, "LAST_TRAN_DATE_CR": null, "LAST_TRAN_DATE_DR": null, "LIEN_AMT": null, "MODE_OF_OPER_CODE": null, "NEXT_TRAN_SRL_NUM": null, "POOL_ID": null, "SANCT_LIM": null, "SCHM_TYPE": "SBA", "SCHM_CODE": "STEDG", "SCHM_SUB_TYPE": null, "SINGLE_TRAN_FLG": null, "SINGLE_TRAN_LIM": null, "SYSTEM_RESERVED_AMT": null, "SYSTEM_GEN_LIM": null, "SYS_BEHAVIOR_CODE": null, "UN_CLR_BAL_AMT": null, "USED_CLEAN_SINGLE_TRAN_LIM": null, "USED_OC_CLN_SINGLE_TRAN_LIM": null, "USED_SINGLE_TRAN_LIM": null, "USED_UN_CLR_OVER_DACC_AMT": null, "UTIL_FUTURE_BAL_AMT": null, "UTILISED_AMT": null, "LAST_BAL_UPDATED_DATE": 1747834460000, "TRAN_DATE": "2025-05-23 00:00:00", "TRAN_ID": "   M36315", "PART_TRAN_SRL_NUM": "   2", "DEL_FLG": "N", "TRAN_TYPE": "T", "TRAN_SUB_TYPE": "CI", "PART_TRAN_TYPE": "C", "GL_SUB_HEAD_CODE": "12005", "ACID": "KM4129922", "VALUE_DATE": "2025-05-23 00:00:00", "TRAN_AMT": 1.0, "TRAN_PARTICULAR": "IFT-RTN-AUTOREL-25052300MCMB-12-ACCOUNT DOES NOT", "ENTRY_USER_ID": "FIVUSR", "PSTD_USER_ID": "FIVUSR", "VFD_USER_ID": "FIVUSR", "ENTRY_DATE": "2025-05-23 17:47:22", "PSTD_DATE": "2025-05-23 17:47:25", "VFD_DATE": "2025-05-23 17:47:25", "RPT_CODE": null, "REF_NUM": "FCM-250523014III0000", "INSTRMNT_TYPE": null, "INSTRMNT_DATE": null, "INSTRMNT_NUM": null, "INSTRMNT_ALPHA": null, "TRAN_RMKS": null, "PSTD_FLG": "Y", "PRNT_ADVC_IND": " ", "AMT_RESERVATION_IND": " ", "RESERVATION_AMT": 0.0, "RESTRICT_MODIFY_IND": " ", "LCHG_USER_ID": "FIVUSR", "LCHG_TIME": "2025-05-23 17:47:25", "RCRE_USER_ID": "FIVUSR", "RCRE_TIME": "2025-05-23 17:47:22", "CUST_ID": "30328159", "VOUCHER_PRINT_FLG": " ", "MODULE_ID": null, "BR_CODE": null, "FX_TRAN_AMT": 0.0, "RATE_CODE": null, "RATE": 1.0, "CRNCY_CODE": null, "NAVIGATION_FLG": " ", "TRAN_CRNCY_CODE": "INR", "REF_CRNCY_CODE": "INR", "REF_AMT": 1.0, "SOL_ID": "0820", "BANK_CODE": null, "TREA_REF_NUM": null, "TREA_RATE": 0.0, "TS_CNT": 1, "GST_UPD_FLG": "N", "ISO_FLG": "N", "EABFAB_UPD_FLG": "N", "LIFT_LIEN_FLG": "N", "PROXY_POST_IND": "B", "SI_SRL_NUM": null, "SI_ORG_EXEC_DATE": null, "PR_SRL_NUM": null, "SERIAL_NUM": null, "DEL_MEMO_PAD": "N", "UAD_MODULE_ID": null, "UAD_MODULE_KEY": null, "REVERSAL_DATE": null, "REVERSAL_VALUE_DATE": null, "PTTM_EVENT_TYPE": null, "PROXY_ACID": null, "TOD_ENTITY_TYPE": null, "TOD_ENTITY_ID": null, "DTH_INIT_SOL_ID": "0001", "REGULARIZATION_AMT": 0.0, "PRINCIPAL_PORTION_AMT": 0.0, "TF_ENTITY_SOL_ID": null, "TRAN_PARTICULAR_2": null, "TRAN_PARTICULAR_CODE": null, "TR_STATUS": " ", "SVS_TRAN_ID": null, "CRNCY_HOL_CHK_DONE_FLG": "N", "REFERRAL_ID": null, "PARTY_CODE": null, "GL_DATE": "2025-05-23 00:00:00", "BKDT_TRAN_FLG": " ", "BANK_ID": "01", "IMPL_CASH_PART_TRAN_FLG": " ", "PTRAN_CHRG_EXISTS_FLG": "N", "MUD_POOL_BAL_BUILD_FLG": "N", "GL_SEGMENT_STRING": null, "SYS_PART_TRAN_CODE": "PTRN00414", "USER_PART_TRAN_CODE": null, "TRAN_FREE_CODE1": null, "TRAN_FREE_CODE2": null, "PSTD_SRL_NUM": 0, "REVERSAL_STATUS": " ", "AVAILABLE_AMT": 0.0, "ACCT_BALANCE": -2.252732962113564E13}})



package com.kotak.orchestrator.orchestrator.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "plutus_finacle_transaction_details",schema = "plutus_ecollection")
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

    @Column(name="received_at",nullable = false)
    private LocalDateTime receivedAt;

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    @Column(name = "raw_json",columnDefinition =  "CLOB")
    private String rawData;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getForacid() {
        return foracid;
    }

    public void setForacid(String foracid) {
        this.foracid = foracid;
    }

    public String getAcctClsFlg() {
        return acctClsFlg;
    }

    public void setAcctClsFlg(String acctClsFlg) {
        this.acctClsFlg = acctClsFlg;
    }

    public String getAcctCrncyCode() {
        return acctCrncyCode;
    }

    public void setAcctCrncyCode(String acctCrncyCode) {
        this.acctCrncyCode = acctCrncyCode;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAcctOwnership() {
        return acctOwnership;
    }

    public void setAcctOwnership(String acctOwnership) {
        this.acctOwnership = acctOwnership;
    }

    public String getAcctOpnDate() {
        return acctOpnDate;
    }

    public void setAcctOpnDate(String acctOpnDate) {
        this.acctOpnDate = acctOpnDate;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public Double getAcctBal() {
        return acctBal;
    }

    public void setAcctBal(Double acctBal) {
        this.acctBal = acctBal;
    }

    public Double getAvailBal() {
        return availBal;
    }

    public void setAvailBal(Double availBal) {
        this.availBal = availBal;
    }

    public Double getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(Double tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranParticular() {
        return tranParticular;
    }

    public void setTranParticular(String tranParticular) {
        this.tranParticular = tranParticular;
    }

    public String getTranTime() {
        return tranTime;
    }

    public void setTranTime(String tranTime) {
        this.tranTime = tranTime;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getTxnCode() {
        return txnCode;
    }

    public void setTxnCode(String txnCode) {
        this.txnCode = txnCode;
    }

    public String getTxnSubType() {
        return txnSubType;
    }

    public void setTxnSubType(String txnSubType) {
        this.txnSubType = txnSubType;
    }

    public String getRefNum() {
        return refNum;
    }

    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    public String getRefDocNum() {
        return refDocNum;
    }

    public void setRefDocNum(String refDocNum) {
        this.refDocNum = refDocNum;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getPartTranType() {
        return partTranType;
    }

    public void setPartTranType(String partTranType) {
        this.partTranType = partTranType;
    }

    public String getLinkedAccNo() {
        return linkedAccNo;
    }

    public void setLinkedAccNo(String linkedAccNo) {
        this.linkedAccNo = linkedAccNo;
    }

    public String getLinkedBranchCode() {
        return linkedBranchCode;
    }

    public void setLinkedBranchCode(String linkedBranchCode) {
        this.linkedBranchCode = linkedBranchCode;
    }

    public String getLinkedCrncyCode() {
        return linkedCrncyCode;
    }

    public void setLinkedCrncyCode(String linkedCrncyCode) {
        this.linkedCrncyCode = linkedCrncyCode;
    }

    public String getLinkedName() {
        return linkedName;
    }

    public void setLinkedName(String linkedName) {
        this.linkedName = linkedName;
    }

    public String getMsgTs() {
        return msgTs;
    }

    public void setMsgTs(String msgTs) {
        this.msgTs = msgTs;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    // ... (use Lombok or generate them manually)
}



  
package com.kotak.orchestrator.orchestrator.consumer;

import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.orchestrator.orchestrator.entity.PlutusFinacleDataEntity;
import com.kotak.orchestrator.orchestrator.schema.BusinessEvent;
import com.kotak.orchestrator.orchestrator.schema.DtdGamBusinessEvent;
import com.kotak.orchestrator.orchestrator.service.ClientConfigCacheService;
import com.kotak.orchestrator.orchestrator.utils.CbsUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.ReceiverRecord;

import java.time.LocalDateTime;

/**
 * Kafka consumer for DTD/GAM business events from Finacle.
 * Filters events based on FORACID presence in the client config cache.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PlutusDtdBusinessEventConsumer implements MessageConsumer<DtdGamBusinessEvent> {

    private final PlutusFinacleDataRepository repository;
    private final ClientConfigCacheService clientConfigCacheService;

    @Override
    public void process(ReceiverRecord<String, DtdGamBusinessEvent> receiverRecord) {
        BusinessEvent data = receiverRecord.value().getEvent();

        if (data == null) {
            log.warn("Received null BusinessEvent.");
            return;
        }

       /* String foracid = CbsUtils.byteBufferToStr(data.getFORACID());

        // Filter based on cache
        if (!clientConfigCacheService.isMasterAccount(foracid)) {
            log.info("FORACID {} not found in client config, skipping record.", foracid);
            receiverRecord.receiverOffset().acknowledge();
            return;
        }*/

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
        entity.setTranTime(null); // Optional
        entity.setMsgTs(LocalDateTime.now().toString());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setReceivedAt(LocalDateTime.now());

        return entity;
    }
}
