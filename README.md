// com/kotak/orchestrator/orchestrator/service/ClientConfigCacheService.java
package com.kotak.orchestrator.orchestrator.service;

import com.kotak.orchestrator.orchestrator.cache.CaffeineCache;
import com.kotak.orchestrator.orchestrator.entity.PlutusClientConfiguration;
import com.kotak.orchestrator.orchestrator.repository.PlutusClientConfigurationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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
            repository.findByActiveFlagTrue().forEach(config -> {
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
