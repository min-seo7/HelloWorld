package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.Service.MemberService;
import com.yedam.Service.MemberServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.MemberVo;

public class loginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO id와 pw로 로그인 기능. 
		String id = req.getParameter("mid");
		String pw = req.getParameter("pass");
		//로그인
		MemberService svc = new MemberServiceImpl();
		MemberVo member = svc.login(id, pw);
		//성공여부체크
		if(member != null) {
			//글등록 화면.
			//세션객체를 생성해, setAttribute("loginId", member.memberId) 
			HttpSession session = req.getSession();   //cookie를 가지고 옴. 톰캣이 웹 브라우저에 접속이력으로 cookie를 심어둔.. 
			session.setAttribute("logId", member.getMemberId());  //생성된 세션에 아이디담아둠. 
			//권한에 따라 시작페이지지정
			if(member.getResponsibility().equals("User")) {
				resp.sendRedirect("addBoard.do");				
			} else if(member.getResponsibility().equals("Admin")) {
				resp.sendRedirect("memberList.do");				
			}
			
		}else {
			//로그인실패시 로그인화면으로 이동.
			req.setAttribute("msg", "ID화 PW를 확인하세요.");
			req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);
		}
		
	}

}
