package com.iu.start.bankMembers;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	private ServletContext servlectContext;
	
	@Autowired
	private BankMembersDAO dao;
	
	@Autowired
	private BankAccountDAO accountDAO;
	
//	public Map<String, Object> getMine(BankMembersDTO dto) throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		dto = dao.getMine(dto);
//		List<BankAccountDTO> list = accountDAO.getListById(dto);
//		
//		map.put("list", list);
//		map.put("dto", dto);
//		
//		return map;
//	}
	
	
	public BankMembersDTO getMine(BankMembersDTO dto) throws Exception{
		
		dto = dao.getMyPageResult(dto);
//		dto = dao.getMine(dto);
		
		return dto;
	}
	
	public BankMembersDTO getLogin(BankMembersDTO dto) throws Exception{
		return dao.getLogin(dto);
	}
	
	public int setJoin(BankMembersDTO bmdto, MultipartFile photo) throws Exception {
		
		//1. hDD에 파일을 저장
		// 파일 저장시에 파일의 경로는 Tomcat기준이 아니라 OS의 기준으로 설정
		// 1) 파일저장 위치
		//   /resources/upload/member
		// 2) 저장할 폴더의 실제경로 반환(OS기준)
		String realPath = servlectContext.getRealPath("resources/upload/member");
		System.out.println("realpath ;"+realPath);
		
		//3) 저장할 폴더의 정보를 가지는 자바 객체 생성
		File file = new File(realPath);

		if(!file.exists()) {
			file.mkdirs();
		}
		//***file첨부가 없을때 구분
//		if(photo.getSize()!=0) {}
		if(!photo.isEmpty()) {
			
		
		
		
		//4) 중복되지 않는 파일명 생성
		String fileName =UUID.randomUUID().toString();
		System.out.println(fileName);
		
		Calendar ca = Calendar.getInstance();
		Long time = ca.getTimeInMillis();
		fileName = fileName+"__"+photo.getOriginalFilename();
		System.out.println(fileName);
		
		//5) HDD에 파일 저장
		file = new File(file, fileName);
//		       //1. mutipartfile 클래스의 transforto 메서드 사용
		photo.transferTo(file);
				//2. filecopy
		
		//2. 저장된 파일 정보를 DB에 저장
		//파일이름이랑 올릴때 이름을 저장할거임 그러므로 테이블이 필요함
		//회원 한명당 사진 하나올리므로 1:1관계이므로 member에 컬럼을 추가해도 됨
		//이번엔 만들어서 join하자
		BankMembersFileDTO membersFileDTO  = new BankMembersFileDTO();
		membersFileDTO.setFileName(photo.getOriginalFilename());
		membersFileDTO.setOriName(fileName);
		membersFileDTO.setUserName(bmdto.getId());
		dao.setAddFile(membersFileDTO);
		
		
		
		
		}//isEmpty 끝
		return dao.setJoin(bmdto);
	}
	
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		return dao.getSearchByID(search);
	}
}
