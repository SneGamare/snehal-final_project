package com.kotak.orchestrator.orchestrator.cache;

import com.kotak.orchestrator.orchestrator.entity.PlutusClientConfigurationEntity;
import com.kotak.orchestrator.orchestrator.repository.PlutusClientConfigurationRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
public class ClientConfigurationCache extends CaffeineCache<String, PlutusClientConfigurationEntity> {

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
            List<PlutusClientConfigurationEntity> configs = repository.findAllActive(); // write custom @Query if needed
            Map<String, PlutusClientConfigurationEntity> configMap = configs.stream()
                    .collect(Collectors.toMap(PlutusClientConfigurationEntity::getMasterAccount, c -> c));
            configMap.forEach(this::put);
            log.info("Cache refreshed with {} entries.", configMap.size());
        } catch (Exception e) {
            log.error("Error refreshing PlutusClientConfiguration cache", e);
        }
    }
}




@RequiredArgsConstructor
@Component
@Slf4j
public class PlutusDtdBusinessEventConsumer implements MessageConsumer<DtdGamBusinessEvent> {

    private final PlutusFinacleDataRepository repository;
    private final ClientConfigurationCache clientConfigCache;

    @Override
    public void process(ReceiverRecord<String, DtdGamBusinessEvent> receiverRecord) {
        BusinessEvent data = receiverRecord.value().getEvent();

        if (data == null) {
            log.warn("Received null BusinessEvent.");
            return;
        }

        String foracid = CbsUtils.byteBufferToStr(data.getFORACID());

        // Check in cache before processing
        if (clientConfigCache.get(foracid) == null) {
            log.info("FORACID {} not found in client config, skipping record.", foracid);
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

    // mapToEntity remains unchanged
}
