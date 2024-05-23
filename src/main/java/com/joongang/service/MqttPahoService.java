package com.joongang.service;

import org.springframework.messaging.Message;

public interface MqttPahoService {
	
	// Publish a message to a target mqtt topic
	public void publishMsg(String msgContent,String targetTopic);
	
	// Handle a incoming message
	public void handleSubscribeTopicMsg(Message message);

}

