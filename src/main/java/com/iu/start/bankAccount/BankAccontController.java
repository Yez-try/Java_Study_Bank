package com.iu.start.bankAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.bankMembers.BankMembersDTO;

@Controller
@RequestMapping("/bankAccount/*")
public class BankAccontController {
	
	@Autowired
	private BankAccountService service;

	@RequestMapping(value = "add.mg", method = RequestMethod.GET)
	public String add(HttpSession session, BankAccountDTO dto) throws Exception{
		System.out.println("BankAccount Add메서드 실행");
		
		//DTO: id, booknum이 필요하다.
		System.out.println( dto.getBooknum());
		BankMembersDTO member = (BankMembersDTO) session.getAttribute("member");
		dto.setId(member.getId());
		
		int result = this.service.add(dto);
		
		System.out.println(result);
		return "redirect: ../bankbook/list.mg";
	}

}
