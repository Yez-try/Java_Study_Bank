package com.iu.start.bankAccount;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.bankMembers.BankMembersDTO;

public class BankAccountDAOTest extends MyAbstractTest{

	@Autowired
	private BankAccountDAO dao;
	@Test
	public void getListTest() throws Exception{
		BankMembersDTO member = new BankMembersDTO();
		member.setId("idtest2");
		List<BankAccountDTO> ar = dao.getListById(member);
		assertNotEquals(0, ar.size());
	}
}
