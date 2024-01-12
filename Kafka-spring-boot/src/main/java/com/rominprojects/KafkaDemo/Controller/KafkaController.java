package com.rominprojects.KafkaDemo.Controller;

import com.rominprojects.KafkaDemo.service.KafkaPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api")
public class KafkaController {

	@Autowired
    KafkaPublisher kafkaPublisher;


    @GetMapping(value = "/producer")
    public String sendMessage(@RequestParam("message") String message)
    {
        kafkaPublisher.sendMessage(message);
        return "Message sent Successfully to the your code decode topic ";
    }
	
}
