/**
 * reply.js
 */

let page = 1;
console.log(bno);

Date.prototype.format = function() {
	let yyyy = this.getFullYear(); //2025-05-27 12:39:23 
	let MM = this.getMonth() + 1;
	let dd = this.getDate();
	let hh = this.getHours();
	let mm = this.getMinutes();
	let ss = this.getSeconds();

	return yyyy + '-' + ('0' + MM).slice(-2) + '-' + ('0' + dd).slice(-2) + ' ' + ('0' + hh).slice(-2) + ':' + ('0' + mm).slice(-2) + ':' + ('0' + ss).slice(-2);
}

//글목록 출력
showReplyList();
function showReplyList(){
	document.querySelector('#target').innerHTML = ""; //목록지우기
	svc.replyList({ bno, page } //게시글번호
		, result => {
			console.log(result)
			let ul = document.querySelector('#target');
			let template = document.querySelector('#target li');

			for (let reply of result) {
				template = makeTemplate(reply);

				ul.insertAdjacentHTML("beforeend", template);
			}
			//댓글페이지
			showPageList()
		}
		, err => console.log(err)
	);
}  //end of showReplyList.




//이벤트모음.
//1) 댓글등록이벤트.
document.querySelector('#addReply').addEventListener('click', addReplyHandler);
//2) 댓글링크 이벤트등록. 
function pagingEvent(){
document.querySelectorAll('.footer nav a').forEach(function(elem,idx){
	elem.addEventListener('click', function(e){
		page = e.target.dataset.page; //a태그의 <a data-page="1">1</a>
		showReplyList();		
	})
});

document.querySelectorAll('#target li').forEach(elem => {	
	elem.addEventListener('mouseover',() => {elem.style.background = rgb(214.255,255)});
	elem.addEventListener('mouseover',() => {elem.style.background = ''});
});
} //end of pagingEvent.



//댓글등록이벤트핸들러함수.
function addReplyHandler(e) {
	let reply = document.querySelector("#reply").value;
	if (!logId || !reply) {
		alert('값을 확인하세요!');
		return;
	}
	//댓글등록
	svc.addReply({ bno, reply, replyer: logId }
		, result => {
			let ul = document.querySelector('#target');
			if (result.retCode == "Success") {
					let rval = result.retVal;
					//ul.insertAdjacentHTML("afterbegin", makeTemplate(rval));
					page = 1;//첫페이지로 지정
					showReplyList();					
					document.querySelector('#reply').value = ""; //입력값 초기화
					}
				}
		, err => console.log(err)
	)
}



//댓글 페이징 출력. [댓글 출력이 5건씩 여러페이지로 출력되도록] 
function showPageList() {
	svc.replyCount(bno // 첫번째매개값.
		, result => {
			console.log(result.totalCnt); // {totalCnt: 80}
			let totalCnt = result.totalCnt;
			let start, end; // 첫번째 ~ 마지막 페이지
			let prev, next; // 이전, 이후 페이지 존재여부
			let realEnd = Math.ceil(totalCnt / 5); // 건수를 기준으로 계산한 마지막 페이지.
			end = Math.ceil(page / 10) * 10; // 계산상의 마지막 페이지.
			start = end - 9;
			end = end > realEnd ? realEnd : end;
			prev = start > 1;
			next = end < realEnd;
			// 기존 페이징 clear.
			document.querySelector('nav ul.pagination-sm').innerHTML = ""; // 지우기.
			// 페이지목록 출력.
			let target = document.querySelector('nav ul.pagination-sm');
			// 이전페이지.
			let str;
			if (prev) {
				str = `<li class="page-item">
			           <a class="page-link" href="#" data-page="${start-1}">Previous</a>
			           </li>`;
			} else {
				str = `<li class="page-item disabled">
			           <span class="page-link" href="#">Previous</span>
			           </li>`;
			}
			target.insertAdjacentHTML('beforeend', str);
			// 1 ~ 10 페이징.
			for (let p = start; p <= end; p++) {
				if (p == page) { // 선택페이지 지정.
					str = `<li class="page-item active" aria-current="page">
				           <span class="page-link">${p}</span>
				           </li>`;
				} else {
					str = `<li class="page-item"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`;
				}
				target.insertAdjacentHTML('beforeend', str);
			}
			// 이후페이지.
			if (next) {
				str = `<li class="page-item">
				       <a class="page-link" href="#" data-page="${end+1}">Next</a>
				       </li>`;
			} else {
				str = `<li class="page-item disabled">
				       <span class="page-link" href="#">Next</span>
				       </li>`;
			}
			target.insertAdjacentHTML('beforeend', str);
			// 생성한 A태그에 이벤트등록.
			pagingEvent();
		}
		, err => console.log(err)
	);
}; // end of showPageList


//댓글화면출력.
function makeTemplate(reply ={}){
	let rdate = new Date(reply.replyDate).format();
	template = `
		<li data-rno=${reply.replyNo}>
		  <span class="col-sm-2">${reply.replyNo}</span>
		  <span class="col-sm-4">${reply.reply}</span>
		  <span class="col-sm-2">${reply.replyer}</span>
		  <span class="col-sm-2">${rdate}</span>
		  <span class="col-sm-1"><button onclick="deleteReply(event)" class="btn btn-danger">삭제</span> 
		</li>
		`;
		return template;
}



//댓글삭제함수. 
async function deleteReply(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;
	let data = await fetch('replyInfo.do?rno=' + rno);
	let result = await data.json();
	if (result.replyer != logId) {
		alert('권한없음!');
		return;
	}
	// 권한이 있을 경우에 삭제함.
	svc.removeReply(rno
		, result => {
			if (result.retCode == "Success") {
				alert("처리성공!");
				//e.target.parentElement.parentElement.remove();
				showReplyList();
			} else {
				alert("처리실패!");
			}
		}
		, err => console.log(err)
	);// 삭제메소드.
	
	삭제하고, 목록글 확인, 목록이 없으면 이전페이지 이동???

} // end of deleteReply.
