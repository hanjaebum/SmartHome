package com.joongang.mapper;

import java.util.List;

import com.joongang.domain.Criteria;
import com.joongang.domain.IotVO;

public interface TestMapper {
	public List<IotVO> getList(Criteria criteria);
	
	
}
