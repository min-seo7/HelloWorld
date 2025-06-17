package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.Service.BoardService;
import com.yedam.Service.BoardServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.EventVO;

public class AddEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		
		String title = req.getParameter("title");
		String st = req.getParameter("start");
		String ed = req.getParameter("end");
		
		EventVO event = new EventVO();
		event.setTitle(title);
		event.setStart(st);
		event.setEnd(ed);
		
		Map<String, Object> map = new HashMap();
		Gson gson = new GsonBuilder().create();
		
		BoardService svc = new BoardServiceImpl();
		
		if(svc.addEvent(event)) {
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}
	}

}
