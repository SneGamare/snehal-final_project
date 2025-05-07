package com.kotak.orchestrator.orchestrator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reconciled_transaction")
public class ReconciledTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "finacle_tran_id", referencedColumnName = "tranId")
    private PlutusFinacleDataEntity plutusFinacleDataEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "txnRefNo", referencedColumnName = "txnRefNo")
    private PaymentProcessorEntity paymentProcessorEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlutusFinacleDataEntity getPlutusFinacleDataEntity() {
        return plutusFinacleDataEntity;
    }

    public void setPlutusFinacleDataEntity(PlutusFinacleDataEntity plutusFinacleDataEntity) {
        this.plutusFinacleDataEntity = plutusFinacleDataEntity;
    }

    public PaymentProcessorEntity getVirtualApacEntity() {
        return paymentProcessorEntity;
    }

    public void setVirtualApacEntity(PaymentProcessorEntity virtualApacEntity) {
        this.paymentProcessorEntity = virtualApacEntity;
    }



    // Getters and Setters
}








package com.kotak.orchestrator.orchestrator.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PAYMENT_PROCESS_TABLE", schema = "KOTAKTCI")
@Data
public class PaymentProcessorEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TXN_REF_NO", nullable = false, length = 1000)
    private String txnRefNo;

    @Column(name = "TXN_DATE")
    private Date txnDate;

    @Column(name = "E_COLL_ACC_NO", length = 1000)
    private String eCollAccNo;

    @Column(name = "MASTER_ACC_NO", length = 1000)
    private String masterAccNo;

    @Column(name = "DEALER_NAME", length = 1000)
    private String dealerName;

    @Column(name = "AMOUNT", precision = 20, scale = 4)
    private BigDecimal amount;

    @Column(name = "BENE_CUST_ACNAME", length = 1000)
    private String beneCustAcName;

    @Column(name = "SEND_CUST_ACNAME", length = 1000)
    private String sendCustAcName;

    @Column(name = "REMITT_INFO", length = 1000)
    private String remittInfo;

    @Column(name = "SENDER_ADDRESS", length = 1000)
    private String senderAddress;

    @Column(name = "REF1", length = 1000)
    private String ref1;

    @Column(name = "REF2", length = 1000)
    private String ref2;

    @Column(name = "REF3", length = 1000)
    private String ref3;

    @Column(name = "PROCESSED_FLAG", length = 1)
    private String processedFlag = "N";

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "IDEA_TXN_REF_NO", length = 1000)
    private String ideaTxnRefNo;

    @Column(name = "INITIAL_AVAIL_BAL", precision = 20, scale = 4)
    private BigDecimal initialAvailBal;

    @Column(name = "INITIAL_CUR_BAL", precision = 20, scale = 4)
    private BigDecimal initialCurBal;

    @Column(name = "UPDATED_AVAIL_BAL", precision = 20, scale = 4)
    private BigDecimal updatedAvailBal;

    @Column(name = "UPDATED_CUR_BAL", precision = 20, scale = 4)
    private BigDecimal updatedCurBal;

    @Column(name = "PROC_REMARKS", length = 4000)
    private String procRemarks;

    @Column(name = "REMIT_AC_NMBR", length = 1000)
    private String remitAcNmbr;

    @Column(name = "PAY_MODE", length = 1000)
    private String payMode;

    @Column(name = "CMS_TRAN_API_STATUS", length = 1)
    private String cmsTranApiStatus;

    @Column(name = "CMS_TRAN_API_REMARKS", length = 1000)
    private String cmsTranApiRemarks;

    @Column(name = "CMS_CREATED_DATE")
    private Date cmsCreatedDate;

    @Column(name = "CMS_REV_API_STATUS", length = 1)
    private String cmsRevApiStatus;

    @Column(name = "CMS_REV_API_REMARKS", length = 1000)
    private String cmsRevApiRemarks;

    @Column(name = "CMS_REV_CREATED_DATE")
    private Date cmsRevCreatedDate;

    // Getters and Setters


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getTxnRefNo() {
        return txnRefNo;
    }

    public void setTxnRefNo(String txnRefNo) {
        this.txnRefNo = txnRefNo;
    }

    public Date getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    public String geteCollAccNo() {
        return eCollAccNo;
    }

    public void seteCollAccNo(String eCollAccNo) {
        this.eCollAccNo = eCollAccNo;
    }

    public String getMasterAccNo() {
        return masterAccNo;
    }

    public void setMasterAccNo(String masterAccNo) {
        this.masterAccNo = masterAccNo;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBeneCustAcName() {
        return beneCustAcName;
    }

    public void setBeneCustAcName(String beneCustAcName) {
        this.beneCustAcName = beneCustAcName;
    }

    public String getSendCustAcName() {
        return sendCustAcName;
    }

    public void setSendCustAcName(String sendCustAcName) {
        this.sendCustAcName = sendCustAcName;
    }

    public String getRemittInfo() {
        return remittInfo;
    }

    public void setRemittInfo(String remittInfo) {
        this.remittInfo = remittInfo;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1;
    }

    public String getRef2() {
        return ref2;
    }

    public void setRef2(String ref2) {
        this.ref2 = ref2;
    }

    public String getRef3() {
        return ref3;
    }

    public void setRef3(String ref3) {
        this.ref3 = ref3;
    }

    public String getProcessedFlag() {
        return processedFlag;
    }

    public void setProcessedFlag(String processedFlag) {
        this.processedFlag = processedFlag;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getIdeaTxnRefNo() {
        return ideaTxnRefNo;
    }

    public void setIdeaTxnRefNo(String ideaTxnRefNo) {
        this.ideaTxnRefNo = ideaTxnRefNo;
    }

    public BigDecimal getInitialAvailBal() {
        return initialAvailBal;
    }

    public void setInitialAvailBal(BigDecimal initialAvailBal) {
        this.initialAvailBal = initialAvailBal;
    }

    public BigDecimal getInitialCurBal() {
        return initialCurBal;
    }

    public void setInitialCurBal(BigDecimal initialCurBal) {
        this.initialCurBal = initialCurBal;
    }

    public BigDecimal getUpdatedAvailBal() {
        return updatedAvailBal;
    }

    public void setUpdatedAvailBal(BigDecimal updatedAvailBal) {
        this.updatedAvailBal = updatedAvailBal;
    }

    public BigDecimal getUpdatedCurBal() {
        return updatedCurBal;
    }

    public void setUpdatedCurBal(BigDecimal updatedCurBal) {
        this.updatedCurBal = updatedCurBal;
    }

    public String getProcRemarks() {
        return procRemarks;
    }

    public void setProcRemarks(String procRemarks) {
        this.procRemarks = procRemarks;
    }

    public String getRemitAcNmbr() {
        return remitAcNmbr;
    }

    public void setRemitAcNmbr(String remitAcNmbr) {
        this.remitAcNmbr = remitAcNmbr;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getCmsTranApiStatus() {
        return cmsTranApiStatus;
    }

    public void setCmsTranApiStatus(String cmsTranApiStatus) {
        this.cmsTranApiStatus = cmsTranApiStatus;
    }

    public String getCmsTranApiRemarks() {
        return cmsTranApiRemarks;
    }

    public void setCmsTranApiRemarks(String cmsTranApiRemarks) {
        this.cmsTranApiRemarks = cmsTranApiRemarks;
    }

    public Date getCmsCreatedDate() {
        return cmsCreatedDate;
    }

    public void setCmsCreatedDate(Date cmsCreatedDate) {
        this.cmsCreatedDate = cmsCreatedDate;
    }

    public String getCmsRevApiStatus() {
        return cmsRevApiStatus;
    }

    public void setCmsRevApiStatus(String cmsRevApiStatus) {
        this.cmsRevApiStatus = cmsRevApiStatus;
    }

    public String getCmsRevApiRemarks() {
        return cmsRevApiRemarks;
    }

    public void setCmsRevApiRemarks(String cmsRevApiRemarks) {
        this.cmsRevApiRemarks = cmsRevApiRemarks;
    }

    public Date getCmsRevCreatedDate() {
        return cmsRevCreatedDate;
    }

    public void setCmsRevCreatedDate(Date cmsRevCreatedDate) {
        this.cmsRevCreatedDate = cmsRevCreatedDate;
    }

}

