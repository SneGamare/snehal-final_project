package com.kotak.orchestrator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpiReconciliationDto {

    // From Virtual APAC Table
    private String txnRefNo;
    private LocalDate txnDate;
    private String masterAccNo;
    private Double amount;
    private String payMode;
    private String beneCustAcName;
    private String remitAcNmbr;
    private String processedFlag;
    private String procRemarks;

    // From Finacle Table
    private String finacleTranId;
    private LocalDate valueDate;
    private String foracid;
    private String acctName;
    private Double finacleAmount;
    private String tranParticular;
    private String refNum;

    // Metadata
    private LocalDateTime matchedAt;
    private boolean isMatched;
    private String matchReason;

    // Optional raw JSONs (if needed for audit/debug)
    private String apacRawJson;
    private String finacleRawJson;
}
