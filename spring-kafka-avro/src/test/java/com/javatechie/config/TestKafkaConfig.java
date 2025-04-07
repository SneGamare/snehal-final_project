package com.javatechie.config;

import com.javatechie.dto.PlutusFinacleData;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestConfiguration
public class TestKafkaConfig {

    @Bean
    @Primary
    public KafkaTemplate<String, PlutusFinacleData> plutusFinacleDataKafkaTemplate() {
        KafkaTemplate<String, PlutusFinacleData> mockTemplate = mock(KafkaTemplate.class);
        when(mockTemplate.send(any(), any(), any())).thenReturn(CompletableFuture.completedFuture(new SendResult<>(null, null)));
        return mockTemplate;
    }
} 