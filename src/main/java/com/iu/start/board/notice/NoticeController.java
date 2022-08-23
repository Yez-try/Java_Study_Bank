package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	//글목록
	@RequestMapping(value = "list.mg", method = RequestMethod.GET)
	public ModelAndView getList() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> arr = service.getList();
		
		mv.addObject("list", arr);
		mv.setViewName("notice/list");
		
		return mv;
	}
	
	//글상세
	@RequestMapping(value = "detail.mg", method= RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception{
		
		boardDTO = service.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		
		return "notice/detail";
	}
	
	//글작성
	//입력폼
	@RequestMapping(value = "add.mg", method = RequestMethod.GET)
	public void setAdd() throws Exception{
//		return "notice/add";
	}
	
	//DB입력
	@RequestMapping(value = "add.mg", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO) throws Exception{
		int result = service.setAdd(boardDTO);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:./list.mg");
		
		return mv;
	}
	
	//글수정
	@RequestMapping(value = "update.mg", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		boardDTO = service.getDetail(boardDTO);
		
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("notice/update");
		
		return mv;
	}
	
	@RequestMapping(value = "update.mg", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		int result = service.setUpdate(boardDTO);
		return "redirect:./detail.mg?num="+boardDTO.getNum();
	}
	
	//글삭제
	@RequestMapping(value = "delete.mg", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result = service.setDelete(boardDTO);
		return "redirect:./list.mg";
	}
	

}
