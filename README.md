SELECT * 
FROM information_schema.tables 
WHERE table_schema = 'plutus_ecollection' 
  AND table_name = 'plutus_finacle_transaction_details';




ALTER TABLE public.plutus_finacle_transaction_details
SET SCHEMA plutus_ecollection;



GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO your_user;


CREATE ROLE app_user WITH LOGIN PASSWORD 'your_password';
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO app_user;




-- Create the user if not already present
CREATE ROLE plutus_app_user WITH LOGIN PASSWORD 'your_password';

-- Grant access to the schema and tables
GRANT USAGE ON SCHEMA plutus_ecollection TO plutus_app_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO plutus_app_user;



logging.level.root=info

#dtd consumer config
spring.kafka.consumer.bootstrap-servers=b-1.uatrosmsk.x7g3kf.c4.kafka.ap-south-1.amazonaws.com:9098,b-2.uatrosmsk.x7g3kf.c4.kafka.ap-south-1.amazonaws.com:9098
spring.kafka.consumer.group-id=plutus-dtd-consumer-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=com.kotak.orchestrator.orchestrator.serializer.PlutusDtdDeserializer
spring.kafka.consumer.enable-auto-commit=true
spring.kafka.consumer.fetch-min-size=1024
spring.kafka.consumer.max-poll-records=500
spring.kafka.consumer.metrics.enabled=true
spring.kafka.consumer.topic=dtd-gam-business-event
spring.kafka.consumer.security-protocol=AWS_MSK_IAM
spring.kafka.consumer.processor-thread-pool-name=plutus_application
spring.kafka.consumer.aws-role-arn=arn:aws:iam::381492193153:role/role-plutus-kafka-ingestor-cross-acc-uat
spring.kafka.consumer.aws-sts-session-name=plutus-kafka-dev-session
spring.kafka.consumer.aws-sts-region=ap-south-1

# Producer Configuration
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=com.kotak.orchestrator.orchestrator.serializer.PlutusFinacleSerializer
spring.kafka.producer.topic=dtd-business-event

# PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://plutus-rds-aurora-postgres-dev.cluster-cnmg44oeipzz.ap-south-1.rds.amazonaws.com:5433/plutusdb_dev
spring.datasource.username=plutus_app_user_dev
spring.datasource.password=Plutus@123
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.sql.init.schema-locations=classpath:schema.sql

