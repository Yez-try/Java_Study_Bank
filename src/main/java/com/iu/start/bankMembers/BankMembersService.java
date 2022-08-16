package com.iu.start.bankMembers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO dao;
	
	// bankmembers 에 회원가입
	// insert 후에 return 이 1이면 성공, 0이거나 에러면 실패
	public int setJoin(BankMembersDTO bmdto) throws Exception{
		return dao.setJoin(bmdto);
	};
	
	// 검색어를 입력해서 ID를 찾기
	// 입력한 검색어를 포함하는 ID 찾아서 return해오기(정렬은 abc순으로 가져오기)
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception{
		return dao.getSearchByID(search);
	};
	
	public BankMembersDTO getLogin(BankMembersDTO dto) throws Exception{
		return dao.getLogin(dto);
	}
}
