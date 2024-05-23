package com.joongang.domain;

import lombok.Data;

@Data
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int total;
	private Criteria criteria;
	
	
	public PageDTO(int total, Criteria criteria) {
		this.total = total;
		this.criteria = criteria;	
		/* 마지막 페이지*/
		this.endPage = (int) (Math.ceil(criteria.getPageNum()/10.0))*10;
		
		/* 시작 페이지*/
		this.startPage = this.endPage-9;
		
		
		int realEnd = (int) Math.ceil(total*1.0/criteria.getAmount());
//		int realEnd = total/criteria.getAmount();
//		realEnd = total%getAmount()==0? realEnd : realEnd+1;
		
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		
		this.prev = this.startPage>1;   
		this.next = this.endPage < realEnd;
	}
	
	
}
