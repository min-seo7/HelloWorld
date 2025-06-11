package com.yedam.Service;

import java.util.List;

import com.yedam.vo.MemberVo;

public interface MemberService {
	public MemberVo login(String id, String pw);
	public List<MemberVo> memberList(String order);
}
