package com.yedam.condition;

import java.util.Scanner;

public class IfExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// 1 ~ 1000 사이의 임의의 값을 생성.
		// 500입력하면 "입력값보다 큽니다."
		// 400입력하면 "입력값보다 작습니다."
		// 임이의 값이 입력값과 동일할 때 break
		// 몇번 시도에 정답을 맞춘지? 시도회수. count++

		int randomValue = (int) ((Math.random() * 1000) + 1); // 랜덤수 생성.
		int count = 0;

		while (true) {
			System.out.print("임의의 수를 입력하세요>> ");
			int userNum = Integer.parseInt(scn.nextLine()); // 입력값.
			//입력값 조건 if
			if (randomValue == userNum) {  // 1. 입력값이 동일하면, 반복문 종료조건을 명시해 주는게 좋음! 
				System.out.println("입력값과 생성된 임의의 수 일치합니다.");
				break;
			} else if (randomValue > userNum) { // 2. 입력값이 작으면
				System.out.println("입력값이 작습니다.");
				count++;
			} else { // 3. 입력값이 크면
				System.out.println("입력값이 큽니다.");
				count++;
			}			
		}// end of while.
		System.out.printf("시도한 회수는 %d 입니다.", ++count);
	}



	public static void test() {
		int score = 80;
//		
//		//if문.    -조건제시시 순서도 중요. [90->80->70 =/= 70->80->90] 
//		if (score >= 90) {
//			System.out.println("A학점");
//		} else if (score >= 80) {
//			System.out.println("B학점");
//		} else if (score >= 70){
//			System.out.println("C학점");
//		} else {
//			System.out.println("불합격");
//		} end of if.

		score = score / 10;
		switch (score) {
		case 10:
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("불합격");
		} // end of switch.
	}// end of test

}