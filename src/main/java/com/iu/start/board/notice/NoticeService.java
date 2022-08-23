package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO dao;

	@Override
	public List<BoardDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		return dao.getList();
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.setDelete(boardDTO);
	}


}
