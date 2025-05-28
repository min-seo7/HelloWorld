package com.yedam.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceDAO;
import com.yedam.vo.Member;

/*
 * 사용자의 입력값을 등록, 수정, 삭제, 목록리스트 기능을 실행. 
 */
public class MemberApp {
	public void execute() {
		Scanner scn = new Scanner(System.in);
		MemberService svc = new MemberServiceDAO();    //메소드로 구현된 기능 사용하기위해 객체생성. 
		
		System.out.println("----------------------------------------");
		System.out.println("1.회원등록 2.정보수정 3.회원삭제 4.목록보기 5.종료");
		System.out.println("----------------------------------------");
		System.out.println("선택>>  ");
		
		//메뉴선택
		int menu = Integer.parseInt(scn.nextLine());
		
		switch(menu) {
		case 1: //등록
			System.out.println("회원아이디>>");
			String mid = scn.nextLine();
			System.out.println("회원이름>>");
			String name = scn.nextLine();
			System.out.println("연락처>>");
			String phone = scn.nextLine();
			System.out.println("포인트>>");
			String point = scn.nextLine();
			Member member = (new Member(mid, name, phone, Integer.parseInt(point)));
			if(svc.addMember(member)) {
				System.out.println("등록완료.");
			} else {
				System.out.println("등록실패.");
			}
			break;
		case 2: //수정
			
		case 3: //삭제
			System.out.println("삭제할 아이디를 입력>> ");
			mid = scn.nextLine();
			
			if(svc.removeMember(mid)) {
				System.out.println("삭제완료.");
			} else {
				System.out.println("삭제실패.");
			}
		case 4: //목록
			List<Member> list = svc.memberList();
			System.out.println("회원ID    회원이름    연락처  포인트  ");
			System.out.println("===============================");
			for(Member members : list ) {
				System.out.printf("%s   %s   %s    %d", members.getMemberId(), members.getMemberName(), members.getPhone(), members.getPoint());
			}
		case 5: //종료
			menu = 0;
			System.out.println("프로그램을 종료합니다.");
			break;
			
		}//end of switch.
		
	}//end of execute()
}
