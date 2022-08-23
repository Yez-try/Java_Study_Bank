package com.iu.start.bankAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.bankMembers.BankMembersDTO;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountDAO dao;
	
	public List<BankAccountDTO> getListById(BankMembersDTO member) throws Exception{
		return dao.getListById(member);
	}
	
	public int add(BankAccountDTO dto) throws Exception{
		return dao.add(dto);
	}

}
