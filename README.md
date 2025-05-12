package com.kotak.smartmessageprocessorservice.smartmessageprocessor.config;

import com.kotak.smartmessageprocessorservice.smartmessageprocessor.model.PlutusFinacleData;
import com.kotak.smartmessageprocessorservice.smartmessageprocessor.serializer.PlutusFinacleDeserializer;
import com.kotak.smartmessageprocessorservice.smartmessageprocessor.serializer.PlutusFinacleSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaBeanRegistrar {

    private final GenericKafkaConfig genericKafkaConfig;

    public KafkaBeanRegistrar(GenericKafkaConfig genericKafkaConfig) {
        this.genericKafkaConfig = genericKafkaConfig;
    }

    // 🟦 PlutusFinacleData Beans
    @Bean
    public KafkaTemplate<String, PlutusFinacleData> plutusKafkaTemplate() {
        return genericKafkaConfig.kafkaTemplate(PlutusFinacleSerializer.class);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PlutusFinacleData> plutusListenerContainerFactory() {
        return genericKafkaConfig.listenerContainerFactory("plutus-finacle-group", PlutusFinacleDeserializer.class);
    }

    // 🟨 Employee Beans (assume JSON/String serialization)
   /* @Bean
    public KafkaTemplate<String, Employee> employeeKafkaTemplate() {
        return genericKafkaConfig.kafkaTemplate((Class<? extends org.apache.kafka.common.serialization.Serializer<Employee>>) StringSerializer.class);
    }*/

    // ➕ Add more beans here for other DTOs if needed...
}
