package com.iu.start.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.bankMembers.BankMembersDTO;
import com.iu.start.bankMembers.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("adminChk인터셉터 프리핸들러");
		//1. roledtos를 반복문 돌려서 rolename프린트
		BankMembersDTO dto = (BankMembersDTO)request.getSession().getAttribute("member");
		
		List<RoleDTO> roles = dto.getRoleDTOs();

		boolean chk = false;
		
		for(RoleDTO role: roles) {
			System.out.println(role.getRoleName());
			if(role.getRoleName().equals("admin")) {
				chk = true;
				break;
			}
		}
		//권한이 없을때 (forward 방식으로 보내보자 )
		if(!chk) {
			System.out.println(chk+"메세지");
			request.setAttribute("message", "권한이 없습니다");
			request.setAttribute("url", "../../../../../");
			
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");//jsp의 경로
			//얘네는 internalresource 어쩌구를 거치지 않으므로 전체 경로를 써준다.
			
			view.forward(request, response);
	
		}
		
		return chk;
	}

}
