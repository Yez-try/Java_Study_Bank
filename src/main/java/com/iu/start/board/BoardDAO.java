package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BoardDAO {
	
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
			dto.setBdate(rs.getDate("bdate"));
			dto.setViews(rs.getInt("views"));
			dto.setId(rs.getString("id"));
			
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
			dto.setBdate(rs.getDate("bdate"));
			dto.setContents(rs.getString("contents"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setViews(rs.getInt("views"));
		}else {
			return null;
		}
		return dto;
	}
	
	public int insert(BoardDTO dto) throws Exception{
		
		Connection con = DBConnector.getConnection();
		
		String sql = "insert into board (no, title, contents, id, views, bdate) "
				+ "values ((select max(no)+1 from board), ?, ?, ?, 0, sysdate)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, dto.getTitle());
		ps.setString(2, dto.getContents());
		ps.setString(3, dto.getId());
		
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
