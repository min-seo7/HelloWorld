package com.yedam.inheritance;
/*
 * 부모: Cellphone
 *     -전원켜기, 전원끄기, 통화, 볼륨up, 볼륨Down 
 *	   -Model, color
 *자식: SmartPhone
 *     -TV보기 
 */
public class CellPhone {
	String model;
	String color;
	
	//생성자
	public CellPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	public CellPhone() {}
	
	//메소드
	public void powerOn() {
		System.out.println("전원을 켜기");
	}
	public void powerOff() {
		System.out.println("전원을 끄기");
	}
	void 통화하기() {
		System.out.println("통화하다.");
	}
	
	@Override
	public String toString() {
		return "CellPhone [model=" + model + ", color=" + color + "]";
	}
	
	
	
}//end of cellPhone
