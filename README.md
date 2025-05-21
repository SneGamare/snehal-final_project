package com.kotak.orchestrator.orchestrator.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotak.orchestrator.orchestrator.entity.PlutusFinacleDataEntity;
import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.orchestrator.orchestrator.schema.PlutusFinacleData;
import com.kotak.orchestrator.orchestrator.service.ClientConfigCacheService;
import com.kotak.orchestrator.orchestrator.validator.PlutusDataValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
public class PlutusFinacleDataConsumer extends GenericAvroConsumer<PlutusFinacleData> {

    private final PlutusFinacleDataRepository repository;
    private final PlutusDataValidator plutusDataValidator;
    private final ClientConfigCacheService clientConfigCacheService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PlutusFinacleDataConsumer(
            PlutusFinacleDataRepository repository,
            PlutusDataValidator plutusDataValidator,
            ClientConfigCacheService clientConfigCacheService) {


        System.out.println("PlutusFinacleDataConsumer constructor called");

        this.repository = repository;
        this.plutusDataValidator = plutusDataValidator;
        this.clientConfigCacheService = clientConfigCacheService;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "plutus-finacle-group")
    public void listen(ConsumerRecord<String, PlutusFinacleData> record) {
        consume(record);
    }

    @Override
    protected void handleMessage(PlutusFinacleData data, ConsumerRecord<String, PlutusFinacleData> record) {
        try {
            // Validate required fields
            plutusDataValidator.validate(data);

            // Normalize FORACID
            String foracid = toStr(data.getForacid()).trim();

            // Fetch valid FORACIDs from cache
            Set<String> validForacids = clientConfigCacheService.getValidForacids();
            log.debug("Valid FORACIDs from cache: {}", validForacids);

            if (!validForacids.contains(foracid)) {
                log.info("Skipping unmatched FORACID: {}", foracid);
                return;
            }

            // Map to entity
            PlutusFinacleDataEntity entity = new PlutusFinacleDataEntity();
            entity.setTranId(toStr(data.getTranId()));
            entity.setTranAmt(data.getTranAmt());
            entity.setAcid(toStr(data.getAcid()));
            entity.setForacid(foracid);
            entity.setRefNum(toStr(data.getRefNum()));
            entity.setReceivedAt(LocalDateTime.now());

            // Prepare raw data map
            Map<String, Object> rawMap = new HashMap<>();
            rawMap.put("acctName", toStr(data.getAcctName()));
            rawMap.put("lastTranDateCr", toStr(data.getLastTranDateCr()));
            rawMap.put("partTranSrlNum", toStr(data.getPartTranSrlNum()));
            rawMap.put("delFlg", toStr(data.getDelFlg()));
            rawMap.put("tranType", toStr(data.getTranType()));
            rawMap.put("tranSubType", toStr(data.getTranSubType()));
            rawMap.put("partTranType", toStr(data.getPartTranType()));
            rawMap.put("glSubHeadCode", toStr(data.getGlSubHeadCode()));
            rawMap.put("valueDate", toStr(data.getValueDate()));
            rawMap.put("tranParticular", toStr(data.getTranParticular()));
            rawMap.put("entryDate", toStr(data.getEntryDate()));
            rawMap.put("pstdDate", toStr(data.getPstdDate()));
            rawMap.put("instrmntType", toStr(data.getInstrmntType()));
            rawMap.put("instrmntDate", toStr(data.getInstrmntDate()));
            rawMap.put("instrmntNum", toStr(data.getInstrmntNum()));
            rawMap.put("tranRmks", toStr(data.getTranRmks()));
            rawMap.put("custId", toStr(data.getCustId()));
            rawMap.put("brCode", toStr(data.getBrCode()));
            rawMap.put("crncyCode", toStr(data.getCrncyCode()));
            rawMap.put("tranCrncyCode", toStr(data.getTranCrncyCode()));
            rawMap.put("refAmt", data.getRefAmt());
            rawMap.put("solId", toStr(data.getSolId()));
            rawMap.put("bankCode", toStr(data.getBankCode()));
            rawMap.put("treaRefNum", toStr(data.getTreaRefNum()));
            rawMap.put("reversalDate", toStr(data.getReversalDate()));

            entity.setRawData(objectMapper.writeValueAsString(rawMap));

            // Save to DB
            repository.save(entity);
            log.info("Saved PlutusFinacleData to DB, tranId: {}", entity.getTranId());

        } catch (IllegalArgumentException e) {
            log.warn("Validation failed: {}", e.getMessage());
        } catch (Exception e) {
            log.error("Error processing record: {}", e.getMessage(), e);
        }
    }

    private String toStr(CharSequence input) {
        return input != null ? input.toString() : null;
    }
}



this is my consumer 



package com.kotak.orchestrator.orchestrator.service;

import com.kotak.orchestrator.orchestrator.cache.CaffeineCache;
import com.kotak.orchestrator.orchestrator.cache.ForAcidCache;
import com.kotak.orchestrator.orchestrator.repository.PlutusClientConfigurationRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClientConfigCacheService {

    private final CaffeineCache<String, Set<String>> foracidCache;
    private final PlutusClientConfigurationRepository plutusClientConfigurationRepository;

    public ClientConfigCacheService(
            PlutusClientConfigurationRepository configRepo
    ) {
        this.plutusClientConfigurationRepository = configRepo;
        this.foracidCache = new ForAcidCache(10, configRepo); // Use subclass with refresh logic
    }


    @PostConstruct
    public void init() {
        Set<String> foracids = getValidForacids();
        log.info("Loaded {} FORACIDs from configuration: {}", foracids.size(), foracids);
    }


    public Set<String> getValidForacids() {
        try {
            Set<String> foracids = plutusClientConfigurationRepository.findAll()
                    .stream()
                    .map(config -> config.getMasterAccount().trim())
                    .collect(Collectors.toSet());

            log.info("Loaded {} FORACIDs from configuration", foracids.size());
            return foracids;
        } catch (Exception e) {
            log.error("Failed to load FORACIDs from configuration", e);
            return Collections.emptySet();
        }
    }
}


package com.kotak.orchestrator.orchestrator.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CaffeineCache<K, V> {

    private final Cache<K, V> cache;
    private final ScheduledExecutorService scheduler;

    public CaffeineCache(long refreshIntervalMinutes) {
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(refreshIntervalMinutes, TimeUnit.MINUTES)
                .build();
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::refreshCache, 0, refreshIntervalMinutes, TimeUnit.MINUTES);
    }

    public V get(K key) {
        return cache.getIfPresent(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public void refreshCache() {
        // To be overridden by subclasses
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}
