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

    @Bean(destroyMethod = "stop")
    public KafkaContainer kafkaContainer() {
        var imageName = DockerImageName.parse("confluentinc/cp-kafka:7.5.2");
        KafkaContainer kafka = new KafkaContainer(imageName)
                .withReuse(true)
                .withEnv("KAFKA_AUTO_CREATE_TOPICS_ENABLE", "false")
                .withEnv("TOPIC_AUTO_CREATE", "false");

        if (!kafka.isRunning()) {
            kafka.start();
        }

        kafka.waitingFor(new DockerHealthcheckWaitStrategy());
        log.info("Kafka container up.");

        KafkaAdminUtils.createTopic(kafka.getBootstrapServers(), gamTopic);

        log.info("[CONFIG] Kafka Bootstrap Servers: " + kafka.getBootstrapServers());
        return kafka;
    }
}
