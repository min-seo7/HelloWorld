package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.ReplyService;
import com.yedam.Service.ReplyServiceImpl;
import com.yedam.common.Control;

public class ReplyCountControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 해당 글번호의 댓글 수 반환. 
		String bno = req.getParameter("bno");
		
		ReplyService svc = new ReplyServiceImpl(); 
		int totalCnt = svc.totalCount(Integer.parseInt(bno));
		//{"totalCnt": 27} 형태로 전달. 
		resp.getWriter().print("{\"totalCnt\": "+ totalCnt + "}");
	}

}
