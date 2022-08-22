package com.iu.start.bankAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.bankMembers.BankMembersDTO;

@Controller
@RequestMapping("/bankAccount/*")
public class BankAccontController {
	
	private BankAccountDAO dao;
	
	public BankAccontController(){ //누군가가 컨트롤러 객체를 만들때 실행해라
		this.dao = new BankAccountDAO();
	}
	
	@RequestMapping(value = "add.mg", method = RequestMethod.GET)
	public String add(HttpSession session, BankAccountDTO dto) throws Exception{
		System.out.println("BankAccount Add메서드 실행");
		
		//DTO: id, booknum이 필요하다.
		System.out.println( dto.getBooknum());
		BankMembersDTO member = (BankMembersDTO) session.getAttribute("member");
		dto.setId(member.getId());
		
		int result = this.dao.add(dto);
		
		System.out.println(result);
		return "redirect: ../bankbook/list.mg";
	}

}
