package productManagement.common;

public interface InquiryDAO {//[월별조회, 입고조회, 출고조회]//[상품코드조회, 상품명조회]
	//재고조회
	public void monthInquiry(String inpuDate); //[등록일, 주문번호, 상품코드, 상품명, 입출고, 수량] -날짜 오름차순
	public void inputInquiry(String chooseInOut); // [입고, 두문번호, 상품코드, 상품명, 수량, 지역, 등록일] -날짜 오름차순
	public void modifyputInquiry(); //[주분번호, 입/출고, 상품코드, 상품명, 수량, 지역, 수정직원이름, 메모, 등록일] -날짜 오름차순
	//상품조회
	public void pCodeInquiry(String pcode); // [상품코드, 상품명, 거래퍼, 상품등록일, info]
	public void pNameInquiry(String pname); // [상품명, 상품코드, 거래처, 상품등록일, info]
}



