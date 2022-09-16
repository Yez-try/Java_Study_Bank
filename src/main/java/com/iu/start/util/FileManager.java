package com.iu.start.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.file.FileDTO;

@Component
public class FileManager {
	
//	@Autowired
//	private ServletContext;
	
	//HDD에서 파일 삭제
	public boolean deleteFile(ServletContext servletContext/*실제경로 받으려고*/, String path, FileDTO dto) throws Exception{
		String realPath = servletContext.getRealPath(path);
		File file = new File(realPath, dto.getFileName()); //파일의 정보를 가진 File객체
		
		boolean result = file.delete(); //해당 파일을 지우자
		
		return result;
	}
	
	//save
	public String saveFile(ServletContext servletContext, String path, MultipartFile multipartfile) throws Exception{
		//1. 실제 경로
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		
		//2. 폴더(directory)체크
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//3. 저장할 파일명 생성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"-"+multipartfile.getOriginalFilename();
		
		
		//4. HDD에 저장
		file = new File(file, fileName);
		multipartfile.transferTo(file);
		
		
		return fileName;
	}

}
