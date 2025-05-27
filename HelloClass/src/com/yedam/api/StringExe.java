package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringExe {
	public static void main(String[] args) {
		String str1 = new String("Hello");   //=>정석의 String 객체선언.
		//str1 = new String(new byte[] {72, 101, 108, 108, 111, 65}, 0, 2); //변수 str1에 byte배열을 생성해 직접 문자열을 생성해로  변수 str1으로 할당. -> 동일한 hello 출력가능. 
		
		
		System.out.println(str1.charAt(1)); //charAt(n)은 해당 인덱스번호 문자출력. 
		System.out.println(str1.indexOf("o"));  //문자열에서 해당 문자의 인덱스 번호를 출력. 
		
		
		String test = "23-12-01";
		
		SimpleDateFormat ts = new SimpleDateFormat("YY-MM-dd");
	
		
	}
}
