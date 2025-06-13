/**
 * service.js
 */
//svc객체의 add메소드.
const svc = {
	 //목록출력 메소드
	 replyList(bno, successCallback, errorCallback){ 
		fetch('replyList.do?bno=' + bno)
		.then(data => data.json())
		.then(successCallback)
		.catch(errorCallback)
	 },
	 //댓글삭제메소드
	 removeReply(rno, successCallback, errorCallback){
		//ajax
		fetch('removeReply.do?rno=' + rno)
		.then(data => data.json())
		.then(successCallback)
		.catch(errorCallback)
	 },
	 //댓글등록메소드.
	 addReply(param = {bno, reply, replyer}, successCallback, errorCallback){
		//ajax
		fetch('addReply.do',{
			method: 'post',
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			body:'bno=' + param.bno + '&reply=' + param.reply + '&replyer=' + param.replyer 
		})
		 	 .then(data => data.json())
			 .then(successCallback)
			 .catch(errorCallback)
	 }
	 
	 
	 
	 
}//end of service


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



