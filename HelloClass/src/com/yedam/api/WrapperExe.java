package com.yedam.api;

public class WrapperExe {
	public static void main(String[] args) {
		
		//Wrapper 클래스: 기본타입을 박싱하게 되면 참조타입으로 됨. //포장을 함으로써 외부에서 변경이 불가능함. 
		//기본타입 -> wrapper type (박싱) 
		 //참조타입 -> 기본타입(언박싱) 
		
		
		int num = 10;
		
		Integer num2 = 20; //new Integer(20);
		num = num2.intValue();
		
		String str = "10";
		num = Integer.parseInt(str);
		
		double num3 = Double.parseDouble(str);
		num3 = Float.parseFloat(str);
		
		
		Integer num4 = new Integer(10);  
		Integer num5 = new Integer(10); 
		System.out.println(num4 == num5);  //주소값으로 비교됨.
		System.out.println(num4.intValue() == num5.intValue());   //값 비교. 
		
	}
}
