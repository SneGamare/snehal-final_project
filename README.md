[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project orchestrator-service: Compilation failure: Compilation failure: 
[ERROR] Source option 5 is no longer supported. Use 8 or later.
[ERROR] Target option 5 is no longer supported. Use 8 or later.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException




<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.kotak.orchestrator</groupId>
    <artifactId>orchestrator-service</artifactId>
    <version>0.0.1</version>
    <name>orchestrator-service</name>
    <description>Orchestrator service for Plutus</description>

    <properties>
        <java.version>21</java.version>
        <spring-boot.version>3.2.5</spring-boot.version>
        <commons-lang3.version>3.13.0</commons-lang3.version>
        <testcontainers.version>1.19.7</testcontainers.version>
        <micrometer.version>1.12.5</micrometer.version>
        <reactor-kafka.version>1.3.23</reactor-kafka.version>
        <reactor-core.version>3.6.5</reactor-core.version>
        <jacoco.version>0.8.11</jacoco.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <!-- Spring Boot -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>


        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka</artifactId>
        </dependency>

        <!-- Reactor Kafka -->
        <dependency>
            <groupId>io.projectreactor.kafka</groupId>
            <artifactId>reactor-kafka</artifactId>
            <version>${reactor-kafka.version}</version>
        </dependency>

        <!-- Micrometer -->
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-core</artifactId>
            <version>${micrometer.version}</version>
        </dependency>
        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-core-micrometer</artifactId>
            <version>1.2.0</version>
        </dependency>

        <!-- Apache Commons Lang (fix for ArrayFill) -->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>${commons-lang3.version}</version>
        </dependency>

        <!-- Testcontainers for Kafka -->
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>${testcontainers.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>kafka</artifactId>
            <version>${testcontainers.version}</version>
            <scope>test</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.awaitility</groupId>
            <artifactId>awaitility</artifactId>
            <version>4.2.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.assertj</groupId>
            <artifactId>assertj-core</artifactId>
            <version>3.25.3</version>
            <scope>test</scope>
        </dependency>

        <!-- Avro -->
        <dependency>
            <groupId>org.apache.avro</groupId>
            <artifactId>avro</artifactId>
            <version>1.11.3</version>
        </dependency>

        <!-- Serialization -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
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
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                        <source>17</source>
                        <target>17</target>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>1.18.36</version>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
                <groupId>org.apache.maven.plugins</groupId>
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
