package com.yedam.interfaces;

public class InterfaceExe {
	public static void main(String[] args) {
		final int num = 10; //

		
		//인터페이스타입 변수에 구현클래스의 인스턴스를 할당. 
		RemoteControl rc = new Television();
		rc.turnOn();
		rc.turnOff();
				
		rc = new radio();
		rc.turnOn();
		rc.turnOff();
		
	}
}
