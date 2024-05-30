package com.joongang.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.paho.client.mqttv3.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.joongang.domain.SmartHomeVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class MqttPahoServiceImpl implements MqttPahoService {
	
	@Autowired
	private MqttPahoMessageHandler mqttOutboundHandler;
	
	@Autowired
	private MqttPahoMessageDrivenChannelAdapter mqttInboundAdapter;
	
	@Autowired
	private MqttService mqttService;
	
		
//	private Long currentTime = 0L;
//	private IotVO iot = new IotVO();
	
	private Long currentTime = 0L;
	private SmartHomeVO sh = new SmartHomeVO();

	// Publish msg to target topic
	public void publishMsg(String msgContent, String targetTopic) {
		log.info("Sending msg "+ msgContent +" to targetTopic "+targetTopic);
		Message<String> message = MessageBuilder.withPayload(msgContent).setHeader(MqttHeaders.TOPIC, targetTopic).build();  
		mqttOutboundHandler.handleMessage(message);  
	}

	// Subscribe Message handler
	public void handleSubscribeTopicMsg(Message message) {	
		log.info("Incoming Msg from topic --" + message.getHeaders().get("mqtt_receivedTopic"));
		String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
		String msgContent = message.getPayload().toString();
		log.info("Incoming msg content --" + msgContent);
		
		if (Strings.isEmpty(msgContent)) {
		return;
		}
		
		String[] buf = msgContent.split("/");
		List<String> list = Arrays.stream(buf).map(array -> array.trim()).collect(Collectors.toList());
		log.info(list);
		sh.setFan(list.get(7));
		sh.setRed(list.get(9));
		sh.setGreen(list.get(10));
		sh.setBlue(list.get(11));
		sh.setIrsensor(list.get(15));
		sh.setTemsensor(list.get(1));
		sh.setHumidity(list.get(3));
		sh.setMotor(list.get(5));
		sh.setLcd(list.get(13));
		mqttService.register(sh);
		
		if (Strings.isEmpty(msgContent)) {
			return;
		}
		
		boolean msgReceived = false;
		currentTime = System.currentTimeMillis();
		if (sh.getCurrentTime() == 0L) {
			sh.setCurrentTime(currentTime);
		}
		if ((currentTime - sh.getCurrentTime()) > 1000) {
			// new msg's coming...
			msgReceived = true;
			sh.setCurrentTime(currentTime);
		}
		
		
//		if (Strings.isEmpty(msgContent)) {
//			return;
//		}
//		
//		boolean msgReceived = false;
//		currentTime = System.currentTimeMillis();
//		if (iot.getCurrentTime() == 0L) {
//			iot.setCurrentTime(currentTime);
//		}
//		if ((currentTime - iot.getCurrentTime()) > 1000) {
//			// new msg's coming...
//			msgReceived = true;
//			iot.setCurrentTime(currentTime);
//		}
//		
//		String[] buf = msgContent.split("/");
//		List<String> list = Arrays.stream(buf).map(array -> array.trim()).collect(Collectors.toList());
//		
//		if (msgContent.startsWith("led")) {
//			iot.setRed(list.get(1));
//			iot.setGreen(list.get(2));
//			iot.setBlue(list.get(3));
//		} else if (msgContent.startsWith("f_a")) {
//			iot.setFanA(list.get(1));
//			iot.setFanB(list.get(3));
//		} else if (msgContent.startsWith("h")) {
//			iot.setHumi(list.get(1).equals("NAN") ? "-" : list.get(1));
//			iot.setTemp(list.get(3).equals("NAN") ? "-" : list.get(3));
//		}
//		if (msgReceived) {
//			mqttService.register(iot);
//		}	
	}
}
