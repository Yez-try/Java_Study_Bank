package com.iu.start.bankbook;

import java.util.List;

public class BankBookDTO {
	
	private long booknum;
	private String bookname;
	private double bookrate;
	private int booksale;
//	private List<BankAccountDTO> bankAccountDTO;//1대N의 관계인경우
	
	public long getBooknum() {
		return booknum;
	}
	public void setBooknum(long booknum) {
		this.booknum = booknum;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookrate() {
		return bookrate;
	}
	public void setBookrate(double bookrate) {
		this.bookrate = bookrate;
	}
	public int getBooksale() {
		return booksale;
	}
	public void setBooksale(int booksale) {
		this.booksale = booksale;
	}
	
	

}
