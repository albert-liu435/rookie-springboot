package com.rookie.bigdata.config;

import com.rookie.bigdata.listener.DefaultListenerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @Class RetryTemplateConfig
 * @Description
 * @Author rookie
 * @Date 2023/12/28 17:05
 * @Version 1.0
 */
@Configuration
public class RetryTemplateConfig {


    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(); //设置重试策略
        retryPolicy.setMaxAttempts(2);
        retryTemplate.setRetryPolicy(retryPolicy);


        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy(); //设置退避策略
        fixedBackOffPolicy.setBackOffPeriod(2000L);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        retryTemplate.registerListener(new DefaultListenerSupport()); //设置retryListener


        return retryTemplate;
    }
}
