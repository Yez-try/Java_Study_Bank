package com.iu.start.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.util.CommentPager;
import com.iu.start.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO dao;
	
	public int updateCmt(BankBookCommentDTO paramDTO) throws Exception{
		return dao.updateCmt(paramDTO);
	}
	
	public int setCommentAdd(BankBookCommentDTO paramDTO) throws Exception {
		return dao.setComment(paramDTO);
	}
	
	public  List<BankBookCommentDTO> getCommentList(CommentPager pager) throws Exception{
		Long totalcnt = (long)dao.getCmtTotal(pager);
		
		pager.calNum(totalcnt);
		
		return dao.getCommentList(pager);
	}
	
	public int delCmt(Long num) throws Exception{
		return dao.delCmt(num);
	}
	
}
