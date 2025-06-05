<%@page import="com.yedam.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.Service.BoardServiceImpl"%>
<%@page import="com.yedam.Service.BoardService"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//자바코드를 쓸 수 있는 영역!  
		
	String str = "Hello, World";
	for (int i = 0; i < 10; i++) {
	%>
	<h3>여기는 HTML영역입니다.</h3>
	<%
	} //end of for.
		//여기는 자바영역이여요!
	BoardService svc = new BoardServiceImpl();
	List<BoardVo> list = svc.boardList();
	out.print("<ul>");  //java영역내에서도 out.print("")를 사용해서 html사용가능!
	for(BoardVo board : list){
	%>
	<li><%= board.getBoardNO() %>,<%=board.getTitle() %></li>
	<%	
	}
	out.print("</ul>");
	System.out.println(str);
	%>
</body>
</html>