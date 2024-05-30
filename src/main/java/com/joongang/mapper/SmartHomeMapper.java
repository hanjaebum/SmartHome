package com.joongang.mapper;

import java.util.List;

import com.joongang.domain.Criteria;
import com.joongang.domain.SmartHomeVO;

public interface SmartHomeMapper {
	public void insert(SmartHomeVO sh);
	public List<SmartHomeVO> getList(Criteria criteria);
}
