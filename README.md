package com.kotak.orchestrator.orchestrator.service;

import com.kotak.orchestrator.orchestrator.cache.CaffeineCache;
import com.kotak.orchestrator.orchestrator.repository.PlutusClientConfigurationRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service to manage and validate master accounts using an in-memory cache.
 */
@Slf4j
@Service
public class ClientConfigCacheService extends CaffeineCache<String, Boolean> {

    private final PlutusClientConfigurationRepository repository;

    //A thread-safe set holding null active master accounts
    private final Set<String> masterAccountSet = ConcurrentHashMap.newKeySet();

    public ClientConfigCacheService(PlutusClientConfigurationRepository repository) {
        super(60); // Cache refresh interval: 60 minutes
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        log.info("Initializing ClientConfigCacheService...");
        refreshCache();
    }

    /**
     * periodically reloads the list of active master account from the DB
     */

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

    /**
     * Checks whether the given FORACID exists in the configured client master accounts.
     */
    public boolean isMasterAccount(String foracid) {
        boolean result = masterAccountSet.contains(foracid);
        log.info("Checking master account {}: {}", foracid, result);
        return result;
    }

}


package com.kotak.orchestrator.orchestrator.service;

import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class PlutusDataCleanupService {

    @Autowired
    private PlutusFinacleDataRepository repository;

    @Scheduled(cron = "0 0 3 * * ?")
    public void cleanupOldData(){
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
        repository.deleteByReceivedAtBefore(oneMonthAgo);
    }
}


package com.kotak.orchestrator.orchestrator.repository;


import com.kotak.orchestrator.orchestrator.entity.PlutusClientConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to fetch active client configurations from the database.
 */
@Repository
public interface PlutusClientConfigurationRepository extends JpaRepository<PlutusClientConfiguration, Integer> {

    /**
     * Fetch all active configurations (with activeFlag = true).
     */
    @Query("SELECT c FROM PlutusClientConfiguration c WHERE c.activeFlag = true")
    List<PlutusClientConfiguration> findAllActive();
}


package com.kotak.orchestrator.orchestrator.repository;


import com.kotak.orchestrator.orchestrator.entity.PlutusFinacleDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PlutusFinacleDataRepository extends JpaRepository<PlutusFinacleDataEntity, String> {
    void deleteByReceivedAtBefore(LocalDateTime dateTime);

} 


