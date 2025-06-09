<%@page import="com.yedam.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" /><!-- 헤더파일 연결 -->
<%
BoardVo board = (BoardVo) request.getAttribute("board");
%>
<h3>상세화면</h3>
<form action="modifyBoard.do">
	<input type="hidden" name="bno" value="<%=board.getBoardNO()%>">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><%=board.getBoardNO()%></td>
			<th>조회수</th>
			<td><%=board.getReadCnt()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><%=board.getTitle()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea readonly><%=board.getContent()%></textarea></td>
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
			<td colspan="4" align="center"><input type="submit" value="수정" class="btn btn-warning">
				<button class="btn btn-danger" type="button">삭제</button></td>
		</tr>
	</table>
</form>

<script>
	let bno = "<%=board.getBoardNO()%>";
	console.log(bno);
	document.querySelector('button.btn-danger').addEventListener('click',
			function() {
				location.href = 'removeBoard.do?bno=' + bno;
			})
</script>
<jsp:include page="../include/footer.jsp" />