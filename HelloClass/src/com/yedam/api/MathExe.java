package com.yedam.api;

public class MathExe {
	public static void main(String[] args) {
		//절대값. 
		System.out.println(Math.abs(-100));  //음수를 양수로 변환. 
		
		//올림, 버림.
		System.out.println(Math.floor(20.6));
		System.out.println(Math.ceil(20.6));
		System.out.println(Math.round(12.3));
		
		//크기비교
		System.out.println(Math.max(Math.ceil(12.3), Math.floor(12.3)));
		
	}
}
