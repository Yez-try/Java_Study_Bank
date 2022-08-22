package com.iu.start.bankMembers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO dao;
	
	@Autowired
	private BankAccountDAO accountDAO;
	
	public Map<String, Object> getMine(BankMembersDTO dto) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		dto = dao.getMine(dto);
		List<BankAccountDTO> list = accountDAO.getListById(dto);
		
		map.put("list", list);
		map.put("dto", dto);
		
		return map;
	}
	
//	public BankMembersDTO getMine(BankMembersDTO dto) throws Exception{
//		
//		dto = dao.getMyPageResult(dto);
//		
//		return dto;
//	}
	
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
