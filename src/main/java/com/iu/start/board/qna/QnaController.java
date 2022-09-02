package com.iu.start.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService service;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	//답글 작성
	@GetMapping("reply.mg") //RequestMapping의 GET인 경우 이렇게 줄여쓸수 있다.
	public ModelAndView setReply(BoardDTO boardDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/reply");
		
		mv.addObject("dto",boardDTO);
		return mv;
	}
	
	@PostMapping("reply.mg")
	public ModelAndView setReply(QnaDTO qnadto, ModelAndView mv) throws Exception{
		
		service.setReply(qnadto);
		
		mv.setViewName("redirect:./list.mg");
		
		return mv;
	}
	
	//글 목록 보기
	@RequestMapping(value = "list.mg", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception{
		
		List<BoardDTO> list = service.getList(pager);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	//글 상세 보기
	@RequestMapping(value = "detail.mg", method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception{
		
		BoardDTO dto = service.getDetail(boardDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	
	//글 작성
	@RequestMapping(value = "add.mg", method = RequestMethod.GET)
	public ModelAndView setAdd() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/add");
		return mv;
	}
	
	@RequestMapping(value= "add.mg", method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO, MultipartFile[] multipartfiles, HttpSession session) throws Exception{
		int result = service.setAdd(boardDTO, multipartfiles, session.getServletContext());
		
		return "redirect:./list.mg";
	}
	
	//글 수정
	@RequestMapping(value = "update.mg", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		System.out.println("update Get 페이지 실행");
		boardDTO = service.getDetail(boardDTO);
		
		mv.addObject("boardDTO",boardDTO);
		mv.setViewName("board/update");
		
		return mv;
	} //모델앤뷰를 되돌려주지 않음 문제 있는지 확인.. 문제 있음!!!
	
	@RequestMapping(value = "update.mg", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		
		int result = service.setUpdate(boardDTO);
		
		return "redirect: ./update.mg?num="+boardDTO.getNum();
	}
	
	//글 삭제
	@RequestMapping("delete.mg")
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result = service.setDelete(boardDTO);
		
		return "redirect: ./list.mg";
	}
	
	

}
