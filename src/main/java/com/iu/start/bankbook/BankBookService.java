package com.iu.start.bankbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO dao;
	
	public int setCommentAdd(BankBookCommentDTO paramDTO) throws Exception {
		return dao.setComment(paramDTO);
	}
	
}
