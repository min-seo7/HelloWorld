package com.yedam.control;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.BoardService;
import com.yedam.Service.BoardServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.BoardVo;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청방식에 따라 분할. [get 요청시 화면 open| post요청시 저장]
		req.setCharacterEncoding("utf-8");   //한글처리
	
		
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		//추가파라미터(page, searchCondition.keyword)  => url에 파라미터.
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");	
		//url 한글 인코딩작업.
		
		
		BoardService svc = new BoardServiceImpl();

		if (req.getMethod().equals("GET")) {   //get방식요청 post요청방식에 따라 응답 출력되는 화면 다름. 
			// 요청재지정(페이지이동) modifyBoard.do?bno=23
			BoardVo board = svc.getBoard(Integer.parseInt(bno));
			req.setAttribute("board", board);
			//요청정보 추가전달!  
			req.setAttribute("page", page);
			req.setAttribute("keyword", kw);
			req.setAttribute("searchCondition", sc);
			
			req.getRequestDispatcher("WEB-INF/jsp/Modifyform.jsp").forward(req, resp);
			
		} else if (req.getMethod().equals("POST")) {
			BoardVo board = new BoardVo();
			board.setBoardNO(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);
			
			svc.modifyBoard(board); //수정
			
			resp.sendRedirect("boardList.do?page=" + page + "&searchCondition=" + sc + "&keyword=" +URLEncoder.encode(kw, "utf-8")); 
			//frontcontroller로 가서 boardList 실행. 
		}
	}

}
