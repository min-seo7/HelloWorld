package com.yedam.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

//문자(char => 2byte)기반 입출력 스트림.(문자열x)

public class StreamExe2 {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("c:/temp/writer.txt")); // 파일을 읽어드릴 수 있음.

			while (true) {
				String data = scanner.nextLine(); // 위에 지정된 파일을 한라인씩 읽어옴.
					
				String[] strAry= data.split(" ");  //split()은 문자열 나누는것. (홍길동 70)을 공백기준으로 나눔.  
				System.out.println(strAry[0] + ", " + strAry[1]);
//				System.out.println(data);
			}

		} catch (Exception e) {
			// e.printStackTrace(); // 에러메세지만 출력.
		} finally {
			scanner.close();// 예외발생시 에러메세지만 출력.
		}
		System.out.println("end of porg.");
	}// end of main.

	// 입력
	public static void read() {
		// char기반의 입력 스트림.
		try {
			Reader reader = new FileReader("c:/temp/writer.txt");
			while (true) {
				int data = reader.read();
				if (data == -1) {
					break;
				}
				System.out.print((char) data);
			}
			reader.close();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 출력
	public static void write() {
		// 문자기반 출력(writer)스트림.
		try {
			Writer wr = new FileWriter("c:/temp/writer.txt");
			wr.write('A');
			wr.write('B');
			wr.write('C');
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}