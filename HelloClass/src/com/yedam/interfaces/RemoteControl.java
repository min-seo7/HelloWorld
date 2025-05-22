package com.yedam.interfaces;
/*
 * 인터페이스: 필드(상수)   인터페이스는 클래스가 아님. 구현한다고 표현! 
 */
public interface RemoteControl {
	public int MAX_VOLUME = 10;  //상수는 대문자로 쓰임.(관례)
	
	//추상메소드. 
	public abstract void turnOn(); //구현클래스에서 메소드 정의.
	public void turnOff(); 
}
