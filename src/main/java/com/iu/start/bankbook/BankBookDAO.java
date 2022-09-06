package com.iu.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.CommentPager;
import com.iu.start.util.DBConnector;
import com.iu.start.util.Pager;

@Repository
public class BankBookDAO implements BookDAO{
	
	private final String NAMESPACE = "com.iu.start.bankbook.BankBookDAO.";
	@Autowired
	private SqlSession session;
	
	public List<BankBookCommentDTO> getCommentList(CommentPager pager) throws Exception{
		return session.selectList(NAMESPACE+"getCommentList", pager);
	}
	
	public int setComment(BankBookCommentDTO paramDTO) throws Exception{
		return session.insert(NAMESPACE+"setComment", paramDTO);
	}
	
	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "select * from bankbook order by booknum desc";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<BankBookDTO> arr = new ArrayList<BankBookDTO>();
		while(rs.next()) {
			BankBookDTO dto = new BankBookDTO();
			
			dto.setBooknum(rs.getLong("booknum"));
			dto.setBookname(rs.getString("bookname"));
			dto.setBookrate(rs.getDouble("bookrate"));
			dto.setBooksale(rs.getInt("booksale"));
			
			arr.add(dto);
		}
		
		DBConnector.disConnect(rs, ps, con);
		
		return arr;
	}
	

	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "insert into bankbook (booknum, bookname, bookrate, booksale) "
				+ "values (?,?,?,1)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setLong(1, Calendar.getInstance().getTimeInMillis());
		ps.setString(2, bankBookDTO.getBookname());
		ps.setDouble(3, bankBookDTO.getBookrate());
		//sale은 1로 고정
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		return result;
	}

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "update bankbook "
				+ "set bankbook.booksale = ? "
				+ "where booknum = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, bankBookDTO.getBooksale());
		ps.setLong(2, bankBookDTO.getBooknum());
		
		
		int rt = ps.executeUpdate();
		return rt;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "select * from bankbook where booknum = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, bankBookDTO.getBooknum());
		
		ResultSet rs = ps.executeQuery();
		
		BankBookDTO DTOal = null;
		
		if(rs.next()) {
			DTOal = new BankBookDTO();
			
			DTOal.setBooknum(rs.getLong("booknum"));
			DTOal.setBookname(rs.getString("bookname"));
			DTOal.setBookrate(rs.getDouble("bookrate"));
			DTOal.setBooksale(rs.getInt("booksale"));
		}
		
		DBConnector.disConnect(rs, ps, con);
		
		return DTOal;
	}


	@Override
	public int setUpdate(BankBookDTO dto) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "update bankbook "
				+ "set bookrate = ?, bookname = ? "
				+ "where booknum = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDouble(1, dto.getBookrate());
		ps.setString(2, dto.getBookname());
		ps.setLong(3, dto.getBooknum());
		
		int chk = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		
		return chk;
	}
	
	public int delete(BankBookDTO dto) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "delete bankbook where booknum = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, dto.getBooknum());
		
		int chk = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		
		return chk;
	}



	
}
