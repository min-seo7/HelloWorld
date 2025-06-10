package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVo;

public interface MemberMapper {
	public MemberVo selectMember(@Param("id")String id, @Param("pw")String pw);    //mapper 구현시 parameterType을 두개 명시할 수 없어 어노테이션 사용. 
}
