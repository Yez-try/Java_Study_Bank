package com.iu.start.bankMembers;

import java.util.ArrayList;

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
	
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		return dao.getSearchByID(search);
	}
	
	
}
