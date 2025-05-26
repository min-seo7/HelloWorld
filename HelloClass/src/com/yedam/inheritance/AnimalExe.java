package com.yedam.inheritance;

public class AnimalExe {
	public static void main(String[] args) {
		//추상클래스는 인스턴스 생성불가.
		//Animal animal = new Animal();   //Cannot instantiate the type Animal 오류. 
		
		Animal a1 = new Bird();   //자식이 부모로 자동형변환 발생되어, 부모에게 정의된 메소드만 사용가능. 부모타입의 참조변수에 자식클래스 겍체할당.
		a1.breathe();
		a1.sound();		
		
		a1 = new Fish();  //부모클래스 타입의 참조변수라 상속받은 자식은 다 변수에 할당가능. 만약 배열을 부모타입 객체로 선언하게되면 자식객체 다 들어갈 수 있음. (다형성)
		a1.breathe();
		a1.sound();	
		
			
	}
}
