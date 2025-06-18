package com.yedam.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{

	public LogFilter() {
		System.out.println("필터객체 생성");
	}
	
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("서블릿 실행전.");
		
		String host = req.getRemoteAddr();
		String port = " "+ req.getRemotePort(); //port가 int타입이라 공백추가해서 String으로 타입변경. 
		//System.out.println("접속HOST:" + host +"PORT:" + port);
		
		
		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String page = uri.substring(context.length());
		System.out.println("IP: "+ host + ",page" +page);
		
		/*
		 * if(host.equals("192.168.0.17")) { return; }
		 */
		
		chain.doFilter(req, resp);  //서블릿 실행.(기준으로 필터전후)
		
		System.out.println("서블릿 실행후.");
	}
	
}
