package com.javatechie.producer;

import com.javatechie.dto.PlutusFinacleData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class PlutusFinacleDataProducerTest {

    @MockBean
    private KafkaTemplate<String, PlutusFinacleData> kafkaTemplate;

    @Autowired
    private PlutusFinacleDataProducer producer;

    @Test
    void testSend() {
        // Arrange
        PlutusFinacleData data = new PlutusFinacleData();
        when(kafkaTemplate.send(any(), any(), any())).thenReturn(CompletableFuture.completedFuture(new SendResult<>(null, null)));

        // Act
        producer.send(data);

        // Assert
        verify(kafkaTemplate).send(eq("plutus-finacle-data"), any(), eq(data));
    }
} 