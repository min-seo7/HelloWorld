package com.yedam.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVo;

public class MemberServiceImpl implements MemberService{
	SqlSession sqlSession = DataSource.getInstance().openSession();
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public MemberVo login(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

	@Override
	public List<MemberVo> memberList(String order) {
		return mapper.selectList(order);
	}

	@Override
	public boolean addMember(MemberVo member) {
		int r = mapper.insertMember(member);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean getMemberInfo(String id) {
		MemberVo member = mapper.selectMemberInfo(id);
		if(member != null) {
			return true;
		}
		return false;
	}

}
