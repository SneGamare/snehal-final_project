SELECT * 
FROM information_schema.tables 
WHERE table_schema = 'plutus_ecollection' 
  AND table_name = 'plutus_finacle_transaction_details';




ALTER TABLE public.plutus_finacle_transaction_details
SET SCHEMA plutus_ecollection;



GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO your_user;




plutusdb_dev=> SELECT * FROM information_schema.tables WHERE table_schema = 'plutus_ecollection' AND table_name = 'plutus_finacle_transaction_details';
 table_catalog |    table_schema    |             table_name             | table_type | self_referencing_column_name | reference_generation | user_defined_type_catalog | user_defined_type_schema | user_defined_type
_name | is_insertable_into | is_typed | commit_action
---------------+--------------------+------------------------------------+------------+------------------------------+----------------------+---------------------------+--------------------------+------------------
------+--------------------+----------+---------------
 plutusdb_dev  | plutus_ecollection | plutus_finacle_transaction_details | BASE TABLE |                              |                      |                           |                          |
      | YES                | NO       |
(1 row)

plutusdb_dev=> ALTER TABLE public.plutus_finacle_transaction_details SET SCHEMA plutus_ecollection;
ERROR:  relation "public.plutus_finacle_transaction_details" does not exist
plutusdb_dev=> GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO your_user;
ERROR:  role "your_user" does not exist
plutusdb_dev=> GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO app_user;
ERROR:  role "app_user" does not exist
plutusdb_dev=>



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



