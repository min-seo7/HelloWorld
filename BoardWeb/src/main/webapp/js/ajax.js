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
let xhtp = new XMLHttpRequest();
xhtp.open('get', 'replyList.do?bno=707'); //페이지 요청.
xhtp.send(); //페이지 요청. 
xhtp.onload = function(){
	console.log(xhtp.responseText)
	let data = JSON.parse(xhtp.responseText);
	data.forEach(function(item){
		console.log(item);
		let tr = document.createElement('tr');//<tr></tr>==>이런형태의 요소를 만들어 줌. 
		
		//글번호, 내용, 작성자
		for(let prop of ['replyNo', 'reply','replyer']){
		
			let td = document.createElement('td');
			td.innerHTML = item[prop]; // <-> 둘다 사용가능. item.'replyNo'
			tr.appendChild(td);//<tr><td></td></tr> 자식으로 달기.	
		}
		//button생성.
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.innerHTML='삭제';
		btn.className = 'btn btn-danger';
		td.appendChild(btn);
		tr.appendChild(td);
		document.querySelector('tbody').appendChild(tr);	
	});	
	//document.querySelector('#show').innerHTML = xhtp.responseText;
};


function memberList(){
	//console.log("1");
	//console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText);
	//console.log(data);
	let str = "<ul>";
	data.forEach(function(item, idx, arr) {
		console.log(xhtp.responseText);
		str +="<li>" + item.id +"," + item.first_name +"</li>";
	});
	str += "</ul>";
	document.querySelector('#show').innerHTML = str;
}
console.log("end");





//fetch('data/sample.json')