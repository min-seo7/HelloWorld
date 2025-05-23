package com.yedam.api;

public class Member {
	public String memberName;
	public int age;
	
	//생성자
	public Member() {}  
	public Member(String memberName, int age) {
		this.memberName = memberName;
		this.age = age;
	}
	
	
	@Override
	public int hashCode() {  //hash코드로 값이 같은지 비교함. 
		return age; 		
	}
	
	
	//이름, 점수를 논리적으로 동등여부 비교. 
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) { //매개값의 유형이 Member. 
			Member member = (Member) obj;  //obj를 캐스팅.
			return this.memberName == member.memberName && this.age == member.age; 
		
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "이름: " + memberName + ", 나이: " + age;
	}
	

}//end of class
