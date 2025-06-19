/**
 * covid_module.js
 */

let url= `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=8tpkLPxt%2BdJBKq8KALg3aNq2sIMkKOL84Op5hkn6Qwqvn232gNAOKPIacJu6G10RTugp9iqwnIgQVdAbm5CG1Q%3D%3D`
let cenName;
function makeRow(center) {
	let tr = document.createElement('tr');
	tr.addEventListener('click', function(e){ //지도
		window.open('map.jsp?lat='+center.lat+'&lng='+center.lng +'&cenName='+center.centerName);
	})
	for (const prop of ['id', 'centerName', 'phoneNumber']) {
		let td = document.createElement('td'); //<td></td>
		td.innerHTML = center[prop]; //==>center.id&center.centerName& center.phoneNumber대신 약식표현0//innerHTML:<td>태그사이에 값</td>
		tr.appendChild(td);
	}
	return tr;
}

export {url, makeRow}  //선택적으로 내보내고 싶은 것만 export처리가능.


