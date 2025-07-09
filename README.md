
package com.kotak.orchestrator.orchestrator.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.orchestrator.orchestrator.entity.PlutusFinacleDataEntity;
import com.kotak.orchestrator.orchestrator.schema.BusinessEvent;
import com.kotak.orchestrator.orchestrator.schema.DtdGamBusinessEvent;
import com.kotak.orchestrator.orchestrator.service.ClientConfigCacheService;
import com.kotak.orchestrator.orchestrator.utils.CbsUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.ReceiverRecord;

import java.io.ByteArrayOutputStream;
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
    private final ObjectMapper objectMapper;


    @Override
    public void process(ReceiverRecord<String, DtdGamBusinessEvent> receiverRecord) {
        BusinessEvent data = receiverRecord.value().getEvent();

        if (data == null) {
            log.warn("Received null BusinessEvent.");
            return;
        }

        String foracid = byteBufferToStr(data.getFORACID());

        // Filter based on cache
//        if (!clientConfigCacheService.isMasterAccount(foracid)) {
//            log.info("FORACID {} not found in client config, skipping record.", foracid);
//            receiverRecord.receiverOffset().acknowledge();
//            return;
//        }

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
        String rawJson = avroToJson(data);
        log.info("Serialized BusinessEvent Json :{}",rawJson);
        entity.setRawJson(rawJson);
        return entity;
    }

    private String avroToJson(BusinessEvent data) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            DatumWriter<BusinessEvent> writer = new SpecificDatumWriter<>(data.getSchema());
            Encoder encoder = EncoderFactory.get().jsonEncoder(data.getSchema(), out);
            writer.write(data, encoder);
            encoder.flush();
            return out.toString("UTF-8");
        } catch (Exception e) {
            log.error("Failed to convert Avro to JSON", e);
            return "{}";
        }
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
