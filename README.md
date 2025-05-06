package com.kotak.orchestrator.producer;

import com.kotak.orchestrator.dto.UpiReconciliationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UpiReconciliationProducer {

    private static final String TOPIC = "upi-reconciliation-topic";

    @Autowired
    private KafkaTemplate<String, UpiReconciliationDto> kafkaTemplate;

    public void send(UpiReconciliationDto dto) {
        kafkaTemplate.send(TOPIC, dto);
    }
}
