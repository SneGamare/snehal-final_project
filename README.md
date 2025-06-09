package com.kotak.orchestrator.orchestrator.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

import java.io.IOException;
import java.util.Map;

public class AwsSecretsUtil {

    public static Map<String, String> getSecret(String secretName, String regionName) {
        try (SecretsManagerClient client = SecretsManagerClient.builder()
                .region(Region.of(regionName))
                .build()) {

            GetSecretValueRequest request = GetSecretValueRequest.builder()
                    .secretId(secretName)
                    .build();

            GetSecretValueResponse response = client.getSecretValue(request);
            String secretString = response.secretString();

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(secretString, new TypeReference<>() {});
        } catch (SecretsManagerException e) {
            System.err.println("AWS SecretsManager error: " + e.awsErrorDetails().errorMessage());
            throw new RuntimeException("Failed to retrieve secret from AWS", e);
        } catch (IOException e) {
            System.err.println("Error parsing secret JSON: " + e.getMessage());
            throw new RuntimeException("Failed to parse secret JSON", e);
        }
    }
}



package com.kotak.orchestrator.orchestrator.config;

import com.kotak.orchestrator.orchestrator.util.AwsSecretsUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class SecretsManagerConfig {

    @Value("${aws.secret.name}")
    private String secretName;

    @Value("${aws.region}")
    private String region;

    @Bean(name = "dbSecrets")
    public Map<String, String> dbSecrets() {
        return AwsSecretsUtil.getSecret(secretName, region);
    }
}


package com.kotak.orchestrator.orchestrator.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(@Qualifier("dbSecrets") Map<String, String> secrets) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://plutus-rds-aurora-postgres-dev.cluster-cnmg44oeipzz.ap-south-1.rds.amazonaws.com:5433/plutusdb_dev");
        config.setUsername(secrets.get("db_postgres_username"));
        config.setPassword(secrets.get("db_postgres_password"));
        config.setDriverClassName("org.postgresql.Driver");
        return new HikariDataSource(config);
    }
}
