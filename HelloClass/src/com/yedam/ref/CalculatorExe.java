package com.yedam.ref;
//실행 클래스 
public class CalculatorExe {   
	public static void main(String[] args) {   
		int a = 20, b = 30;
		
		Calculator c1 = new Calculator();
		c1.sum(a, b);
		
		Calculator.sum(a, b); //sum은 정적메소드로 선언되어서 인스턴스 생성업이 사용가능!
		
		CalculatorExe ce = new CalculatorExe();
		ce.printStar();
		
	}//end of main. 
	
	void printStar() {   //static 정적메소드가 되면 인스턴스 생성없이도 메소드 사용가능.
		System.out.println("*");  
	}
}//end of CalculatorExe.
