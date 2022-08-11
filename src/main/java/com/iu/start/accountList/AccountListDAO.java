package com.iu.start.accountList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import com.iu.start.util.DBConnector;

public class AccountListDAO implements ListDAO{
	
	public int setUpdate(AccountListDTO dto) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "update accountlist "
				+ "set acrate = ?, acname = ? "
				+ "where acid = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDouble(1, dto.getAcRate());
		ps.setString(2, dto.getAcName());
		ps.setLong(3, dto.getAcId());
		
		int chk = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		
		return chk;
	}
	
	@Override
	public int setAccountList(AccountListDTO alDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "insert into accountlist (acid, acname, acrate, acsale) "
				+ "values (?,?,?,1)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setLong(1, Calendar.getInstance().getTimeInMillis());
		ps.setString(2, alDTO.getAcName());
		ps.setDouble(3, alDTO.getAcRate());
		//sale은 1로 고정
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	@Override
	public ArrayList<AccountListDTO> getList() throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "select * from accountlist order by acid desc";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<AccountListDTO> arr = new ArrayList<AccountListDTO>();
		while(rs.next()) {
			AccountListDTO dto = new AccountListDTO();
			
			dto.setAcId(rs.getLong("acid"));
			dto.setAcName(rs.getString("acname"));
			dto.setAcRate(rs.getDouble("acrate"));
			dto.setAcSale(rs.getInt("acsale"));
			
			arr.add(dto);
		}
		
		DBConnector.disConnect(rs, ps, con);
		
		return arr;
	}
	
	@Override
	public AccountListDTO getDetail(AccountListDTO alDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "select * from accountlist where acid = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, alDTO.getAcId());
		
		ResultSet rs = ps.executeQuery();
		
		AccountListDTO DTOal = null;
		
		if(rs.next()) {
			DTOal = new AccountListDTO();
			
			DTOal.setAcId(rs.getLong("acid"));
			DTOal.setAcName(rs.getString("acname"));
			DTOal.setAcRate(rs.getDouble("acrate"));
			DTOal.setAcSale(rs.getInt("acsale"));
		}
		
		DBConnector.disConnect(rs, ps, con);
		
		return DTOal;
	}
	
	@Override
	public int setChangeSale(AccountListDTO alDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "update accountlist "
				+ "set accountlist.acsale = ? "
				+ "where acid = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, alDTO.getAcSale());
		ps.setLong(2, alDTO.getAcId());
		
		
		int rt = ps.executeUpdate();
		return rt;
		
	}

}
