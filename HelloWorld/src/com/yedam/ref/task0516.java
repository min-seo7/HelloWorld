package com.yedam.ref;

import java.util.Scanner;

public class task0516 {

	public static void main(String[] args) {

		Exam06();

	}// end of main.

	public static void Exam06() {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("선택>  ");

			int selectNo = Integer.parseInt(scanner.nextLine());

			if (selectNo == 1) {

				System.out.println("학생수>  ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
				
			} else if (selectNo == 2) {		
				
				for (int i = 0; i < scores.length; i++) {
					if (scores[i] != 0) {  //1번재 학생이 0점이면 안걸러짐! 
						System.out.println("입력가능한 학생수 초과! 학생수를 다시 지정해주세요.");
						break;
					}
					System.out.printf("scores[%d]> ", i);
					scores[i] = Integer.parseInt(scanner.nextLine());
				}

			} else if (selectNo == 3) {

				for (int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d]> %d\n", i, scores[i]);
				}

			} else if (selectNo == 4) {

				int max = 0;
				int sum = 0;

				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if (scores[i] > max) {
						max = scores[i];
					}
				}
				double avg = (1.0 * sum) / scores.length;
				System.out.printf("최고점수: %d\n평균점수: %.3f\n", max, avg);

			} else  if (selectNo == 5) {
				run = false;
			}
		} // end of while.

	}// end of Exam06.
}// end of class.
