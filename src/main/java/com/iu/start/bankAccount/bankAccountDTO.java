package com.iu.start.bankAccount;

import java.sql.Date;

public class bankAccountDTO {

	private Long acnum;
	private String id;
	private Long booknum;
	private Date acdate;
	
	public Long getAcnum() {
		return acnum;
	}
	public void setAcnum(Long acnum) {
		this.acnum = acnum;
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
