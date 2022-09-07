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
	
	@Test
	public void updateCmtTest() throws Exception{
		BankBookCommentDTO d = new BankBookCommentDTO();
		d.setContents("수정주성하기");
		d.setNum(590L);
		
		int result = dao.updateCmt(d);
		assertSame(1, d);
	}
	
	
//	@Test
//	public void getCmtTotalTest() throws Exception{
//		long result = dao.getCmtTotal();
//		System.out.println(result);
//		
//		assertNotSame(0, dao);
//	}
	
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
	
//	@Test
//	public void getCommentListTest() throws Exception{
//		CommentPager pager = new CommentPager();
//		pager.setPage(1L);
//		pager.setBooknum(1662359624020L);
//		pager.getRow();
//		
//		List<BankBookCommentDTO> result = dao.getCommentList(pager);
//		
//		assertNotNull(result);
//	}

}
