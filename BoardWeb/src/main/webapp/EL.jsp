<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.Service.BoardServiceImpl"%>
<%@page import="com.yedam.Service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setAttribute("msg", "Hello"); 
		session.setAttribute("errorMsg","ID, PW확인하세요");  //일정기간 서버에 정보남음. 
		application.setAttribute("projectName", "BoardWeb");  //서블릿이 init된 시점에~ session보다 생존시간 김.
		String name = "Hong";
		System.out.print(name);
		BoardService svc = new BoardServiceImpl();
		SearchDTO search = new SearchDTO();
		search.setPage(1);
		List<BoardVo> list = svc.boardList(search);
		request.setAttribute("blist", list);
	%>
	<p>${10 - 5 eq 10} <!-- EL은 별도의 연산자도 갖고 있음. ['=='= eq],['=/=' = ne] -->
	${!empty msg}  <!-- empty는 값의 유무를 확인 -->
	${errorMsg}   <!-- getAttribute 대신 식으로 활용가능.jsp에서 변수 불러돌떄 [%=변수명 %]사용을 ${변수명} 가능.-->
	${empty hello}</p> <!-- 값이 없으므로, true -->
	
	<c:set var="name" value="Hongkildong"></c:set>  <!-- 변수선언 & 값할당. -->
	<c:out value="${name }"></c:out> <!-- 제일상단 taglib의 prefix의 c로 지정해서 간단히 c:사용가능 -->
	
	<c:set var="age" value="20"></c:set>   
	<c:if test="${age >= 20 }">
		<p>성인</p>
	</c:if>
	
	<!-- 조건문(if, else -->
	<c:choose>
		<c:when test="${!empty logId }">
		   <p>로그인 상태</p>
		</c:when>
		<c:otherwise>
		   <p>로그아웃</p>
	    </c:otherwise>
	</c:choose>
	
	<!-- 반복 -->
	<c:forEach var="i" begin="1" end="5" step="2">
		<span>i의 값은 ${i}</span>	
	</c:forEach>
	
	<!-- 반복2 -->
	<table border="1">
	<c:forEach var="board" items="${blist }">
		<tr>
			<td>${board.boardNO }</td> 
			<td>${board.title }</td>
			<td><c:out value="${board.writer }" /></td>  
			<td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>