package com.kotak.orchestrator.orchestrator.config;

import com.kotak.orchestrator.orchestrator.consumer.ConsumerConfiguration;
import com.kotak.orchestrator.orchestrator.consumer.GenericReactiveConsumer;
import com.kotak.orchestrator.orchestrator.consumer.PlutusDtdBusinessEventConsumer;
import com.kotak.orchestrator.orchestrator.failurehandler.DlqHandler;
import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.orchestrator.orchestrator.schema.DtdGamBusinessEvent;
import com.kotak.orchestrator.orchestrator.utils.MetricUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlutusDtdConsumerConfig {

    private final PlutusFinacleDataRepository repository;

    public PlutusDtdConsumerConfig(PlutusFinacleDataRepository repository) {
        this.repository = repository;
    }

    @Bean
    public PlutusDtdBusinessEventConsumer plutusDtdBusinessEventConsumer() {
        return new PlutusDtdBusinessEventConsumer(repository);
    }

    @Bean
    @ConfigurationProperties(prefix = "dtd-gam-topic.kafka.consumer")
    @Qualifier("plutusDtdEventConfig")
    public ConsumerConfiguration<DtdGamBusinessEvent> plutusDtdEventConfig(
            PlutusDtdBusinessEventConsumer consumer, DlqHandler<DtdGamBusinessEvent> failureHandler) {
        return ConsumerConfiguration.<DtdGamBusinessEvent>builder().processor(consumer)
                .failureHandler(failureHandler).build();
    }

    @Bean
    @Qualifier("plutusDtdConsumer")
    public GenericReactiveConsumer<DtdGamBusinessEvent> plutusDtdConsumer(
            @Qualifier("plutusDtdEventConfig") ConsumerConfiguration<DtdGamBusinessEvent> config,
            MetricUtil metricUtil) {
        System.out.println("Config: " + config);
        System.out.println("MetricUtil: " + metricUtil);
        var consumer = new GenericReactiveConsumer<>(config, metricUtil);
        consumer.start();
        return consumer;
    }
}




 public java.lang.CharSequence getTRANDATE() {
    return TRAN_DATE;
  } this is generated from avro 

so here also keep this only entity.setTran_date(data.getTRANDATE());


and entity also we need to update accordingly   private String tran_date;
