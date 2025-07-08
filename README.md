if ("SASL_SSL".equalsIgnoreCase(securityProtocol)) {
    props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
    props.put(SaslConfigs.SASL_MECHANISM, "SCRAM-SHA-512");
    props.put(SaslConfigs.SASL_JAAS_CONFIG,
        "org.apache.kafka.common.security.scram.ScramLoginModule required username=\""
        + saslScramUsername + "\" password=\"" + saslScramPassword + "\";");
} else if ("AWS_MSK_IAM".equalsIgnoreCase(securityProtocol)) {
    props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
    props.put(SaslConfigs.SASL_MECHANISM, "AWS_MSK_IAM");
    props.put("sasl.client.callback.handler.class", "software.amazon.msk.auth.iam.IAMClientCallbackHandler");
    props.put("aws.msk.iam.role.arn", awsRoleArn);
    props.put("aws.msk.iam.session.name", awsStsSessionName);
    props.put("aws.msk.iam.region", awsStsRegion);
} else if ("PLAINTEXT".equalsIgnoreCase(securityProtocol)) {
    props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "PLAINTEXT");
}
