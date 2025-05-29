package productManagement.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import productManagement.vo.Stock;

public class StockService extends Dbconnect implements StockDAO {
	List<Stock> stocklist = new ArrayList<Stock>();
	
	@Override
	public void addStock(Stock stock) {//추가 
		String sql = "insert into stock_t(p_code, in_out, in_out_date, ea, location)" + "values(?,?,?,?,?)";
		getConnect();
		int r = 0 ;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stock.getpCode());
			psmt.setString(2, stock.getInOut());
			psmt.setString(3, stock.getInoutdate());
			psmt.setInt(4, stock.getEa());
			psmt.setString(5, stock.getLocation());
			
			r = psmt.executeUpdate();
			if(r == 1) {
				System.out.println("등록완료.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}	
		
	}

	@Override
	public void modifyStock(String pCode, int ea, int countNo) {//수정
		String sql = "update stock_t" + "  set p_code = ?" +"	,ea = ?" + "where count_number = ? " ;
		
		getConnect();
		
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pCode);
			psmt.setInt(2, ea);
			psmt.setInt(3, countNo);
			
			r = psmt.executeUpdate();
			if(r == 1) {
				System.out.println("수정완료.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}

	@Override
	public void removeStock(int countNo) {//삭제
		String sql = "delete from stock_t" + "   where count_number = ?";
		
		getConnect();
	
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, countNo);
			r = psmt.executeUpdate();
			if(r==0) {
				System.out.println("삭제완료.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void stockList() {//목록 
		String sql = "select * from stock_t";
		List<Stock> inoutlist = new ArrayList<>();
		
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); 
			
			while (rs.next()) {
				Stock stock = new Stock();
				stock.setcountNo(rs.getInt("count_number"));
				stock.setpCode(rs.getString("p_code"));
				stock.setInOut(rs.getString("in_out"));
				stock.setInOut(rs.getString("in_out_date"));
				stock.setEa(rs.getInt("ea"));
				stock.setLocation(rs.getString("location"));
				stock.setRegistdate(rs.getString("register_date"));
				stock.setEmpno(rs.getInt("emp_no"));
				stock.setTotal(rs.getInt("total"));
				stock.setUpdatecheck(rs.getString("updatecheck"));
				stock.setMemo(rs.getString("memo"));
				
				inoutlist.add(stock);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		System.out.println(" 목록번호   상품코드   입고/출고  입고/출고일  수량   발주처   등록일   재고수량    수정여부    비고");
		System.out.println("---------------------------------------------------------------------");
		for(int i = 0; i < inoutlist.size(); i++) {
			System.out.printf("   %d    %s    %s     %s    %d    %s    %s    %d    %d    %s     %s", //
					inoutlist.get(i).getcountNo(), inoutlist.get(i).getpCode(), inoutlist.get(i).getInOut(), inoutlist.get(i).getInoutdate(), inoutlist.get(i).getEa(), //
					inoutlist.get(i).getLocation(), inoutlist.get(i).getRegistdate(), inoutlist.get(i).getEmpno(), inoutlist.get(i).getTotal(),//
					inoutlist.get(i).getUpdatecheck(), inoutlist.get(i).getMemo());
		}
			
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
}

