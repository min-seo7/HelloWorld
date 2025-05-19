package com.yedam.ref.app;

import java.util.Scanner;

import com.yedam.ref.Student;

/*
 *  회원 추가, 수정, 삭제, 조회 기능.
 *  1) 추가
 *  -아이디, 이름, 전화번호, 포인트
 *  2) 수정
 *  -아이디(아이디기준 검색)해서 전화번호 수정
 *  -전화번호(바뀔항목)
 *  3) 삭제
 *  아이디 검색해서 삭제하고, 없으면 해당아이디 없음 
 *  4) 조회
 *  이름검색으로 조회. 
 */
public class MemeberExe {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int memberNum = 0;
		Member[] memberAry = null;
		
		while (run) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1. 회원추가 | 2. 수정 | 3. 삭제 | 4. 조회 |5. 종료");
			System.out.println("-------------------------------------------------------");
			System.out.print("선택>  ");

			int select = Integer.parseInt(scn.nextLine());

			if (select == 1) { // 회원추가
				System.out.println("추가할 회원수를 입력해 주세요. >>");
				memberNum = Integer.parseInt(scn.nextLine());
				memberAry = new Member[memberNum]; // 배열크기지정.

				for (int i = 0; i < memberAry.length; i++) {
					System.out.println("등록할 아이디를 입력해 주세요. >>");
					String id = scn.nextLine();
					System.out.println("회원의 성함을 입력해 주세요. >>");
					String name = scn.nextLine();
					System.out.println("전화번호를 입력. >>");
					String number = scn.nextLine();
					System.out.println("포인트 적립. >>");
					int point = Integer.parseInt(scn.nextLine());

					Member member = new Member();
					member.userID = id;
					member.userName = name;
					member.phone = number;
					member.point = point;	
					memberAry[i] = member;    //배열에 넣어줌!!!! 
				} // end of for.
			
			} else if (select == 2) { // 수정
				System.out.println("수정할 아이디를 입력해 주세요. >>");
				String newId = scn.nextLine();
				for (int i = 0; i < memberAry.length; i++) {
					if (newId.equals(memberAry[i].userID)) {
						System.out.println("수정할 연락처를 입력해 주세요.");
						String newPhone = scn.nextLine();
						memberAry[i].phone = newPhone;
					}
				}
			} else if (select == 3) { // 삭제
				boolean isExist = false;
				System.out.println("삭제할 아이디를 입력해 주세요.>>");
				String delId = scn.nextLine();
				for (int i = 0; i < memberAry.length; i++) {
					if (delId.equals(memberAry[i].userID)) {
						memberAry[i] = null;  // 배열을 null로 지정하니 null Exception 발생! 
						isExist = true;
						break;
					} 
				}				
				if (!isExist) {   //아이디는 비교를 하되, 문구는 한번만. 
					System.out.println("해당아이디가 없습니다.");
				}
			} else if (select == 4) { // 조회
				for (int i = 0; i < memberAry.length; i++) {
					System.out.printf("회원아이디: %s, 이름: %s, 전화번호: %s, 잔여포인트: %d\n",  memberAry[i].userID, memberAry[i].userName, memberAry[i].phone,memberAry[i].point);
				}
			} else if (select == 5) { // 종료
				run = false;
			}

		}

	}// end of main.
} // end of class
