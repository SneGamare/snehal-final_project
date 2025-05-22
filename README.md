package com.kotak.orchestrator.orchestrator.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dtd_business_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtdBusinessEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double effectiveBal;
    private Double clrBal;
    private String foracid;
    private String tranId;
    private Double tranAmt;
    private String tranParticular;
    private String acctName;
    private Double acctBalance;
    private Double availableAmt;
    private String tranDate; // <-- This maps to getTRANDATE() in Avro
    private String valueDate;
    private String reversalDate;
    private String tranType;
    private String tranSubType;
    private String partTranType;
    private String glSubHeadCode;
    private String acid;
    private Double refAmt;
    private String refNum;
    private String custId;
    private String brCode;
    private String crncyCode;
    private String tranCrncyCode;
    private String solId;
    private String bankCode;
    private String treaRefNum;
    private String tranRmks;
    private String tranParticular2;

    // Add more fields as needed from Avro schema
}



private static DtdBusinessEventEntity getPlutusFinacleDataEntity(BusinessEvent data) {
    return DtdBusinessEventEntity.builder()
        .effectiveBal(data.getEFFECTIVEBAL())
        .clrBal(data.getCLRBAL())
        .foracid(toStr(data.getFORACID()))
        .tranId(toStr(data.getTRANID()))
        .tranAmt(data.getTRANAMT())
        .tranParticular(toStr(data.getTRANPARTICULAR()))
        .acctName(toStr(data.getACCTNAME()))
        .acctBalance(data.getACCTBALANCE())
        .availableAmt(data.getAVAILABLEAMT())
        .tranDate(toStr(data.getTRANDATE()))   // Matches `private String tranDate`
        .valueDate(toStr(data.getVALUEDATE()))
        .reversalDate(toStr(data.getREVERSALDATE()))
        .tranType(toStr(data.getTRANTYPE()))
        .tranSubType(toStr(data.getTRANSUBTYPE()))
        .partTranType(toStr(data.getPARTTRANTYPE()))
        .glSubHeadCode(toStr(data.getGLSUBHEADCODE()))
        .acid(toStr(data.getACID()))
        .refAmt(data.getREFAMT())
        .refNum(toStr(data.getREFNUM()))
        .custId(toStr(data.getCUSTID()))
        .brCode(toStr(data.getBRCODE()))
        .crncyCode(toStr(data.getCRNCYCODE()))
        .tranCrncyCode(toStr(data.getTRANCRNCYCODE()))
        .solId(toStr(data.getSOLID()))
        .bankCode(toStr(data.getBANKCODE()))
        .treaRefNum(toStr(data.getTREAREFNUM()))
        .tranRmks(toStr(data.getTRANRMKS()))
        .tranParticular2(toStr(data.getTRANPARTICULAR2()))
        .build();
}

