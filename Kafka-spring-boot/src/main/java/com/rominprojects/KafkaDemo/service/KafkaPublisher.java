package com.rominprojects.KafkaDemo.service;

import com.rominprojects.KafkaDemo.configuration.KafkaTopicConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaPublisher {

	@Autowired
	KafkaTopicConfig kafkaTopicConfig;

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;

	public void sendMessage(String msg)
	{
		ListenableFuture<SendResult<String,String>> future = kafkaTemplate.
				send(
						kafkaTopicConfig.topic().name(),
						msg
				);

		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onFailure(Throwable ex) {
				System.out.println("Unable to send message ERROR : "+ex.getMessage());
			}

			@Override
			public void onSuccess(SendResult<String, String> result) {
				System.out.println("Sent message=[" + msg +
						"] with offset=[" + result.getRecordMetadata().offset() + "]");
			}
		});
	}
}
