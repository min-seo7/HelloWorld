package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control {
	public void exec(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
}

ajax코드 교수님꺼 다시 확인할 것! 
mapper도 확인


promise, fetch[then-then-catch]