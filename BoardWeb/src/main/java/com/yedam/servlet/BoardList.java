package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVo;

@WebServlet("/boardList.serv")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardList() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		//컨텐츠 담고 있는 정보지정. 
		PrintWriter out = response.getWriter();  //출력스트림 printwriter => 웹브라우저상에 출력됨. filewriter는 파일상에 출력!
		out.print("<h3>hello</h3>");
		out.print("<h2>나는 한글이여요! 😂😂</h2>");
		out.print("<h2>까탈스럽네요!! 🙄🙄<h2>");
		SqlSession sqlSession = DataSource.getInstance().openSession();
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		List<BoardVo>list = mapper.selectList();
	
		out.print("<table border='1'");
		out.print("<thead><tr><th>글번호</th><th>글제목</th><th>작성자</th></tr></thead>");
		out.print("<tbody>");
		for (int i = 0; i < list.size(); i++) {
			out.print("<tr>");
			out.print("<td align = 'center'>"+list.get(i).getBoardNO() + "</td>");
			out.print("<td>"+list.get(i).getTitle() + "</td>");
			out.print("<td>"+list.get(i).getWriter() + "</td>");
			out.print("</tr>");	
		}
		out.print("<tbody></table>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
