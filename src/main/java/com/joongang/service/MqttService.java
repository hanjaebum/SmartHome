package com.joongang.service;

import java.util.List;

import com.joongang.domain.Criteria;
import com.joongang.domain.IotVO;

public interface MqttService {
	public void register(IotVO iot);
	public IotVO getIotState();
	public List<IotVO> getList(Criteria criteria);
}
