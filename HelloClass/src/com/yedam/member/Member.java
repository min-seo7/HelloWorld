package com.yedam.member;

public class Member {
	private String memberId;
	private String memberName;
	private String phone;
	private int point;
	
	//생성자
	public Member() {}
	public Member(String memberId, String memberName, String phone, int point) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.point = point;
	}

	//메소드(getter, setter)
	void setMemberId(String memberId) {
		this.memberId = memberId; 
	}
	void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	void setPhone(String phone) {
		this.phone = phone;
	}
	void setPoint(int point) {
		this.point = point;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getPhone() {
		return phone;
	}
	public int getPoint() {
		return point;
	}
	//이름, 연락처, 포인트 출력메소드. 
	public void showInfo() {
		System.out.printf("이름은 %s, 연락처 %s, 포인트는 %d\n", memberName, phone, point);
	}
}
