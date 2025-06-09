package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVo;

/*
 * 인터페이스(BoardMapper)와 XML(BoardMapper.xml)파일 매칭작업. => 인터페이스에 선언되면 xml파일에 쿼리문 구현. 
 */ 
public interface BoardMapper { //기능들~ 
	public List<BoardVo> selectList();   //boardmapper의 아이디값 기준. 
	public List<BoardVo> selectListWithPaging(int page);  //페이징 SQL
	public BoardVo selectBoard(int bno); //단건조회
	public int updateReadCnt(int bno); //조회 count증가.
	public int insertBoard(BoardVo board);
	public int updateBoard(BoardVo Board);
	public int deleteBoard(int bno);
}
