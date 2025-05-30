package com.kotak.orchestrator.orchestrator.integration;

import com.kotak.orchestrator.orchestrator.integration.testutils.KafkaAdminUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class KafkaIntegrationTest {

    // Define Kafka container as static for the entire test class lifecycle
    private static final KafkaContainer kafkaContainer = new KafkaContainer(
            DockerImageName.parse("confluentinc/cp-kafka:7.5.2")
    ).withReuse(true);

    private static final String testTopic = "test-topic";

    @BeforeAll
    static void setup() {
        kafkaContainer.start();
        // Create your topic after container started
        KafkaAdminUtils.createTopic(kafkaContainer.getBootstrapServers(), testTopic);
    }

    @AfterAll
    static void cleanup() {
        kafkaContainer.stop();
    }

    // Inject Kafka bootstrap servers dynamically into Spring Environment
    @DynamicPropertySource
    static void kafkaProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
        // Add your topic property if needed
        registry.add("spring.kafka.consumer.topic", () -> testTopic);
    }

    @Test
    public void contextLoads() {
        assertThat(kafkaContainer.isRunning()).isTrue();
        System.out.println("Kafka bootstrap servers: " + kafkaContainer.getBootstrapServers());
    }

    // Add more integration tests that produce/consume messages to/from Kafka here

}
