{"kongcertkey-uat":"test","db_postgres_username":"plutus_app_user_dev","db_postgres_password":"Plutus@123"}



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


@Configuration
public class SecretsManagerConfig {

    @Value("${aws.secret.name}")
    private String secretName;

    @Value("${aws.region}")
    private String region;

    @Bean
    public Map<String, String> dbSecrets() throws IOException {
        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(Region.of(region))
                .build();

        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        GetSecretValueResponse getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
        String secretString = getSecretValueResponse.secretString();

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> secrets = mapper.readValue(secretString, new TypeReference<Map<String, String>>() {});

        System.out.println("DB Username: " + secrets.get("db_postgres_username"));

        return secrets;
    }

}
