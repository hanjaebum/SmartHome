package com.joongang.mapper;

import java.util.List;

import com.joongang.domain.Criteria;
import com.joongang.domain.IotVO;

public interface IotMapper {
	public List<IotVO> getList(Criteria criteria);
	
	public void insert(IotVO iot);

}
