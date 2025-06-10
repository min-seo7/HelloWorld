<%@page import="com.yedam.common.SearchDTO"%>
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
	SearchDTO search = (SearchDTO) request.getAttribute("search");
	
	%>
	<p><%=paging %></p>
    <h3>게시글 목록</h3>
    
  <!-- 검색조건추가 -->  
  <form action="boardList.do">
    <div class="row">
      <div class="col-sm-4">  <!--col-sm-4는 화면 1/4차지-->
        <select name="searchCondition" class="form-control">
          <option value="">선택하세요</option>
          <option value="T" <%=search.getSearchCondition() != null  && search.getSearchCondition().equals("T") ? "selected": "" %>>제목</option>
          <option value="W" <%=search.getSearchCondition() != null  && search.getSearchCondition().equals("W") ? "selected": "" %>>작성자</option>
          <option value="TW" <%=search.getSearchCondition() != null  && search.getSearchCondition().equals("TW") ? "selected": "" %>>제목&작성자</option>
        </select>
      </div>
      <div class="col-sm-6">
        <input type="text" name="keyword" class="form-control" value= "<%=search.getKeyword() != null ? search.getKeyword(): ""%>">
      </div>
      <div class="col-sm-2">
        <input type="submit" value="검색" class="btn btn-primary"></intput>
      </div>
    </div> 
  </form>
    
    
    
    <table class ="table">
        <thead>
            <tr>
                <th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th><th>조회수</th>
            </tr>
        </thead>
        <tbody>
        <%for(BoardVo board : list) {%>
            <tr>
                <td><a href="board.do?bno=<%=board.getBoardNO()%>&page=<%=paging.getCurrentPage()%>&keyword=<%=search.getKeyword()%>&searchCondition=<%=search.getSearchCondition() %>"><%=board.getBoardNO()%></a></td>
                <td><%=board.getTitle() %></td>
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
 <%if(p != paging.getCurrentPage()) {%>
 <li class="page-item">
 <a class="page-link" href="boardList.do?searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword() %>&page=<%=p %>"><%=p %></a></li>
  <%} else {%> 
  <li class="page-item active" aria-current="page">
    <span class="page-link"><%=p %></span>
    </li>
 <%} }%>
  
  
  
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