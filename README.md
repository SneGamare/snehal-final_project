
java.lang.NoClassDefFoundError: org/apache/commons/lang3/ArrayFill

	at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.writeEOFRecord(TarArchiveOutputStream.java:677)
	at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.finish(TarArchiveOutputStream.java:421)
	at org.testcontainers.containers.ContainerState.copyFileToContainer(ContainerState.java:356)
	at org.testcontainers.containers.KafkaContainer.containerIsStarting(KafkaContainer.java:199)
	at org.testcontainers.containers.GenericContainer.containerIsStarting(GenericContainer.java:712)
	at org.testcontainers.containers.GenericContainer.tryStart(GenericContainer.java:489)
	at org.testcontainers.containers.GenericContainer.lambda$doStart$0(GenericContainer.java:354)
	at org.rnorth.ducttape.unreliables.Unreliables.retryUntilSuccess(Unreliables.java:81)
	at org.testcontainers.containers.GenericContainer.doStart(GenericContainer.java:344)
	at org.testcontainers.containers.GenericContainer.start(GenericContainer.java:330)
	at com.kotak.orchestrator.orchestrator.integration.config.ContainerConfig.kafkaContainer(ContainerConfig.java:37)
	at com.kotak.orchestrator.orchestrator.integration.testutils.KafkaTestBase.setUpBeforeClass(KafkaTestBase.java:25)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	Suppressed: java.lang.NoClassDefFoundError: org/apache/commons/lang3/ArrayFill
		at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.writeEOFRecord(TarArchiveOutputStream.java:677)
		at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.finish(TarArchiveOutputStream.java:421)
		at org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.close(TarArchiveOutputStream.java:303)
		at org.testcontainers.containers.ContainerState.copyFileToContainer(ContainerState.java:363)
		... 11 more
	Caused by: java.lang.ClassNotFoundException: org.apache.commons.lang3.ArrayFill
		... 15 more
Caused by: java.lang.ClassNotFoundException: org.apache.commons.lang3.ArrayFill
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526)
	... 14 more



package com.kotak.orchestrator.orchestrator.consumer;

import static com.kotak.orchestrator.orchestrator.integration.testutils.CommonUtils.byteBuffToStr;
import static com.kotak.orchestrator.orchestrator.testUtils.TestDataGenerator.generateDtdData;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

import com.kotak.orchestrator.orchestrator.integration.testutils.KafkaTestBase;
import com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler;
import com.kotak.orchestrator.orchestrator.schema.PlutusFinacleData;
import com.kotak.orchestrator.orchestrator.serializer.PlutusAvroDeserializer;
import com.kotak.orchestrator.orchestrator.serializer.PlutusAvroSerializerTest;
import com.kotak.orchestrator.orchestrator.serializer.PlutusFinacleDeserializer;
import com.kotak.orchestrator.orchestrator.serializer.PlutusFinacleSerializer;
import com.kotak.orchestrator.orchestrator.utils.MetricUtil;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.kafka.receiver.ReceiverRecord;

@Slf4j
public class GenericReactiveConsumerTest extends KafkaTestBase {

    private CbsDtdConsumerLite cbsDtdConsumerLite;

    @BeforeEach
    public void setUp() {
        this.cbsDtdConsumerLite = new CbsDtdConsumerLite();
    }

    @Test
    public void testOrderedProcessingOfConsecutiveAccounts() {

        try (var consumer = newConsumer()) {

            var event = generateDtdData();
            var offsets = publishMessages(event);

            await().atMost(Duration.ofSeconds(20)).until(() -> cbsDtdConsumerLite.totalMessages() >= 1);

            assertThat(cbsDtdConsumerLite.messages.get(0)).isEqualTo(event);

            event = generateDtdData();
            offsets = publishMessages(event);

            await().atMost(Duration.ofSeconds(20)).until(() -> cbsDtdConsumerLite.totalMessages() >= 2);

            assertThat(cbsDtdConsumerLite.messages.get(1)).isEqualTo(event);

            event = generateDtdData();
            offsets = publishMessages(event);

            await().atMost(Duration.ofSeconds(20)).until(() -> cbsDtdConsumerLite.totalMessages() >= 3);

            assertThat(cbsDtdConsumerLite.messages.get(2)).isEqualTo(event);
        }
    }

    private GenericReactiveConsumer<PlutusFinacleData> newConsumer() {
        var failureHandler = new DlqHandler<PlutusFinacleData>();
        var config = ConsumerConfiguration.<PlutusFinacleData>builder()
                .bootstrapServers(bootstrapServers)
                .topic(topic)
                .groupId(groupId)
                .valueDeserializer(PlutusFinacleDeserializer.class)
                .processor(cbsDtdConsumerLite)
                .maxPollRecords(10)
                .inMemoryPartitions(10)
                .processorThreadPoolName("ROS-Testing")
                .deferredCommitConfig(ConsumerConfiguration.DeferredCommitConfiguration.builder()
                        .commitIntervalMillis(3000L)
                        .commitBatchSize(5)
                        .maxDeferredCommits(5)
                        .build())
                .failureHandler(failureHandler)
                .dlqConfig(ConsumerConfiguration.DlqConfiguration.<PlutusFinacleData>builder()
                        .dlqTopic(dlq_topic)
                        .valueSerializer(PlutusFinacleSerializer.class)
                        .build())
                .build();
        var consumer = new GenericReactiveConsumer<>(config, new MetricUtil(new SimpleMeterRegistry()));
        consumer.start();
        return consumer;
    }

    private Map<Integer, Long> publishMessages(PlutusFinacleData message) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, PlutusAvroSerializerTest.class.getName());
        props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "1");
        props.put(ProducerConfig.ACKS_CONFIG, "1");
        var offsets = new ConcurrentHashMap<Integer, Long>();

        try (KafkaProducer<String, PlutusFinacleData> producer = new KafkaProducer<>(props)) {
            producer.send(message(message), ((metadata, exception) -> {
                if (exception == null) {
                    log.info("Received new metadata. \n" + "Topic:" + metadata.topic() + "\n" + "Partition: "
                            + metadata.partition() + "\n" + "Offset: " + metadata.offset() + "\n" + "Timestamp: "
                            + metadata.timestamp());
                    var currOffset = metadata.offset() + 1;
                    offsets.compute(metadata.partition(), (k, p) -> Math.max(p == null ? 0 : p, currOffset));
                }
            }));
            producer.flush();
        }
        await().atMost(Duration.ofSeconds(10));
        return offsets;
    }

    public ProducerRecord<String, PlutusFinacleData> message(PlutusFinacleData p) {
        return new ProducerRecord<>(topic, "key:value", p);
    }

    public static class CbsDtdConsumerLite implements MessageConsumer<PlutusFinacleData> {

        private final List<PlutusFinacleData> messages = Collections.synchronizedList(new ArrayList<>());

        @Override
        public void process(ReceiverRecord<String, PlutusFinacleData> message) {
            messages.add(message.value());
        }

        @Override
        public String partitionKey(PlutusFinacleData message) {
            try {
                return byteBuffToStr(message.toByteBuffer());
            } catch (Exception e) {
                return "";
            }
        }

        public int totalMessages() {
            return messages.size();
        }
    }

    public static class CbsDtdLiteDeserializer extends PlutusAvroDeserializer<PlutusFinacleData> {

        public CbsDtdLiteDeserializer() {
            super(PlutusFinacleData.class);
        }
    }
}



<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.kotak.orchestrator</groupId>
    <artifactId>orchestrator-service</artifactId>
    <version>0.0.1</version>
    <name>orchestrator-service</name>
    <description>orchestrator-service for plutus</description>
    <parent>
        <artifactId>spring-boot-starter-bom</artifactId>
        <groupId>com.kmbl.buildertools</groupId>
        <version>0.0.11</version>
    </parent>
    <properties>
        <!-- Maven Properties -->
        <parentVersion>0.0.1</parentVersion>
        <aws.sdk.version>2.22.9</aws.sdk.version>
        <!--<revision>${revision}</revision>-->
        <main.basedir>${project.basedir}</main.basedir>
        <java.version>21</java.version>
        <spring-cloud.version>2024.0.0</spring-cloud.version>
        <spring.version>6.2.1</spring.version>
        <jacoco.version>0.8.11</jacoco.version>
        <start-class>com.kotak.orchestrator.orchestrator.OrchestratorServiceApplication</start-class>
    </properties>
    <repositories>
        <repository>
            <id>DevOps-BuilderTools-Feed</id>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
            <url>https://pkgs.dev.azure.com/kmbl-devops/_packaging/DevOps-BuilderTools-Feed/maven/v1</url>
        </repository>
        <repository>
            <id>central</id>
            <url>https://repo.maven.apache.org/maven2</url>
        </repository>
        <repository>
            <id>plutus-application</id>
            <url>
                https://pkgs.dev.azure.com/kmbl-devops/9eeae0ff-87c8-44c3-a547-9f23496d21ad/_packaging/plutus-application/maven/v1
            </url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>

    </repositories>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>io.projectreactor</groupId>
                <artifactId>reactor-core</artifactId>
                <version>3.6.5</version>
            </dependency>
            <dependency>
                <groupId>commons-logging</groupId>
                <artifactId>commons-logging</artifactId>
                <version>1.2</version>
            </dependency>
            <dependency>
                <groupId>software.amazon.awssdk</groupId>
                <artifactId>bom</artifactId>
                <version>2.30.23</version> <!-- Match the version pulled by aws-msk-iam-auth -->
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka</artifactId>
        </dependency>

        <dependency>
            <groupId>io.lettuce</groupId>
            <artifactId>lettuce-core</artifactId>
        </dependency>


        <dependency>
            <groupId>io.projectreactor.kafka</groupId>
            <artifactId>reactor-kafka</artifactId>
            <version>1.3.23</version>
            <exclusions>
                <exclusion>
                    <groupId>org.apache.kafka</groupId>
                    <artifactId>kafka-clients</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-core</artifactId>
            <version>1.12.5</version>
        </dependency>

        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-core-micrometer</artifactId>
            <version>1.2.0</version>
        </dependency>


        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>software.amazon.msk</groupId>
            <artifactId>aws-msk-iam-auth</artifactId>
            <version>2.3.2</version>
            <exclusions>
                <exclusion>
                    <groupId>commons-logging</groupId>
                    <artifactId>commons-logging</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>software.amazon.awssdk</groupId>
            <artifactId>sdk-core</artifactId>
        </dependency>
        <dependency>
            <groupId>software.amazon.awssdk</groupId>
            <artifactId>auth</artifactId>
        </dependency>
        <dependency>
            <groupId>software.amazon.awssdk</groupId>
            <artifactId>sts</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>kafka</artifactId>
            <version>1.19.3</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <artifactId>spring-boot-starter-actuator</artifactId>
            <groupId>org.springframework.boot</groupId>
            <exclusions>
                <exclusion>
                    <groupId>com.fasterxml.jackson.core</groupId>
                    <artifactId>jackson-databind</artifactId>
                </exclusion>
            </exclusions>
        </dependency>


        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>commons-codec</groupId>
            <artifactId>commons-codec</artifactId>
            <version>1.16.1</version>
        </dependency>
        <dependency>
            <groupId>org.scala-lang</groupId>
            <artifactId>scala-library</artifactId>
            <version>2.13.11</version>
        </dependency>
        <dependency>
            <groupId>org.apache.avro</groupId>
            <artifactId>avro</artifactId>
            <version>1.12.0</version>
        </dependency>

        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-compress</artifactId>
            <version>1.26.2</version>
        </dependency>


        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-configuration2</artifactId>
            <version>2.10.1</version>
            <exclusions>
                <exclusion>
                    <groupId>commons-logging</groupId>
                    <artifactId>commons-logging</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.avro</groupId>
                <artifactId>avro-maven-plugin</artifactId>
                <version>1.8.2</version>
                <executions>
                    <execution>
                        <id>schemas</id>
                        <phase>generate-sources</phase>
                        <goals>
                            <goal>schema</goal>
                        </goals>
                        <configuration>
                            <sourceDirectory>${project.basedir}/src/main/resources/</sourceDirectory>
                            <outputDirectory>${project.basedir}/src/main/java/</outputDirectory>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>${jacoco.version}</version>
                <executions>
                    <execution>
                        <id>jacoco-initialize</id>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>jacoco-site</id>
                        <phase>package</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>check-coverage</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>check</goal>
                        </goals>
                        <configuration>
                            <rules>
                                <rule>
                                    <element>BUNDLE</element>
                                    <limits>
                                        <limit>
                                            <counter>LINE</counter>
                                            <value>COVEREDRATIO</value>
                                            <minimum>0.1</minimum>
                                        </limit>
                                        <!--<limit>
                                            <counter>BRANCH</counter>
                                            <value>COVEREDRATIO</value>
                                            <minimum>0.8</minimum>
                                        </limit>-->
                                    </limits>
                                </rule>
                            </rules>
                            <haltOnFailure>false</haltOnFailure>
                        </configuration>
                    </execution>
                </executions>
            </plugin>


        </plugins>
    </build>
    <distributionManagement>
        <repository>
            <id>DevOps-BuilderTools-Feed</id>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
            <url>https://pkgs.dev.azure.com/kmbl-devops/_packaging/DevOps-BuilderTools-Feed/maven/v1</url>
        </repository>

    </distributionManagement>
    <reporting>
        <plugins>
            <plugin>
                <artifactId>maven-project-info-reports-plugin</artifactId>
                <groupId>org.apache.maven.plugins</groupId>
                <reportSets>
                    <reportSet>
                        <reports>
                            <report>index</report>
                            <report>summary</report>
                            <report>licenses</report>
                            <report>dependency-info</report>
                            <report>dependencies</report>
                        </reports>
                    </reportSet>
                </reportSets>
            </plugin>
            <plugin>
                <artifactId>jacoco-maven-plugin</artifactId>
                <groupId>org.jacoco</groupId>
                <version>${jacoco.version}</version>
                <reportSets>
                    <reportSet>
                        <reports>
                            <report>report</report>
                        </reports>
                    </reportSet>
                </reportSets>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.2</version>
                <configuration>
                    <rerunFailingTestsCount>2</rerunFailingTestsCount>
                </configuration>
            </plugin>


            <plugin>
                <artifactId>maven-surefire-report-plugin</artifactId>
                <groupId>org.apache.maven.plugins</groupId>
                <version>${surefire.report.plugin.version}</version>
            </plugin>
            <plugin>
                <artifactId>maven-jxr-plugin</artifactId>
                <groupId>org.apache.maven.plugins</groupId>
                <reportSets>
                    <reportSet>
                        <id>aggregate</id>
                        <inherited>false</inherited>
                        <reports>
                            <report>aggregate</report>
                        </reports>
                    </reportSet>
                </reportSets>
                <version>${maven.jxr.plugin.version}</version>
            </plugin>
        </plugins>
    </reporting>
</project>
