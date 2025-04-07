package com.javatechie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
} 