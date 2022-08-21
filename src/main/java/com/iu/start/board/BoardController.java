package com.iu.start.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
		
	@RequestMapping(value = "list.mg", method = RequestMethod.GET)
	public ModelAndView list() throws Exception {
		System.out.println("board list 실행");
		
		List<BoardDTO> arr = service.getList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", arr);
		
		return mv;
	}
	
	@RequestMapping(value = "detail.mg", method = RequestMethod.GET)
	public BoardDTO detail(BoardDTO dto, HttpServletRequest request) throws Exception{
		System.out.println("board detail 실행");
		
		dto = service.getDetail(dto);
		
		request.setAttribute("board", dto);
		
		HttpSession session = request.getSession();
		
		int chk = service.updateHit(dto);
		System.out.println(chk);
		return dto;
	}
	
	@RequestMapping(value = "add.mg", method = RequestMethod.GET)
	public void add() {
		System.out.println("글 작성 실행");
	}
	
	@RequestMapping(value="add.mg", method = RequestMethod.POST)
	public String add(BoardDTO dto, String id) throws Exception{
		System.out.println("작성글 insert 요청");
		
		System.out.println(id);
		dto.setWriter(id);
		System.out.println(dto.getWriter());
		
		int result = service.insert(dto);
		
		if(result==1) {
			System.out.println("글 입력 완료");
		}else {
			System.out.println("입력 실패");
		}
		
		return "redirect: ./list.mg";
	}
	
	@RequestMapping(value="update.mg", method = RequestMethod.GET)
	public ModelAndView update(String id) throws Exception{
		System.out.println("글 수정 실행");
		
		ModelAndView mv = new ModelAndView();
		
		BoardDTO dto = new BoardDTO();
		
		dto.setWriter(id);
		dto = service.getDetail(dto);
		
		mv.addObject("board", dto);
		
		return mv;
	}
	
	@RequestMapping(value="update.mg", method = RequestMethod.POST)
	public String update(BoardDTO dto) throws Exception{
		System.out.println("글 수정 처리");
		
		int chk = service.update(dto);
		
		if(chk==1) {
			System.out.println("수정완료");
		}else {
			System.out.println("수정실패");
		}
		
		return "redirect:./list.mg";
	}
	
	
	@RequestMapping(value="delete.mg", method = RequestMethod.GET)
	public String delete(BoardDTO dto) throws Exception{
		System.out.println("글 삭제 처리");
		
		service.delete(dto);
		return "redirect:./list.mg";
	}

}
