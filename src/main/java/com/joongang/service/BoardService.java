package com.joongang.service;

import java.util.List;

import com.joongang.domain.BoardAttachVO;
import com.joongang.domain.BoardVO;
import com.joongang.domain.Criteria;

public interface BoardService {

	public int getTotalCount(Criteria criteria);

	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	public List<BoardVO> getList();
	
	public List<BoardVO> getList(Criteria criteria);
	
	public List<BoardAttachVO> getAttachList(Long bno);
}
