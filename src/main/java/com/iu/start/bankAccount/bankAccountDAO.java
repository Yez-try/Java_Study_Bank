package com.iu.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iu.start.util.DBConnector;

public class bankAccountDAO {
	
	//add메서드 만들기 (insert쿼리 사용)
	public int add(bankAccountDTO dto) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "insert into bankaccount "
				+ "values (account_seq.nextval, ?,?,sysdate)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, dto.getId());
		ps.setLong(2, dto.getBooknum());
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		
		return result;
	}
	

}
