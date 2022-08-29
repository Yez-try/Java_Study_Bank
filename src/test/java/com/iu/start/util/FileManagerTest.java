package com.iu.start.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;

public class FileManagerTest extends MyAbstractTest{
	
	@Autowired
	private FileManager fileManager;

	@Test
	public void saveFiletest() {
		System.out.println("시작");
		
//		fileManager.saveFile("resources/upload/test");
		
		System.out.println("끝");
	}

}
