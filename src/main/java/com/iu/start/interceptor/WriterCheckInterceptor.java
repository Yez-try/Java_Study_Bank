package com.iu.start.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.bankMembers.BankMembersDTO;
import com.iu.start.board.impl.BoardDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//Post일때는 실행하지 않고 , Get일 때만 실행하고 싶다...
		String method = request.getMethod();
		if(method.equals("POST")) {
			return ;
		}
		
		// 글의 작성자를 알 수 있는 건 요청이 가고 난 뒤 게시글의 상세내용을 받아 온 후 이므로 postHandle을 쓴다.
		// 로그인 사용자의 ID와 DTO의 작성자가 일치하는가?
		
		// 로그인 사용자 정보
		HttpSession session = request.getSession();
		BankMembersDTO member = (BankMembersDTO)session.getAttribute("member");
		
		//DTO의 작성자
		Map<String, Object> model = modelAndView.getModel();
		
//		model.keySet();//맵에 키가 뭐가 있는지 모를때
		BoardDTO dto = (BoardDTO)model.get("boardDTO");
		
		if(member.getId().equals(dto.getWriter())) {
			System.out.println("작성자일치");
		}else {
			modelAndView.setViewName("common/result");
			modelAndView.addObject("message","작성자만 수정이 가능합니다.");
			modelAndView.addObject("url", "./list.mg");
			System.out.println("작성자불일치");
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}

}
