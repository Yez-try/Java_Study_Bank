package com.iu.start.bankMembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.util.DBConnector;

@Repository
public class BankMembersDAO implements MembersDAO{
	
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.iu.start.bankMembers.BankMembersDAO.";
	
	public int setAddFile(BankMembersFileDTO fileDTO)throws Exception{
		return session.update(NAMESPACE+"setAddFile", fileDTO);
	}
	
	public BankMembersDTO getMyPageResult(BankMembersDTO dto) throws Exception{
		return session.selectOne(NAMESPACE+"getMyPage", dto);
	}
	
	public BankMembersDTO getMine(BankMembersDTO dto) throws Exception{
		return session.selectOne(NAMESPACE+"getMine", dto);
	}
	
	public BankMembersDTO getLogin(BankMembersDTO dto) throws Exception{
		
		return session.selectOne(NAMESPACE+"getLogin", dto);
	}

	@Override
	public int setJoin(BankMembersDTO bmdto) throws Exception {
		
		return session.insert(NAMESPACE+"setJoin", bmdto);
	}

	@Override
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "select * from bankmembers where id like '%'||?||'%' order by id asc";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, search);
		
		ResultSet rs =  ps.executeQuery();
		
		ArrayList<BankMembersDTO> dtos = new ArrayList<BankMembersDTO>();
		while(rs.next()) {
			BankMembersDTO dtobm = new BankMembersDTO();
			
			dtobm.setId(rs.getString("ID"));
			dtobm.setEmail(rs.getString("EMAIL"));
			dtobm.setLv(rs.getString("LV"));
			dtobm.setName(rs.getString("name"));
			dtobm.setPhone(rs.getString("PHONE"));
			dtobm.setPw("pw");
			
			
			dtos.add(dtobm);
		}
		return dtos;
	}

}
