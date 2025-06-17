package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control {
	public void exec(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
}

/*
 * 구글차트 - 파이차트
 *  
 * 테이블 - datatables  //글목록 - HTML DOM 방식
 * 댓글 Ajax방식
 * 
 * board.jsp
 * 
 * https://fullcalendar.io/
 * 
 * 
 * 
js.이벤트감지. 
fetch 파라미터와 함께 전송. 
.then 결과
 * 
 * 
 */