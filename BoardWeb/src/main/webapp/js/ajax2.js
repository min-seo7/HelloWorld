/*
*ajax2.js
*/

// service.js에 정의해둔 메소드 사용. 
//  //service.js에 const로 svc 선언됨.


//목록출력.
svc.replyList(707,
	function(result) {//성공콜백함수
		console.log(result);
		result.forEach(function(item) { //댓글수만큼 tr생성. 
			let tr = makeRow(item);
			document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
		});
	},
	function(err) {//실패콜백함수 
		console.log(err);
	}) //파라미터(원본글번호, 성공처리함수, 실패처리함수)  //end of 목록출력.


//등록이벤트
document.querySelector('#addReply').addEventListener('click', addReplyFnc);
function addReplyFnc(e) {
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;
	if (!bno || !reply || !logId) {
		alert('필수값 입력!');
		return;
	}
	//메소드호출. 
	svc.addReply({ bno, reply, replyer: logId },
		function(data) {
			if (data.retCode == 'Success') {
				alert('등록성공!');
				let tr = makeRow(data.retVal);
				let target = document.querySelector('table:nth-of-type(2) tbody tr');
				document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr, target);
			} else {
				alert('등록실패!');
			}
		}, 
		function(err){
			console.error(err);
		})

}//end of addReply




//삭제메소드
function deleteReplyFnc(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno,
		function(result) {//성공실행함수.
			if (result.retCode == 'Success') {
				alert('삭제완료');
				e.target.parentElement.parentElement.remove();
			} else {
				alert('삭제실패');
			}
		},
		function(err) {//실패실행함수.
			console.error(err);
		}
	)
}//end of deleteReplyFnc.



