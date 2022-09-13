package com.iu.start.bankMembers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;

public class BankMembersDAOTest extends MyAbstractTest{
	@Autowired
	private BankMembersDAO dao;

	@Test
	public void Logintest() throws Exception{
		BankMembersDTO dto = new BankMembersDTO();
		dto.setId("hi");
		dto.setPw("hi");
		
		BankMembersDTO result = dao.getLogin(dto);
		for(RoleDTO role:result.getRoleDTOs()) {
			System.out.println(role.getRoleName());
			
		}
		
		
		
		assertNotNull(result.getRoleDTOs());
		
	}

}
