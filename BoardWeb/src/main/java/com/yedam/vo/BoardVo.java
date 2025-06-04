package com.yedam.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 필드, 생성자, 메소드(getter, setter) 
 * lombok 사용법(설치, 라이브러리도 가지고와야함.) => 생성자, 메소드 쉽게 가능.
 */
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor

@Data  //getter&setter&to_String등 한번에 만들어줌. 생성자는 안만들어주셔~ 
public class BoardVo { 
	//필드는 SQL 컬럼명.
	private int boardNO;
	private String title;
	private String content;
	private String writer;
	private Date witeDate;
	private int readCnt;
	
	
	
}
