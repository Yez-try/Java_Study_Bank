package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}
	
	//글목록
	@RequestMapping(value = "list.mg", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getPage() + "Page: 글목록의 페이지 번호 (보내줌)");
		System.out.println(pager.getStartNum() + "StartNum : 블록의 시작번호");
		System.out.println(pager.getLastNum()+ "LastNum : 블록의 끝번호");
		System.out.println(pager.getStartRow() + "StartRow : 불러올 db의 rownum 시작");
		System.out.println(pager.getLastRow()+ "LastRow : 불러올 db의 rownum 끝");
		System.out.println(pager.getPerPage()+ "perpage : 페이지 당 출력할 글의 개수  ");
		System.out.println(pager.getPerBlock()+"perBlock: 페이지에 보여줄 블록의 개수");
		
		
		
		List<BoardDTO> arr = service.getList(pager);
		
		System.out.println(pager.getPage() + "Page: 글목록의 페이지 번호 (보내줌)");
		System.out.println(pager.getStartNum() + "StartNum : 블록의 시작번호");
		System.out.println(pager.getLastNum()+ "LastNum : 블록의 끝번호");
		System.out.println(pager.getStartRow() + "StartRow : 불러올 db의 rownum 시작");
		System.out.println(pager.getLastRow()+ "LastRow : 불러올 db의 rownum 끝");
		System.out.println(pager.getPerPage()+ "perpage : 페이지 당 출력할 글의 개수  ");
		System.out.println(pager.getPerBlock()+"perBlock: 페이지에 보여줄 블록의 번호");
		
		
		mv.addObject("list", arr);
		mv.addObject("pager",pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	//글상세
	@RequestMapping(value = "detail.mg", method= RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception{
		
		boardDTO = service.getDetail(boardDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}
	
	//글작성
	//입력폼
	@RequestMapping(value = "add.mg", method = RequestMethod.GET)
	public ModelAndView setAdd() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", "Notice");
		mv.setViewName("board/add");
		return mv;
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
