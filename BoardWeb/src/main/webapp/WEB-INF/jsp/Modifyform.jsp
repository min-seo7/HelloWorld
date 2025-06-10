<%@page import="com.yedam.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
<!-- 헤더파일 연결 -->
<h3>수정화면(modifyForm.jsp)</h3>
<%
BoardVo board = (BoardVo) request.getAttribute("board"); //modifycontroller의 req.setAttribute("board", board); 받음.
String pg = (String)request.getAttribute("page");
String sc = (String)request.getAttribute("searchCondition");
String kw = (String)request.getAttribute("keyword");
%>

<form action="modifyBoard.do" method="post">
	<!-- post방식은 주소에 파라메터 보이지 않음 -->
	<input type="hidden" name="bno" value="<%=board.getBoardNO()%>">
	<input type="hidden" name="page" value="<%=pg %>">
	<input type="hidden" name="searchCondition" value="<%=sc%>">
	<input type="hidden" name="keyword" value="<%=kw %>">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><%=board.getBoardNO()%></td>
			<th>조회수</th>
			<td><%=board.getReadCnt()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" name="title"
				value="<%=board.getTitle()%>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea cols="45" rows="4" name="content"><%=board.getContent()%></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><%=board.getWriter()%></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan="3"><%=board.getWriteDate()%></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input type="submit" value="저장">
				<button>삭제</button></td>
		</tr>
	</table>
</form>



<jsp:include page="../include/footer.jsp" />
