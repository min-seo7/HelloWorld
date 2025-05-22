package com.yedam;

import java.util.Scanner;

public class ObjectExe {
	public static void main(String[] args) {
//		Calendar test = new Calendar(); 
//		test.showMonth();	

		Scanner scn = new Scanner(System.in);

		while (true) {
			int year = 0;
			System.out.println("년도를 입력하세요.>> ");
			try {
				year = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요.");
				continue;
			}
			if (Calendar.isLeapYear(year)) {
				System.out.println("윤년");
				break;
			} else {
				System.out.println("평년");
				break;
			}
		}
		// 평년입니다. 윤년입니다.
	}
}
