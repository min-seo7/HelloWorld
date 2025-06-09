package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.BoardService;
import com.yedam.Service.BoardServiceImpl;
import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.vo.BoardVo;

public class BoardListControl implements Control {  

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
	//	req.setAttribute("maName","HongKildong"); - 전달 연습용 ~ 
		String page = req.getParameter("page");
		page = page == null ? "1" : page;   //boardList.do는 1페이지가 출력되도록.
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVo> list = svc.boardList(Integer.parseInt(page));
		//페이징 계산.
		int totalCnt = 112;
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
		
		req.setAttribute("blist", list); //요청정보에 값을 담아서 전달. 
		req.setAttribute("pageInfo", paging);
		
		//요청재지정(페이지이동)
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);    //froward는 페이지 이동을 의미. 
		
		//글목록 페이징.
		
		
	}
}
