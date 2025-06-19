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
	// 장바구니 수량 변경.
	changePNum(e) {
		let updown = e.target;
		let subdiv = updown.closest('div.subdiv')
		let pPrice = subdiv.querySelector('input[name="p_price"]').value;
		let pnum = subdiv.querySelector('input[name="p_num"]').value;
		
		
	},
	// 상품삭제.
	delItem(e) {
		 document.querySelector('.abutton').addEventListener('click', function(e){
				console.log(e.target);
			e.target.parentElement.parentElement.parentElement.remove();
		})
	
	},
	// 선택상품삭제.
	delCheckedItem(e) {
		
	},
	// 장바구니 비우기.
	delAllItem(e) {
				
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
	                    <div class="pname"> <span>${item.itemName}</span> </div>
	                </div>
	                <div class="subdiv">
	                    <div class="basketprice">
	                        <input type="hidden" name="p_price" id="p_price1" class="p_price" value="${item.price}">${item.price}원
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
	                    <div class="sum">${item.price * item.qyc}}</div>
	                </div>
	                <div class="subdiv">
	                    <div class="basketcmd">
	                        <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem(event);">삭제</a>
	                    </div>
	                </div>
	            </div>`;
	return templete;
}

