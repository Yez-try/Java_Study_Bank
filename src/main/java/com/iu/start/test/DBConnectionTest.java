package com.iu.start.test;

import java.util.ArrayList;

import com.iu.start.accountList.AccountListDAO;
import com.iu.start.accountList.AccountListDTO;
import com.iu.start.bankMembers.BankMembersDAO;
import com.iu.start.bankMembers.BankMembersDTO;

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
		
		
//		ArrayList<BankMembersDTO> arr= new ArrayList();
//		arr = bmdao.getSearchByID("test");
//		System.out.println("총" + arr.size()+ "개");
//		for (BankMembersDTO b : arr) {
//			System.out.println(b.getId());
//			System.out.println(b.getName());
//			System.out.println(b.getEmail());
//			System.out.println(b.getPhone());
//			System.out.println(b.getLv());
//			System.out.println("=========================");
//		}
		
		
		AccountListDTO DTOal = new AccountListDTO();
		ArrayList<AccountListDTO> arral = new ArrayList<AccountListDTO>();
		
		AccountListDAO daoal = new AccountListDAO();
		
		
//		DTOal.setAcName("적금이자율이이거면좋겠다");
//		DTOal.setAcRate(99.45);
//		if(daoal.setAccountList(DTOal)==1) {
//			System.out.println("성공");
//		}
//		else{
//			System.out.println("실패");
//		};
		
		try {
			arral = daoal.getList();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (AccountListDTO d : arral) {
			System.out.println(d.getAcId());
			System.out.println(d.getAcName());
			System.out.println(d.getAcRate());
			System.out.println(d.getAcSale());
			System.out.println("==================");
		}
		
		//getdetail 과 setchangesale 테스
		DTOal.setAcId(1659511280341L);
		
		try {
			DTOal = daoal.getDetail(DTOal);
			
			System.out.println(DTOal.getAcId());
			System.out.println(DTOal.getAcName());
			System.out.println(DTOal.getAcRate());
			System.out.println(DTOal.getAcSale());
			
			DTOal.setAcSale(0);
			
			int chk = daoal.setChangeSale(DTOal);
			if(chk==1) {
				System.out.println("변경완료");
			}else{
				System.out.println("변경실패");
				System.out.println(chk);
			};
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		}


}
