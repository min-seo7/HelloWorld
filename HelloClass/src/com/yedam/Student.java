package com.yedam;

/*
 * 라이브러리 클래스.
 */
public class Student { // static이 없는 class는 인스턴스(=객체)가 선언되어야 사용가능.
	// 필드(속성)  => 외부클래스에서 필드에 직접접근보다 메소드를 통해서 값할당.
	private int studentNo;
	private String studentName;
	private double height;
	private int engScore;
	private int mathScore;

	// 생성자(객체= instance의 초기화)
	public Student() { // 생성자를 정의하지 않아도 컴파일러가 자동 기본생성자를 생성함.
		// 매개값이 없는 생성자 => 기본생성자
	}

	public Student(int studentNo, String studentName) { // 매개값을 갖는 생성자.
		this.studentNo = studentNo; // 첫번째 매개값은 학생번호 할당.
		this.studentName = studentName; // 두번째 매개값은 학생이름을 할당.
	}

	public Student(int studentNo, int engScore, int mathScore) {
		this.studentNo = studentNo;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	// 메소드(기능)
	void study() { // 인스턴스 메소드는 static xxxxxxxxxxx ==> 객체가 선언되어야 사용가능.
		System.out.println("공부를 합니다.");
	}

	void introduce() {
		System.out.printf("학번은 %d이고 이름은 %s\n", studentNo, studentName);
	}
	
	//영어, 수학.
	void setEngScore(int engScore) {
		if (engScore < 0 || engScore > 100) {
			return;
		}
		this.engScore = engScore;
	}
	void setMathScore(int mathScore) {
		if (engScore < 0 || engScore > 100) {
			return;
		}
		this.mathScore = mathScore;
	}
	//학번, 학생명.
	void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	int getStudentNo() {
		return studentNo;
	}
	String getStudentName() {
		return studentName;
	}

	int getEngScore() {
		return engScore;
	}

	int getMathScore() {
		return mathScore;
	}
	
	
}
