package com.yedam.ref;

import java.util.Scanner;

public class task0516addname {
	static Student[] scores = null; // 배열의 크기는 입력값으로 받을꺼라 null 초기화.

	public static void main(String[] args) {
		init(); // 초기데이터 생성.

		boolean run = true;
		int studentNum = 0;
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
				scores = new Student[studentNum]; // 배열크기지정.

			} else if (selectNo == 2) { // 점수입력.
				for (int i = 0; i < scores.length; i++) { // 배열로 점수 입력.

					System.out.printf("scores[%d] 이름> ", i);
					String name = scanner.nextLine();
					System.out.printf("scores[%d] 점수> ", i);
					int score = Integer.parseInt(scanner.nextLine());
					System.out.printf("scores[%d] 키> ", i);
					double height = Double.parseDouble(scanner.nextLine());
					System.out.printf("scores[%d] 성별> ", i);
					String gender = scanner.nextLine();
					Gender gen = Gender.MALE; // Gender 클래스를 갖는 gen 변수선언후 초기값 할당.
					if (gender.equals("남") || gender.equals("남자")) { // 입력되는 값으로 남, 남자, Man, M ==> 열거형, Gender male로 일괄성유지. 
						gen = Gender.MALE;
					} else if (gender.equals("여") || gender.equals("여자")) {
						gen = Gender.FEMALE;
					}

					Student student = new Student(); // 인스턴스 생성후 입력값 할당.
					student.studentName = name;
					student.score = score;
					student.height = height;
					student.gender = gen;
					scores[i] = student;

				}
			} else if (selectNo == 3) { // 입력된 이름, 점수 출력
				if (scores == null) {
					System.out.println("2번과정을 진행해주세요.");
				}
				System.out.println("검색조건: '남' 또는 '여' >> ");
				String keyword = scanner.nextLine(); // 남, 여, 엔터
				Gender gen = Gender.MALE; // 초기화
				if (keyword.equals("남") || keyword.equals("남자") || keyword.equals("Men") || keyword.equals("M")) {
					gen = Gender.MALE;
				} else if (keyword.equals("여") || keyword.equals("여자") || keyword.equals("Women")
						|| keyword.equals("W")) {
					gen = Gender.FEMALE;
				}
				for (int i = 0; i < scores.length; i++) { // 배열에 점수추가 추가.
					if (keyword.equals("") || gen == scores[i].gender) { // 성별 or 전체로 지정하여 출력.
						System.out.printf("학생이름: %s 점수: %d 키: %.1f 성별: %s\n", scores[i].studentName, scores[i].score,
								scores[i].height, scores[i].gender);
					}
				}
			} else if (selectNo == 4) {
				double max = 0, sum = 0;
				Student maxStd = new Student(); // 최고점수정보 담을 인스턴스 생성.
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i].score; // 점수누적합.
					if (scores[i].height > max) { // 최고점수 확인.
						max = scores[i].height;
						maxStd.studentName = scores[i].studentName;
						maxStd.score = scores[i].score;
						maxStd.height = scores[i].height;
						maxStd.gender = scores[i].gender;
					}
				}
				double avg = (1.0 * sum) / scores.length;
				System.out.printf("가장 키가 큰 학생이름: %s 키: %.1f 평균점수: %.3f \n", maxStd.studentName, maxStd.height, avg);

			} else if (selectNo == 5) { // 종료
				run = false;
			}
		} // end of while.
		System.out.println("프로그램 종료.");
	}// end of Exam06.

	public static void init() { // 배열 stdAry의 초기화.
		Student s1 = new Student(); // 인스턴스 생성.
		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height = 170.8;
		s1.gender = Gender.MALE;

		Student s2 = new Student();
		s2.studentName = "김민선";
		s2.score = 85;
		s2.height = 165.7;
		s2.gender = Gender.FEMALE;

		Student s3 = new Student();
		s3.studentName = "박철민";
		s3.score = 90;
		s3.height = 180.3;
		s3.gender = Gender.MALE; // 성별 작성이 통일되지 않을때, 남 or 남자 => 일괄되게 입력하도록 열거형 사용.

		scores = new Student[] { s1, s2, s3 };
	}// end of main.

}// end of class
