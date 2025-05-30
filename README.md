package com.kotak.orchestrator.orchestrator.integration.testutils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import static com.kotak.orchestrator.orchestrator.testUtils.RandUtils.randStr;

@Slf4j
public class KafkaTestBase {

    public static KafkaContainer kafkaContainer;
    public static String bootstrapServers;

    public String topic;
    public String dlq_topic;
    public String groupId;

    @BeforeAll
    public static void setUpBeforeClass() {
        kafkaContainer = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.5.2"))
                .withReuse(true);
        kafkaContainer.start();

        bootstrapServers = kafkaContainer.getBootstrapServers();
        log.info("Kafka container started at: {}", bootstrapServers);
    }

    @BeforeEach
    public void setUpBase() {
        this.topic = randStr("test-", 28);
        this.dlq_topic = topic + "-dlq";
        this.groupId = randStr("test-", 32);
        log.info("Creating topic: {}", topic);
        KafkaAdminUtils.createTopic(bootstrapServers, this.topic);
    }

    @AfterEach
    public void cleanUpBase() {
        log.info("Deleting topic: {}", this.topic);
        KafkaAdminUtils.deleteTopics(bootstrapServers, this.topic);
    }

    // Optional helper sleep method for async test waits
    public static void peacefulSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
