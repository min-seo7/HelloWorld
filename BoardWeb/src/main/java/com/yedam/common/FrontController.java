package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;
import com.yedam.control.loginControl;
import com.yedam.control.logoutControl;

/*
 * M-V-C 중 Control역할.
 */

public class FrontController extends HttpServlet {
	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		//boardList.do - 글목록 출력기능.
		//처리순서가 중요.
		map.put("/boardList.do", new BoardListControl());  //글목록
		map.put("/board.do", new BoardControl()); //상세화면
		map.put("/addBoard.do", new AddBoardControl());  //등록
		map.put("/modifyBoard.do", new ModifyBoardControl());  //수정
		map.put("/removeBoard.do", new RemoveBoardControl()); //삭제
		//member관련.
		map.put("/loginForm.do", new LoginFormControl()); //화면
		map.put("/login.do", new loginControl()); //로그인기능
		map.put("/logout.do", new logoutControl());
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // ~.do때마다 호출됨. 												
		// url의 호출(http://localhost:8080/BoardWeb/boardList.do) -> 페이지 호출 ->control/
		String uri = req.getRequestURI(); // /BoardWeb/boardList.do
		String context = req.getContextPath();
		String page = uri.substring(context.length()); //   /boardList.do
		Control sub = map.get(page);
		sub.exec(req, resp); //
		
	}
}
