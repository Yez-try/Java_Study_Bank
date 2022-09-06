package com.iu.start.bankbook;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;

public class BankBookDAOTest extends MyAbstractTest{
	
	@Autowired
	private BankBookDAO dao;
	@Test
	public void setCommentTest() throws Exception{
		
		BankBookCommentDTO paramDTO = new BankBookCommentDTO();
		
		paramDTO.setWriter("0905");
		paramDTO.setContents("테스트코메트");
		paramDTO.setBookNum(1662359624020L);
		
		
		int result = dao.setComment(paramDTO);
		assertEquals(1, result);
	}

}
