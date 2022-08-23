package com.iu.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService service;
	
	//글 목록 보기
	@RequestMapping(value = "list.mg", method = RequestMethod.GET)
	public ModelAndView getList() throws Exception{
		
		List<BoardDTO> list = service.getList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("qna/list");
		
		return mv;
	}
	
	//글 상세 보기
	@RequestMapping(value = "detail.mg", method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception{
		
		BoardDTO dto = service.getDetail(boardDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.setViewName("qna/detail");
		
		return mv;
	}
	
	
	//글 작성
	@RequestMapping(value = "add.mg", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		return "qna/add";
	}
	
	@RequestMapping(value= "add.mg", method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO) throws Exception{
		int chk = service.setAdd(boardDTO);
		
		return "redirect:./list.mg";
	}
	
	//글 수정
	@RequestMapping(value = "update.mg", method = RequestMethod.GET)
	public void setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		
		boardDTO = service.getDetail(boardDTO);
		
		mv.addObject("dto",boardDTO);
		mv.setViewName("qna/update");
	} //모델앤뷰를 되돌려주지 않음 문제 있는지 확인..
	
	@RequestMapping(value = "update.mg", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		
		int result = service.setUpdate(boardDTO);
		
		return "redirect: ./update.mg?num="+boardDTO.getNum();
	}
	
	//글 삭제
	@RequestMapping("delete.mg")
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result = service.setDelete(boardDTO);
		
		return "./list.mg";
	}
	
	

}
