package com.kotak.orchestrator.service;

import com.kotak.orchestrator.dto.UpiReconciliationDto;
import com.kotak.orchestrator.orchestrator.entity.PlutusFinacleDataEntity;
import com.kotak.orchestrator.orchestrator.entity.VirtualApacEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UpiReconciliationService {

    public UpiReconciliationDto matchUpiRecords(VirtualApacEntity apac, PlutusFinacleDataEntity finacle) {
        boolean matched = false;
        String reason = "";

        if (apac.getAmount().equals(finacle.getTranAmt()) &&
            apac.getTxnRefNo().equalsIgnoreCase(finacle.getRefNum())) {
            matched = true;
            reason = "Matched by amount and reference number";
        } else {
            reason = "Mismatch in amount or reference";
        }

        return new UpiReconciliationDto(
            apac.getTxnRefNo(),
            apac.getTxnDate(),
            apac.getMasterAccNo(),
            apac.getAmount(),
            apac.getPayMode(),
            apac.getBeneCustAcName(),
            apac.getRemitAcNmbr(),
            apac.getProcessedFlag(),
            apac.getProcRemarks(),

            finacle.getTranId(),
            parseDate(finacle.getValueDate()),
            finacle.getForacid(),
            finacle.getAcctName(),
            finacle.getTranAmt(),
            finacle.getTranParticular(),
            finacle.getRefNum(),

            LocalDateTime.now(),
            matched,
            reason,

            apac.getRawJson(),
            finacle.getRawData()
        );
    }

    private LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr); // Use formatter if format is not ISO
    }
}
