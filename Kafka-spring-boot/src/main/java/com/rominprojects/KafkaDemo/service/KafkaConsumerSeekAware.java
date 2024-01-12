package com.rominprojects.KafkaDemo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AbstractConsumerSeekAware;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerSeekAware extends AbstractConsumerSeekAware {

    Boolean reset = Boolean.TRUE;

    @KafkaListener(id = "Consumer2", topics = "Topic1", concurrency = "3" , groupId = "2")
    public void listen(String payload) {
        System.out.println("Listener received: " + payload);
        if(this.reset) {
            this.reset = Boolean.FALSE;
            seekToStart();
        }
    }

    public void seekToStart() {
        getSeekCallbacks().forEach((tp, callback) -> callback.seekToBeginning(tp.topic(), tp.partition()));
    }
}

