spring.application.name=smartmessageprocessor

server.port=8082
logging.level.root=INFO

# Kafka Configuration
spring.kafka.bootstrap-servers=localhost:9092

# Consumer Configuration
spring.kafka.consumer.group-id=smp-group
spring.kafka.consumer.auto-offset-reset=earliest


spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=com.kotak.smartmessageprocessorservice.smartmessageprocessor.serializer.PlutusFinacleDeserializer
spring.kafka.consumer.enable-auto-commit=true
spring.kafka.consumer.fetch-min-size=1024
spring.kafka.consumer.max-poll-records=500
spring.kafka.consumer.metrics.enabled=true
spring.kafka.consumer.topic=dtd-business-event

## Producer Configuration json
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
#spring.kafka.producer.topic=dtd_business_event

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
