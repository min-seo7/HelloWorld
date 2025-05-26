package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

//바이트기반 입출력 스트림. 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamExe {
	public static void main(String[] args) {
		//
		try {
			InputStream is = new FileInputStream("c:/temp/original3.png");
			OutputStream os = new FileOutputStream("c:/temp/copy3.png");
			// 보조스트림에 연결.
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			while (true) {
				int data = bis.read();
				if (data == -1) {
					break;
				}
				bos.write(data);
			}
			bos.close();
			bis.close();
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end of prog.");
	}// end of main.

	public static void copy() {// 입출력 동시에 진행 메소드.
		// 입력스트림을 출력스트림으로. (입/출력동시)
		try {
			// 입력스트림(original.png 읽어옴)
			// 1MB => 1,000,000 바이트
			InputStream is = new FileInputStream("c:/temp/original2.png");
			// 출력스트림(copy.png)
			OutputStream os = new FileOutputStream("c:/temp/copy2.png");
			// 한번에 읽기쓰기를 byte[] 배열의 크기만큼 한번에 처리. 배열을 선언하여 크기를 지정하지 않으면 한번에 1byte씩 읽음.
			byte[] buf = new byte[10];
			long start = System.currentTimeMillis();// 시작시점.
			while (true) {
				int data = is.read(buf); // 배열(buf)크기만큼 한번에 읽기 //예외발생시 IOException으로 지정.
				if (data == -1) { // 데이터가 -1이 될때까지 반복문 반복 (=파일을 끝까지 읽으시오)
					os.write(data); // 1byte 쓰기.
					break;
				}
				os.write(data);
			}
			os.close();
			is.close();
			long end = System.currentTimeMillis(); // 종료시점.
			System.out.println("걸린시간: " + (end - start));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end of copy.

	// 입력스트림.
	public static void read() {
		// 입력(파일입력을 읽어드림) - byte 기반.
		try {
			InputStream is = new FileInputStream("c:/temp/os1.db");
			// read() 1바이트씩 읽기 -1 반환.
			while (true) {
				int data = is.read();
				if (data == -1) {
					break;
				}
				System.out.println(data);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 출력스트림.
	public static void write() {
		// Byte 기반 파일로 출력.
		try {
			OutputStream os = new FileOutputStream("c:/temp/os1.db");
			byte b1 = 10;
			byte b2 = 20;
			byte b3 = 30;
			os.write(b1);
			os.write(b2);
			os.write(b3);
			os.close();
		} catch (IOException e) { // 입출력예외처리.
			e.printStackTrace();
		}
	}

}
