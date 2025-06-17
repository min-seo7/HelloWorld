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
import com.yedam.control.AddEventControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.AllControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.ChartControl;
import com.yedam.control.ChartPageControl;
import com.yedam.control.EventListControl;
import com.yedam.control.GetReplyControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;
import com.yedam.control.RemoveEventControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyCountControl;
import com.yedam.control.ReplyInfoControl;
import com.yedam.control.ReplyListControl;
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
		map.put("/chart.do", new ChartControl());
		map.put("/chartPage.do", new ChartPageControl());
		//member관련.
		map.put("/loginForm.do", new LoginFormControl()); //화면
		map.put("/login.do", new loginControl()); //로그인기능
		map.put("/logout.do", new logoutControl());
		//회원목록
		map.put("/memberList.do", new MemberListControl());
		//상품관련
		map.put("/allProduct.do", new AllControl());
		
		//댓글관련, json형태 파일로~ 
		map.put("/replyList.do",new ReplyListControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/getReply.do", new GetReplyControl());
		map.put("/replyCount.do", new ReplyCountControl()); //댓글건수
		map.put("/replyInfo.do", new ReplyInfoControl());
		
		
		//events
		map.put("/eventList.do", new EventListControl());
		map.put("/addEvent.do", new AddEventControl());
		map.put("/removeEvent.do", new RemoveEventControl());
		
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
