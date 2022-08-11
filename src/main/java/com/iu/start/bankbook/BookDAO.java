package com.iu.start.bankbook;

import java.util.ArrayList;

public interface BookDAO {
	
	public int setUpdate(BankBookDTO dto) throws Exception;
	
	public int setBankBook(BankBookDTO bankBookDTO)throws Exception;
	//북넘: 현재시간을 밀리세컨즈로 변환하여 입력
	//북세일: 1 -판매
	
	public ArrayList<BankBookDTO> getList()throws Exception;
	//뱅크북 모든 데이터 조회 최신순으로
	
	public int setChangeSale (BankBookDTO bankBookDTO)throws Exception;
	//Sale 컬럼 수정
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO)throws Exception;
	//북넘의 값으로 조회. 조회하고싶으면 북넘값 입력
}
