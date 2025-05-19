package com.yedam.ref;

/*
 * 배열 + 기본타입: 정수, 실수
 * 배열 + 참조타입(클래스): 학생이름, 점수 
 * 
 */

public class ArrayExe3 {

	static Student[] stdAry; // 배열선언. 선언만.

	public static void main(String[] args) { // 데이터 타입이 서로 다른 배열생성.

		init();
		int sum = 0;
		double max = 0;
		String maxName = "";
		Student maxStd = new Student(); // 최고점수 담는 인스턴스생성.
		// 배열의 값 출력.
		for (int i = 0; i < stdAry.length; i++) {
			System.out.printf("이름: %s 점수: %d\n", stdAry[i].studentName, stdAry[i].score);
			sum += stdAry[i].score;
			if (stdAry[i].height > max) { // 키- max
				maxStd.height = stdAry[i].height;
				
				maxStd.studentName = stdAry[i].studentName;
				maxStd.score = stdAry[i].score;
				maxStd.height = stdAry[i].height;
				maxStd.gender = stdAry[i].gender;
			}
		}

		double avg = (1.0 * sum) / stdAry.length;
		String strFmt = "가장 키가 큰 학생: %s, 점수: %d, 키: %.1f, 평균:%.2f";
		System.out.printf(strFmt, maxStd.studentName, maxStd.score, maxStd.height, avg);
		// test(); //Student 클래스 인스턴스 생성.

	}// end of main.

	public static void init() {  //배열 stdAry의 초기화. 
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
		s3.gender = Gender.MALE;

		stdAry = new Student[] { s1, s2, s3 }; // 선언된 stdAry 배열에 값(Student로 생성된 인스턴스) 할당.

	}

	public static void test() {

		int num1 = 90;

		// 홍길동, 80
		Student s1 = new Student(); // 인스턴스 생성.
		s1.studentName = "홍길동";
		s1.score = 80;

		// 김민규, 85
		Student s2 = new Student(); // Student 클래스를 갖는 인스턴스2 생성.
		s2.studentName = "김민규";
		s2.score = 85;

		s1.score = 90; // 할당된 값 변경방법.

		// 학생정보를 배열에 저장.
		Student[] students = { s1, s2 }; // Students[0]요소로 s1의 주소값을 가지고 있음.
		students[0].studentName = "홍길도"; // 참조하고 있는 주소값을 찾아가서 값변경.

		System.out.printf("이름: %s, 점수:%d\n", s1.studentName, s1.score);

	}// end of test.
} //end of ArrayExe3.
