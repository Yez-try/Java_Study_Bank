package com.iu.start.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.util.CommentPager;

public class BankBookDAOTest extends MyAbstractTest{
	
	@Autowired
	private BankBookDAO dao;
	
//	@Test
//	public void setCommentTest() throws Exception{
//		
//		BankBookCommentDTO paramDTO = new BankBookCommentDTO();
//		
//		paramDTO.setWriter("0905");
//		paramDTO.setContents("테스트코메트");
//		paramDTO.setBookNum(1662359624020L);
//		
//		
//		int result = dao.setComment(paramDTO);
//		assertEquals(1, result);
//	}
	
	@Test
	public void getCommentList() throws Exception{
		CommentPager pager = new CommentPager();
		pager.setPage(1L);
		pager.setBooknum(1662359624020L);
		pager.getRow();
		
		List<BankBookCommentDTO> result = dao.getCommentList(pager);
		
		assertNotNull(result);
	}

}
