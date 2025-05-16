package com.yedam.ref;

public class NullExe {
	public static void main(String[] args) {
		String str1 = "홍길동";
		String str2 = null;

		/*
		 * js배열선언 let ary = [10, "string", 11.2] -> 타입상관x
		 */

		// java 배열선언
		/* 형식1: */ int[] ary = { 10, 20, 30 };
		// 선언과 초기화
		/* 형식2: */ int ary1[] = { 10, 20, 30 };
		System.out.printf("ary 배열의 크기 %d\n", ary.length);

		int[] intAry; // 배열선언.
		intAry = new int[] { 40, 50, 60 }; // 선언된 변수에 값 할당.

		// 배열 Ary의 첫번째 위치 값, '40'을 '400'으로 변경.
		intAry[0] = 400;

		// 인덱스가 3이면, 배열의 4번째 위치.
		// intAry[3] = 10; //오류발생: Index 3 out of bounds

		// for반복문
		for (int i = 0; i < 3; i++) {
			System.out.printf("[%d]번째의 값: %d\n", i, intAry[i]);
		} // end of for.

		// 배열은 선언하면 크기가 고정. (선언된 배열의 크기는 변경불가.)
		// 크기를 변경하려면 새로 선언.
		intAry = new int[5]; // 크기를 변경하기 위해 새로 선언되면 초기값으로 0 반환되어 값을 재할당해주어야 함.
		intAry[0] = 40;
		intAry[1] = 50;
		intAry[2] = 60;
		intAry[3] = 10;
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("intAry[%d]번째의 값: %d\n", i, intAry[i]);
		} // end of for.

		// 배열선언: double 값을 담는 배열 dblAry
		double[] dbAry = { 10.2, 23.2, 34.5 };
		for (int i = 0; i < dbAry.length; i++) {
			System.out.printf("dbAry[%d]번째의 값: %.1f\n", i,dbAry[i]);
		}//end of for.
		
		String[] strAry = new String[10];//배열크기지정, 초기값 null
		for (int i = 0; i < strAry.length; i++) {
		System.out.printf("strAry[%d]번째의 값: %s\n", i,strAry[i]);
	}//end of for.
		
	}
}
