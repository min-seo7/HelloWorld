package com.yedam.Service;

import java.util.List;

import com.yedam.vo.BoardVo;

/*
 * 업무단위의 처리 ==> (ex. 신규사원등록을 하면 급여등 같이 하나의 덩어리 업무로 반영되도록)
 */
public interface BoardService {
	public List<BoardVo> boardList(); //목록조회
	public BoardVo getBoard(int bno); //단건조회
	public boolean registerBoard(BoardVo board); //등록기능
}
