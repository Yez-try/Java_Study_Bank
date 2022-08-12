package com.iu.start.board;

import java.sql.Connection;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BoardDAO {
	
	public ArrayList<BoardDTO> list() throws Exception{
		
		BoardDTO dto = new BoardDTO();
		
		Connection con = DBConnector.getConnection();
		
		String sql = "";
		
		con.prepareStatement(sql);
		
		return null;
	}

}
