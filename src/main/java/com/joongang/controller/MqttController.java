package com.joongang.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joongang.domain.Criteria;
import com.joongang.domain.IotVO;
import com.joongang.service.MqttPahoService;
import com.joongang.service.MqttService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/mqtt/*")
@AllArgsConstructor
public class MqttController {
	
	private MqttService service;
	
	private MqttPahoService pahoService;
	
	private static final String inTopic = "inTopic";
	
	@GetMapping("/main")
	public void main(Model model) {
	}
	
	@GetMapping(value = "/pubish", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> publish(@RequestParam("arr0")String arr0, @RequestParam("arr1")String arr1,
			@RequestParam("arr2")String arr2, @RequestParam("arr3")String arr3) {
		log.info("publish.................");
		String msg = "";
		if (!StringUtils.hasText(arr2) && !StringUtils.hasText(arr3)) {
			msg = String.join("/", arr0, arr1);
		} else {
			msg = String.join("/", arr0, arr1, arr2, arr3); //   led/arr0/arr1/aa2
		}
		pahoService.publishMsg(msg, inTopic);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@GetMapping(value = "/getIotState", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IotVO> getIotState() {
		log.info("/getIotState");
		return new ResponseEntity<>(service.getIotState(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/list", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<IotVO>> getMainPageList() {
		log.info("getMainPageList.................");
		Criteria criteria = new Criteria(1, 10);
		log.info(criteria);
		return new ResponseEntity<>(service.getList(criteria), HttpStatus.OK);
	}

}
