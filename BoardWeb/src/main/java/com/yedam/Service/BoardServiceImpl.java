package com.yedam.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVo;

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DataSource.getInstance().openSession();
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class); // DB처리기능

	@Override
	public List<BoardVo> boardList() {
		return mapper.selectList();
	}

	@Override
	public BoardVo getBoard(int bno) {
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

}
