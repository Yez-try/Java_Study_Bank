package com.iu.start.accountList;

import java.util.ArrayList;

public interface ListDAO {
	
	//AccountList table에 insert
	//현재시간을 밀리세컨즈로 변환해서 입력
	//booksale은 무조건 1로 입력한다.
	public int setAccountList(AccountListDTO alDTO) throws Exception;

	
	//모든 데이터를 조회하는데 최신순으로 가져오기
	public ArrayList<AccountListDTO> getList() throws Exception;
	
	//sale컬럼 수정. 
	//특정한 값을 넣어준 대로 업데이트 
	public int setChangeSale(AccountListDTO alDTO) throws Exception;
	
	//BookNum의 값으로 조회
	//하나 아니면 없음
	public AccountListDTO getDetail(AccountListDTO alDTO) throws Exception;
}
