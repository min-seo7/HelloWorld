package com.yedam;

import com.yedam.member.Member;

/*
 * 메소드 연습
 * 1) 메소드 선언.
 * 2) 매개변수.
 * 3) 반환유형.
 */
public class Calculator {
	// 필드.
	// 생성자.
	// 메소드.
	String printStar(int times, String shape) { // 매개변수(times)
		String str = "";
		for (int i = 1; i <= times; i++) {
//			System.out.println(shape);	
			str += shape + "\n";
		}
		return str;
	} // end of printStar.

	
	
	//
	Member getMaxPoint(Member[] member) {
		Member max = null; 	 //아이디, 이름, 연락처, 포인트.
		int maxPoint = 0;    //포인트 비교위한 변수. 
			
		for (int i = 0; i < member.length; i++) {
			if(member[i].getPoint() > maxPoint) {
				maxPoint = member[i].getPoint();
				max = member[i];
			}
		}
		return max;
	}
	
	
	
	//메소드 오버로딩. ==> 같은이름의 메소드 중복정의[차이: 매개변수 타입, 매개변수 개수가 다름]
	int add(int num1, int num2) {
		return num1 + num2;
	}	
	double add (double num1, double num2){
		return num1 + num2 ;
	}
	double add(int[] ary) {
		double sum = 0;
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		return sum; 
	}

} // end of class.