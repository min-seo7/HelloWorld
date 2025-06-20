package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVo;
import com.yedam.vo.EventVO;

/*
 * 인터페이스(BoardMapper)와 XML(BoardMapper.xml)파일 매칭작업. => 인터페이스에 선언되면 xml파일에 쿼리문 구현. 
 */ 
public interface BoardMapper { //기능들~ 
	public List<BoardVo> selectList();   //boardmapper의 아이디값 기준. 
	public List<BoardVo> selectListWithPaging(SearchDTO search);  //페이징 SQL
	public BoardVo selectBoard(int bno); //단건조회
	public int updateReadCnt(int bno); //조회 count증가.
	public int insertBoard(BoardVo board);
	public int updateBoard(BoardVo Board);
	public int deleteBoard(int bno);
	
	public int selectCount(SearchDTO search); //전체 글 카운트 
	public List<Map> selectUserByCount();// join한 테이블 vo안만들고 map타입으로 ~ 
	
	//이벤트 
	public List<EventVO> selectEventList();
	public int insertEvent(EventVO event);
	public int removeEvent(EventVO event);
	
}
