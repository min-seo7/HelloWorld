package com.yedam.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVo;

//추가, 목록, 단건조회, 삭제
public class ReplyServiceImpl implements ReplyService {
	SqlSession sqlSession = DataSource.getInstance().openSession();
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

	@Override
	public boolean addReply(ReplyVo rvo) {
		int r = mapper.insertreply(rvo);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<ReplyVo> replyList(int bno, int page) {
		return mapper.selectList(bno, page);
		
	}

	@Override
	public ReplyVo getReply(int rno) {
		return mapper.selectReply(rno);
	}

	@Override
	public boolean removeReply(int rno) {
		int r = mapper.deletereply(rno);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public int totalCount(int bno) {
		return mapper.selectTotal(bno);
	}

}
