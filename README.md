package com.kotak.orchestrator.orchestrator.service;

import com.kotak.orchestrator.orchestrator.entity.PlutusClientConfiguration;
import com.kotak.orchestrator.orchestrator.repository.PlutusClientConfigurationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientConfigCacheServiceTest {

    @Mock
    private PlutusClientConfigurationRepository repository;

    @InjectMocks
    private ClientConfigCacheService cacheService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRefreshCacheLoadsActiveMasterAccounts() {
        PlutusClientConfiguration config1 = new PlutusClientConfiguration();
        config1.setMasterAccount("ACC123");
        PlutusClientConfiguration config2 = new PlutusClientConfiguration();
        config2.setMasterAccount("ACC456");

        when(repository.findAllActive()).thenReturn(List.of(config1, config2));

        cacheService.refreshCache();

        assertTrue(cacheService.isMasterAccount("ACC123"));
        assertTrue(cacheService.isMasterAccount("ACC456"));
        assertFalse(cacheService.isMasterAccount("UNKNOWN"));
    }

    @Test
    void testIsMasterAccountLogsCorrectly() {
        // No data loaded, so should return false
        boolean result = cacheService.isMasterAccount("ACC999");
        assertFalse(result);
    }

    @Test
    void testRefreshCacheHandlesNullMasterAccount() {
        PlutusClientConfiguration configWithNull = new PlutusClientConfiguration();
        configWithNull.setMasterAccount(null);

        when(repository.findAllActive()).thenReturn(List.of(configWithNull));

        // Should not throw exception or add null
        cacheService.refreshCache();

        assertFalse(cacheService.isMasterAccount(null));
    }
}



package com.kotak.orchestrator.orchestrator.service;

import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class PlutusDataCleanupServiceTest {

    @Mock
    private PlutusFinacleDataRepository repository;

    @InjectMocks
    private PlutusDataCleanupService cleanupService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCleanupOldDataCallsRepository() {
        cleanupService.cleanupOldData();
        verify(repository, times(1)).deleteByReceivedAtBefore(any(LocalDateTime.class));
    }

    @Test
    void testCleanupOldDataExceptionHandled() {
        doThrow(new RuntimeException("DB error")).when(repository).deleteByReceivedAtBefore(any(LocalDateTime.class));

        // Should not throw, just logs error
        cleanupService.cleanupOldData();

        verify(repository, times(1)).deleteByReceivedAtBefore(any(LocalDateTime.class));
    }
}


package com.kotak.orchestrator.orchestrator.repository;

import com.kotak.orchestrator.orchestrator.entity.PlutusClientConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PlutusClientConfigurationRepositoryTest {

    @Autowired
    private PlutusClientConfigurationRepository repository;

    @Test
    void findAllActiveReturnsOnlyActiveConfigs() {
        // Prepare test data (assuming entity has setters)
        PlutusClientConfiguration activeConfig = new PlutusClientConfiguration();
        activeConfig.setActiveFlag(true);
        activeConfig.setMasterAccount("ACTIVE_ACC");

        PlutusClientConfiguration inactiveConfig = new PlutusClientConfiguration();
        inactiveConfig.setActiveFlag(false);
        inactiveConfig.setMasterAccount("INACTIVE_ACC");

        repository.save(activeConfig);
        repository.save(inactiveConfig);

        List<PlutusClientConfiguration> activeConfigs = repository.findAllActive();

        assertThat(activeConfigs).hasSize(1);
        assertThat(activeConfigs.get(0).getMasterAccount()).isEqualTo("ACTIVE_ACC");
    }
}
