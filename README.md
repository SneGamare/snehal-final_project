package com.kotak.orchestrator.orchestrator.integration.testutils;


import com.kotak.orchestrator.orchestrator.integration.config.ContainerConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.kotak.orchestrator.orchestrator.testUtils.RandUtils.randStr;

@Slf4j
public class KafkaTestBase {

    public static String bootstrapServers;
    public static final ContainerConfig containerConfig = new ContainerConfig();

    public String topic;
    public String dlq_topic;

    public String groupId;

    @BeforeAll
    public static void setUpBeforeClass() {
        var container = containerConfig.kafkaContainer();
        bootstrapServers = container.getBootstrapServers();
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

    public static void peacefulSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
