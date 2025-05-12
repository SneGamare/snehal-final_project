package com.kotak.smartmessageprocessorservice.smartmessageprocessor.config;

import com.kotak.smartmessageprocessorservice.smartmessageprocessor.model.PlutusFinacleData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializerWrapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaBeanRegistrar {

    private final GenericKafkaConfig genericKafkaConfig;

    public KafkaBeanRegistrar(GenericKafkaConfig genericKafkaConfig) {
        this.genericKafkaConfig = genericKafkaConfig;
    }

    // 🟦 PlutusFinacleData Beans - Use JsonSerializer and JsonDeserializer instead of custom serializer
    @Bean
    public KafkaTemplate<String, PlutusFinacleData> plutusKafkaTemplate() {
        // Using default JsonSerializer for PlutusFinacleData
        return genericKafkaConfig.kafkaTemplate(JsonSerializer.class);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PlutusFinacleData> plutusListenerContainerFactory() {
        // Use JsonDeserializer for deserializing PlutusFinacleData
        return genericKafkaConfig.listenerContainerFactory("plutus-finacle-group", JsonDeserializer.class);
    }

    // 🟨 Add other DTO Beans for JSON (like PlutusDto, etc.)
    @Bean
    public KafkaTemplate<String, Object> jsonKafkaTemplate() {
        // If you're using JSON serialization for other DTOs (like PlutusDto)
        return genericKafkaConfig.kafkaTemplate(JsonSerializer.class);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> jsonListenerContainerFactory() {
        // If you're using JSON deserialization for other DTOs (like PlutusDto)
        return genericKafkaConfig.listenerContainerFactory("json-group", JsonDeserializer.class);
    }
    
    // ➕ Additional beans for other message types can be added here, e.g., Employee
}
