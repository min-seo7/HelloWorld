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
 * 
 *frontcontroler-각 controler 식별- tiles(main) 들러서 개별 찾아-개별 jsp파일로 이동.  

서블릿, mapper, *.do, control, tile

=============
js  => web폴더 참고!





vo - [서비스인터페이스, 서비스Impl] - [mapper.java(인터페이스로), mapper.xml] => id와 인터페이스 메소드명 동일해야함] 



댓글을 ajax로




ajax 동기화, 비동기화 
 * 
 * 
 */
