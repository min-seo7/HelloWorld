package com.yedam.interfaces;
/*
 * 클래스(Television)는 RemoteControl 인터페이스를 구현하는 클래스. 
 */
public class Television implements RemoteControl{
	
	@Override
	public void turnOn(){
		System.out.println("텔레비젼을 켭니다.");
	}
	
	@Override
	public void turnOff(){
		System.out.println("텔레비젼을 켭니다.");
	}
	
}
