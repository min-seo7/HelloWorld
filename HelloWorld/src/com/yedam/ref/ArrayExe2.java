package com.yedam.ref;

/*
 * 2차원 배열
 * intAry[2][3]*/
public class ArrayExe2 {
	public static void main(String[] args) {
		int[][] intAry = { { 17, 22, 31, 55 }, { 28, 38, 12 } }; // 배열 선언시 초기화.
		// intAry[0] = {17, 22, 31}; 17=> intAry[0][0], 22=>intAry[0][1]
		// intAry[1] = {28, 38, 12};

		intAry[0][2] = 44;
		for (int outer = 0; outer < intAry.length; outer++) {
			for (int inner = 0; inner < intAry[outer].length; inner++) {
				System.out.printf("intAry[%d][%d] = %d \n", outer, inner, intAry[outer][inner]);
			}
		}

		int[][] ary2 = new int[3][4]; // 배열크기 지정. intType 배열의 초기값 = 0

		// (int)(Math.random() * 100) + 1;
		int sum = 0;
		for (int out = 0; out < ary2.length; out++) {
			for (int in = 0; in < ary2[out].length; in++) {
				ary2[out][in] = (int) (Math.random() * 100) + 1;
				if (out == 1) { // ary2[1]위치만 합.
					sum += ary2[out][in];
				}
				System.out.printf("ary2[%d][%d] => %d\n", out, in, ary2[out][in]);
			}	
		}
		System.out.printf("ary2[1] 요소의 합: %d\n", sum);
	}
}
