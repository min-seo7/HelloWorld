/**
 * cart.js
 */
// 장바구니 상품.
const cartItems = [{
	itemId: 1,
	itemName: "상품1",
	price: 2500,
	qty: 3,
	image: 'basket1.jpg'
}, {
	itemId: 2,
	itemName: "상품2",
	price: 3500,
	qty: 2,
	image: 'basket2.jpg'
}, {
	itemId: 3,
	itemName: "상품3",
	price: 4500,
	qty: 1,
	image: 'basket3.jpg'
}]

itemList(cartItems);
const basket = {
	// 장바구니 수량 변경.  장바구니배열에서 해당 상품명 찾아서 수량변경 && 가격반영
	changePNum(e) { //이벤트 타겟의 부모라인 거슬러 올라가서 각 요소 찾기.
		let updown = e.target; // i태그 up or down.
		let row = updown.closest('.row.data');
		let pname = row.querySelector('.pname span').textContent;//span태그는 value가 없음! 
		let price = row.querySelector('.p_price').value;//가격
		let qty = row.querySelector('.p_num'); 
		let each = parseInt(qty.value); //현수량

		
		
		if(updown.classList.contains('down') && each > 1){
			each--;
		}else{
			each++;
		}
		
		qty.value = each;
		
		for(let i = 0; i < cartItems.length; i++){
			if(cartItems[i].itemName == pname){
				cartItems[i].qty = each;
			}
		}
		
	},
	// 상품삭제.
	delItem(e) {
		let btn = e.target;
		btn.closest('.row.data').remove();  //부모요소찾기 closest ==> 활용해서 부모요소로 거슬러 올라가 자식도 찾을 수 있음. 
		
	},
	// 선택상품삭제.
	delCheckedItem(e) {
	 	let checked = document.querySelectorAll('input[type=checkbox]:checked');  //querySelectorAll은 배열??처럼 관련된것 다 담고 있음. 
		console.log(checked); //
		for(let i = 0; i < checked.length; i++){
			checked[i].closest('.row.data').remove();
		}
	},
	// 장바구니 비우기.
	delAllItem(e) {
		let allList = document.querySelectorAll('.row.data');
		for (let i = 0; i < allList.length; i++){
			allList[i].remove();
		}		
	}
}




function itemList(cartItems){
	let basket = document.querySelector('#basket');
	for (let item of cartItems ){
		let list = maketemplete(item);
		basket.insertAdjacentHTML("beforeend", list);	
	}
	
}



function  maketemplete(item){  //목록템플릿.
	   let templete= `	<div class="row data" data-id="1">
	                <div class="subdiv">
	                    <div class="check"><input type="checkbox" name="buy" value="260" checked="">&nbsp;</div>
	                    <div class="img"><img src="./images/basket1.jpg" width="60"></div>
	                    <div class="pname"><span>${item.itemName}</span> </div>
	                </div>
	                <div class="subdiv">
	                    <div class="basketprice">
	                        <input type="hidden" name="p_price" id="p_price${item.itemId}" class="p_price" value="${item.price}">${item.price}원
	                    </div>
	                    <div class="num">
	                        <div class="updown">
	                            <input type="text" name="p_num1" id="p_num1" size="2" maxlength="4" class="p_num" value="2"
	                                onkeyup="javascript:basket.changePNum(event);">
	                            <span onclick="javascript:basket.changePNum(event);">
	                                <i class="fas fa-arrow-alt-circle-up up"></i> </span>
	                            <span onclick="javascript:basket.changePNum(event);">
	                                <i class="fas fa-arrow-alt-circle-down down"></i> </span>
	                        </div>
	                    </div>
	                    <div class="sum">40,000원</div>
	                </div>
	                <div class="subdiv">
	                    <div class="basketcmd">
	                        <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem(event);">삭제</a>
	                    </div>
	                </div>
	            </div>`;
	return templete;
}

