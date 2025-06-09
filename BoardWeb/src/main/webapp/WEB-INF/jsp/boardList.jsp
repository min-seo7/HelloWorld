<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>   <!-- 헤더파일 연결 -->
	<%
	List<BoardVo> list = (List<BoardVo>) request.getAttribute("blist");	 //getAttribute 반환타입은 object 타입임! 형변환 시켜줘야~ 
	PageDTO paging = (PageDTO) request.getAttribute("pageInfo");
	
	%>
	<p><%=paging %></p>
    <h3>게시글 목록</h3>
    
    <table class ="table">
        <thead>
            <tr>
                <th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th><th>조회수</th>
            </tr>
        </thead>
        <tbody>
        <%for(BoardVo board : list) {%>
            <tr>
                <td><a href="board.do?bno=<%=board.getBoardNO()%>"><%=board.getBoardNO()%></a></td>
                <td><%=board.getTitle() %></a></td>
                <td><%=board.getWriter() %></td>
                <td><%=board.getWriteDate() %></td>
                <td><%=board.getReadCnt() %></td>
            </tr>
            <%} %>
        </tbody>
    </table>
    
    <!-- paging 시작. -->
    <nav aria-label="Page navigation example">
<ul class="pagination justify-content-center">

<!-- 이전페이지 활성화. -->
<%if(!paging.isPrev()){ %>
  <li class="page-item disabled">
    <a class="page-link">Previous</a>
  </li>
  <%} else { %>
  <li class="page-item">
    <a class="page-link" href="boardList.do?page<%=paging.getStart() - 1 %>">Previous</a>
  </li>
  <%} %>
  
  
 <!-- 페이징 정보를 활용. -->
  <%for(int p = paging.getStart(); p<= paging.getEnd(); p++) { %>
  <li class="page-item"><a class="page-link" href="boardList.do?page=<%=p %>"><%=p %></a></li>
  <%} %>
  
  <!-- 이후페이지 활성화. -->
  <%if(!paging.isNext()){ %>
  <li class="page-item disabled">
    <a class="page-link">Next</a>
  </li>
  <%} else { %>
  <li class="page-item">
    <a class="page-link" href="boardList.do?page=<%=paging.getEnd() + 1 %>">Next</a>
  </li>
  <%} %>
  
  
</ul>
</nav>
    <!-- paging 종료. -->
    
<jsp:include page="../include/footer.jsp" /> <!-- 푸터파일 연결 -->