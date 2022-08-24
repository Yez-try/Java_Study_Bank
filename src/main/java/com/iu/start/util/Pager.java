package com.iu.start.util;

public class Pager {
	
	//멤버변수
	//파라미터를 담을 변수
	private Long page; //현재 페이지, 파라미터로 받음
	//jsp에서 꺼내서 사용할 변수
	private Long startNum;
	private Long lastNum;
	private Long totalPage; //전체 페이지, getNum에서 계산함
	//Mapper에서 꺼내서 사용할 변수
	private Long startRow;
	private Long lastRow;
	
	private Long perPage; //한 페이지에 출력할 글의 개수
	private Long perBlock; //한 페이지에 출력할 번호의 갯수
	
	public Pager() {
		this.perPage= 15L;
		this.perBlock = 10L;
	}
	//  1.mapper에서 사용할 값 (가져올 행의 범위) 계산
	public void getRowNum()throws Exception{
	    this.startRow = (this.getPage()-1)*this.perPage+1;
	    this.lastRow = this.getPage()*this.perPage;
	}
	
	// 2. jsp에서 사용 할 값 게산
    public void getNum(Long totalCount)throws Exception{
      //2. totalCount로 totalPage구하기 (전체 페이지수)
       this.totalPage = ((totalCount-1)/this.perPage+1);
    		  
    		  
//	    3. totalPage로 totalBlock 구하기
       Long totalBlock = ((totalPage-1)/perBlock+1);
      
   //   4. page로 curBlock찾기 (현재 블록번호를 찾기, 이걸로 나중에 jsp에서 쓸 숫자를 계산)
       Long curBlock = (this.getPage()-1)/perBlock+1;
      
      //5.curBlock으로 startNum ,lastNum 구하기
       this.startNum = (curBlock -1)*this.getPerBlock()+1;
       
       this.lastNum = curBlock*this.getPerBlock();
       if(lastNum>totalPage) {
    	   this.lastNum = this.totalPage;
       }
      
    }

	
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
	
	
	public Long getPerBlock() {
		return perBlock;
	}
	
	
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
}
