package com.iu.start.bankbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankMembers.BankMembersDTO;
import com.iu.start.util.CommentPager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService service;
	
	@PostMapping("commentUpdate")
	@ResponseBody
	public int cmtUpdate(BankBookCommentDTO dto)throws Exception{
		
		int result = service.updateCmt(dto);
		
		return result;
	}
	
	@PostMapping("commentDelete")
	@ResponseBody
	public int cmtDelete(Long num) throws Exception {
		System.out.println("commentDelete 실행");

		int result = service.delCmt(num);
		
		return result;
	}
	
	@GetMapping("commentList")
	@ResponseBody
	public Map<String, Object> getCommentList(CommentPager pager/*pager내에 page와 booknum이 들어있음*/) throws Exception{
		//1. JSP에 출력하고 결과물을 응답으로 전송
//		ModelAndView mv =  new ModelAndView();
//		List<BankBookCommentDTO> ar = service.getCommentList(pager);
//		
//		mv.addObject("commentlist", ar);
//		mv.setViewName("common/commentlist");
//
//		
//		return mv;
		
		//2. JSON으로 보내주기
		// pom.xml에  jackson-databind 패키지를 넣어준 후
		// responseBody 어노테이션으로 바로 리턴
		
		//pager의 총 페이지수로 return해주고 싶다. 근데 한개밖에 리턴을 모샣 ㅠ 어떻게 하지?
		//map을 만들어보자
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<BankBookCommentDTO> ar = service.getCommentList(pager);
		
		map.put("list", ar);
		map.put("pager", pager);
		
		return map;
	}
	
	@PostMapping("commentAdd")
	@ResponseBody //응답으로 return 하는 애들을 전부 body로 받아와서 return 하겠다
	public String setCommentAdd(BankBookCommentDTO paramdto) throws Exception{
		System.out.println("commentAdd실행");
		
		int result = service.setCommentAdd(paramdto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		
//		mv.setViewName("common/ajaxResult"); //jsp로 보내는 방법: 해당 jsp의 모든 html이 저장된다.
		String jsonResult = "{\"result\":\""+result+"\"}";
		
		return jsonResult;
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
	public ModelAndView add(HttpSession session) {		
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		String vname = "redirect:../member/login.mg";
		if(bankMembersDTO!=null) {
			vname = "bankbook/add";
		}else {
			vname = "redirect:../member/login.mg";
		}
		
		ModelAndView mv = new ModelAndView(); //modelandview를 리턴해도 된다.
		mv.setViewName(vname); //경로명을 꼭 담아주어야한다.
		
		
		
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
