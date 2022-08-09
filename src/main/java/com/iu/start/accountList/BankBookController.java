package com.iu.start.accountList;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(HttpServletRequest request) throws Exception{
		System.out.println("list실행");
		
		
		AccountListDAO dao = new AccountListDAO();
		ArrayList<AccountListDTO> arr = dao.getList();

		request.setAttribute("list", arr);
		
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(HttpServletRequest request, Long booknum) { //신기하게도 이렇게 void로 주면 자동으로 "bankbook/detail.jsp"를 찾아간다.
		System.out.println("detail실행");
		System.out.println("booknum:"+booknum);
		
		AccountListDTO acDTO = new AccountListDTO();
		AccountListDAO dao = new AccountListDAO();
		
		acDTO.setAcId(booknum);
		try {
			acDTO = dao.getDetail(acDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("detail", acDTO);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		System.out.println("상품등록폼 실행");
		
		return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(AccountListDTO dto) {
		System.out.println("상품등록 post 실행");
		
		AccountListDAO dao = new AccountListDAO();
		
		int chk=0;
		try {
			chk = dao.setAccountList(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(chk==1) {
			System.out.println("등록 완료");
		}else {
			System.out.println("등록실패 : "+chk);
		}
		return "bankbook/add";
	}

}
