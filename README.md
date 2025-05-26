package com.kotak.orchestrator.orchestrator.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.kotak.orchestrator.orchestrator.entity.PlutusClientConfiguration;
import com.kotak.orchestrator.orchestrator.repository.PlutusClientConfigurationRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Cache class that stores active master accounts from PlutusClientConfiguration.
 * Uses Caffeine to expire and refresh cache periodically.
 */
@Slf4j
public class PlutusClientConfigurationCache {

    private final Cache<String, Boolean> cache;
    private final ScheduledExecutorService scheduler;
    private final PlutusClientConfigurationRepository repository;

    private static final String CACHE_KEY_PREFIX = "MASTER_ACCOUNT:";

    public PlutusClientConfigurationCache(long refreshIntervalMinutes, PlutusClientConfigurationRepository repository) {
        this.repository = repository;
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(refreshIntervalMinutes, TimeUnit.MINUTES)
                .build();

        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::refreshCache, 0, refreshIntervalMinutes, TimeUnit.MINUTES);
    }

    /**
     * Refreshes the cache by fetching active master accounts from the DB.
     */
    public void refreshCache() {
        try {
            log.info("Refreshing PlutusClientConfiguration cache...");
            List<PlutusClientConfiguration> configs = repository.findAllActive();
            Set<String> masterAccounts = configs.stream()
                    .filter(cfg -> cfg.getActiveFlag() && cfg.getMasterAccount() != null)
                    .map(PlutusClientConfiguration::getMasterAccount)
                    .collect(Collectors.toSet());

            cache.invalidateAll(); // clear old
            masterAccounts.forEach(ma -> cache.put(CACHE_KEY_PREFIX + ma, true));

            log.info("Cache refreshed with {} active master accounts", masterAccounts.size());
        } catch (Exception e) {
            log.error("Error refreshing PlutusClientConfiguration cache", e);
        }
    }

    /**
     * Checks if a FORACID is present in the cache.
     */
    public boolean isMasterAccount(String foracid) {
        return cache.getIfPresent(CACHE_KEY_PREFIX + foracid) != null;
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}
