
package com.kotak.orchestrator.orchestrator.consumer;

import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.orchestrator.orchestrator.entity.PlutusFinacleDataEntity;
import com.kotak.orchestrator.orchestrator.schema.BusinessEvent;
import com.kotak.orchestrator.orchestrator.schema.DtdGamBusinessEvent;
import com.kotak.orchestrator.orchestrator.service.ClientConfigCacheService;
import com.kotak.orchestrator.orchestrator.utils.CbsUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.ReceiverRecord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.kotak.orchestrator.orchestrator.utils.CbsUtils.byteBufferToStr;

/**
 * Kafka consumer for DTD/GAM business events from Finacle.
 * Filters events based on FORACID presence in the client config cache.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PlutusDtdBusinessEventConsumer implements MessageConsumer<DtdGamBusinessEvent> {

    private final PlutusFinacleDataRepository repository;
    private final ClientConfigCacheService clientConfigCacheService;


    @Override
    public void process(ReceiverRecord<String, DtdGamBusinessEvent> receiverRecord) {
        BusinessEvent data = receiverRecord.value().getEvent();

        if (data == null) {
            log.warn("Received null BusinessEvent.");
            return;
        }

        String foracid = byteBufferToStr(data.getFORACID());

        // Filter based on cache
        if (!clientConfigCacheService.isMasterAccount(foracid)) {
            log.info("FORACID {} not found in client config, skipping record.", foracid);
            receiverRecord.receiverOffset().acknowledge();
            return;
        }

        try {
            PlutusFinacleDataEntity entity = mapToEntity(data);
            repository.save(entity);

            log.info("Saved DTD Event with TRAN_ID: {}", byteBufferToStr(data.getTRANID()));
            receiverRecord.receiverOffset().acknowledge();
        } catch (Exception e) {
            log.error("Error while saving DTD Event: {}", e.getMessage(), e);
        }
    }

    private PlutusFinacleDataEntity mapToEntity(BusinessEvent data) {
        PlutusFinacleDataEntity entity = new PlutusFinacleDataEntity();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        entity.setTranDate(LocalDateTime.parse(data.getTRANDATE(),formatter).toLocalDate());
        entity.setTranId(byteBufferToStr(data.getTRANID()));
        entity.setPartTranSrlNum(byteBufferToStr(data.getPARTTRANSRLNUM()));
        entity.setDelFlg(byteBufferToStr(data.getDELFLG()));
        entity.setTranType(byteBufferToStr(data.getTRANTYPE()));
        entity.setTranSubType(byteBufferToStr(data.getTRANSUBTYPE()));
        entity.setPartTranType(byteBufferToStr(data.getPARTTRANTYPE()));
        entity.setGlSubHeadCode(byteBufferToStr(data.getGLSUBHEADCODE()));
        entity.setAcid(byteBufferToStr(data.getACID()));
        entity.setValueDate(LocalDateTime.parse(data.getVALUEDATE(),formatter).toLocalDate());
        entity.setTranAmt(CbsUtils.doubleToBigDecimal(data.getTRANAMT()));
        entity.setTranParticular(byteBufferToStr(data.getTRANPARTICULAR()));
        entity.setEntryDate(LocalDateTime.parse(data.getENTRYDATE(), formatter));
        entity.setPstdDate(LocalDateTime.parse(data.getPSTDDATE(), formatter));
        entity.setRefNum(byteBufferToStr(data.getREFNUM()));
        entity.setInstrmntType(byteBufferToStr(data.getINSTRMNTTYPE()));
        entity.setInstrmntDate(data.getINSTRMNTDATE() != null ? LocalDateTime.parse(data.getINSTRMNTDATE(), formatter).toLocalDate() : null);
        entity.setInstrmntNum(byteBufferToStr(data.getINSTRMNTNUM()));
        entity.setTranRmks(byteBufferToStr(data.getTRANRMKS()));
        entity.setCustId(byteBufferToStr(data.getCUSTID()));
        entity.setBrCode(byteBufferToStr(data.getBRCODE()));
        entity.setCrncyCode(byteBufferToStr(data.getCRNCYCODE()));
        entity.setTranCrncyCode(byteBufferToStr(data.getTRANCRNCYCODE()));
        entity.setRefAmt(CbsUtils.doubleToBigDecimal(data.getREFAMT()));
        entity.setSolId(byteBufferToStr(data.getSOLID()));
        entity.setBankCode(byteBufferToStr(data.getBANKCODE()));
        entity.setTreaRefNum(byteBufferToStr(data.getTREAREFNUM()));
        entity.setReversalDate(data.getREVERSALDATE() != null ? LocalDateTime.parse(data.getREVERSALDATE(), formatter).toLocalDate() : null);
        entity.setReversalValueDate(data.getREVERSALVALUEDATE() != null ? LocalDateTime.parse(data.getREVERSALVALUEDATE(), formatter).toLocalDate() : null);
        entity.setTranParticular2(byteBufferToStr(data.getTRANFREECODE2()));
        entity.setTranParticularCode(byteBufferToStr(data.getTRANPARTICULARCODE()));
        entity.setTrStatus(byteBufferToStr(data.getTRSTATUS()));
        entity.setPartyCode(byteBufferToStr(data.getPARTYCODE()));
        entity.setGlDate(LocalDateTime.parse(data.getGLDATE(), formatter).toLocalDate());
        entity.setBankId(byteBufferToStr(data.getBANKID()));
        entity.setTranFreeCode1(byteBufferToStr(data.getTRANFREECODE1()));
        entity.setTranFreeCode2(byteBufferToStr(data.getTRANFREECODE2()));
        entity.setReversalStatus(byteBufferToStr(data.getREVERSALSTATUS()));
        entity.setAvailableAmt(CbsUtils.doubleToBigDecimal(data.getAVAILABLEAMT()));
        entity.setAcctBalance(CbsUtils.doubleToBigDecimal(data.getACCTBALANCE()));
        entity.setForacid(byteBufferToStr(data.getFORACID()));
        entity.setForacid(byteBufferToStr(data.getFORACID()));
        entity.setAcctName(byteBufferToStr(data.getACCTNAME()));
        entity.setAcctShortName(byteBufferToStr(data.getACCTSHORTNAME()));
        entity.setLastTranDateCr(data.getLASTTRANDATECR() != null ? LocalDateTime.parse(data.getLASTTRANDATECR(), formatter).toLocalDate() : null);
        entity.setReceivedAt(LocalDateTime.now());
        return entity;
    }



    @Override
    public String partitionKey(DtdGamBusinessEvent message) {
        try {
            var acid = byteBufferToStr(message.getEvent().getACID());
            return acid == null ? "" : acid;
        } catch (Exception e) {
            return "";
        }
    }
}


package com.kotak.orchestrator.orchestrator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "plutus_finacle_transaction_details", schema = "plutus_ecollection")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PlutusFinacleDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tran_date")
    private LocalDate tranDate;

    @Column(name = "tran_id")
    private String tranId;

    @Column(name = "part_tran_srl_num")
    private String partTranSrlNum;

    @Column(name = "del_flg")
    private String delFlg;

    @Column(name = "tran_type")
    private String tranType;

    @Column(name = "tran_sub_type")
    private String tranSubType;

    @Column(name = "part_tran_type")
    private String partTranType;

    @Column(name = "gl_sub_head_code")
    private String glSubHeadCode;

    @Column(name = "acid")
    private String acid;

    @Column(name = "value_date")
    private LocalDate valueDate;

    @Column(name = "tran_amt")
    private BigDecimal tranAmt;

    @Column(name = "tran_particular")
    private String tranParticular;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    @Column(name = "pstd_date")
    private LocalDateTime pstdDate;

    @Column(name = "ref_num")
    private String refNum;

    @Column(name = "instrmnt_type")
    private String instrmntType;

    @Column(name = "instrmnt_date")
    private LocalDate instrmntDate;

    @Column(name = "instrmnt_num")
    private String instrmntNum;

    @Column(name = "tran_rmks")
    private String tranRmks;

    @Column(name = "cust_id")
    private String custId;

    @Column(name = "br_code")
    private String brCode;

    @Column(name = "crncy_code")
    private String crncyCode;

    @Column(name = "tran_crncy_code")
    private String tranCrncyCode;

    @Column(name = "ref_amt")
    private BigDecimal refAmt;

    @Column(name = "sol_id")
    private String solId;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "trea_ref_num")
    private String treaRefNum;

    @Column(name = "reversal_date")
    private LocalDate reversalDate;

    @Column(name = "reversal_value_date")
    private LocalDate reversalValueDate;

    @Column(name = "tran_particular_2")
    private String tranParticular2;

    @Column(name = "tran_particular_code")
    private String tranParticularCode;

    @Column(name = "tr_status")
    private String trStatus;

    @Column(name = "party_code")
    private String partyCode;

    @Column(name = "gl_date")
    private LocalDate glDate;

    @Column(name = "bank_id")
    private String bankId;

    @Column(name = "tran_free_code1")
    private String tranFreeCode1;

    @Column(name = "tran_free_code2")
    private String tranFreeCode2;

    @Column(name = "reversal_status")
    private String reversalStatus;

    @Column(name = "available_amt")
    private BigDecimal availableAmt;

    @Column(name = "acct_balance")
    private BigDecimal acctBalance;

    @Column(name = "foracid")
    private String foracid;

    @Column(name = "acct_name")
    private String acctName;

    @Column(name = "acct_short_name")
    private String acctShortName;

    @Column(name = "last_tran_date_cr")
    private LocalDate lastTranDateCr;

    @Lob
    @Column(name = "raw_json", columnDefinition = "TEXT")
    private String rawJson;

    @Column(name = "received_at")
    private LocalDateTime receivedAt;
}

This is my entity the data from consumer i need to store as is in row_json and rest data in table that is working fine but the pending data i need to store in row_json
