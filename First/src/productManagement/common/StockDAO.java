package productManagement.common;

import productManagement.vo.Stock;

//등록, 수정, 삭제, 목록
public interface StockDAO {
	public void addStock(Stock stock);
	public void modifyStock(int orderNumber, int ea, int empNO, String memo);
	public void removeStock(int orderNumber);
	public void stockList();
	
	
	public void total(String pCode, int Ea); //상품등록시 재고변공
	public int inOutEa(int orderNumber); // 주문건별 입출고수량추출.
	public int pCodeTotal(String pCode); //상품별 재고량추출.
	public String findPcode(int orderNumber);//주문번호로 상품코드추출.
	public int resetTotal(String pCode, int num1, int num2); // 상품코드로 재고 수량변경
	public void updateTotal(String pCode, int ptotal, int beforeinOutEa); // 상품재고 + 입출고별 EA반영.
}
