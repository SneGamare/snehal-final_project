package com.kotak.smartmessageprocessorservice.smartmessageprocessor.config;

import com.kotak.smartmessageprocessorservice.smartmessageprocessor.model.PlutusFinacleData;
import com.kotak.smartmessageprocessorservice.smartmessageprocessor.serializer.PlutusFinacleDeserializer;
import com.kotak.smartmessageprocessorservice.smartmessageprocessor.serializer.PlutusFinacleSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializerWrapper;

@Configuration
public class KafkaBeanRegistrar {

    private final GenericKafkaConfig genericKafkaConfig;

    public KafkaBeanRegistrar(GenericKafkaConfig genericKafkaConfig) {
        this.genericKafkaConfig = genericKafkaConfig;
    }

    // 🟦 PlutusFinacleData Beans with custom serializer and deserializer
    @Bean
    public KafkaTemplate<String, PlutusFinacleData> plutusKafkaTemplate() {
        // Use the custom serializer for PlutusFinacleData
        return genericKafkaConfig.kafkaTemplate(PlutusFinacleSerializer.class);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PlutusFinacleData> plutusListenerContainerFactory() {
        // Create a listener factory with the custom deserializer for PlutusFinacleData
        return genericKafkaConfig.listenerContainerFactory("plutus-finacle-group", PlutusFinacleDeserializer.class);
    }

    // 🟨 Add other DTO Beans (for example, if you are using JSON or other formats)
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
    
    // ➕ Additional beans for other message types (e.g., Employee) can be added here.
}
