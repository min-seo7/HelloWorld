package productManagement.common;

import java.util.List;

import productManagement.vo.Stock;

//등록, 수정, 삭제, 목록
public interface StockDAO {
	public void addStock(Stock stock);
	public void modifyStock(String pCode, int ea, int countNo);
	public void removeStock(int countNo);
	public List<Stock> stockList();
}
