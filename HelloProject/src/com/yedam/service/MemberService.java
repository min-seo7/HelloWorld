package com.yedam.service;

import java.util.List;

import com.yedam.vo.Member;

/*
 * 업무로직 (등록, 변경, 삭제, 출력)
 * 
 */
public interface MemberService { //반환간 boolean 으로 지정하여 처리여부확인. 
	public boolean addMember(Member member);  //등록.  // Member 클래스 타입 변수 매개값으로 사용. import	
	public boolean modifyMember(Member member); //수정 & 변경.
	public boolean removeMember(String memverId); //삭제.
	public List<Member> memberList();  //목록출력위해 리스트 컬랙션 사용. 
}
