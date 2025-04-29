logging.level.root=INFO 

# Kafka Configuration
spring.kafka.bootstrap-servers=b-1.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9092,b-2.mskplutusdev01.n5cllq.c2.kafka.ap-south-1.amazonaws.com:9092

# Consumer Configuration
spring.kafka.consumer.group-id=plutus-finacle-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=com.kotak.orchestrator.orchestrator.serializer.PlutusFinacleDeserializer
spring.kafka.consumer.enable-auto-commit=true
spring.kafka.consumer.fetch-min-size=1024
spring.kafka.consumer.max-poll-records=500
spring.kafka.consumer.metrics.enabled=true
spring.kafka.consumer.topic=dtd-business-event

# Producer Configuration
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=com.kotak.orchestrator.orchestrator.serializer.PlutusFinacleSerializer
spring.kafka.producer.topic=dtd-business-event

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.sql.init.schema-locations=classpath:schema.sql

## Enable IAM-based authentication
#spring.kafka.properties.sasl.mechanism=AWS_MSK_IAM
#spring.kafka.properties.sasl.jaas.config=software.amazon.msk.auth.iam.IAMLoginModule required;
#spring.kafka.properties.sasl.client.callback.handler.class=software.amazon.msk.auth.iam.IAMClientCallbackHandler
#
## Management Endpoints
#management.endpoints.web.exposure.include=health,info,prometheus,integrationgraph,metrics
#management.endpoints.enabled-by-default=true
#management.endpoints.web.base-path=/
#server.servlet.context-path=/api/plutus-consumer






b-2.mskplutusuat01.y79307.c2.kafka.ap-south-1.amazonaws.com:9098,b-1.mskplutusuat01.y79307.c2.kafka.ap-south-1.amazonaws.com:9098

logging.level.org.apache.kafka=DEBUG
logging.level.org.apache.kafka.clients=DEBUG

