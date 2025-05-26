
package com.kotak.orchestrator.orchestrator.cache;


import com.kotak.orchestrator.orchestrator.entity.PlutusClientConfiguration;
import com.kotak.orchestrator.orchestrator.repository.PlutusClientConfigurationRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class ClientConfigurationCache extends CaffeineCache<String, Set<String>> {

    private final PlutusClientConfigurationRepository repository;

    public ClientConfigurationCache(long refreshIntervalMinutes, PlutusClientConfigurationRepository repository) {
        super(refreshIntervalMinutes);
        this.repository = repository;
        refreshCache(); // Initial load
    }

    @Override
    public void refreshCache() {
        try {
            log.info("Refreshing PlutusClientConfiguration cache...");
            List<PlutusClientConfiguration> configs = repository.findAllActive(); // write custom @Query if needed
            Set<String> validForacids = configs.stream()
                    .filter(cfg -> cfg.getActiveFlag() && cfg.getMasterAccount() != null)
                    .map(PlutusClientConfiguration::getMasterAccount)
                    .collect(Collectors.toSet());

            this.put("validForacids", validForacids);
            log.info("Cache refreshed with {} entries.", configs.size());
        } catch (Exception e) {
            log.error("Error refreshing PlutusClientConfiguration cache", e);
        }
    }
}

package com.kotak.orchestrator.orchestrator.service;

import com.kotak.orchestrator.orchestrator.cache.CaffeineCache;
import com.kotak.orchestrator.orchestrator.repository.PlutusClientConfigurationRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class ClientConfigCacheService extends CaffeineCache<String, Boolean> {

    private final PlutusClientConfigurationRepository repository;
    private final Set<String> masterAccountSet = ConcurrentHashMap.newKeySet();

    public ClientConfigCacheService(PlutusClientConfigurationRepository repository) {
        super(60); // Refresh every 60 minutes
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        refreshCache();
    }

    @Override
    public void refreshCache() {
        try {
            masterAccountSet.clear();
            repository.findAllActive().forEach(config -> {
                if (config.getMasterAccount() != null) {
                    masterAccountSet.add(config.getMasterAccount());
                }
            });
            log.info("Client configuration cache refreshed with {} master accounts", masterAccountSet.size());
        } catch (Exception e) {
            log.error("Error refreshing client config cache", e);
        }
    }
    public boolean isMasterAccount(String foracid) {
        return masterAccountSet.contains(foracid);
    }
}


package com.kotak.orchestrator.orchestrator.repository;


import com.kotak.orchestrator.orchestrator.entity.PlutusClientConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlutusClientConfigurationRepository extends JpaRepository<PlutusClientConfiguration, Integer> {

    @Query("SELECT p FROM PlutusClientConfiguration p WHERE p.activeFlag = true")
    List<PlutusClientConfiguration> findAllActive();
}

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

        String foracid = CbsUtils.byteBufferToStr(data.getFORACID());

        // Check in cache before processing
        if (!clientConfigCacheService.isMasterAccount(foracid)) {
            log.info("FORACID {} not found in client config, skipping record.", foracid);
            receiverRecord.receiverOffset().acknowledge();
            return;
        }

        try {
            PlutusFinacleDataEntity entity = mapToEntity(data);
            repository.save(entity);

            log.info("Saved DTD Event with TRAN_ID: {}", CbsUtils.byteBufferToStr(data.getTRANID()));
            receiverRecord.receiverOffset().acknowledge();
        } catch (Exception e) {
            log.error("Error while saving DTD Event: {}", e.getMessage(), e);
        }
    }

    @Override
    public String partitionKey(DtdGamBusinessEvent data) {
        return CbsUtils.byteBufferToStr(data.getEvent() != null ? data.getEvent().getTRANID() : null);
    }

    private PlutusFinacleDataEntity mapToEntity(BusinessEvent data) {
        PlutusFinacleDataEntity entity = new PlutusFinacleDataEntity();

        entity.setForacid(CbsUtils.byteBufferToStr(data.getFORACID()));
        entity.setAcctCrncyCode(CbsUtils.byteBufferToStr(data.getCRNCYCODE()));
        entity.setAcctName(CbsUtils.byteBufferToStr(data.getACCTNAME()));
        entity.setAcctBal(CbsUtils.doubleToBigDecimal(data.getACCTBALANCE()) != null ? CbsUtils.doubleToBigDecimal(data.getACCTBALANCE()).doubleValue() : null);
        entity.setAvailBal(CbsUtils.doubleToBigDecimal(data.getAVAILABLEAMT()) != null ? CbsUtils.doubleToBigDecimal(data.getAVAILABLEAMT()).doubleValue() : null);
        entity.setTranAmt(CbsUtils.doubleToBigDecimal(data.getTRANAMT()) != null ? CbsUtils.doubleToBigDecimal(data.getTRANAMT()).doubleValue() : null);
        entity.setTranDate(CbsUtils.charSeqToStr(data.getTRANDATE()));
        entity.setTranParticular(CbsUtils.byteBufferToStr(data.getTRANPARTICULAR()));
        entity.setTranType(CbsUtils.byteBufferToStr(data.getTRANTYPE()));
        entity.setTxnSubType(CbsUtils.byteBufferToStr(data.getTRANSUBTYPE()));
        entity.setPartTranType(CbsUtils.byteBufferToStr(data.getPARTTRANTYPE()));
        entity.setRefNum(CbsUtils.byteBufferToStr(data.getREFNUM()));
        entity.setTxnCode(CbsUtils.byteBufferToStr(data.getGLSUBHEADCODE()));
        entity.setLinkedAccNo(CbsUtils.byteBufferToStr(data.getACID()));
        entity.setLinkedBranchCode(CbsUtils.byteBufferToStr(data.getBRCODE()));
        entity.setLinkedCrncyCode(CbsUtils.byteBufferToStr(data.getTRANCRNCYCODE()));
        entity.setLinkedName(CbsUtils.byteBufferToStr(data.getBANKCODE()));
        entity.setNarrative(CbsUtils.byteBufferToStr(data.getTRANRMKS()));
        entity.setTranTime(null); // Populate if available
        entity.setMsgTs(LocalDateTime.now().toString());
        entity.setCreatedAt(LocalDateTime.now());

        return entity;
    }
}


