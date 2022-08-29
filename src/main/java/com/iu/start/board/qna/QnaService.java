package com.iu.start.board.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO dao;
	
	public int setReply(QnaDTO qnaDTO) throws Exception{
		
		System.out.println(qnaDTO.getNum()+"부모 detail 가져오기");
		QnaDTO parent = (QnaDTO)dao.getDetail(qnaDTO);
		
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		int result = dao.setStepUpdate(parent);
		int result2 = dao.setReplyAdd(qnaDTO);
		
		return 0;
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.calNum(dao.getCount(pager));
		
		return dao.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return dao.getDetail(boardDTO);
	}


	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return dao.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return dao.setDelete(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception {
//		@Override
//		public int setAdd(BoardDTO boardDTO) throws Exception {
//			return dao.setAdd(boardDTO);
//		}
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
