package com.yedam;

//ctrl+shft+f
public class HelloJava {
	public static void main(String[] args) {  
		// int(정수), double(실수), boolean(참거짓)
		int num1 = 10;  //초기화
		double num2 = 20; //자동형변환(promotion)
		
		num1 = (int)num2; //강제형변환(casting)
		
		int num3 = 100;
		double num4 = 200;
		double result =num3 + num4;
		System.out.println("결과는 " + result); //"결과는 "과 연결되는 result도 문자열로 변환됨. 
		
		// 20 + 30 => 50
		System.out.println("결과는 "+ (20 + 30));  //동일한 자료형만 서로 연산가능. 
	}
}