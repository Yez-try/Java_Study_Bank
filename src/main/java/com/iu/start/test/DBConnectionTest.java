package com.iu.start.test;

import java.sql.Connection;
import java.util.ArrayList;

import com.iu.start.bankMembers.BankMembersDAO;
import com.iu.start.bankMembers.BankMembersDTO;
import com.iu.start.util.DBConnector;

public class DBConnectionTest {

	public static void main(String[] args) {
		BankMembersDTO bmdto = new BankMembersDTO();
		BankMembersDAO bmdao = new BankMembersDAO();
		
//		bmdto.setId("idtest4");
//		bmdto.setPw("pwtest4");
//		bmdto.setEmail("emai1l2@naver.com");
//		bmdto.setLv("NORMAL");
//		bmdto.setPhone("010-5847-6666");
//		bmdto.setName("이네임");
//		
//		int chk = bmdao.setJoin(bmdto);
//		
//		System.out.println(chk == 1? "성공": "실패");
		
		ArrayList<BankMembersDTO> arr= new ArrayList();
		
		try {
			arr = bmdao.getSearchByID("test");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("총" + arr.size()+ "개");
		for (BankMembersDTO b : arr) {
			System.out.println(b.getId());
			System.out.println(b.getName());
			System.out.println(b.getEmail());
			System.out.println(b.getPhone());
			System.out.println(b.getLv());
			System.out.println("=========================");
		}

	}

}
