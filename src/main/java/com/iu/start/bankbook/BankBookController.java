package com.iu.start.bankbook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService service;
	
	@PostMapping("commentAdd")
	public void setCommentAdd(BankBookCommentDTO paramdto) throws Exception{
		int result = service.setCommentAdd(paramdto);
		
	}
	
	@RequestMapping(value = "delete.mg", method = RequestMethod.GET)
	public String delete(BankBookDTO dto) throws Exception{
		System.out.println("bankbook delete 실행");
		
		BankBookDAO dao = new BankBookDAO();
		
		int i = dao.delete(dto);
		
		if(i==1) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		
		return "redirect:./list.mg";
	}
	
	@RequestMapping(value = "update.mg", method = RequestMethod.GET)
	public void update(BankBookDTO dto, Model model) throws Exception{
		System.out.println("bankbook update 실행");
		
		BankBookDAO dao = new BankBookDAO();
		
		BankBookDTO d = dao.getDetail(dto);
		
		model.addAttribute("dto", d);
	}


	@RequestMapping(value = "update.mg", method = RequestMethod.POST)
	public String update(BankBookDTO dto) throws Exception{
		System.out.println("bankbook update 실행");
		
		BankBookDAO dao = new BankBookDAO();
		
		int chk = dao.setUpdate(dto);
		
		if(chk==1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		return "redirect: ./list.mg";
	}
	
	@RequestMapping(value = "list.mg", method = RequestMethod.GET)
	public String getList(Model model) throws Exception{//모델앤뷰의 모델을 매개변수로 받는다.
		System.out.println("list실행");
		
		
		BankBookDAO dao = new BankBookDAO();
		ArrayList<BankBookDTO> arr = dao.getList();
		
		model.addAttribute("list", arr);
//		위 모델은 아래 리퀘스트와 동일하다. 꺼낼때도 request에서 꺼내도 문제어벗ㄷ당
//		request.setAttribute("list", arr);
		
		
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail.mg", method = RequestMethod.GET)
	public ModelAndView detail(String booknum)throws Exception { //신기하게도 이렇게 void로 주면 자동으로 "bankbook/detail.jsp"를 찾아간다.
		System.out.println("detail실행");
		System.out.println("booknum:"+booknum);
		

		BankBookDAO dao = new BankBookDAO();
		BankBookDTO dto = new BankBookDTO();
		
		dto.setBooknum(Long.parseLong(booknum));
		
		dto = dao.getDetail(dto);
	

		ModelAndView mv = new ModelAndView();
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", dto);
		
		return mv;
	}
	
	@RequestMapping(value = "add.mg", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView(); //modelandview를 리턴해도 된다.
		mv.setViewName("bankbook/add"); //경로명을 꼭 담아주어야한다.
		System.out.println("상품등록폼 modelandview리턴해서 실행");
		
		return mv;
	}
	
	@RequestMapping(value = "add.mg", method = RequestMethod.POST)
	public ModelAndView add (BankBookDTO dto) throws Exception{
		System.out.println("상품등록 post 실행");
		
		BankBookDAO dao = new BankBookDAO();
		
		int chk=0;
		chk = dao.setBankBook(dto);
		ModelAndView mv = new ModelAndView();
		
		if(chk==1) {
			System.out.println("등록 완료");
			mv.setViewName("redirect:./list.mg");
			mv.addObject("list", dao.getList());
			
		}else {
			System.out.println("등록실패 : "+chk);
		}
		
		return mv;
	}

}
