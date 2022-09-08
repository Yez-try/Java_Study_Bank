package com.iu.start.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 여기서 체크한 후 return 이 true면 Controller로 진행
		// return이 false면 Controller로 진행 X
		System.out.println("Test 인터셉터 Controller 진입 전 실행");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 리턴이 void
		System.out.println("Test 인터셉터 Controller에서 DS로 나가기 전에 실행");
		super.postHandle(request, response, handler, modelAndView);
	}

}
