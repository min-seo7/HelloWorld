package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVo;

public interface MemberMapper {
	
	public MemberVo selectMember(@Param("id")String id, @Param("pw")String pw);    //mapper 구현시 parameterType을 두개 명시할 수 없어 어노테이션 사용. 
	//회원목록
	public List<MemberVo> selectList(String order);
	//회원추가. 
	public int insertMember(MemberVo member);
	//회원조회
	public MemberVo selectMemberInfo(String id);
	
}
