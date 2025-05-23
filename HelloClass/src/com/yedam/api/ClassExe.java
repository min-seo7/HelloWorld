package com.yedam.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExe {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("com.yedam.api.Member");
			
			Member member = new Member();
			cls = member.getClass();
			System.out.println(cls.getName());
			
			
			//선언된 필드정보 확인. 
			Field[] fieldAry = cls.getDeclaredFields(); //클래스의 필드들을 배열로 반환. 
			
			for(Field field : fieldAry) {  //클래스 필드명 출력. 
				System.out.println(field.getName());
			}
			
			//클래스가 가지고 있는 메소드 확인.
			Method[] methodAry = cls.getDeclaredMethods();
			
			for(Method method : methodAry) {
				System.out.println(method.getName());
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
