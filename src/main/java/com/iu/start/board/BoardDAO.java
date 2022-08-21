package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.iu.start.board.BoardDAO.";
	
	public int updateHit(BoardDTO dto) throws Exception{
		return session.update(NAMESPACE+"updateHit");
	}
	
	public List<BoardDTO> getList() throws Exception{
		return session.selectList(NAMESPACE+"getList");		
	}
	
	public BoardDTO getDetail(BoardDTO dto) throws Exception{
		return session.selectOne(NAMESPACE+"getDatail", dto);
	}
	
	public int insert(BoardDTO dto) throws Exception{
		return session.insert(NAMESPACE+"insert", dto);
	}
	
	public int update(BoardDTO dto) throws Exception{
		return session.update(NAMESPACE+"update");
	}
	
	public int delete(BoardDTO dto) throws Exception{
		return session.delete(NAMESPACE+"delete");
	}

}
