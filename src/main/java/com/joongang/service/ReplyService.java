package com.joongang.service;

import java.util.List;

import com.joongang.domain.Criteria;
import com.joongang.domain.ReplyPageDTO;
import com.joongang.domain.ReplyVO;

public interface ReplyService {

	public int register (ReplyVO reply);
	
	public ReplyVO get(Long rno);
	
	public int remove(Long rno);
	
	public int modify(ReplyVO reply);
	
	public List<ReplyVO> getList(Criteria criteria, Long bno);
	
	public ReplyPageDTO getListPage(Criteria criteria, Long bno);
	
}
