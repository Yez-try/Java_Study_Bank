package com.iu.start.board.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO dao;

	@Override
	public List<BoardDTO> getList(Long page) throws Exception {
		
		Long perPage= 15L; //한 페이지에 출력할 목록의 갯수
		
		Long startRow = ((page-1)*perPage +1);
		Long lastRow = (page*perPage);
		
		
		Map<String, Long> map = new HashMap<String, Long>();
		
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		
		return dao.getList(map);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return dao.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return dao.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return dao.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return dao.setDelete(boardDTO);
	}
	
	

}
