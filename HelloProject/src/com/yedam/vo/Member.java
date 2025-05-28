package com.yedam.vo;
/*
 *DB의 테이블(tbl_member)의 데이터에 대응하는 클래스 생성. 
 */
public class Member {
	//필드
	private String memberId;  //db에는 컬럼명으로 ' _ '가능하지만 자바는 관례상 사용하지 않으니 확인할것. 
	private String memberName;
	private String phone;
	private int point;
	
	//생성자
	public Member() {}
	public Member(String memberId, String memberName, String phone, int point) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.point = point;
	}


	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	//toString()	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", phone=" + phone + ", point=" + point
				+ "]";
	}
	
}
