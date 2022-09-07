package com.iu.start.util;

public class CommentPager {
	
	//멤버변수
	//내가 정하는 변수
	private Long perPage; //한 페이지에 출력할 글의 개수
	//파라미터를 담을 변수
	private Long page; //현재 페이지, 파라미터로 받음
	//jsp에서 꺼내서 사용할 변수
	private Long startNum;
	private Long lastNum;
	private Long totalPage; //전체 페이지, getPageBlock에서 계산함
	//Mapper에서 꺼내서 사용할 변수
	private Long startRow;
	private Long lastRow;
	
	//북넘 값 받기
	private Long booknum;
	
	
	public CommentPager() {
		this.perPage= 5L;
	}
	
	
	public void calNum(Long totalCount) throws Exception{
		
		//jsp에서 사용할 값. totalCount로 totalPage구하기 (전체 페이지수)
	    this.totalPage = ((totalCount-1)/this.getPerPage()+1);
		
		//totalPage보다 파라미터page가 더 클 경우
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}
		
		this.getRow();
	}
	
	//  1.mapper에서 사용할 값 (가져올 행의 범위) 계산
	public void getRow()throws Exception{
	    this.startRow = (this.getPage()-1)*this.getPerPage()+1;
	    this.lastRow = this.getPage()*this.getPerPage();
	}
    
	//getter, setter 영역
	public Long getPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getPerPage() {
		return perPage;
	}	
	
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}


	public Long getBooknum() {
		if(this.booknum == null) {
			this.booknum = 0L;
		}
		
		return booknum;
	}


	public void setBooknum(Long booknum) {
		this.booknum = booknum;
	}


}
