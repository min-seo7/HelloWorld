package com.yedam.inheritance;

public class PhoneExe {
	public static void main(String[] args) {

		// 부모클래스.
		CellPhone phone1 = new CellPhone();
		//phone1.model = "IT203";
		//phone1.color = "red";
		phone1.powerOn();
		phone1.powerOff();
		System.out.println(phone1.toString());

		// 자식클래스
		CellPhone phone2 = new SmartPhone();
		//phone2.model = "S21";
		//phone2.color = "white";
		phone2.powerOn();
		phone2.powerOff();
		
		SmartPhone phone3 = null;
		if (phone2 instanceof SmartPhone) {
			phone3 = (SmartPhone) phone2; // Casting 강제형변환.
			phone3.channel = 2;
			phone3.watch();
			System.out.println(phone3.toString());
		}
		
		// phone2.channel = 3; //오류발생 => 부모타입으로 객체생성시 부모가 가지는 것만 사용가능하나 재정의 된건 자식걸로
		// 출력됨..
		// phone2.watch(); //자식만 가지고 있는거라 오류발생.


		if (phone1 instanceof SmartPhone) {   //불가능!!! 
			phone3 = (SmartPhone) phone1;
			phone3.channel = 4;
			phone3.watch();
		}
	
	
	
	}//end of main.
	
	
	
	
}//end of class