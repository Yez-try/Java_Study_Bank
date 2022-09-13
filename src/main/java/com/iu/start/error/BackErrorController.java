package com.iu.start.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//controllerAdvice는 예외처리를 전문으로 하는 컨트롤러이다.
@ControllerAdvice
public class BackErrorController {
	//컨트롤러마다 메서드를 만들지 않아도 전역으로 메서드를 만들어 가능하다.
	
	//에러처리 메서드
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exceptionTest1() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("errors/error_404");
		
		return mv;
	}
	
	//위에서 널포인터로 못받은 exception은 여기서 받도록
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest2() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("errors/error_404");
		
		return mv;
	}
	
}
