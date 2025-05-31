package productManagement.common;

import productManagement.vo.Stock;

//등록, 수정, 삭제, 목록
public interface StockDAO {
	public void addStock(Stock stock);
	public void modifyStock(int oderNumber, String pCode, int ea, String location, int Mempno, String memo);
	public void removeStock(int oderNumber);
	public void stockList();
	public void total(String pCode, int Ea); 
	public void moodifytotal(int ordernumber, String pCode, int ea);
}
