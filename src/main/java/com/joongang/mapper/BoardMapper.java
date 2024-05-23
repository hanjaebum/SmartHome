package com.joongang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.joongang.domain.BoardVO;
import com.joongang.domain.Criteria;

public interface BoardMapper {
	
	public int getTotalCount(Criteria criteria);

	//	@Select("select * from tbl_board where bno >0")
	public List<BoardVO> getList();

	public void insert(BoardVO board);

	public Integer update(BoardVO board);

	public Integer delete(Long bno);
	
	public BoardVO read(Long bno);
	
	public List<BoardVO> getListWithPaging(Criteria criteria);
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
}
