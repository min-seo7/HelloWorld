package com.yedam.operator;

public class OpertorExe {

	public static void main (String[] ards) {
		//test();
		//test1();
		//test2();
		//test3(); //토글
		//test4(); //월입력시 공란, 마지막일 출력함수 & 달력형식 출력
		test5();  //삼항연산자. 
	}
	
	public static void test5() { //삼항연산자 test
		String pass = "";
		
		int score = (int) (Math.random() * 100);    //0~99
		System.out.println(score);
		
		 pass = (score >= 60) ? ((score >= 80) ? "우수" : "합격"): ((score < 20 ) ? "재재수강" : "불합격") ;  //삼항연산자. 
	    /*if(score >= 60) {
	       *if(score >= 80) {
	        	pass = "우수"; 
	       } else {
			pass = "합격";
		} else {
		    if(score < 20) {
			pass = "재재수강";
		} else {
			pass = "불합격"; 
		} */
	    
		System.out.println(pass);
	}

	
	
	
	
	//"월" 정보를 입력하면 "공란" 반환하는 메소드. getSpace()
	public static int getSpace(int month) {
		int space = 0;
		if(month == 3) { //3월 공란
			space = 6;
		} else if(month == 4) { //4월 공란
			space =2;
		} else if(month == 5) {  //5월 공란
			space = 4;
		} else if(month == 7) {   //7월 공란
			space = 2;
		}
		return space;
	} //end of getSpace.
	
	
	
	//"월" 정보 입력시 말일을 반환하는 메소드. getLastDate()
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch(month) {
		case 2:
			lastDate =28; break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
			break;
		}
		return lastDate;		
	}//end of getLastDate
	
	
	public static void test4() {   //달력출력, 시작 공란, 마지말 일 변수 대입시 달력형태 형식.
		
		int mon = 5; //월 정보입력.
		
		System.out.printf("              %d 월                ", mon);
		System.out.println("\n  sun Mon Tue Wed Thu Fri Sat");
		
		int space = getSpace(mon);   //월 입력시 공백출력함수.
		int lastDate = getLastDate(mon); //월 입력시 마지막일 출력
		//빈 공간
		for (int s = 1; s <= space; s++) {
			System.out.printf("%4s", " ");
		}
		
		//날짜출력
		for (int day = 1; day <= lastDate; day++) { 
			System.out.printf("%4d", day);   //---3개의 공간안에 숫자기록.
			if ((day + space) % 7 == 0) { //7일마다 줄바꿈 조건
				System.out.println();  
			}
		}
		
	}//end of test4
	
	
	
	
	public static void test3() {
		boolean isTrue = true;
		for(int i = 1; i < 11; i++) {
			if(isTrue) {
				System.out.printf("i의 값은 %d\n", i);
			}
			isTrue = !isTrue; //토글: on을 off로, off를 on으로 바꿔줌.			
		}//for
		
	}//end of test3
	
	
	
	
	public static void test2() {   //단항연산자[++, --]
		int num1 = 10; //변수 초기화
		int num2 = 20; 
		
		int result = ++num1 + num2++;  //num1 = 11, num2 =20 으로 sum 대입 후 num2 = 21;
		System.out.printf("num1 => %d, num2 => %d, result => %d", num1, num2, result);
		
		boolean isTrue = true;
		if(!isTrue) {
			System.out.println("참입니다.");
		}
		
		// '=='같다의 부정은 '!=', '>'의 부정은 '<=', '>=' 부정은 <.
		result = 30;
		if(!(result > 30)) {
			System.out.println("\n result 는 30보다 작거나 같음.");
		}
		
		if(!(--num1 > 10 || num2 < 20)) {
			System.out.printf("num1 => %d", num1);
		}		
	}//end of test2
	
	
	
	
	//연습2. Byte, short, long, int, char
	public static void test1() {
		byte num1 = 10;
		byte num2 = 20;
		byte sum = (byte) (num1 + num2) ; //불가. error 연산은 정수가 기본. byte를 int로 변환하여 연산을 함으로 byte타입인 sum에 대입불가. 
		System.out.println(sum);                        //1) sum을 int 타입으로 or 2) (byte)(num1+num2)로 캐스팅처리.
		
		long num3 = 1234567891011121314L;  //L을 붙여 long형 명시.
		//System.out.println(Long.MAX_VALUE); //long형이 가질수 있는 최대값 확인
	}//end of test1
	
	
	
	
	
	//연습1. 
	public static void test() {	//증가, 감소 연산자(++, --)
		
		byte num1 = 10;   //byte범위: -128 ~ 127 (0포함)
		num1 = 127;
		num1++;
		System.out.println(num1);   //-128로 출력됨. [127에서 -128로 ]
		
		char ch1 = 'A'; 
		ch1 = 66;    //형변환 없으면 문자로 'B'출력, int 형변환시 66
		ch1 = '가';
		ch1 = 0x29D7; //16진수
		System.out.println((int) ch1);   //문자->int형 변환
		
		
		/*ch1 = 'A';     //알파벳 순차출력. 
		for (int i = 1; i < 27; i++) {
			System.out.println(ch1++);
		} */
	
	}//end of test
}
