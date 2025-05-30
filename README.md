package com.kotak.orchestrator.orchestrator.integration.config;

import com.kotak.orchestrator.orchestrator.integration.testutils.KafkaAdminUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.wait.strategy.DockerHealthcheckWaitStrategy;
import org.testcontainers.utility.DockerImageName;

@Configuration
@Slf4j
public class ContainerConfig {

    @Value("${spring.kafka.consumer.topic}")
    private String gamTopic;

    @Bean
    public KafkaContainer kafkaContainer(DynamicPropertyRegistry registry) {
        return kafkaContainer(registry, true);
    }

    public KafkaContainer kafkaContainer(DynamicPropertyRegistry registry, boolean createTopic) {

        var imageName = DockerImageName.parse("confluentinc/cp-kafka:7.5.2");
        KafkaContainer kafka = new KafkaContainer(imageName)
                .withReuse(true)
                .withEnv("KAFKA_AUTO_CREATE_TOPICS_ENABLE", "false")
                .withEnv("TOPIC_AUTO_CREATE", "false");
        if (!kafka.isRunning()) {
            kafka.start();
        }

        kafka.waitingFor(new DockerHealthcheckWaitStrategy());
        log.info("Kafka container up. Creating topics if needed.");
        registry.add("cros-account-master-events.kafka.consumer.bootstrap-servers", kafka::getBootstrapServers);
        registry.add("cros-transaction-events.kafka.consumer.bootstrap-servers", kafka::getBootstrapServers);
        log.info("[CONFIG] Kafka Bootstrap Servers: " + kafka.getBootstrapServers());
        if (createTopic) {
            KafkaAdminUtils.createTopic(kafka.getBootstrapServers(), gamTopic);
        }
        return kafka;
    }

}
