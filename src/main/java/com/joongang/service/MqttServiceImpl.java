package com.joongang.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joongang.domain.Criteria;
import com.joongang.domain.IotVO;
import com.joongang.mapper.IotMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MqttServiceImpl implements MqttService {
	@Autowired
	private IotMapper mapper;
	private IotVO tIot = new IotVO();
	
	@Override
	public void register(IotVO iot) {
		log.info("register...." + iot);
		if (!tIot.equals(iot)) {
			mapper.insert(iot);
			tIot.setHumi(iot.getHumi());
			tIot.setTemp(iot.getTemp());
			tIot.setFanA(iot.getFanA());
			tIot.setFanB(iot.getFanB());
			tIot.setRed(iot.getRed());
			tIot.setGreen(iot.getGreen());
			tIot.setBlue(iot.getBlue());
		}
	}
	
	@Override
	public IotVO getIotState() {
		log.info("getIotState.....");
		if (tIot.getHumi().equals("")) {
			tIot.setHumi("7");
			tIot.setTemp("20");
			tIot.setFanA("off");
			tIot.setFanB("off");
			tIot.setRed("50");
			tIot.setGreen("50");
			tIot.setBlue("50");
		}
		return tIot;
	}

	@Override
	public List<IotVO> getList(Criteria criteria) {
		criteria.calOffset();
		log.info("getList....." + criteria);
		return mapper.getList(criteria);
	}

}
