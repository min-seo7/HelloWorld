package com.yedam.Service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVo;
import com.yedam.vo.EventVO;

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DataSource.getInstance().openSession();
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class); // DB처리기능

	@Override
	public List<BoardVo> boardList(SearchDTO search) {
		//return mapper.selectListWithPaging(search);
		return mapper.selectList();
	}

	@Override
	public BoardVo getBoard(int bno) { // 글번호로 상세내용.
		BoardVo board = mapper.selectBoard(bno); // 글번호 -> 조회
		if (board != null) { // 해당 글 번호 조회수 증가.
			mapper.updateReadCnt(bno);
			sqlSession.commit();// 커밋해서 DB반영
		}
		return board;
	}

	@Override
	public boolean registerBoard(BoardVo board) {// insertBoard는 처리된 건수를 반환하므로 == 1.
		int r = mapper.insertBoard(board);
		if (r == 1) {
			sqlSession.commit();// 커밋처리
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyBoard(BoardVo board) {
		int r = mapper.updateBoard(board);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean removeBoard(int bno) {
		int r = mapper.deleteBoard(bno);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}


	@Override
	public int getTotalCount(SearchDTO search) {
		return mapper.selectCount(search);
	}

	@Override
	public List<Map> chartCount() {
		return mapper.selectUserByCount();
	}

	@Override
	public List<EventVO> eventList() {
		return mapper.selectEventList();
	}

	@Override
	public boolean addEvent(EventVO event) {
		int r = mapper.insertEvent(event);
		if(r == 1) {
			return true; 			
		}
		return false; 
	}

	@Override
	public boolean removeEvent(EventVO event) {
		int r = mapper.removeEvent(event);
		if(r == 1) {
			return true;			
		}
		return false;
	}	

}
