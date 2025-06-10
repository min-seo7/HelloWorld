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
 * mybatis config  -> mapper 순서로.


1. 글 전체 수 // mapper->select count(*) from tlb_
	       serviceImpl에서 기능추가. 
	       boardlist에도 기능반영.


modifycontrol ->


========
1) pageDTO 코드확인.
2) 이클립스에서 비주얼코드 열리도록~ 
3) 검색기능
4) 검색 -> 상세조회 후 다시 검색된 목록 출력 
=> URL에 검색사용 파라메터가 남아있도록 함.  => 각 *.do마다 설정을 해줘야 수정, 삭제 등에 서도 파라메터 남아있음. 


- frontcontrol 외 다른 페이지 컨트롤 방식. 

->실행된 query 로그에 출력! 
<!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->
 */
