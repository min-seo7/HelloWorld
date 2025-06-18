package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.Service.MemberService;
import com.yedam.Service.MemberServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.MemberVo;

public class signUpControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//get요청 = 화면출력.
		//post요청 = 회원등록.
		if(req.getMethod().equals("GET")) {
			req.getRequestDispatcher("member/signUp.tiles").forward(req, resp);
			
		} else if(req.getMethod().equals("POST")) {
			
			//images 폴더에 업로드작업.
			String savePath = req.getServletContext().getRealPath("images"); //이미지폴더찾기! 
			//MultipartRequest필드구성 [1.요청정보 2.경로 3.최대크기 4.인코딩(한글) 5.리네임정책(동일명 서버에존재가능->so,리네임)]
			MultipartRequest mr = new MultipartRequest(
					req, //요청정보.
					savePath, //업로드경로
					1024 * 1024 * 5, //최대크기(5MB).
					"UTF-8",//인코딩
					new DefaultFileRenamePolicy()//리네임정책.
					);  //cos maven에서 추가함. 
				
			//db 입력.
			String id = mr.getParameter("userId");
			String pw = mr.getParameter("userPw");
			String nm = mr.getParameter("userName");
			String img = mr.getFilesystemName("userImg");
			
			MemberVo member = new MemberVo();
			member.setMemberId(id);
			member.setPassword(pw);
			member.setMemberName(nm);
			member.setImg(img);
			
			MemberService svc = new MemberServiceImpl();
			if(svc.addMember(member)) {
				resp.sendRedirect("boardList.do");
			}
			
			
		}
	}

}
