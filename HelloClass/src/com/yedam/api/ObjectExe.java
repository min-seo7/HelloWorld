package com.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class ObjectExe {
	public static void main(String[] args) {
		//배열로 여러 객체를 저장. ==> 단점. 크기가 정해지면 변경불가. ==> 컬랙션 대안.(1.List 2.Set 3.Map)
		int[] ary = new int[5]; //배열선언 & 초기화.
		Set<Integer> set = new HashSet<Integer>(); //set 컬랙션 선언&생성. 
		//확장된 for
		for(int num : ary) { //배열 ary 크기많큼 반복하겠음!
			System.out.println(num);
		}
		
		set.add(10); //set 컬랙션 요소 추가방법. 
		set.add(20);
		set.add(30);
		set.add(10); //set 컬랙션은 중복된 값은 저장안됨 & 저장순서 없음.  
		
		//선언하는 클래스. Member.
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 10));  
		members.add(new Member("김민석", 12));
		members.add(new Member("홍길동", 10));  //클래스 작성시 hashcode( ) & equals( )를 오버라이딩해야 논리적 동등비교 & 중복값 저장 안됨. [해쉬코드비교 - equals 순으로 진행] 
		
		for(Integer num : set) {  
			System.out.println(num);
		}
		
		for(Member num : members) {  
			System.out.println(num.toString()); //toStiring( )오버라이딩 필요.// toString이 없으면 주소값이 나와용! => object클래스에서 toString은 문자정보가 리턴됨. 
		}
	}
	
		

	public static void exe1() {
		int num1 = 10, num2 = 20;
		System.out.println(num1 == num2);

		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1 == str2); // 같은 객체를 가리키고 있나???(=동일주소값인가??)
		System.out.println(str1.equals(str2)); // 문자열 비교.

		Member mem1 = new Member();
		mem1.memberName = "홍길동";
		mem1.age = 10;
		Member mem2 = new Member();
		mem2.memberName = "홍길동";
		mem2.age = 10;

		System.out.println(mem1 == mem2); // 동일 주소값이셩?????????
		System.out.println(mem1.equals(mem2)); // 사용자 정의타입은 주소값을 비교하기때문에 재정의 필요함. (Member클래스에 재정의해둠.)
	}
}
