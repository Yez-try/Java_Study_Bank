package com.iu.start.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	private BoardDAO dao;
	
	public BoardController(){
		this.dao = new BoardDAO();
	}
		
	@RequestMapping(value = "list.mg", method = RequestMethod.GET)
	public ModelAndView list() throws Exception {
		System.out.println("board list 실행");
		
		ArrayList<BoardDTO> arr = dao.getList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", arr);
		
		return mv;
	}
	
	@RequestMapping(value = "detail.mg", method = RequestMethod.GET)
	public BoardDTO detail(BoardDTO dto, HttpServletRequest request) throws Exception{
		System.out.println("board detail 실행");
		
		dto = dao.getDetail(dto);
		
		request.setAttribute("board", dto);
		
		HttpSession session = request.getSession();
		
		int chk = dao.updateHit(dto);
		System.out.println(chk);
		return dto;
	}
	
	@RequestMapping(value = "add.mg", method = RequestMethod.GET)
	public void add() {
		System.out.println("글 작성 실행");
	}
	
	@RequestMapping(value="add.mg", method = RequestMethod.POST)
	public String add(BoardDTO dto) throws Exception{
		System.out.println("작성글 insert 요청");
		
		int result = dao.insert(dto);
		
		if(result==1) {
			System.out.println("글 입력 완료");
		}else {
			System.out.println("입력 실패");
		}
		
		return "redirect: ./list.mg";
	}
	
	@RequestMapping(value="update.mg", method = RequestMethod.GET)
	public ModelAndView update(String no) throws Exception{
		System.out.println("글 수정 실행");
		
		ModelAndView mv = new ModelAndView();
		
		BoardDTO dto = new BoardDTO();
		
		dto.setNo(Long.parseLong(no));
		dto = dao.getDetail(dto);
		
		mv.addObject("board", dto);
		
		return mv;
	}
	
	@RequestMapping(value="update.mg", method = RequestMethod.POST)
	public String update(BoardDTO dto) throws Exception{
		System.out.println("글 수정 처리");
		
		int chk = dao.update(dto);
		
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
		
		dao.delete(dto);
		return "redirect:./list.mg";
	}

}
