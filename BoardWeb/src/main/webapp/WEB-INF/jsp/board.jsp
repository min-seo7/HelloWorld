<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://cdn.datatables.net/2.3.2/css/dataTables.dataTables.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src= "https://cdn.datatables.net/2.3.2/js/dataTables.js"></script>

<h3>상세화면</h3>
<form action="modifyBoard.do">
	<input type="hidden" name="bno" value="${board.boardNO}"> <input
		type="hidden" name="page" value="${page}"> <input
		type="hidden" name="searchCondition" value="${SearchCondition}">
	<input type="hidden" name="keyword" value="${keyword}">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.boardNO}</td>
			<th>조회수</th>
			<td>${board.readCnt}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea readonly>${board.content}</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${board.writer }</td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan="3">${board.writeDate }</td>
		</tr>
		<tr>
			<c:choose>
				<c:when test="${board.writer != logId}">
					<td colspan="4" align="center"><input type="submit" value="수정"
						class="btn btn-warning">
						<button class="btn btn-danger" type="button">삭제</button></td>
				</c:when>
				<c:otherwise>
					<td colspan="4" align="center"><input type="submit" value="수정"
						class="btn btn-warning" disabled>
						<button class="btn btn-danger" type="button" disabled>삭제</button></td>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</form>

<!-- 댓글관련 페이지 -->
<style>
div.reply ul {
	list-style-type: none;
}

div.reply span {
	display: inline-block;
}
</style>
<div class="container reply">
	<div class="header">
		<input class="col-sm-8" id="reply">
		<button class="col-sm-3 btn btn-primary" id="addReply">등록</button>
		<button class="col-sm-3 btn btn-danger" id="delReply">삭제</button>
	</div>
	<!-- 데이터테이블 적용. -->
	<table id="example" class="display">
		<thead>
			<tr>
				<th>댓글번호</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>댓글번호</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</tfoot>
	</table>
	<!-- 데이터테이블 적용 end. -->
</div>
<!-- 댓글관련 페이지 -->
<script>
	let bno = "${board.boardNO}";
	let page = "${page}"
	let logId = "${logId}";
	console.log(bno);
	document.querySelector('button.btn-danger').addEventListener('click',
			function() {
				location.href = 'removeBoard.do?bno=' + bno;
			})
</script>
<script>
const table = new DataTable('#example', {
    ajax: 'replyList.do?bno='+bno + '&page=' + page,
    columns: [
        { data: 'replyNo' },
        { data: 'reply' },
        { data: 'replyer' },
        { data: 'replyDate' }
    ], 
    lengthMenu: [5, 10, 15, 20, -1],
    order: [[0, 'desc']]
});



//row 삭제
table.on('click', 'tbody tr', (e) => {
    let classList = e.currentTarget.classList;
 	
    if (classList.contains('selected')) {
        classList.remove('selected');
    }
    else {
        table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
        classList.add('selected');
    }
});
 
document.querySelector('#delReply').addEventListener('click', async function (e) {
	//화면갱신. 
	
	if(!document.querySelector('tr.selected')){
		alert('댓글을 선택하세요');
		return;
	}  //댓글미선택시 선택안내. (selected가 안됐을때. )
	
	let rno = document.querySelector('tr.selected').children[0].innerHTML;  //클래스 이릉미 selected인 tr태그찾기.  
	let data = await fetch('removeReply.do?rno=' + rno);
	let result = await data.json();
	if(result.retCode == "Success"){
	    table.row('.selected').remove().draw(false);	
	} else {
		alert("삭제실패");
	}
});



function addNewRow() {
	//ajax호출
	let reply= document.querySelector('#reply').value;
	if(!reply || !logId){
		return;
	}
  	fetch('addReply.do?bno'+bno+'&reply='+reply+'&replyer='+logId)
  	.then(data => data.json())
  	.then(result => {
		console.log(result);
		let rvo = result.retVal;
	//화면 row추가출력
    table.row
        .add({replyNo: 'rvo.replyNo',
        	   reply: 'rvo.reply',
        	   replyer: 'rvo.replyer',
        	   replyDate: 'rvo.replyDate'              	
        })
        .draw(false);
  	})
 .catch(err => console.log(err));
}
      
document.querySelector('#addReply').addEventListener('click', addNewRow);

</script>