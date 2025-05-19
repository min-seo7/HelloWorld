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
			System.out.println("-------------------------------------------------------");
			System.out.print("선택>  ");

			int selectNo = Integer.parseInt(scanner.nextLine());

			if (scores == null) {
				if (selectNo == 2 || selectNo == 3 || selectNo == 4) {
					System.out.println("1번 과정부터 시작해주세요.");
					continue;
				}
			} // 순차진행 경고.

			if (selectNo == 1) { // 학생수 입력.
				System.out.print("학생수>  ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum]; // 배열크기지정.

			} else if (selectNo == 2) { // 점수입력.
				for (int i = 0; i < scores.length; i++) { // 배열로 점수 입력.
					System.out.printf("scores[%d]> ", i);
					scores[i] = Integer.parseInt(scanner.nextLine());
				}

			} else if (selectNo == 3) { // 입력점수 확인.
				// 배열의 합이 0이면 점수 입력이 안되었으니 경고문구.
				int check = 0;
				for (int i = 0; i < scores.length; i++) {
					check += scores[i];
				}
				if (check == 0) {
					System.out.println("2번과정을 진행해주세요.");
					continue;
				}
				for (int i = 0; i < scores.length; i++) {   //배열에 점수추가 추가.
					System.out.printf("scores[%d]> %d\n", i, scores[i]);
				}
			} else if (selectNo == 4) { // 합계점수, 평균
				int max = 0, sum = 0;
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if (scores[i] > max) {
						max = scores[i];
					}
				}
				double avg = (1.0 * sum) / scores.length;
				System.out.printf("최고점수: %d\n평균점수: %.3f\n", max, avg);

			} else if (selectNo == 5) { // 종료
				run = false;
			}
		} // end of while.
		System.out.println("프로그램 종료.");
	}// end of Exam06.
}// end of class.
