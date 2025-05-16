package com.yedam.ref;
//p223 6번문제 풀기.
public class ArrayExe1 {
	public static void main(String[] args) {
		// math.random 활용해서 10 ~ 100 사이의 점수를 생성.
		// 학생 10명의 점수를 생성해서 학생점수의 평균을 구하고 최고점수 구하기.
		// scoreAry 변수명. [random 값 구해서 배열에 추가, 값 평균, 최고점수 구하기]

		double sum = 0;
		int max = 0;
		int[] scoreAry = new int[10];

		for (int i = 0; i < scoreAry.length; i++) {
			scoreAry[i] = (int) (Math.random() * 91) + 10;
			System.out.printf(" %d", scoreAry[i]);
			sum += scoreAry[i];
			if (scoreAry[i] > max) {
				max = scoreAry[i];
			}
		}
		System.out.printf("\n 학생들의 총점수:%d\n 평균점수: %.1f\n 최고점수: %d", (int)sum, (1.0*sum / scoreAry.length), max);

		// arr();
		// arrMax(); // 배열의 요소 중 최고값.
		// arrySum(); // 합.
		// p.183
		// test3();
		// test4();
		// test5();
		// test51();
		// test6();
		
	}// end of main.

	public static void arr() {
		// int 배열.
		int[] intAry = { 10, 7, 22, 31, 55, 44 };

		// 배열정렬
		int temp = 0;
		for (int j = 0; j < intAry.length - 1; j++)
			for (int i = 0; i < intAry.length - 1; i++) {
				if (intAry[i] < intAry[i + 1]) {
					temp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = temp;
				}
			}
	}

	public static void arrMax() {
		int[] intAry = { 10, 7, 22, 31, 55, 44 };
		int max = 0;
		for (int i = 0; i < intAry.length; i++) {
			if (intAry[i] > max) {
				max = intAry[i];
			}
		}
		System.out.printf("최대값은 %d\n", max);
		if (max != 0) {
			return;
		}
	}// end of arrMax.

	public static void arrySum() {
		int[] intAry = { 10, 7, 22, 31, 55, 44 };

		int sum = 0;
		for (int i = 0; i < intAry.length; i++) { // i++도 여러 조건으로 변경가능[ i+=2, i +=3 등등, 감소도 가능. ]
			sum += intAry[i];
			System.out.printf("sum: %d, intAry[%d]값: %d\n", sum, i, intAry[i]);
		}
	}// and of arrySum.

	public static void test3() {
		while (true) {
			int randomNum1 = (int) (Math.random() * 6) + 1;
			int randomNum2 = (int) (Math.random() * 6) + 1;

			System.out.printf("(%d, %d)", randomNum1, randomNum2);

			if ((randomNum1 + randomNum2) == 5) {
				break;
			}
		} // end of while.
	}// end of test3

	public static void test4() {
		int sum = 0;
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				sum = (4 * i) + (5 * j);
				if (sum == 60) {
					System.out.printf("x의 값: %d, y의 값: %d\n", i, j);
				}
			} // end of for(y).
		} // end of for(x).
	}// end of test4.

	public static void test5() {
		String star = "*";
		String sum = "";
		for (int i = 0; i < 5; i++) {
			sum += star;
			System.out.println(sum);
		}
	}// end of test5.

	public static void test51() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j <= i) {
					System.out.print("*");
				}
			} // end of for(j).
			System.out.println();
		} // end of for(i).
	}// end of test51.

	public static void test6() {
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) {
				if ((j + i) >= 4) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			} // end of for(j).
			System.out.println();
		} // end of for(i).
	}// end of test6.

}// end of class
