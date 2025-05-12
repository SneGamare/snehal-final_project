package com.kotak.smartmessageprocessorservice.smartmessageprocessor.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class GenericKafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.consumer.topic}")
    private String consumerTopic;

    // IAM Configuration
    private Map<String, Object> getCommonKafkaProperties() {
        return new HashMap<>();
    }

    public <T> ProducerFactory<String, T> producerFactory(Class<? extends Serializer<T>> valueSerializerClass) {
        Map<String, Object> config = new HashMap<>(getCommonKafkaProperties());
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    public <T> KafkaTemplate<String, T> kafkaTemplate(Class<? extends Serializer<T>> valueSerializerClass) {
        return new KafkaTemplate<>(producerFactory(valueSerializerClass));
    }

    public <T> ConsumerFactory<String, T> consumerFactory(String groupId, Class<? extends Deserializer<T>> valueDeserializerClass) {
        Map<String, Object> config = new HashMap<>(getCommonKafkaProperties());
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializerClass);
        return new DefaultKafkaConsumerFactory<>(config);
    }

    public <T> ConcurrentKafkaListenerContainerFactory<String, T> listenerContainerFactory(
            String groupId, Class<? extends Deserializer<T>> valueDeserializerClass) {
        ConcurrentKafkaListenerContainerFactory<String, T> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(groupId, valueDeserializerClass));
        return factory;
    }

    @Bean
    public NewTopic dtdBusinessEventTopic() {
        return new NewTopic(consumerTopic, 3, (short) 1); // Adjust partition and RF as per MSK topic config
    }
}
