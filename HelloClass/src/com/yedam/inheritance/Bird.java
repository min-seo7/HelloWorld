package com.yedam.inheritance;
/*
 * 부모클래스: Animal(추상클래스)
 * 
 */
public class Bird extends Animal{ //부모클래스에 추상메소드가 정의되기 전까지 오류!

	@Override
	public void sound() {
		//반드시 부모클래스의 sound()를 재정의 필요. 
		System.out.println("짹짹");
	}   

}
