package com.kotak.orchestrator.orchestrator.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "VIRTUAL_APAC_TABLE", schema = "KOTAKTCI")
@Data
public class VirtualApacEntity {

    @Id
    @Column(name = "TXN_REF_NO", nullable = false)
    private String txnRefNo;

    @Column(name = "TXN_DATE")
    private LocalDate txnDate;

    @Column(name = "E_COLL_ACC_NO")
    private String eCollAccNo;

    @Column(name = "MASTER_ACC_NO")
    private String masterAccNo;

    @Column(name = "DEALER_NAME")
    private String dealerName;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "BENE_CUST_ACNAME")
    private String beneCustAcName;

    @Column(name = "SEND_CUST_ACNAME")
    private String sendCustAcName;

    @Column(name = "REMITT_INFO")
    private String remittInfo;

    @Column(name = "SENDER_ADDRESS")
    private String senderAddress;

    @Column(name = "REF1")
    private String ref1;

    @Column(name = "REF2")
    private String ref2;

    @Column(name = "REF3")
    private String ref3;

    @Column(name = "PROCESSED_FLAG", nullable = false)
    private String processedFlag = "N";

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;

    @Column(name = "IDEA_TXN_REF_NO")
    private String ideaTxnRefNo;

    @Column(name = "INITIAL_AVAIL_BAL")
    private Double initialAvailBal;

    @Column(name = "INITIAL_CUR_BAL")
    private Double initialCurBal;

    @Column(name = "UPDATED_AVAIL_BAL")
    private Double updatedAvailBal;

    @Column(name = "UPDATED_CUR_BAL")
    private Double updatedCurBal;

    @Column(name = "PROC_REMARKS")
    private String procRemarks;

    @Column(name = "REMIT_AC_NMBR")
    private String remitAcNmbr;

    @Column(name = "PAY_MODE")
    private String payMode;

    @Column(name = "CMS_TRAN_API_STATUS")
    private String cmsTranApiStatus;

    @Column(name = "CMS_TRAN_API_REMARKS")
    private String cmsTranApiRemarks;

    @Column(name = "CMS_CREATED_DATE")
    private LocalDateTime cmsCreatedDate;

    @Column(name = "CMS_REV_API_STATUS")
    private String cmsRevApiStatus;

    @Column(name = "CMS_REV_API_REMARKS")
    private String cmsRevApiRemarks;

    @Column(name = "CMS_REV_CREATED_DATE")
    private LocalDateTime cmsRevCreatedDate;

    @Column(name = "RAW_JSON", columnDefinition = "CLOB")
    private String rawJson;

    public String getTxnRefNo() {
        return txnRefNo;
    }

    public void setTxnRefNo(String txnRefNo) {
        this.txnRefNo = txnRefNo;
    }

    public LocalDate getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(LocalDate txnDate) {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getIdeaTxnRefNo() {
        return ideaTxnRefNo;
    }

    public void setIdeaTxnRefNo(String ideaTxnRefNo) {
        this.ideaTxnRefNo = ideaTxnRefNo;
    }

    public Double getInitialAvailBal() {
        return initialAvailBal;
    }

    public void setInitialAvailBal(Double initialAvailBal) {
        this.initialAvailBal = initialAvailBal;
    }

    public Double getInitialCurBal() {
        return initialCurBal;
    }

    public void setInitialCurBal(Double initialCurBal) {
        this.initialCurBal = initialCurBal;
    }

    public Double getUpdatedAvailBal() {
        return updatedAvailBal;
    }

    public void setUpdatedAvailBal(Double updatedAvailBal) {
        this.updatedAvailBal = updatedAvailBal;
    }

    public Double getUpdatedCurBal() {
        return updatedCurBal;
    }

    public void setUpdatedCurBal(Double updatedCurBal) {
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

    public LocalDateTime getCmsCreatedDate() {
        return cmsCreatedDate;
    }

    public void setCmsCreatedDate(LocalDateTime cmsCreatedDate) {
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

    public LocalDateTime getCmsRevCreatedDate() {
        return cmsRevCreatedDate;
    }

    public void setCmsRevCreatedDate(LocalDateTime cmsRevCreatedDate) {
        this.cmsRevCreatedDate = cmsRevCreatedDate;
    }

    public String getRawJson() {
        return rawJson;
    }

    public void setRawJson(String rawJson) {
        this.rawJson = rawJson;
    }


}
