package com.joongang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joongang.domain.Criteria;
import com.joongang.domain.SmartHomeVO;
import com.joongang.mapper.SmartHomeMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MqttServiceImpl implements MqttService {
//	@Autowired
//	private IotMapper mapper;
//	private IotVO tIot = new IotVO();
	
	@Autowired
	private SmartHomeMapper mapper;
	private SmartHomeVO tsh = new SmartHomeVO();
	
	@Override
	public void register(SmartHomeVO sh) {
		log.info("register...." + sh);
		if (!tsh.equals(sh)) {
			mapper.insert(sh);
			tsh.setRed(sh.getRed());
			tsh.setGreen(sh.getGreen());
			tsh.setBlue(sh.getBlue());
			tsh.setIrsensor(sh.getIrsensor());
			tsh.setTemsensor(sh.getTemsensor());
			tsh.setMotor(sh.getMotor());
			tsh.setFan(sh.getFan());
			tsh.setLcd(sh.getLcd());
			tsh.setHumidity(sh.getHumidity());
		}
	}
	
	@Override
	public List<SmartHomeVO> getList(Criteria criteria) {
		criteria.calOffset();
		return mapper.getList(criteria);
	}
	
	@Override
	public SmartHomeVO getSmartHomeState() {
		log.info("getSmartHomeState.....");
		if (tsh.getHumidity().equals("")) {
			tsh.setHumidity("7");
			tsh.setTemsensor("20");
			tsh.setFan("off");
			tsh.setIrsensor("off");
			tsh.setMotor("off");
			tsh.setLcd("hi");
			tsh.setRed("50");
			tsh.setGreen("50");
			tsh.setBlue("50");
		}
		return tsh;
	}
	
//	@Override
//	public void register(IotVO iot) {
//		log.info("register...." + iot);
//		if (!tIot.equals(iot)) {
//			mapper.insert(iot);
//			tIot.setHumi(iot.getHumi());
//			tIot.setTemp(iot.getTemp());
//			tIot.setFanA(iot.getFanA());
//			tIot.setFanB(iot.getFanB());
//			tIot.setRed(iot.getRed());
//			tIot.setGreen(iot.getGreen());
//			tIot.setBlue(iot.getBlue());
//		}
//	}
	
//	@Override
//	public IotVO getIotState() {
//		log.info("getIotState.....");
//		if (tIot.getHumi().equals("")) {
//			tIot.setHumi("7");
//			tIot.setTemp("20");
//			tIot.setFanA("off");
//			tIot.setFanB("off");
//			tIot.setRed("50");
//			tIot.setGreen("50");
//			tIot.setBlue("50");
//		}
//		return tIot;
//	}
//
//	@Override
//	public List<IotVO> getList(Criteria criteria) {
//		criteria.calOffset();
//		log.info("getList....." + criteria);
//		return mapper.getList(criteria);
//	}

}
