package com.yedam.inheritance;
/*
 * 추상클래스(Animal)
 * 
 * 자식클래스: Bird, Fish
 */
public abstract class Animal {   //abstract 추상클래스 ==> 클래스가 가지는 성질은 다 갖고 있으나, 단! 객체를 생성할 수 없음.
	String kind;
	
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	//추상메소드.
	public abstract void sound();  //=> 추상메소드: 메소드 선언부만 있고, 구현은 없음.//상속받는 자식클래스에서 재정의가 필요. 
}