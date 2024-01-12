package com.rominprojects.KafkaDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer implements ConsumerSeekAware {

	@KafkaListener(id = "Consumer1" , topics = "Topic1",groupId = "1")
	public void listenGroupFoo(String mssg)
	{
		System.out.println("Message : "+mssg);
	}
}
