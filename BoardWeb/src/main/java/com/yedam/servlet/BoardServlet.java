package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.Service.BoardService;
import com.yedam.Service.BoardServiceImpl;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVo;

/*
 * 클래스가 서블릿이 되는 순서. 
 * httpServlet을 상속받아야 함. 
 * 생성자선언 - init() - service() 순으로 작성.
 * url 등록("board.serv") 
 */
@WebServlet("/board.serv")
public class BoardServlet extends HttpServlet {
	// 생성자선언
	public BoardServlet() { // 최초생성시 객체생성!
		System.out.println("BoardServlet 생성자 호출.");
	}

	// init()메소드
	@Override
	public void init(ServletConfig config) throws ServletException { // 최초호출!
		System.out.println("init 메소드 호출.");
	}

	// service()메소드.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("service 메소드 호출.");
		resp.setContentType("text/html;charset=utf-8"); // content 타입지정.

		// 요청페이지? bon = 3 파라메타
		String boardNo = req.getParameter("bno"); // 중요함!!!
		SqlSession sqlSession = DataSource.getInstance().openSession(true); // opensession이 true면 자동 커밋.
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		// 날짜 출력형식
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 상세조회
		BoardService svc = new BoardServiceImpl();
		BoardVo board = svc.getBoard(Integer.parseInt(boardNo)); 

//		BoardVo board = mapper.selectBoard(Integer.parseInt(boardNo)); // 페이지 번호에 맞게 출력되도록.
//		mapper.updateReadCnt(Integer.parseInt(boardNo)); // 조회수 카운트 증가
		// table(표) 출력.
		String str = "";
		str += "<table border = '1'>";
		str += "<tbody>";
		str += "<tr><th>글번호</th><td>" + board.getBoardNO() + "</td><th>조회수</th><td>" + board.getReadCnt()
				+ "</td></tr>";
		str += "<tr><th>제목</th><td colspan = '3'>" + board.getTitle() + "</td></tr>";
		str += "<tr><th>내용</th><td colspan = '3'>" + board.getContent() + "</td></tr>";
		str += "<tr><th>작성자</th><td colspan = '3'>" + board.getWriter() + "</td></tr>";
		str += "<tr><th>작성일시</th><td colspan = '3'>" + sdf.format(board.getWriteDate()) + "</td></tr>";
		str += "</tbody></table>";
		str += "<p><a href ='servlet/boardList.serv'>목록이동</a></p>";

		PrintWriter out = resp.getWriter();
		out.print(str);

	}
}
