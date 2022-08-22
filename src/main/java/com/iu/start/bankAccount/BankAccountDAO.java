package com.iu.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.bankMembers.BankMembersDTO;
import com.iu.start.util.DBConnector;

@Repository
public class BankAccountDAO {
	
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.iu.start.bankAccount.BankAccountDAO.";
	
	public List<BankAccountDTO> getListById(BankMembersDTO dto) throws Exception{
		return session.selectList(NAMESPACE+"getListById", dto);
	}
	
	
	//add메서드 만들기 (insert쿼리 사용)
	public int add(BankAccountDTO dto) throws Exception{
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
