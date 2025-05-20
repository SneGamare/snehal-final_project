org.h2.jdbc.JdbcSQLDataException: Data conversion error converting "TIMESTAMP to BINARY VARYING" [22018-224]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:518) ~[h2-2.2.224.jar:2.2.224]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:489) ~[h2-2.2.224.jar:2.2.224]
	at org.h2.message.DbException.get(DbException.java:223) ~[h2-2.2.224.jar:2.2.224]
	at org.h2.message.DbException.get(DbException.java:199) ~[h2-2.2.224.jar:2.2.224]
	at org.h2.value.Value.getDataConversionError(Value.java:2573) ~[h2-2.2.224.jar:2.2.224]
	at org.h2.value.Value.getBytes(Value.java:798) ~[h2-2.2.224.jar:2.2.224]
	at org.h2.jdbc.JdbcResultSet.getBytes(JdbcResultSet.java:1208) ~[h2-2.2.224.jar:2.2.224]
	at com.zaxxer.hikari.pool.HikariProxyResultSet.getBytes(HikariProxyResultSet.java) ~[HikariCP-5.0.1.jar:na]



CREATE TABLE PLUTUS_CLIENT_CONFIGURATION (
    Id INT PRIMARY KEY,
    Master_account VARCHAR(255),
    UPI_SOURCE VARCHAR(255),
    IMPS_SOURCE_System VARCHAR(255),
    NEFT_Source VARCHAR(255),
    RTGS_Source_System VARCHAR(255),
    IFT_Source_System VARCHAR(255),
    PG_Source_System VARCHAR(255),
    API_TYPE VARCHAR(255),
    ClientNAME VARCHAR(255),
    CRN VARCHAR(255),
    Active_Flag BOOLEAN,
    Created_by VARCHAR(255),
    modified_by VARCHAR(255),
    created_date TIMESTAMP,
    modified_date TIMESTAMP
);


package com.kotak.orchestrator.orchestrator.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENT_PROCESSOR_TABLE")
@Data
public class PaymentProcessorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foracid;
    private String acctName;

    @Column(name = "tran_date")
    private LocalDateTime tranDate;

    private String tranId;
    private Double tranAmt;
    private String clientName;
}


package com.kotak.orchestrator.orchestrator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "plutus_finacle_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlutusFinacleDataEntity {
    
    @Id
    private String tranId; // Using tranId as the primary key
    private String foracid;
    private String acctName;
    private String lastTranDateCr;
    private String tranDate;
    private String partTranSrlNum;
    private String delFlg;
    private String tranType;
    private String tranSubType;
    private String partTranType;
    private String glSubHeadCode;
    private String acid;
    private String valueDate;
    private Double tranAmt;
    private String tranParticular;
    private String entryDate;
    private String pstdDate;
    private String refNum;
    private String instrmntType;
    private String instrmntDate;
    private String instrmntNum;
    private String tranRmks;
    private String custId;
    private String brCode;
    private String crncyCode;
    private String tranCrncyCode;
    private Double refAmt;
    private String solId;
    private String bankCode;
    private String treaRefNum;
    private String reversalDate;
    @Column(name="received_at",nullable = false)
    private LocalDateTime receivedAt;

    @Column(name = "raw_json",columnDefinition =  "CLOB")
    private String rawData;

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

    public String getForacid() {
        return foracid;
    }

    public void setForacid(String foracid) {
        this.foracid = foracid;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getLastTranDateCr() {
        return lastTranDateCr;
    }

    public void setLastTranDateCr(String lastTranDateCr) {
        this.lastTranDateCr = lastTranDateCr;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getPartTranSrlNum() {
        return partTranSrlNum;
    }

    public void setPartTranSrlNum(String partTranSrlNum) {
        this.partTranSrlNum = partTranSrlNum;
    }

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getTranSubType() {
        return tranSubType;
    }

    public void setTranSubType(String tranSubType) {
        this.tranSubType = tranSubType;
    }

    public String getPartTranType() {
        return partTranType;
    }

    public void setPartTranType(String partTranType) {
        this.partTranType = partTranType;
    }

    public String getGlSubHeadCode() {
        return glSubHeadCode;
    }

    public void setGlSubHeadCode(String glSubHeadCode) {
        this.glSubHeadCode = glSubHeadCode;
    }

    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public Double getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(Double tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getTranParticular() {
        return tranParticular;
    }

    public void setTranParticular(String tranParticular) {
        this.tranParticular = tranParticular;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getPstdDate() {
        return pstdDate;
    }

    public void setPstdDate(String pstdDate) {
        this.pstdDate = pstdDate;
    }

    public String getRefNum() {
        return refNum;
    }

    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    public String getInstrmntType() {
        return instrmntType;
    }

    public void setInstrmntType(String instrmntType) {
        this.instrmntType = instrmntType;
    }

    public String getInstrmntDate() {
        return instrmntDate;
    }

    public void setInstrmntDate(String instrmntDate) {
        this.instrmntDate = instrmntDate;
    }

    public String getInstrmntNum() {
        return instrmntNum;
    }

    public void setInstrmntNum(String instrmntNum) {
        this.instrmntNum = instrmntNum;
    }

    public String getTranRmks() {
        return tranRmks;
    }

    public void setTranRmks(String tranRmks) {
        this.tranRmks = tranRmks;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getBrCode() {
        return brCode;
    }

    public void setBrCode(String brCode) {
        this.brCode = brCode;
    }

    public String getCrncyCode() {
        return crncyCode;
    }

    public void setCrncyCode(String crncyCode) {
        this.crncyCode = crncyCode;
    }

    public String getTranCrncyCode() {
        return tranCrncyCode;
    }

    public void setTranCrncyCode(String tranCrncyCode) {
        this.tranCrncyCode = tranCrncyCode;
    }

    public Double getRefAmt() {
        return refAmt;
    }

    public void setRefAmt(Double refAmt) {
        this.refAmt = refAmt;
    }

    public String getSolId() {
        return solId;
    }

    public void setSolId(String solId) {
        this.solId = solId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getTreaRefNum() {
        return treaRefNum;
    }

    public void setTreaRefNum(String treaRefNum) {
        this.treaRefNum = treaRefNum;
    }

    public String getReversalDate() {
        return reversalDate;
    }

    public void setReversalDate(String reversalDate) {
        this.reversalDate = reversalDate;
    }

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
} 





{
  "type": "record",
  "name": "PlutusFinacleData",
  "namespace": "com.kotak.orchestrator.orchestrator.schema",
  "fields": [
    {"name": "foracid", "type": ["null", "string"], "default": null},
    {"name": "acctName", "type": ["null", "string"], "default": null},
    {"name": "lastTranDateCr", "type": ["null", "string"], "default": null},
    {"name": "tranDate", "type": ["null", "string"], "default": null},
    {"name": "tranId", "type": ["null", "string"], "default": null},
    {"name": "partTranSrlNum", "type": ["null", "string"], "default": null},
    {"name": "delFlg", "type": ["null", "string"], "default": null},
    {"name": "tranType", "type": ["null", "string"], "default": null},
    {"name": "tranSubType", "type": ["null", "string"], "default": null},
    {"name": "partTranType", "type": ["null", "string"], "default": null},
    {"name": "glSubHeadCode", "type": ["null", "string"], "default": null},
    {"name": "acid", "type": ["null", "string"], "default": null},
    {"name": "valueDate", "type": ["null", "string"], "default": null},
    {"name": "tranAmt", "type": ["null", "double"], "default": null},
    {"name": "tranParticular", "type": ["null", "string"], "default": null},
    {"name": "entryDate", "type": ["null", "string"], "default": null},
    {"name": "pstdDate", "type": ["null", "string"], "default": null},
    {"name": "refNum", "type": ["null", "string"], "default": null},
    {"name": "instrmntType", "type": ["null", "string"], "default": null},
    {"name": "instrmntDate", "type": ["null", "string"], "default": null},
    {"name": "instrmntNum", "type": ["null", "string"], "default": null},
    {"name": "tranRmks", "type": ["null", "string"], "default": null},
    {"name": "custId", "type": ["null", "string"], "default": null},
    {"name": "brCode", "type": ["null", "string"], "default": null},
    {"name": "crncyCode", "type": ["null", "string"], "default": null},
    {"name": "tranCrncyCode", "type": ["null", "string"], "default": null},
    {"name": "refAmt", "type": ["null", "double"], "default": null},
    {"name": "solId", "type": ["null", "string"], "default": null},
    {"name": "bankCode", "type": ["null", "string"], "default": null},
    {"name": "treaRefNum", "type": ["null", "string"], "default": null},
    {"name": "reversalDate", "type": ["null", "string"], "default": null}
  ]
}   this is my avro generated class please solved this issue 
