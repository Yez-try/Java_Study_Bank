package com.iu.start.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;

	
	public List<BoardDTO> getList() throws Exception{
		return dao.getList();
	}
	
	public int updateHit(BoardDTO dto) throws Exception{
		return dao.update(dto);
	}
	
	public BoardDTO getDetail(BoardDTO dto) throws Exception{
		return dao.getDetail(dto);
	}
	
	public int insert(BoardDTO dto) throws Exception{
		return dao.insert(dto);
	}
	
	public int update(BoardDTO dto) throws Exception{
		return dao.update(dto);
	}
	
	public int delete(BoardDTO dto) throws Exception{
		return dao.delete(dto);
	}

}
