package com.yedam.operator;

import java.util.Scanner;

public class ScannerExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int balance = 0; // 계좌의 금액.
		int mo = 0; // 입&출금액을 동일한 변수로 받음. 
		//
		// 계좌가 10만원이상 입금불가, -금액 불가.
		//
		while (true) {
			System.out.println("1.입금 2.출금 3.잔액 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			if (menu == 1) { //입금기능구현.	
				System.out.print("입금액을 입력>> ");
				mo = Integer.parseInt(scn.nextLine());
				if ((balance + mo) > 100000) {  //입금조건제시
					System.out.println("입금이 불가능합니다.");
				} else { 
					balance += mo;
				} 
			} else if (menu == 2) { //출금기능구현.
				System.out.println("출금액을 입력>> "); 
				mo = Integer.parseInt(scn.nextLine());
				if (balance < mo) { //출금조건제시
					System.out.println("잔액을 초과하여 출금이 불가능합니다.");
				} else {
					balance -= mo;
				}
			} else if (menu == 3) { //잔고출력
				System.out.println("현잔액>> ");
				System.out.println(balance);
			} else if (menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("1 ~ 4번 중에 선택하세요.");
			}
		} // end of while
		System.out.println("end of prog.");
	}// main

}
