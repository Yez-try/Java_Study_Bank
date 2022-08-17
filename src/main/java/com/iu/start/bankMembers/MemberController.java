package com.iu.start.bankMembers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*") //루트 밑에 멤버로 시작하는 모든 애들은 여기로 와라
public class MemberController {
	
	@Autowired
	private bankMembersService service;
	
	@RequestMapping(value = "logout.mg", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) throws Exception{
		//로그아웃하는 방법
		//1. 세션 소멸시키기(추천)
		//2. 멤버변수 소멸시키기
		System.out.println("로그아웃페이지");
		
		session.invalidate(); //세션 삭제: 세션의 유효시간을 0으로 만듦
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect: ./login.mg");
		return mv;
	}
	
	//
	@RequestMapping(value = "search.mg", method=RequestMethod.GET)
	public void search() throws Exception{
		System.out.println("멤버search페이지");
	
	}
	
	@RequestMapping(value = "search.mg", method = RequestMethod.POST)
	public String search(HttpServletRequest request,Model model) throws Exception{
		System.out.println("멤버list 페이지");

		ArrayList<BankMembersDTO> arr = service.getSearchByID(request.getParameter("search"));
		

		model.addAttribute("mlist", arr);
		
		return "member/list";
	}
	
	// 루트/member/login이 들어왔을 때 실행해야 할 메서드를 만들어준다.
//	@RequestMapping(value = "/member/login") //클래스 상단에 RequestMapping을 해주면 login만 써도 여기로 오게된다.
	@RequestMapping(value = "login")
	public String login() {
		System.out.println("로그인페이지 실행");
		
		return "member/login";
	} 
	
	@RequestMapping(value = "login.mg", method=RequestMethod.POST)
	public String login(HttpSession session /*HttpServletRequest request*/, BankMembersDTO dto, Model model) throws Exception {
		System.out.println("db에 로그인 실행");
		
		dto = service.getLogin(dto);
//		model.addAttribute("member", dto); //이렇게 해도 메인페이지에서는 member를 받아오지 못한다. 우리가 리다이렉트로 주소값을 반환하므로
		
		//그래서 응답을 해도 없어지지 않는 session 객체에 담아 리턴해준다.
//		HttpSession session = request.getSession();
		session.setAttribute("member", dto);
		
		
		System.out.println(dto);
		return "redirect:../";
	} 
	
	
	// 메서드명 join (Get)
	// url주소 루트/member/join
	@RequestMapping(value = "/member/join.mg", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 실행");
		
		return "member/join"; //jsp의 경로명을 작성해준다. 기존과 달리 views아래부터 시작하고 jsp는 생략해준다.
		// 경로설정 파일은 servlet-context.xml에 있다.
	}
	
	
	
	//join post방식
	//오버로딩: 매개변수가 달라야하므로, HttpServletRequest request 값을 받아준다.
	@RequestMapping(value = "/member/join.mg", method = RequestMethod.POST)
	public String join(BankMembersDTO dto) throws Exception{
		System.out.println("회원가입 post 실행");
		
//		BankMembersDTO dto = new BankMembersDTO();

		//HttpServletRequset를 매개변수로 받지 않고도 파라미터를 받을 수 있다(BankBookController detail에서 해보자)
		//Bean(객체, DTO, VO) DTO클래스의 멤버변수의 이름과 파라미터의 이름이 같고, setter메서드가 있는 경우 아래 코드를 자동으로 해준다.
//		dto.setEmail(request.getParameter("email"));
//		dto.setId(request.getParameter("id"));
//		dto.setName(request.getParameter("name"));
//		dto.setPhone(request.getParameter("phone"));
//		dto.setPw(request.getParameter("pw"));
//		if(request.getParameter("lv").equals("sysmanager")) {
		if(dto.getLv().equals("sysmanager")) {
			dto.setLv("MANAGER");
		}else {
			dto.setLv("NORMAL");
		}
		
		int chk = 0;

		chk = service.setJoin(dto);

		
		if(chk == 1) {
			System.out.println("가입성공");
		}else {
			System.out.println("가입실패");
		}
		return "redirect:./login.mg"; //jsp의 경로명을 작성해준다. 기존과 달리 views아래부터 시작하고 jsp는 생략해준다.
		// 경로설정 파일은 servlet-context.xml에 있다.
	}

}
