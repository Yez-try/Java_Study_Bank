package com.iu.start.bankbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO dao;
	
	public ArrayList<BankBookDTO> getList() throws Exception {
		return dao.getList();
	}
	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		return dao.setBankBook(bankBookDTO);
	}
	
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		return dao.setChangeSale(bankBookDTO);
	}
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return dao.getDetail(bankBookDTO);
	}
	
	public int setUpdate(BankBookDTO dto) throws Exception{
		return dao.setUpdate(dto);
	}
	
	public int delete(BankBookDTO dto) throws Exception{
		return dao.delete(dto);
	}
	
	

}
