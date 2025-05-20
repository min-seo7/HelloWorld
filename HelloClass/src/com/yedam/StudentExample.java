package com.yedam;

/*
 * 실행클래스.
 */
public class StudentExample {
	public static void main(String[] args) {
		// 클래스 변수명 = 인스턴스 생성
		Student student = new Student(); // 객체생성.
	//	student.studentNo = 1001;
	//	student.studentName = "홍길동";
	//	student.engScore = 80;    //private로 필드접근제한. 
	//	student.mathScore = 85;
		student.setEngScore(80);
		student.setMathScore(85);
		student.setStudentNo(1001);
		student.setStudentName("홍길동");
		student.study();
		student.introduce();
				
		//System.out.println("이름: " + student.studentName + "영어: " + student.engScore + "수학: "student.mathScore);
		//필드 직접접근불가. ==> 오류발생. 
		System.out.println("이름:" + student.getStudentName() + " 영어:" +student.getEngScore() + " 수학:" + student.getMathScore()); 
		
		Student student2 = new Student(1002, "김민규"); //생성자 호출시 필드에 값 할당. 
		//student2.studentNo = 1002;
		//student2.studentName = "홍길동";
		//student.engScore = -50;
		//student.mathScore = -80;
		student2.setEngScore(-50);
		student2.setMathScore(-80);
		student2.setStudentNo(1002);
		student2.setStudentName("김민규");
		student2.study();
		student2.introduce();
		System.out.println("이름:" + student2.getStudentName() + " 영어:" +student2.getEngScore() + " 수학:" + student2.getMathScore()); 
		
	//	student2.studentName = "박민규";
		student2.introduce();
		
	}//end of main. 
}//end of class.