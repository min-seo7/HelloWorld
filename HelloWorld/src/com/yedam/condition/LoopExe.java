package com.yedam.condition;

import java.util.Scanner;

public class LoopExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// "가위 = 1, 바위 = 2, 보 =3"
		
		

		while (true) {
			int randomValue = (int) ((Math.random() * 3) + 1);
			System.out.println(randomValue);
			System.out.println("[가위: 1, 바위: 2, 보: 3, 종료: 4] 중 하나의 수 를 입력하세요.");
			int userInsert = Integer.parseInt(scn.nextLine());
			if (userInsert == 4) {
				System.out.println("게임을 종료합니다.");
				break;
			} else if (userInsert < 1 || userInsert > 4) {
				System.out.println("다시입력");
			} else {
				// 이기는조건
				if ((userInsert == 1 && randomValue == 3) || (userInsert == 2 && randomValue == 1)
						|| (userInsert == 3 && randomValue == 2)) {
					System.out.println("이김.");
				} else if ((userInsert == 1 && randomValue == 2) || (userInsert == 2 && randomValue == 3)
						|| (userInsert == 3 && randomValue == 1)) {
					System.out.println("짐.");
				} else if (userInsert == randomValue) {
					System.out.println("same");
				}
			}

		}

	}
	
	// 1. 비긴거 (입력값 동일), 가위1-보3,바위2-가위1,보3-바위2 4.종료.

	public static void test() {
		// while vs. do - while
		boolean run = false;

//		while(run = !run) {
//			System.out.println("while문");
//		}

		do { // 블록안의 코드를 반드시 한번은 실행함.
			System.out.println("while문");
		} while (run = !run);

		System.out.println("end of prog.");

	}// end of main.
}

