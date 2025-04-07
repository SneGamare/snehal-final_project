package com.javatechie.producer;

import com.javatechie.dto.PlutusFinacleData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class PlutusFinacleDataProducer {

    @Autowired
    private KafkaTemplate<String, PlutusFinacleData> kafkaTemplate;
    
    @Value("${topic.plutus-finacle:plutus-finacle-topic}")
    private String topicName;

    public CompletableFuture<SendResult<String, PlutusFinacleData>> send(PlutusFinacleData data) {
        log.info("Sending PlutusFinacleData to topic {}: {}", topicName, data);
        return kafkaTemplate.send(topicName, data);
    }
} 