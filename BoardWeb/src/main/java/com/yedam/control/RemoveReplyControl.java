package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.ReplyService;
import com.yedam.Service.ReplyServiceImpl;
import com.yedam.common.Control;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//rno로 댓글삭제.
		
		String rno = req.getParameter("rno");
		
		ReplyService svc = new ReplyServiceImpl();
		if(svc.removeReply(Integer.parseInt(rno))) {
			//{"retCode":"Success"}
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		}else {
			//{"retCode":"Fail"}
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}		

	}

}
