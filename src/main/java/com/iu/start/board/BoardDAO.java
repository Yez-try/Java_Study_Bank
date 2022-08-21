package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BoardDAO {
	
	public int updateHit(BoardDTO dto) throws Exception{
		
		Connection con = DBConnector.getConnection();
		
		String sql = "update board set Hit = Hit+1 where no=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setLong(1, dto.getNo());
		
		int chk = ps.executeUpdate();
		
		return chk;
	}
	
	public ArrayList<BoardDTO> getList() throws Exception{
		
		ArrayList<BoardDTO> arr = new ArrayList<BoardDTO>();
		
		Connection con = DBConnector.getConnection();
		
		String sql = "select * from board order by no desc";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setNo(rs.getLong("no"));
			dto.setTitle(rs.getString("title"));
			dto.setContents(rs.getString("contents"));
			dto.setRegdate(rs.getDate("Regdate"));
			dto.setHit(rs.getInt("Hit"));
			dto.setWriter(rs.getString("Writer"));
			
			arr.add(dto);
		}
		
		return arr;		
	}
	
	public BoardDTO getDetail(BoardDTO dto) throws Exception{
		
		Connection con = DBConnector.getConnection();
		
		String sql = "select * from board where no = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setLong(1, dto.getNo());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			dto.setRegdate(rs.getDate("Regdate"));
			dto.setContents(rs.getString("contents"));
			dto.setWriter(rs.getString("Writer"));
			dto.setTitle(rs.getString("title"));
			dto.setHit(rs.getInt("Hit"));
		}else {
			return null;
		}
		return dto;
	}
	
	public int insert(BoardDTO dto) throws Exception{
		
		Connection con = DBConnector.getConnection();
		
		String sql = "insert into board (no, title, contents, Writer, Hit, Regdate) "
				+ "values ((select max(no)+1 from board), ?, ?, ?, 0, sysdate)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, dto.getTitle());
		ps.setString(2, dto.getContents());
		ps.setString(3, dto.getWriter());
		
		int result = ps.executeUpdate();
		
		return result;
	}
	
	public int update(BoardDTO dto) throws Exception{
		
		Connection con = DBConnector.getConnection();
		
		String sql = "update board set contents = ?,title=? "
				+ "where no = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, dto.getContents());
		ps.setString(2, dto.getTitle());
		ps.setLong(3, dto.getNo());
		
		int result = ps.executeUpdate();
		
		return result;
	}
	
	public int delete(BoardDTO dto) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "delete board where no =?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setLong(1, dto.getNo());
		
		int result = ps.executeUpdate();
		
		return result;
	}

}
