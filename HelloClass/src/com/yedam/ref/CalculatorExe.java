package com.yedam.ref;
//실행 클래스 
public class CalculatorExe {   
	public static void main(String[] args) {   
		int a = 20, b = 30;
		
		Calculator c1 = new Calculator();
		c1.sum(a, b);
		
		Calculator.sum(a, b); //sum은 정적메소드로 선언되어서 인스턴스 생성업이 사용가능!
		
		
		
		
		CalculatorExe ce = new CalculatorExe();
		ce.printStar();  //printStar()정적메소드가 아니라서 객체 생성후 사용가능. 
		
	}//end of main. 
	
	void printStar() {   //정적(static)메소드로 선언 되면 인스턴스 생성없이도 메소드 사용가능.
		System.out.println("*");  
	}
}//end of CalculatorExe.
