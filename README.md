[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (default-compile) on project orchestrator-service: Compilation failure
[ERROR] /home/vsts/work/1/s/src/main/java/com/kotak/orchestrator/orchestrator/config/PlutusDtdConsumerConfig.java:[35,16] constructor PlutusDtdBusinessEventConsumer in class com.kotak.orchestrator.orchestrator.consumer.PlutusDtdBusinessEventConsumer cannot be applied to given types;
[ERROR]   required: com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository,com.kotak.orchestrator.orchestrator.service.ClientConfigCacheService,com.fasterxml.jackson.databind.ObjectMapper
[ERROR]   found:    com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository,com.kotak.orchestrator.orchestrator.service.ClientConfigCacheService
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR] 
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
