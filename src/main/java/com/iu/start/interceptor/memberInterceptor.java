package com.iu.start.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class memberInterceptor extends HandlerInterceptorAdapter{

	//이렇게 필요한 것만 오버라이딩해서 사용한다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 로그인 유무를 체크하려고 한다.
		System.out.println("멤버 인터셉터 로그인 유뮤 체크");
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("member");
		
		if(obj != null) {
			System.out.println("로그인 했음");
			return true;
		}else {
			System.out.println("로그인 안함");
			response.sendRedirect("../../../../member/login.mg");
			return false;
		}
		
		
	}
	
	

}
