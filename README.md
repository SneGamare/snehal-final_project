package com.kotak.orchestrator.orchestrator.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reconciled_transaction")
@Data
public class ReconciledTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Finacle fields
    private String tranId;
    private String foracid;
    private Double tranAmt;
    private String tranDate;

    // Virtual APAC fields
    private String txnRefNo;
    private Double amount;
    private String eCollAccNo;
    private String remittInfo;

    // Raw JSONs (optional, for traceability)
    @Column(columnDefinition = "CLOB")
    private String finacleRaw;

    @Column(columnDefinition = "CLOB")
    private String virtualApacRaw;
}
