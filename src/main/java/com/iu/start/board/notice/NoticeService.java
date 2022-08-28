package com.iu.start.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO dao;
	@Autowired
	private ServletContext servletContext;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		

//		pager.getRow(); //mapper에서 사용할 startRow와 lastRow 계산		
//		pager.getPageBlock(totalCount);  //전체 개수 전달해 페이지수 및 블록 계산하기
		System.out.println("service getCount 이전"+pager.getSearch());
		Long totalCount = dao.getCount(pager); //전체 갯수 가져오기
		System.out.println("service getCount 이후"+pager.getSearch());
		pager.calNum(totalCount);
		System.out.println("service 페이지수 계산및 리스트 가져오기"+pager.getSearch());

		return dao.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		
		//1. 실제경로
		String realPath = servletContext.getRealPath("resources/upload/notice");
		
		//2. 폴더 확인
		File file = new File (realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		for (MultipartFile mf:files) {
			if(mf.isEmpty()) {
			}
		}
		return dao.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.setDelete(boardDTO);
	}


}
