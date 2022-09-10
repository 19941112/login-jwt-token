package com.java.login.jwt.kafka.producer;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
	
	@Bean
    public NewTopic myFirstTopic(){
        return TopicBuilder.name("userfeed")
        		.partitions(10)
                .build();
    }

}
