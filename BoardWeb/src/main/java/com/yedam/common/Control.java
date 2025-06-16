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
 * ajax1코드 교수님꺼 다시 확인할 것! mapper도 확인
 * 
 * 페이징계산법 확인할것. 
 * 
 * 
 * 
 * 
 * replyInfo 추가. (front부터 다 진행~)
 * reply.js 코드비교 
 *  
 *  
 *  
 *  리플기능 정리. [리스트, 삭제, 등록] , 리스트 페이징 
 */