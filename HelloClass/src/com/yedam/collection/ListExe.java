package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.api.Member;

/*
 * 인덱스로 객체를 관리.
 * 순서有, 중복된 값 可.
 * 
 */

class Student {
	private int studentNo; //1001, 1002, 1003***1010;
	private int score;
	public Student(int studentNo, int score) {
		this.studentNo = studentNo;
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	
}

public class ListExe { 
	public static void main(String[] args) { 
		// student 타입의 score 10개출력 
		int sum = 0;
		double avg = 0;     
		
		List<Student> numbers = new ArrayList<Student>();
		for (int i = 0; i < 10; i++) {
			int score = (int)(Math.random() * 91) + 10;
			numbers.add(new Student(1000 + i, score));
			sum += numbers.get(i).getScore();			
		}
			avg = (1.0 * sum)/numbers.size(); //numbers.size로 List크기 출력가능. 
			System.out.printf("합계: %d 평균: %.1f", sum, avg);    
}	
	
	
	public static void exe3() {   //정수타입 리스트 10개 생성&추가 후 요소의 합 & 평균출력. 
		int sum = 0;
		double avg = 0;     
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			numbers.add((int)(Math.random() * 91) + 10);
			sum += numbers.get(i);
		}
		avg = (1.0 * sum)/numbers.size();
		System.out.printf("합계: %d 평균: %.1f", sum, avg);
	}
	
	
	public static void exe2() {
		List<Member> members = new ArrayList<>();
		Member member = new Member("김홍동", 30);
		
		members.add(new Member("홍길동", 10));
		members.add(member); //추가
		members.add(new Member("김홍도", 40));
		
		//삭제
		// members.remove(member);
	
		String search = "김홍동";
		for (int i = 0; i < members.size(); i++) {
			if(members.get(i).memberName.equals(search)) {
				members.remove(i);   //i = 인덱스 번호.
			}
		}
		
		for (int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).toString());
		}		
		
	}
		
		
	public static void exe1() {	
		//int[] ary = {10, 20, 30.4}; //타입이 다르면 요소할당 불가능. 
		//인터페이스  - 구현클래스.
		List<String> list = new ArrayList<String>();  //문자열만 담을 수 있도록 타입표기.=> 타입파라메타 지정. 
		// list.add(new Integer(10));  //<String> 지정으로 오류발생. 
		list.add("10");
		list.add(new String("Hello"));
		
		list.add(1, "20");  //인덱스 번호로 위치 지정 후 요소입력가능. 
	
		//삭제.
		list.remove(0);
		
		//변경
		list.set(1, "World");
		
		for(int i = 0; i < list.size(); i++) {  //리스트 출력방법.
			System.out.println(list.get(i));    
		}
		
		
//		for(Object item : list) {  
//			System.out.println(item);
//		}
	
	}
}
