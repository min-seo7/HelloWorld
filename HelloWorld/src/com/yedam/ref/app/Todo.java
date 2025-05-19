package com.yedam.ref.app;

public class Todo {
	public static void main(String[] args) {
		int[][] numAry = new int[3][5];
		// 임의의 숫자 생성.
		
		for (int outer = 0; outer < numAry.length; outer++) {
			int sum = 0;
			for (int inner = 0; inner < numAry[outer].length; inner++) {
				numAry[outer][inner] = (int) (Math.random() * 100);
				//System.out.printf("numAry[%d][%d] ==> %d\n", outer, inner, numAry[outer][inner] ); //배열요소 확인.
				sum += numAry[outer][inner];  //누적합. 
			}//end of inner.
			//System.out.printf("numAry[%d]의 합: %d\n", outer, sum);  //행별로 누적합 출력. 
			double avg = (1.0 * sum) / numAry[outer].length ;
			System.out.printf("numAry[%d]의 평균은 %.2f\n", outer, avg);
		}//end of outer.
	}//end of main. 
}
