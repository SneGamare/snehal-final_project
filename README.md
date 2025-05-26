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
