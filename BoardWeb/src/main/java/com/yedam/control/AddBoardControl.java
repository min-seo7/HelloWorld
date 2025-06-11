package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.BoardService;
import com.yedam.Service.BoardServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.BoardVo;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글처리 인코딩.
		req.setCharacterEncoding("utf-8");

		// 요청방식 get or post 구분처리
		if (req.getMethod().equals("GET")) {
			// Web-INF/jsp/addBoard.jsp
			req.getRequestDispatcher("user/addBoard.tiles").forward(req, resp);  
			
		} else if (req.getMethod().equals("POST")) { // 등록
			// post요청
			// addBoard.serv?title=제목&content=내용&writer=user01
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");

			// 메소드의 메개값으로 전달.
			BoardVo board = new BoardVo();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);

			// 업무서비스
			BoardService svc = new BoardServiceImpl();
			if (svc.registerBoard(board)) {
				System.out.println("등록성공.");
				// 등록이 성공하면 목록페이지로 이동.
				 resp.sendRedirect("boardList.do");
			} else {
				System.out.println("등록실패.");
			}
		}

	}

}
