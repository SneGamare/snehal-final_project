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

    @Column(name = "MASTER_ACC_NO")
    private String masterAccNo;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "PAY_MODE")
    private String payMode;

    @Column(name = "BENE_CUST_ACNAME")
    private String beneCustAcName;

    @Column(name = "REMIT_AC_NMBR")
    private String remitAcNmbr;

    @Column(name = "PROCESSED_FLAG")
    private String processedFlag;

    @Column(name = "PROC_REMARKS")
    private String procRemarks;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;

    @Column(name = "RAW_JSON", columnDefinition = "CLOB")
    private String rawJson;
}
