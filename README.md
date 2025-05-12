package com.kotak.smartmessageprocessorservice.smartmessageprocessor.config;

import com.kotak.smartmessageprocessorservice.smartmessageprocessor.model.PlutusFinacleData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaBeanRegistrar {

    private final GenericKafkaConfig genericKafkaConfig;

    public KafkaBeanRegistrar(GenericKafkaConfig genericKafkaConfig) {
        this.genericKafkaConfig = genericKafkaConfig;
    }

    // 🟨 Add other DTO Beans for JSON (like PlutusDto, etc.)
    @Bean
    public KafkaTemplate<String, Object> jsonKafkaTemplate() {
        // Using default JsonSerializer for general Object DTOs (like PlutusDto)
        return genericKafkaConfig.kafkaTemplate(JsonSerializer.class);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> jsonListenerContainerFactory() {
        // Using JsonDeserializer for general Object DTOs (like PlutusDto)
        JsonDeserializer<Object> deserializer = new JsonDeserializer<>(Object.class);
        deserializer.addTrustedPackages("*");  // This ensures all packages are trusted for deserialization

        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(genericKafkaConfig.consumerFactory("plutus-finacle-group", deserializer.getClass()));
        return factory;
    }

    // 🟦 PlutusFinacleData Beans - Use JsonSerializer and JsonDeserializer instead of custom serializer
    @Bean
    public KafkaTemplate<String, PlutusFinacleData> plutusKafkaTemplate() {
        return genericKafkaConfig.kafkaTemplate(JsonSerializer.class);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PlutusFinacleData> plutusListenerContainerFactory() {
        JsonDeserializer<PlutusFinacleData> deserializer = new JsonDeserializer<>(PlutusFinacleData.class);
        deserializer.addTrustedPackages("*");  // This ensures all packages are trusted for deserialization

        ConcurrentKafkaListenerContainerFactory<String, PlutusFinacleData> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(genericKafkaConfig.consumerFactory("plutus-finacle-group", deserializer.getClass()));
        return factory;
    }

    // ➕ Add more beans for other DTOs if needed...
}
