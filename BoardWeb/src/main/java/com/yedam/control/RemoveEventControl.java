package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.BoardService;
import com.yedam.Service.BoardServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.EventVO;

public class RemoveEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		EventVO event = new EventVO();
		event.setTitle(title);
		event.setStart(start);
		event.setEnd(end);
		
		BoardService svc = new BoardServiceImpl();
		
		if(svc.removeEvent(event)) {
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}
	}

}
