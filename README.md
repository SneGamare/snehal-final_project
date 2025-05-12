package com.kotak.smartmessageprocessorservice.smartmessageprocessor.producer;

import com.kotak.smartmessageprocessorservice.smartmessageprocessor.entity.PlutusDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaProducer {

    @Autowired
    private final KafkaTemplate<String, PlutusDto> kafkaTemplate;

    @Value("${spring.kafka.producer.topic}")
    private String topicName;

    public JsonKafkaProducer(KafkaTemplate<String, PlutusDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(PlutusDto data) {
        System.out.println("data is getting produced ");
        kafkaTemplate.send(topicName, data);
    }
}


package com.kotak.smartmessageprocessorservice.smartmessageprocessor.config;

import com.kotak.smartmessageprocessorservice.smartmessageprocessor.model.PlutusFinacleData;
import com.kotak.smartmessageprocessorservice.smartmessageprocessor.serializer.PlutusFinacleDeserializer;
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
    public KafkaTemplate<String, Object> plutusKafkaTemplate() {
        return genericKafkaConfig.kafkaTemplate();
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


package com.kotak.smartmessageprocessorservice.smartmessageprocessor.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Deserializer;
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

    // Producer Factory Method - now uses JsonSerializer for serializing the value (DTO)

    public <T> ProducerFactory<String, T> producerFactory() {
        Map<String, Object> config = new HashMap<>(getCommonKafkaProperties());
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }


    // Kafka Template Bean Definition - uses JsonSerializer for the DTOs

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    // Consumer Factory Method - Configures consumer to read Avro (or other format) data
    public <T> ConsumerFactory<String, T> consumerFactory(String groupId, Class<? extends Deserializer<T>> valueDeserializerClass) {
        Map<String, Object> config = new HashMap<>(getCommonKafkaProperties());
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializerClass);
        return new DefaultKafkaConsumerFactory<>(config);
    }

    // Listener Container Factory - for creating consumer listeners
    public <T> ConcurrentKafkaListenerContainerFactory<String, T> listenerContainerFactory(
            String groupId, Class<? extends Deserializer<T>> valueDeserializerClass) {
        ConcurrentKafkaListenerContainerFactory<String, T> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(groupId, valueDeserializerClass));
        return factory;
    }

    // New Kafka topic definition (if necessary)
    @Bean
    public NewTopic dtdBusinessEventTopic() {
        return new NewTopic(consumerTopic, 3, (short) 1); // Adjust partition and RF as per MSK topic config
    }
}
