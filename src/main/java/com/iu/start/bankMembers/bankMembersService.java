package com.iu.start.bankMembers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class bankMembersService {
	
	@Autowired
	private BankMembersDAO dao;
	
	public BankMembersDTO getLogin(BankMembersDTO dto) throws Exception{
		return dao.getLogin(dto);
	}
	
	public int setJoin(BankMembersDTO bmdto) throws Exception {
		return dao.setJoin(bmdto);
	}
	
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		return dao.getSearchByID(search);
	}
}
