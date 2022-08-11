package com.iu.start.test;

import java.util.Calendar;

import com.iu.start.accountList.AccountListDAO;
import com.iu.start.accountList.AccountListDTO;

public class TestMain {

	public static void main(String[] args) {
//		System.out.println( Calendar.getInstance().getTimeInMillis());
		//DAO는 여기서 테스트한다.
		
		AccountListDAO aldao = new AccountListDAO();
		AccountListDTO dto = new AccountListDTO();
		
		dto.setAcId(2382255456656L);
		dto.setAcName("테스트적금2");
		dto.setAcRate(88.1);
		
		int i = 100;
		try {
			i = aldao.setUpdate(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i);
		
		
	}

}
