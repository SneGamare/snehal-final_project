log.info("DLQ config - topic: {}, serializer: {}, bootstrapServers: {}, securityProtocol: {}",
        dlqConfig.getDlqTopic(),
        dlqConfig.getValueSerializer(),
        dlqConfig.getBootstrapServers(),
        securityProtocol
);
