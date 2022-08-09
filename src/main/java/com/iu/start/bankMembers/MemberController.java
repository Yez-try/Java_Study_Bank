package com.iu.start.bankMembers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member/*") //루트 밑에 멤버로 시작하는 모든 애들은 여기로 와라
public class MemberController {
	
	// 루트/member/login이 들어왔을 때 실행해야 할 메서드를 만들어준다.
//	@RequestMapping(value = "/member/login") //클래스 상단에 RequestMapping을 해주면 login만 써도 여기로 오게된다.
	@RequestMapping(value = "login")
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	} 
	
	// 메서드명 join (Get)
	// url주소 루트/member/join
	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 실행");
		
		return "member/join"; //jsp의 경로명을 작성해준다. 기존과 달리 views아래부터 시작하고 jsp는 생략해준다.
		// 경로설정 파일은 servlet-context.xml에 있다.
	}
	
	
	
	//join post방식
	//오버로딩: 매개변수가 달라야하므로, HttpServletRequest request 값을 받아준다.
	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	public String join(BankMembersDTO dto) throws Exception{
		System.out.println("회원가입 post 실행");
		
//		BankMembersDTO dto = new BankMembersDTO();
		BankMembersDAO bmdao = new BankMembersDAO();
		
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

		chk = bmdao.setJoin(dto);

		
		if(chk == 1) {
			System.out.println("가입성공");
		}else {
			System.out.println("가입실패");
		}
		return "member/join"; //jsp의 경로명을 작성해준다. 기존과 달리 views아래부터 시작하고 jsp는 생략해준다.
		// 경로설정 파일은 servlet-context.xml에 있다.
	}

}
