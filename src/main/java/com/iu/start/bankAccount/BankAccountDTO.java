package com.iu.start.bankAccount;

import java.sql.Date;

import com.iu.start.bankbook.BankBookDTO;

public class BankAccountDTO {

	private Long acnum;
	private String id;
	private Long booknum;
	private Date acdate;
	private BankBookDTO bankBookDTO; //1대1의 관계인 경우
	
	public Long getAcnum() {
		return acnum;
	}
	public void setAcnum(Long acnum) {
		this.acnum = acnum;
	}
	public BankBookDTO getBankBookDTO() {
		return bankBookDTO;
	}
	public void setBankBookDTO(BankBookDTO bankBookDTO) {
		this.bankBookDTO = bankBookDTO;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getBooknum() {
		return booknum;
	}
	public void setBooknum(Long booknum) {
		this.booknum = booknum;
	}
	public Date getAcdate() {
		return acdate;
	}
	public void setAcdate(Date acdate) {
		this.acdate = acdate;
	}
	
	
	
	
	
}
