package com.spring.cloud.hashmap.broker.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(CloudConnectorConfig.class)
@EnableJpaRepositories
@ComponentScan("com.spring.cloud")
public class SpringCloudHashmapBrokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHashmapBrokerApplication.class, args);
	}
}
