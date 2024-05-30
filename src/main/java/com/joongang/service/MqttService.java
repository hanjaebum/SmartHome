package com.joongang.service;

import java.util.List;

import com.joongang.domain.Criteria;
import com.joongang.domain.SmartHomeVO;

public interface MqttService {
	public void register(SmartHomeVO sh);
	public List<SmartHomeVO> getList(Criteria criteria);
	public SmartHomeVO getSmartHomeState();
//	public void register(IotVO iot);
//	public IotVO getIotState();
//	public List<IotVO> getList(Criteria criteria);
}
