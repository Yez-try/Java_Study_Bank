package com.iu.start.bankMembers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO dao;
	
	public BankMembersDTO getLogin(BankMembersDTO dto) throws Exception{
		return dao.getLogin(dto);
	}
	
	public int setJoin(BankMembersDTO dto) throws Exception {
		return dao.setJoin(dto);
	}
	
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		return dao.getSearchByID(search);
	}
	
	
}
