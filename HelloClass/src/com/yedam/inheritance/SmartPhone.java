package com.yedam.inheritance;

/*
 * CellPhone을 상속.
 */
public class SmartPhone extends CellPhone {
	int channel;

	//생성자
	public SmartPhone(String model, String color, int channel) {
		super(model, color);  //부모의 생성자. 
		this.channel = channel;
	}
	
	public SmartPhone(){}
	
	void watch() {
		System.out.println(channel + "을 시청합니다. ");
	}

	
//부모클래스의 기능을 자식클래스 재정의(overriding)
	@Override // @override 붙여주면 부모와 대조해서 접근제한자, 리턴타입, 이름등을 체크해줌!
	public void powerOn() {
		System.out.println("전원을 켭니다.🥵🥵");
	}

	@Override
	public void powerOff() {
		super.powerOff();
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
