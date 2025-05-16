package com.yedam.ref;

import java.util.Scanner;

public class ArrayExe {
	public static void main(String[] args) {
		// strAry(); //문자열 배열.
		// deleteAry(); //값이 있는 배열의 값 삭제.
		friendApp(); // 친구정보관리.
	}

	public static void friendApp() {
		Scanner scn = new Scanner(System.in);
		String[] friendAry = new String[10];

		boolean run = true;
		while (run) {  
			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			System.out.print("선택>> ");
			// 1 ~ 4 선택
			int menu = Integer.parseInt(scn.nextLine());
			//
			switch (menu) {
			case 1: // 추가 [기존 리스트에 존재하는 이름입니다. 1.추가 2.취소]
				System.out.print("친구 이름입력>> ");
				String name = scn.nextLine();
				// name으로 받은 값 배열에 추가하는 반복문
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] == null) {
						friendAry[i] = name;
						break;
					}
				} // 추가 for
				break;
			case 2: // 목록
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						System.out.printf("친구 리스트[%d]번째: %s\n", i + 1, friendAry[i]);
					}
				}
				break;
			case 3: // 삭제 [입력값, 비교, 삭제] + @리스트상에 없는 이름 확인.
				System.out.print("삭제할 친구이름 입력>> ");
				String delname = scn.nextLine();

				boolean isExist = false;
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null && friendAry[i].equals(delname)) {
						friendAry[i] = null;
						isExist = true;
						break;
					}
				}
				if (!isExist) {
					System.out.println("리스트에 없는 이름입니다.");
				}
				break;
			case 4: // 종료
				if (menu == 4) {
					run = !run;
				}
				break;
			}// end of switch.

		} // end of while.

	}// end of friendApp.

	public static void deleteAry() {
		Scanner scn = new Scanner(System.in);
		String[] stringAry = new String[10];
		stringAry[0] = "홍길동";
		stringAry[1] = "김친구";
		stringAry[2] = "김태완";
		stringAry[3] = "김태희";

		System.out.println("삭제할 친구 이름>>  ");
		String name = scn.nextLine();
		// 이름 비교후 삭제.
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null && stringAry[i].equals(name)) {
				stringAry[i] = null;
			}
		} // end of for.
			// 배열값 출력.
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		} // end of for.
	}// end of delete.

	// 문자열 배열. [배열에 이름추가]
	public static void strAry() {
		Scanner scn = new Scanner(System.in);

		String[] stringAry = new String[10];
		// 이름을 배열에 추가.
		while (true) {
			System.out.println("이름입력>>  ");
			String name = scn.nextLine();

			// while문 종료조건.
			if (name.equals("quit")) {
				break;
			}
			// 배열에 빈공간 check & 값추가.
			for (int i = 0; i < stringAry.length; i++) {
				if (stringAry[i] == null) {
					stringAry[i] = name;
					System.out.println("입력성공.");
					break;
				}
			} // end of for.
		} // end of while
			// 배열입력값 출력(조건:null이 아닐 때).
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		} // end of for.
		System.out.println("end of prog.");

	}// end of strAry

}
