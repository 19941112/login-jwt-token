package com.java.login.jwt.controller;


import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.login.jwt.bo.ResponseData;
import com.java.login.jwt.kafka.producer.KafkaProducer;


@RestController
@RequestMapping("/kafka")
public class KafkaController {

private KafkaProducer producer;
	
    public KafkaController(KafkaProducer producer) {
		this.producer = producer;
	}

	@PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody ResponseData inputData) {
        try {
			this.producer.sendMessage(inputData);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
    }
}
