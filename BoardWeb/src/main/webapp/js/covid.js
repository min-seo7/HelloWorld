/*
covid.js
*/
import{url, makeRow} from'./covid_module.js';   //covid_module에서 export한 값만 가지고 옴.

//document.querySelector('#centerList').innerHTML = "Hello";  =>설명xxxxxxxxxxxxxx 나중에 
//변수선언
let centerAry;

fetch(url) //import된 url주소에서 데이터 가지고 옴!
  .then(data => data.json())
  .then(result => {
   console.log(result.data);    //result & result.data는 결과가 달라요! 
   centerAry = result.data; //[{},{},{},....{}]
   
   let sidoAry = [];//시도정보담을 배열선언.
   
   //tr/td *2
   //##centerList
   //[].forEach(function(elem, idx, ary){ })
   centerAry.forEach((center, idx) =>{
	//sidoAry에 중복값은 제거하고 배열담음. 
	   if(sidoAry.indexOf(center.sido) == -1){
		sidoAry.push(center.sido);//추가
	   }
	   if(idx < 10){//데이터 10줄만 출력되도록
    		//tr생성하기.  
		let tr = makeRow(center);
        document.querySelector('#centerList').appendChild(tr);
	   }//end of if.
   })//end of forEach
   console.log(sidoAry);
   //sidoAry의 갯수만큼 <option value="sido정보">sido정보</option>
   sidoAry.forEach(sido => {
	let opt = document.createElement('option');
	opt.value = sido;
	opt.innerText = sido;
	document.getElementById('sido').appendChild(opt);
   })
  })
  .catch(err => console.log(err))
  
  
  
  //조회evet (검색용)
 document.querySelector('button.btn-primary').addEventListener('click', function(){

	document.querySelector('#centerList').innerHTML = "";	//->검색시 기존 목록삭제후 목록출력
	
	let keyword = document.getElementById('centerName').value; //이벤트 발생시 해당위치 값 가지고 옴. 
	
	centerAry //js에서 쓰이는 메서드 체이닝방식으로 작성됨. 
	//.filter(center => center.centerName.indexOf(keyword) != -1 )   //센터값 중에서 검색된 입력명과 비교해서 새로운 결과배열 담음. //indexof는 찾는 값의 인덱스번호 가지고 옴.  (-1=값이 없을때!)
	.filter(center => center.centerName.includes(keyword))//배열 
	.forEach(center => {
		let tr = makeRow(center);
		document.querySelector('#centerList').appendChild(tr);
	})
 });

 
 //select태그의 change event (드롭다운기능)
 document.querySelector('#sido').addEventListener('change', function(e){  
	document.querySelector('#centerList').innerHTML = "";
	
	let keyword = document.getElementById('sido').value;
	centerAry 
	.reduce((acc, center) =>{
		if(center.sido == keyword){
			let tr = makeRow(center);
			acc.appendChild(tr);
		}
		return acc;
	}, document.querySelector('#centerList'));
	/*.filter(center => center.sido == keyword)  
	.forEach(center => {
			let tr = makeRow(center);
			document.querySelector('#centerList').appendChild(tr);
		})*/
 });
 
/* //배열요소 추가, 삭제~ [].push, [].unshift(), [].pop(), [].shift  => [].splice()
 //reduce(); 배열에서만 쓰임. 
 let result = [1, 3, 5, 7].reduce(function(acc, elem, idx, ary){
	console.log(acc, elem);  //
	if(elem > 4){
		let li = document.createElement('li');
		li.innerHTML = elem;
		acc.appendChild(li);
	}
	return acc; // <ul>
 }, document.querySelector('#target')); //초기값으로 배열도 가능[], 
 console.log('결과:', result);
 */
 