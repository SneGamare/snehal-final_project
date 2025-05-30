package com.kotak.orchestrator.orchestrator.consumer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.kotak.orchestrator.orchestrator.schema.DtdGamBusinessEvent;
import com.kotak.orchestrator.orchestrator.serializer.PlutusDtdDeserializer;
import org.junit.jupiter.api.Test;
import reactor.kafka.receiver.ReceiverRecord;

public class ConsumerConfigurationTest {

    @Test
    public void testBuilder_allFields() {
        String bootstrapServers = "localhost:9092";
        String topic = "test-topic";
        String groupId = "test-group";
        Class<PlutusDtdDeserializer> valueDeserializer = PlutusDtdDeserializer.class;
        MockMessageConsumer processor = new MockMessageConsumer();

        ConsumerConfiguration<DtdGamBusinessEvent> config = ConsumerConfiguration.<DtdGamBusinessEvent>builder()
                .bootstrapServers(bootstrapServers)
                .topic(topic)
                .groupId(groupId)
                .valueDeserializer(valueDeserializer)
                .processor(processor)
                .securityProtocol("MSK_AWS_IAM")
                .build();

        assertAll(
                "Consumer configuration",
                () -> assertEquals(bootstrapServers, config.getBootstrapServers()),
                () -> assertEquals(topic, config.getTopic()),
                () -> assertEquals(groupId, config.getGroupId()),
                () -> assertEquals(valueDeserializer, config.getValueDeserializer()),
                () -> assertEquals(processor, config.getProcessor()),
                () -> assertEquals("MSK_AWS_IAM", config.getSecurityProtocol()));
    }

    @Test
    public void testBuilder_requiredFields() {
        String bootstrapServers = "localhost:9092";
        String topic = "test-topic";
        String groupId = "test-group";
        Class<PlutusDtdDeserializer> valueDeserializer = PlutusDtdDeserializer.class;
        MockMessageConsumer processor = new MockMessageConsumer();

        ConsumerConfiguration<DtdGamBusinessEvent> config = ConsumerConfiguration.<DtdGamBusinessEvent>builder()
                .bootstrapServers(bootstrapServers)
                .topic(topic)
                .groupId(groupId)
                .valueDeserializer(valueDeserializer)
                .processor(processor)
                .build();

        assertAll(
                "Consumer configuration",
                () -> assertEquals(bootstrapServers, config.getBootstrapServers()),
                () -> assertEquals(topic, config.getTopic()),
                () -> assertEquals(groupId, config.getGroupId()),
                () -> assertEquals(valueDeserializer, config.getValueDeserializer()),
                () -> assertEquals(processor, config.getProcessor()));
    }

    @Test
    public void testBuilder_noValueDeserializer() {
        ConsumerConfiguration<String> config =
                ConsumerConfiguration.<String>builder().build();

        assertNull(config.getValueDeserializer());
    }

    @Test
    public void testBuilder_noProcessor() {
        ConsumerConfiguration<String> config =
                ConsumerConfiguration.<String>builder().build();
        assertNull(config.getProcessor());
    }

    private static class MockMessageConsumer implements MessageConsumer<DtdGamBusinessEvent> {

        @Override
        public void process(ReceiverRecord<String, DtdGamBusinessEvent> message) {
            // Just for testing purposes
        }

        @Override
        public String partitionKey(DtdGamBusinessEvent message) {
            return null;
        }
    }
}


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


    // https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.testcontainers
    // https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testcontainers

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

package com.kotak.orchestrator.orchestrator.integration.testutils;


import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.apache.avro.Schema;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static com.kotak.orchestrator.orchestrator.constant.AppConstants.GAM_DATE_TIME;


public class CommonUtils {


   /* public static CharSequence stringToBB(String val) {
        if (val == null) {
            return null;
        }
        ByteBuffer buffer = ByteBuffer.wrap(val.getBytes(StandardCharsets.UTF_8));
        return StandardCharsets.UTF_8.decode(buffer).toString();
    }*/

    public static ByteBuffer stringToBB(String val) {
        if (val == null) {
            return null;
        }
        return ByteBuffer.wrap(val.getBytes(StandardCharsets.UTF_8));
    }


    public static String byteBuffToStr(ByteBuffer value) {
        if (value == null) {
            return null;
        }
        ByteBuffer duplicate = value.duplicate();
        return StandardCharsets.UTF_8.decode(duplicate).toString();
    }

    public static BigDecimal roundDouble(Double val) {
        return (val != null) ? new BigDecimal(val).setScale(4, RoundingMode.HALF_UP) : null;
    }

    public static LocalDateTime strToDate(CharSequence dateTime) {
        return (dateTime != null) ? LocalDateTime.parse(dateTime.toString(), GAM_DATE_TIME) : null;
    }


    public static Schema readAvscFileFromResources(String avscFileName, ClassLoader loader) throws Exception {
        try (InputStream inputStream = loader.getResourceAsStream(avscFileName);
             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            if (inputStream == null) {
                throw new Exception();
            }
            StringBuilder content = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                content.append((char) character);
            }
            JSONObject schemaJson = (JSONObject) new JSONParser().parse(content.toString());
            return new Schema.Parser().parse(schemaJson.toJSONString());
        }
    }
}


package com.kotak.orchestrator.orchestrator.integration.testutils;

import org.springframework.test.context.DynamicPropertyRegistry;

import java.util.function.Supplier;

public class DummyPropertyRegistry implements DynamicPropertyRegistry {

    @Override
    public void add(String name, Supplier<Object> valueSupplier) {}
}


package com.kotak.orchestrator.orchestrator;

import com.kotak.orchestrator.orchestrator.config.PlutusDtdConsumerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@ActiveProfiles("test")
@Import({PlutusDtdConsumerConfig.class})
class OrchestratorServiceApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    void Loads() {
        assertThat(applicationContext).isNotNull();
    }

    @Test
    void plutusDtdConsumerConfigBeanShouldBeLoaded() {
        boolean beanExists = applicationContext.containsBeanDefinition("plutusDtdConsumerConfig");
        assertThat(beanExists).isTrue();
    }
}

