package com.yedam;

public class JSexe {
	public static void main(String[] args) {
		//임의의 수를 생성. 1 ~ 100 사이의 임의의 값 생성.
		// 1과 11사이의 수 생성
		
		int sum = 0;
		for (int i = 1; i < 6; i++) {
			int result = (int) (Math.random() * 100) + 1; //math.random   0 <= x < 1 [0과 1사이의 실수]
			sum += result;
		}
		System.out.println("결과: " + sum);
		
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

}// end of class.
