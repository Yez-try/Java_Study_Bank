package com.iu.start.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO dao;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		Long totalCount = dao.getCount(); //전체 갯수 가져오기

		pager.getRowNum(); //mapper에서 사용할 startRow와 lastRow 계산		
		pager.getNum(totalCount);  //전체 개수 전달해 페이지수 및 블록 계산하기
		
//		System.out.println(page +"service");
//		
//		//페이지에 10개씩 출력을 기준으로 함
//		//page startRow lastRow
//		// 1   1         10    #1+9 
//		// 2   11        20
//		// 3   21        30
//		Long perPage= 15L; //한 페이지에 출력할 목록의 갯수
//		
//		Long startRow = ((page-1)*perPage +1);
//		Long lastRow = (page*perPage);
//		
//		Map<String, Long> map = new HashMap<String, Long>();
//		
//		map.put("startRow", pager.getStartRow());
//		map.put("lastRow", pager.getLastRow());
//		
//		
//		//JSP에 페이지번호를 출력 1-?
//		//1. 글의 총갯수를 이용해서 총 페이지 수 구하기
//		Long count = dao.getCount();
//		Long totalPage = ((count-1)/perPage+1);
////		totalPage = count%perPage==0 ? count/perPage : count/perPage+1;
//		
//		//2. totalBlock 갯수 구하기
//		//block : 
//		//perBlock : 한 페이지에 출력할 번호의 수
//		Long perBlock =5L;
//		Long totalBlock = ((totalPage-1)/perBlock+1);
//		
//		//3. page로 현재 Block 번호 찾기
//		//curBlock
//		
//		Long curBlock = (page-1)/perBlock+1;
//		
//		//4. 현재 블록 번호로 시작번호와 끝번호 알아오기
//		//startNum / lastNum
//		
//		Long startNum = (curBlock-1)*perBlock+1;
//		Long lastNum = curBlock*perBlock;
		

		return dao.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
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
