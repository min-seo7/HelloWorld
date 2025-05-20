package com.yedam;

import com.yedam.member.Member;

public class CalculatorExe {
	public static void main(String[] args) {
		Calculator cal = new Calculator(); // 인스턴스 생성.
		int num1 = 10;
		String str = "🥗🥗";
		String result = cal.printStar(num1, str); // 매개값.
		System.out.println(result);

		double sum = cal.add(num1, 10.5); // num1은 자동형변환 발생.

		int[] numAry = { 10, 20, 30 };
		sum = cal.add(numAry);

		// Member[] 중에서 point가 큰 회원을 반환하는 메소드 생성.
		Member[] members = { new Member("user01", "홍길동", "1111", 1000), new Member("user01", "김민규", "2222", 2200),
				new Member("user01", "황선홍", "3333", 2700), new Member("user01", "홍명보", "4444", 1900) };

		Member member = cal.getMaxPoint(members);
		member.showInfo();
		
//		System.out.println(true);
//		System.out.println("10");
//		System.out.println(sum);
	}
}
