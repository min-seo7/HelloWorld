package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVo;

/*
 * 인터페이스(BoardMapper)와 XML(BoardMapper.xml)파일 매칭작업.
 */
public interface BoardMapper {
	public List<BoardVo> selectList();   //boardmapper의 아이디값 기준. 
	public int insertBoard(BoardVo board);
	public int updateBoard(BoardVo Board);
	public int deleteBoard(int bno);
}
