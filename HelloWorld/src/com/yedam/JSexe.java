package com.yedam;

import java.util.Scanner; //

public class JSexe {
	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 30;
//		System.out.println(num1 == num2);

		String str1 = new String("Hello");
		String str2 = new String("Hello");
//		System.out.println(str1);
//		System.out.println(str2);
//		System.out.println(str1.equals(str2)); // 문자비교시 equals( )사용.


		// "30" vs 30
		String str3 = "30";
		int num3 = 30;
//		System.out.println(str3.equals("" + num3)); // 숫자를 문자로 바꿔서 비교위해 공백으로 연결.
		Integer.parseInt(str3); // 문자열숫자
		int num4 = Integer.parseInt(str3); // 문자열 숫자를 정수변수에 담으면 정수타입!.
//		System.out.println(num3 == num4);

		// test2(); //평균구하기
		// test3(); //스캐너로 입력값 받기.
		test4();

	} // end of main

	public static void test() {
		int sum = 0;
		// 1 ~10까지의 누적합.
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		} // for
		System.out.println("결과: " + sum);
	}// end of test.

	public static void test2() {
		// 임의의 수를 생성. 30 ~ 100 사이의 임의의 값 생성.
		// 누적합 평균: 실수값.

		int sum = 0;
		for (int i = 1; i < 6; i++) {
			int result = (int) (Math.random() * 71) + 30; // math.random 0 <= x < 1 [0과 1사이의 실수]
			sum += result;
		}

		double avg = sum / 7.0;

		System.out.println("결과: " + sum); // java lang 패키지
		System.out.println("결과: " + Math.round(avg * 100) / 100.0); // 소수점 2째자리까지 표현

		System.out.println("결과: " + Math.round(23.678 * 1000) / 1000.0); // 소수점 3째자리까지 표현
	} // end of test2.

	public static void test3() { // 사용자의 입력값을 읽어들이기.
		// java.util.Scanner scn; //Scanner클래스는 java utill패키지에 있씀!
		// Scanner scn; ctrl+shift+o로 패키지 import 단축키.

		Scanner scn = new Scanner(System.in); // 입력값으로 변수받음. //import되어 있어 바로사용가능..
		int sum = 0;
		for (int i = 1; i < 4; i++) {
			System.out.println("학생의 점수를 입력 >> ");
			String value = scn.nextLine(); // 입력값을 문자열형태로 반환.
			int score = Integer.parseInt(value);
			sum += score;
		}
		double avg = sum / 3.0;
		avg = Math.round(avg * 100) / 100.0;
		System.out.println("합계: " + sum + ",평균: " + avg);
	}// end of test3.

	
	
	public static void test4() {
		Scanner scn = new Scanner(System.in);
		String str = "친구목록은 ";   
		while (true) {
			System.out.println("친구이름 입력. 종료하려면 quit 입력 >>");
			String msg = scn.nextLine();
			if (msg.equals("quit")) { // equals비교.
				break;
			}
			str += msg +", ";
			System.out.println(str+"입니다."); 
//			System.out.println("입력한 값은 " + msg);
		}
		//홍길동, 김민규, 최석영
		//친구목록은 홍길동, 김민규, 최석영 입니다.
		System.out.println(str+"입니다.");
	}// end of test4.

}// end of class.
