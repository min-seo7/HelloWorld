package com.yedam.Service;

import java.util.List;

import com.yedam.vo.MemberVo;

public interface MemberService {
	public MemberVo login(String id, String pw);
	//회원목록
	public List<MemberVo> memberList(String order);
	//회원등록
	public boolean addMember(MemberVo member); 
	//회원가입시 기존아이디 여부check
	public boolean getMemberInfo(String id);
}
