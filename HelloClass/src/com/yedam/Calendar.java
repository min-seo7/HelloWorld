package com.yedam;

import java.util.Scanner;

public class Calendar {
	Scanner scn = new Scanner(System.in);

	static boolean isLeapYear(int year) {
		// 윤년이면 true, 평년이면 false

		if (year % 4 == 0 && year > 0) { // 1
			if (year % 100 == 0) { // 2
				if (year % 400 == 0) { // 3
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
		return false;
	}

	void showMonth() {
		// Sun Mon Tue Wed Thu fri Sat
		// ============================
		// 1 2 3
		// 4 5 6 7 8 9 10
		int mon = 5;
		int space = 4;
		System.out.printf("              %d월       \n", mon);
		System.out.println("   Sun  Mon  Tue  Wed  Thu  fri  Sat");
		System.out.println("====================================");

		for (int s = 1; s < space + 1; s++) {
			System.out.printf("%5s", " ");
		}

		// 1 ~ 마지막일 날짜 출력 for.
		for (int day = 1; day < 32; day++) {
			System.out.printf("%5d", day);
			if ((day + space) % 7 == 0) {
				System.out.println();
			}
		}
	}// end of showMonth.

	// 달입력.
	int month() {
		int mon = Integer.parseInt(scn.nextLine());
		return mon;
	}

}// end of calendar.
