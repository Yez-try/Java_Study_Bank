package com.iu.start.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.notice.NoticeDTO;

public class NoticeDAOTest extends MyAbstractTest{

	private String NAMESPACE = "com.iu.start.board.notice.NoticeDAO.";
	
	@Autowired
	private SqlSession session;
	
	@Test
	public void getList() throws Exception {
		
		List<BoardDTO> ar = session.selectList(NAMESPACE+"getList");
		
		assertNotNull(ar);
	}
	
	@Test
	public void setAdd() throws Exception {
		
		NoticeDTO dto = new NoticeDTO();
		
		dto.setWriter("id22");
		dto.setTitle("제목테스트");
		dto.setContents("내용테스테스테스트");
		
		
		int chk = session.insert(NAMESPACE+"setAdd", dto);
		
		assertEquals(1, chk);
	}
	
	@Test
	public void getDetail() throws Exception {
		NoticeDTO dto = new NoticeDTO();
		
		dto.setNum(3l);
		
		BoardDTO boardDTO = session.selectOne(NAMESPACE+"getDetail",dto);
		
		assertNotNull(boardDTO);
		
	}
	
	@Test
	public void setUpdate() throws Exception {
		
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setNum(3l);
		boardDTO.setContents("투투테스투");
		boardDTO.setTitle("투테스투투");
		
		int chk = session.update(NAMESPACE+"setUpdate", boardDTO);
		
		assertEquals(1, chk);
		
	}
	
	@Test
	public void setDelete() throws Exception {
		
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setNum(2L);
		
		int chk = session.delete(NAMESPACE+"setDelete", boardDTO);
	
		assertEquals(1, chk);
	}
		

}
