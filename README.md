package com.kotak.orchestrator.orchestrator;

import com.kotak.orchestrator.orchestrator.config.PlutusDtdConsumerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Import({PlutusDtdConsumerConfig.class})
class OrchestratorServiceApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoadsSuccessfully() {
        assertThat(applicationContext).isNotNull();
    }

    @Test
    void plutusDtdConsumerConfigBeanShouldBeLoaded() {
        boolean beanExists = applicationContext.containsBeanDefinition("plutusDtdConsumerConfig");
        assertThat(beanExists).isTrue();
    }
}
