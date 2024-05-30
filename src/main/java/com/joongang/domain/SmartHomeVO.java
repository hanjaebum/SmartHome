package com.joongang.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SmartHomeVO {
	private Long rn;
	private Long id = 0L;
	private String red= "";
	private String green= "";
	private String blue= "";
	private String irsensor= "";
	private String temsensor= "";
	private String humidity= "";
	private String motor= "";
	private String fan= "";
	private String lcd= "";
	private Timestamp time;
	private Long currentTime = 0L;
	
	public String getFanState( ) {
		if(fan.equals("1")) {
			return "on";
		} else {
			return "off";
		}
	}
	
	public String getIrsensorState( ) {
		if(irsensor.equals("1")) {
			return "on";
		} else {
			return "off";
		}
	}
	
	public String getMotorState( ) {
		if(motor.equals("1")) {
			return "on";
		} else {
			return "off";
		}
	}
	
	public boolean equals(SmartHomeVO sh) {
		return ( this.getHumidity().equals(sh.getHumidity())
				&& this.getTemsensor().equals(sh.getTemsensor())
				&& this.getIrsensor().equals(sh.getIrsensor())
				&& this.getMotor().equals(sh.getMotor())
				&& this.getFan().equals(sh.getFan())
				&& this.getLcd().equals(sh.getLcd())
				&& this.getRed().equals(sh.getRed())
				&& this.getGreen().equals(sh.getGreen())
				&& this.getBlue().equals(sh.getBlue()) ) ? true : false;
		
		
		
	}
}

