package com.java.login.jwt.kafka.producer;


import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.java.login.jwt.bo.ResponseData;

@Service
public class KafkaProducer {
	

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, ResponseData> kafkaTemplate;
    
    public KafkaProducer(KafkaTemplate<String, ResponseData> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(ResponseData inputData) throws InterruptedException, ExecutionException{
    		LOGGER.info(String.format("Message sent"));
    		Message<ResponseData> message = MessageBuilder.withPayload(inputData)
    				.setHeader(KafkaHeaders.TOPIC, "userfeed")
    				.build();
            ListenableFuture<SendResult<String, ResponseData>> result = kafkaTemplate.send(message);
            RecordMetadata data = result.get().getRecordMetadata();
            System.out.println("Produced Data Details:"+ data.partition()+ " "+ data.offset());
        
    }

}
