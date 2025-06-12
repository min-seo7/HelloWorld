package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.MemberService;
import com.yedam.Service.MemberServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.MemberVo;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String order = req.getParameter("order");
		order = order == null ? "member_id" : order; //order의 default값 지정. 
		MemberService svc = new MemberServiceImpl();
		List<MemberVo> list = svc.memberList(order);
		req.setAttribute("memberList", list);
		
		//출력jsp 페이지
		req.getRequestDispatcher("admin/memberList.tiles").forward(req, resp);   //.tiles는 타일즈 적용이 되어 메인 tiles파일로 넘어가서 개별경로 찾아감. (definition을 찾아서 다음 경로로 진행)
	}

}
