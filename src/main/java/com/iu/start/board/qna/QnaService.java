package com.iu.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO dao;

	@Override
	public List<BoardDTO> getList() throws Exception {
		return dao.getList();
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
