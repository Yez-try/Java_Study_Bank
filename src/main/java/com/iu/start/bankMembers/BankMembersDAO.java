package com.iu.start.bankMembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.iu.start.bankAccount.bankAccountDTO;
import com.iu.start.util.DBConnector;

@Repository
public class BankMembersDAO implements MembersDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankMembers.BankMembersDAO."; //멤버변수로 String namespace 선언 대입 : 연결하려는 mapper의 namespace속성의 값과 동일한 값, 끝에 . 추가
	
	
	public BankMembersDTO getLogin(BankMembersDTO dto) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", dto);
	}

	@Override
	public int setJoin(BankMembersDTO bmdto) throws Exception {

		return sqlSession.insert(NAMESPACE+"setJoin", bmdto);
	}

	@Override
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
//		Connection con = DBConnector.getConnection();
//		
//		String sql = "select * from bankmembers where id like '%'||?||'%' order by id asc";
//		
//		PreparedStatement ps = con.prepareStatement(sql);
//		
//		ps.setString(1, search);
		
//		ResultSet rs =  ps.executeQuery();
		
//		ArrayList<BankMembersDTO> dtos = new ArrayList<BankMembersDTO>();
//		while(rs.next()) {
//			BankMembersDTO dtobm = new BankMembersDTO();
//			
//			dtobm.setId(rs.getString("ID"));
//			dtobm.setEmail(rs.getString("EMAIL"));
//			dtobm.setLv(rs.getString("LV"));
//			dtobm.setName(rs.getString("name"));
//			dtobm.setPhone(rs.getString("PHONE"));
//			dtobm.setPw("pw");
//			
//			
//			dtos.add(dtobm);
//		}
		return sqlSession.selectList(NAMESPACE+"getSearchByID",search);
	}

}
