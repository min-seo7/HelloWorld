package com.yedam.exception;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExceptionExe2 {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			System.out.println("1.메뉴 2.종료");
			System.out.println("메뉴를 다시 선택하세요.");
			int menu = 0;
			
			while (true) { // 적절한 값을 선택할때까지 반복.
				try {
					menu = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException | NoSuchElementException e) {
					System.out.println("1.메뉴 2.종료");
					System.out.println("메뉴를 다시 선택하세요.");
					continue;
				}
				break; // 입력받은 값이 예외가 발생하지 않고, 정상적 실행.
			}

			switch (menu) {
			case 1:
				백업();
				break;
			case 2:
				run = false;
				break;
			default:
				System.out.println("없는 메뉴를 선택해서 종료합니다. ");
				run = false;
			}// end of switch.
		}
		System.out.println("end of prog.");
		scn.close();
	}// end of main.

	public static void 백업() {
		// 예외의 종류들~~
		// NullPointException
		// NumberFormatException
		// ClasscastException
		// ArrayIndexOutOfBoundsException

		Scanner scanner = new Scanner(System.in); // 리소스 결손 경고발생, finally에서 close.

		String str = scanner.nextLine();
		try {
			System.out.println(str.toString()); // str에 참조하고있는 값이 없어 nullPointException발생.
			int num = Integer.parseInt("a");

		} catch (NullPointerException | NumberFormatException e) { // 예외를 병렬구조도 작성가능. (작성방법 2)
			System.out.println("예외가 발생했습니다.");
		}
//				catch (NumberFormatException e) {			//catch구문은 여러개 나열 가능.(작성방법 1) 
//					System.out.println("포맷이 비정상.");
//				}
		finally {
			// [정상실행, 예외발생]외 반드시 실행해야할 코드.
//			scanner.close();// 리소스를 환원.
		}

		System.out.println("end of prog.");

	}// end of 백업().

}
