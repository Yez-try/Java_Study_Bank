package com.iu.start;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DBTest {

	@Autowired
	private SqlSession sqlsession;
	@Test
	public void test() {
		//단정문 
//		assertNotNull(sqlsession); //: Null이 아니길 희망함
		assertNull(sqlsession); //널이길 희망함
		

	}

}
