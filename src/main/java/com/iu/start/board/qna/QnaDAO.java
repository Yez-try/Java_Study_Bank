package com.iu.start.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;

@Repository
public class QnaDAO implements BoardDAO{
	
	private String NAMESPACE = "com.iu.start.board.qna.QnaDAO.";
	@Autowired
	private SqlSession session;

	@Override
	public List<BoardDTO> getList() throws Exception {
		return session.selectList(NAMESPACE+"getList");
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return session.selectOne(NAMESPACE+"getDetail", boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return session.insert(NAMESPACE+"setAdd", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return session.update(NAMESPACE+"setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return session.delete(NAMESPACE+"setDelete", boardDTO);
	}
	
	

}
