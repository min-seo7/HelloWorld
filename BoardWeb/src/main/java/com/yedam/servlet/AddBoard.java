package com.yedam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.BoardService;
import com.yedam.Service.BoardServiceImpl;
import com.yedam.vo.BoardVo;

@WebServlet("/addBoard.serv")
public class AddBoard extends HttpServlet{
	
	@Override  
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//addBoard.serv?title=제목&content=내용&writer=user01
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		//메소드의 메개값으로 전달.
		BoardVo board = new BoardVo();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		//업무서비스
		BoardService svc = new BoardServiceImpl();
		if(svc.registerBoard(board)) {
			System.out.println("등록성공.");
			//등록이 성공하면 목록페이지 호출
			resp.sendRedirect("servlet/boardList.serv");
		} else {
			System.out.println("등록실패.");
		}
	}
}
