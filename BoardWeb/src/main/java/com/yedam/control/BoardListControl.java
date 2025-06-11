package com.yedam.control;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.BoardService;
import com.yedam.Service.BoardServiceImpl;
import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVo;

public class BoardListControl implements Control {  

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
	//	req.setAttribute("maName","HongKildong"); - 전달 연습용 ~ 
		String page = req.getParameter("page");
		page = page == null ? "1" : page;   //boardList.do는 1페이지가 출력되도록.
		String sc = req.getParameter("searchCondition");
		sc = sc == null ? "" : sc;
		String kw = req.getParameter("keyword");
		kw = kw == null ? "" : kw;
		kw = URLDecoder.decode(kw); //16진수로 출력되는 문자를 한글로 인코딩. 
		
		//검색조건
		SearchDTO search = new SearchDTO();
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(sc);
		search.setKeyword(kw);
		
		//데이터처리.
		BoardService svc = new BoardServiceImpl();
		List<BoardVo> list = svc.boardList(search);
		
		//페이징 계산.
		int totalCnt = svc.getTotalCount(search);
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
		//jsp페이지에 정보전달. 
		req.setAttribute("blist", list); //요청정보에 값을 담아서 전달. 
		req.setAttribute("pageInfo", paging);
		req.setAttribute("search", search);
		
		//요청재지정(페이지이동)
		req.getRequestDispatcher("user/boardList.tiles").forward(req, resp);    //froward는 페이지 이동을 의미.		
	}
}
