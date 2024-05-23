package com.joongang.domain;

import java.util.Date;

import com.joongang.service.MqttPahoServiceImpl;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
public class IotVO {
	private Long rn;
	private Long no = 0L;
	private String humi = "";
	private String temp = "";
	private String fanA = "";
	private String fanB = "";
	private String red = "";
	private String green = "";
	private String blue = "";
	private Long currentTime = 0L;
	private Date date;
	
	public boolean equals(IotVO iot) {
		/*log.info("--------------equals------------");
		log.info("humi  [" + this.humi + "] [" + iot.getHumi() + "]   " + this.humi.equals(iot.getHumi()));
		log.info("temp  [" + this.temp + "] [" + iot.getTemp() + "]   "+ this.temp.equals(iot.getTemp()));
		log.info("fanA  [" + this.fanA + "] [" + iot.getFanA() + "]   "+ this.fanA.equals(iot.getFanA()));
		log.info("fanB  [" + this.fanB + "] [" + iot.getFanB() + "]   "+ this.fanB.equals(iot.getFanB()));
		log.info("red   [" + this.red + "] [" + iot.getRed() + "]   "+ this.red.equals(iot.getRed()));
		log.info("green [" + this.green + "] [" + iot.getGreen() + "]   "+ this.green.equals(iot.getGreen()));
		log.info("blue  [" + this.blue + "] [" + iot.getBlue() + "]   "+ this.blue.equals(iot.getBlue()));*/
		
		return ( this.getHumi().equals(iot.getHumi())
				&& this.getTemp().equals(iot.getTemp())
				&& this.getFanA().equals(iot.getFanA())
				&& this.getFanB().equals(iot.getFanB())
				&& this.getRed().equals(iot.getRed()) 
				&& this.getGreen().equals(iot.getGreen()) 
				&& this.getBlue().equals(iot.getBlue()) ) ? true : false;
	}
}