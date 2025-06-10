package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.BoardService;
import com.yedam.Service.BoardServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.BoardVo;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// http://localhost:8080/BoardWqb/board.do?bno=34 =>파라메터 전달
		// 목록에서 제목클릭시 해당 글번호 상세조회기능.
		String bno = req.getParameter("bno"); // 요청을 받음.
		//추가파라미터(page, searchCondition.keyword)
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		//글 상세조회
		BoardService svc = new BoardServiceImpl(); // 서비스 객체생성.
		BoardVo board = svc.getBoard(Integer.parseInt(bno)); // 객체안 메소드 호출.
		// 요청정보에 값을 담아서 전달.
		req.setAttribute("board", board); 
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		// 요청재지정(페이지이동)=>보여지는 페이지
		req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp); // froward는 페이지 이동을 의미.
	}
}