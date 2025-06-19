/**
 * ajax.js
 * Asyschronous Javascript And Xml 
 */

//비동기 vs 동기방식
//setTimeout은 비동기 함수.   1000 = 1초

//setTime함수를 동기방식으로 사용하는 방법. 
/*setTimeout(function(){  
	console.log("1");
	setTimeout(function(){
		console.log("2");
		setTimeout(function(){
			console.log("start");
		}, 2500);
	}, 2000);
}, 1000);    //==>총 작업시간 5.5초


//비동기방식 사용법 [코드상 순서와 다르게 작업시간에 맞춰 출력됨.(2->start->1순으로 )]
 setTimeout(function(){  
   console.log("1");
}, 2000);

setTimeout(function(){
   console.log("2");
}, 1000);

setTimeout(function(){
   console.log("start");
}, 1500); */

//{"id": 1, "first_name": "Hong"} => json 객체   [json -> javascript로 변환하는 것을 파싱이라 함.]
//->{id: 1, first_name: "Hong"} ==> javascript 객체 [데이터사용에 용이! so, parsing.]

//객체.XMLHttpRequest
console.log("start");
let xhtp = new XMLHttpRequest();   //ajax호출. 비동기방식. 
xhtp.open('get', 'replyList.do?bno=707'); //페이지 요청.
xhtp.send(); //페이지 요청. 
xhtp.onload = function() {
	console.log(xhtp.responseText)
	let data = JSON.parse(xhtp.responseText);   //json문자열을 자바스크립트 객체로 parsing
	data.forEach(function(item) { 
		//console.log(item);
		let tr = makeRow(item);
		//tr을 tboby에 추가.
		
		document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
	});
	//document.querySelector('#show').innerHTML = xhtp.responseText;
};
//댓글등록이벤트.
document.querySelector('#addReply').addEventListener('click', addReplyFnc);

//댓글등록함수.
function addReplyFnc(e) {
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;
	//필수입력. 
	if (!bno || !reply || !logId) {
		alert('필수값 입력!');
		return;
	}
	const addAjax = new XMLHttpRequest();
	addAjax.open('get', 'addReply.do?bno=' + bno +'&reply=' + reply +'&replyer=' + logId); 
	addAjax.send();
	addAjax.onload = function(ev) {
		let result = JSON.parse(addAjax.responseText);
		if (result.retCode == 'Success') {
			console.log(result.retVal);
			alert('등록성공!');
			let tr = makeRow(result.retVal);
			//부모요소.insertBefore(새요소, 대상)
			let target = document.querySelector('table:nth-of-type(2) tbody tr');
			document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr,target);
		} else {
			alert('등록실패!');
		}
	}
}


//댓글삭제함수
function deleteReplyFnc(e) {
	if(!confirm("삭제하시겠습니까?")){
		return;
	}
	let rno = e.target.parentElement.parentElement.dataset.rno;
	console.log(rno);
	const delAjax = new XMLHttpRequest();
	delAjax.open('get', 'removeReply.do?rno=' + rno);
	delAjax.send();

	delAjax.onload = function(e) {
		let result = JSON.parse(delAjax.responseText);
		if (result.retCode == 'Success') {
			e.target.parentElement.parentElement.remove(); //화면처리
		} else {
			alert('처리실패');
		}
	}
}

//댓글을 출력할 수 있도록 row 생성.
function makeRow(item){
	let tr = document.createElement('tr');//<tr></tr>==>이런형태의 요소를 만들어 줌. 
			tr.setAttribute('data-rno', item.replyNo); //<tr data-rno="댓글번호">
			//글번호, 내용, 작성자
			for (let prop of ['replyNo', 'reply', 'replyer']) {

				let td = document.createElement('td');
				td.innerHTML = item[prop]; // <-> 둘다 사용가능. item.'replyNo'
				tr.appendChild(td);//<tr><td></td></tr> 자식으로 달기.	
			}
			//button생성.
			let td = document.createElement('td');
			let btn = document.createElement('button');
			btn.addEventListener('click', deleteReplyFnc);  //(이벤트 유형, 이벤트가 발생하면 실행할 함수.)
			btn.innerHTML = '삭제';
			btn.className = 'btn btn-danger';
			td.appendChild(btn);
			tr.appendChild(td);
			return tr; //makeRow를 호출한 영역으로 tr반환. 
}//end of makeRow;


function memberList() {
	//console.log("1");
	//console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText);
	//console.log(data);
	let str = "<ul>";
	data.forEach(function(item, idx, arr) {
		console.log(xhtp.responseText);
		str += "<li>" + item.id + "," + item.first_name + "</li>";
	});
	str += "</ul>";
	document.querySelector('#show').innerHTML = str;
}
console.log("end");





//fetch('data/sample.json')