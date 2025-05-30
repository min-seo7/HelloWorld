package productManagement.common;

import productManagement.vo.Stock;

//등록, 수정, 삭제, 목록
public interface StockDAO {
	public void addStock(Stock stock);
	public void modifyStock(String pCode, int ea, int countNo, int empNo, String memo);
	public void removeStock(int orderNo);
	public void stockList();
	public int total(); //
}
