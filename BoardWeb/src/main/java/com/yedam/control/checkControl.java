package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.MemberService;
import com.yedam.Service.MemberServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.MemberVo;

public class checkControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//URL이 *.do?id = user01일때, 파라미터값 받아오기.
		String user = req.getParameter("id");
		
		MemberService svc = new MemberServiceImpl();
		
		if(svc.getMemberInfo(user) ) {
			resp.getWriter().print("{\"retCode\":\"Exist\"}"); //{"retCode":"Exist"}
		} else {
			resp.getWriter().print("{\"retCode\":\"NotExist\"}");
		}

	}

}
