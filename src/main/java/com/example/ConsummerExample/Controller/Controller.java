package com.example.ConsummerExample.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	List<String> messages = new ArrayList<>();
	
	@GetMapping("/consumeStringMessage")
	public List<String> consumeMsg() {
		return messages;
	}
	
	@KafkaListener(groupId = "TwoListeners", topics = "topic")
//	topicPartitions = @TopicPartition(topic = "topic", partitions = {"0"})
	public List<String> getMsgFromTopic(String data) {
		messages.add(data);
		return messages;
	}
}
