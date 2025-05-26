package com.yedam.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.yedam.collection.Student;

/*
 * 학생(추가, 수정, 삭제, 목록) -> studentList.txt
 * add(추가: 이름, 점수 입력받기)
 * modify(수정: 이름으로 찾아 점수수정)
 * remove(삭제: 이름기준으로 찾아서 삭제)
 * list(목록)
 * 종료 시 저장. 
 */
public class StreamExe3 {

	static Scanner scn = new Scanner(System.in); // main이 static이라 사용될 수 있도록 scn도 static으로.
	static List<Student> studentList = new ArrayList<>();

	public static void main(String[] args) {
		
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (NoSuchElementException e) {
			//파일의 끝부분에서 더이상 읽을 값이 없음. 
		}
		
		boolean run = true;

		while (run) {
			System.out.println("1.추가  2.수정  3.삭제  4.목록  5.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			// 조건.
			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				 modify();
				break;
			case 3:
				
				break;
			case 4:
				break;
			case 5:
				run = false;
				save();
				break;
			}

		} // end of while.
		System.out.println("end of prog.");
	}// end of main

	static void add() { // 추가 메소드
		// 추가위해 값 입력받기
		System.out.println("학생번호: ");
		String sno = scn.nextLine();
		System.out.println("점수: ");
		String score = scn.nextLine();
		Student student = new Student(Integer.parseInt(sno), Integer.parseInt(score));

		// 입력받은 값 리스트에 추가.
		if (studentList.add(student)) {
			System.out.println("저장완료.");
		}
	}// end of add.

	
	static void modify() { //수정
		System.out.println("학생번호: ");
		int sno = scn.nextInt();
		System.out.println("점수: ");
		int score = scn.nextInt(); //nextInt는 바로 정수를 받아오나 엔터를 처리해줘야함. 
		scn.nextLine();
		//컬렉션에서 검색. 
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getStudentNo() == sno) {
				studentList.get(i).setScore(score);
				System.out.println("수정완료");
			}
		}
	}//end of modify.
	
	
	
	static void save() { // txt형식 저장하는 메소드.
		// 문자기반 출력스트림.
		try {
			Writer writer = new FileWriter("c:/temp/studentList.txt");
			// 1001 70
			for (Student student : studentList) { // 컬랙션 안에 들어있는 객체 개수만큼 write.
				String txt = student.getStudentNo() + " " + student.getScore() + "\n";
				writer.write(txt);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end of save.

	// 초기화
	static void init() throws IOException, NoSuchElementException {
		Scanner scan = new Scanner(new File("c:/temp/studentList.txt"));
		while (true) {
			String txt = scan.nextLine();
			String[] strAry = txt.split(" ");
			// studentList 컬렉션에 추가. strAry[0]
			studentList.add((new Student(Integer.parseInt(strAry[0]), Integer.parseInt(strAry[1]))));

		} // end of while.

	}// end of init.

}
