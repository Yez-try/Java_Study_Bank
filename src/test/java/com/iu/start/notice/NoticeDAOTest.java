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
import com.iu.start.board.qna.QnaDTO;

public class NoticeDAOTest extends MyAbstractTest{

	private String NAMESPACE = "com.iu.start.board.qna.QnaDAO.";
	
	@Autowired
	private SqlSession session;
	
//	@Test
//	public void getCountTest() throws Exception{
//		
//		
//		System.out.println((1-1)/5+1);
//		System.out.println(session.selectOne(NAMESPACE+"getCount"));
//	}
//	
//	@Test
//	public void getList() throws Exception {
//		
//		List<BoardDTO> ar = session.selectList(NAMESPACE+"getList");
//		
//		assertNotNull(ar);
//	}
//	
	@Test
	public void setAddTest() throws Exception {
		
		for(int i=0;i<100;i++) {
			QnaDTO dto = new QnaDTO();
			
			dto.setWriter("idtest2");
			dto.setTitle("QNA테스트"+i);
			dto.setContents("QNA내용"+i);
					
			int chk = session.insert(NAMESPACE+"setAdd", dto);

			if(i%10==0) {
				Thread.sleep(500);
			}
		}
		
	}
//	
//	@Test
//	public void getDetail() throws Exception {
//		NoticeDTO dto = new NoticeDTO();
//		
//		dto.setNum(3l);
//		
//		BoardDTO boardDTO = session.selectOne(NAMESPACE+"getDetail",dto);
//		
//		assertNotNull(boardDTO);
//		
//	}
//	
//	@Test
//	public void setUpdate() throws Exception {
//		
//		BoardDTO boardDTO = new BoardDTO();
//		
//		boardDTO.setNum(3l);
//		boardDTO.setContents("투투테스투");
//		boardDTO.setTitle("투테스투투");
//		
//		int chk = session.update(NAMESPACE+"setUpdate", boardDTO);
//		
//		assertEquals(1, chk);
//		
//	}
//	
//	@Test
//	public void setDeleteTest() throws Exception {
//		
//		BoardDTO boardDTO = new BoardDTO();
//		
//		boardDTO.setNum(29L);
//		
//		int chk = session.delete(NAMESPACE+"setDelete", boardDTO);
//	
//		assertEquals(1, chk);
//	}
		

}
