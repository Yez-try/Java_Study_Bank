package com.iu.start.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
		return "notice";
	}
	
	//글목록
	@RequestMapping(value = "list.mg", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		List<BoardDTO> arr = service.getList(pager);
		
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
	public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception{
		System.out.println("MultipartFile[]을 가져오기");
		

		int result = service.setAdd(boardDTO,files, session.getServletContext());
		
		ModelAndView mv = new ModelAndView();
		
		String message = "글작성 실패";
		String url = "./list.mg";
		if(result==1) {
			message = "글작성 성공";
		}
		mv.addObject("message", message);
		mv.setViewName("/common/result");
		mv.addObject("url", url);
		
		
		return mv;
	}
	
	//글수정
	@RequestMapping(value = "update.mg", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		boardDTO = service.getDetail(boardDTO);
		
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/update");
		
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
