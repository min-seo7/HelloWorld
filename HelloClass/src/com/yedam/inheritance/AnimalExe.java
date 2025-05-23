package com.yedam.inheritance;

public class AnimalExe {
	public static void main(String[] args) {
		//추상클래스는 인스턴스 생성불가.
		//Animal animal = new Animal();   //Cannot instantiate the type Animal 오류. 
		
		Animal a1 = new Bird();   //자식 -> 부모로 자동형변환 발생. 
		a1.breathe();
		a1.sound();		
		
		a1 = new Fish();
		a1.breathe();
		a1.sound();	
		
			
	}
}
