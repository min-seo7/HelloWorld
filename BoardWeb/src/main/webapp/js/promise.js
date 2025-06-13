/**
 * promise.js 
 * 동기방식 비동기방식.
 * 
 * promise 객체역할
 * 비동기방식의 처리를 동기방식의 순서로 처리.
 * 
 * -화살표함수??? 
 * 함수정의방법1
 * function add(num1, num2){
 * 		return num1 + num2;
 * }
 * 
 * 함수정의방법2(함수표현식)
 * const add = function add(num1, num2){
 * 		return num1 + num2;
 * } 
 *  
 * 화살표 함수로 표현방법.
 * const add = (num1, num2) => num1 + num2; 로 사용가능. 
 * 
 * //ajax호출방식
 * fetch(url) =>get방식
 * fetch(url, option) =>post방식
 * 
 * 
 */
//let data = "";
/*
setTimeout(function(){
	data = "Hello, World";
	console.log(data);
},0); //0=측시실행 1000=1초


for(let i = 0; i <10000; i++){
	
}
*/


//promise 객체설명
/*let promise = new Promise(function(resolve, reject){
	setTimeout(function(){
	resolve("성공했을 때 실행할 함수.");
		
	},1000);
	//reject("실패했을때 함수.");
});

promise
	.then(function(data){
		console.log(data)
		return new promise(function(resolve, reject){
			resolve("두번째 호출");	
		})
	})
	.then(function(result){
		console.log(result);
	})
	.catch(function(err){
		console.log('=>',err);
	}) */

//fetch 'post'방식


//댓글목록
fetch('replyList.do?bno=707')
	.then(function(data) {
		//console.log(data); //Response결과
		return data.json(); //json -> object
	})
	.then(function(result) {
		console.log(result);
		result.forEach(function(item) { //댓글수만큼 tr생성. 
			let tr = makeRow(item);
			document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
		});
	})
	.catch(function(err) {
		console.log(err);
	})//댓글목록출력.




//댓글등록함수
document.querySelector('#addReply').addEventListener('click', addReplyFnc);
function addReplyFnc(e) {
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;
	if (!bno || !reply || !logId) {
		alert('필수값 입력!');
		return;
	}
	//ajax호출
	fetch('addReply.do?bno=' + bno + '&reply=' + reply + '&replyer=' + logId)
		.then(json => json.json()) //json객체를 자바스크립트 객체로 변경. 
		.then(result => { //
			if (data.retCode == 'Success') {
				alert('등록성공!');
				let tr = makeRow(data.retVal);
				let target = document.querySelector('table:nth-of-type(2) tbody tr');
				document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr, target);
			} else {
				alert('등록실패!');
			}
		})
		.catch(function(err) {
			console.log(err);
		})


	//end of addReplyFnc



	//댓글목록출력

	//삭제함수.
	function deletReplyFnc() {
		if (!confirm("삭제하겠습니까?")) {
			return;
		}
		//removeReply.do?rno=23
		let rno = e.target.parentElement.parentElement.dataset.rno;

		//ajax호출
		//방법1(화살표함수 사용.)
		fetch('removeReply.do?rno=' + rno) //작성방법 2가지
			.then(json => json.json())
			.then(data => {
				if (data.retCode == 'Success') {
					alert('삭제완료');
					e.target.parentElement.parentElement.remove();
				} else {
					alert('삭제실패');
				}
			})
			.catch(err => console.error(err))

		/*fetch('removeReply.do?rno='+ rno)
		.then(function(json){
			return json.json();
		}) 
		.then(function(data){
			if(data.retCode == 'Success'){
				alert('삭제완료');
				e.target.parentElement.parentElement.remove();
			} else{
				alert('삭제실패');
			}
		})
		.catch(function(err){
			console.error(err);
		})*/

	}


	//댓글 한줄 row 생성. 
	function makeRow(item) {
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
		btn.addEventListener('click', deletReplyFnc);  //(이벤트 유형, 이벤트가 발생하면 실행할 함수.)
		btn.innerHTML = '삭제';
		btn.className = 'btn btn-danger';
		td.appendChild(btn);
		tr.appendChild(td);
		return tr; //makeRow를 호출한 영역으로 tr반환. 
	}
}//end of makeRow;