package com.spring.cloud.hashmap.broker.init;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 
 * @author aditya.gupta2
 *
 */

//Configuration for all cloud related

@Configuration
public class CloudConnectorConfig {
	

    @Bean
    @ConditionalOnMissingBean
    public Cloud cloud() {
        return new CloudFactory().getCloud();
    }

}
