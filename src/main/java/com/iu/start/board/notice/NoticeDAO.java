package com.iu.start.board.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO{
	
	private String NAMESPACE = "com.iu.start.board.notice.NoticeDAO.";
	@Autowired
	private SqlSession session;
	
	@Override
	public int setAddFile(BoardFileDTO boardFileDTO) throws Exception {
		return session.insert(NAMESPACE+"setAddFile", boardFileDTO);
	}

	public Long getCount(Pager pager) throws Exception{
		return session.selectOne(NAMESPACE+"getCount", pager);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return session.selectList(NAMESPACE+"getList", pager);
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
