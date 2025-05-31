package productManagement.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import productManagement.vo.Stock;

public class StockService extends Dbconnect implements StockDAO {

	@Override
	public void addStock(Stock stock) {// 추가
		
		String sql = "insert into stock_t(p_code, in_out, ea, location, emp_no)" 
		              + "values(?,?,?,?,?)";   
		getConnect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stock.getpCode());
			psmt.setInt(3, stock.getEa());
			psmt.setString(4, stock.getLocation());
			psmt.setInt(5, stock.getEmpno());			
			if(stock.getEa() < 0) {
				psmt.setString(2, "OUT"); 
			} else if(stock.getEa() > 0){
				psmt.setString(2, "IN");
			}
			
			r = psmt.executeUpdate();
			if (r == 1) {
				System.out.println("등록완료.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		total(stock.getpCode(), stock.getEa()); //기존재고량 

	}

	@Override   
	public void modifyStock(int oderNumber, String pCode, int ea, String location, int empNO, String memo) {// 수정   
		String sql = "select ea from stock_t where order_number = ?";
		String sql2 = "update stock_t" 
					  + "  set p_code = ?" 
				      +"      ,in_out = ?" 
					  +"	  ,ea = ?" 
				      +"      ,location = ?"
				      +"      ,modifyCheck = ?"
					  +"      ,modify_emp= ?"
				      +"      ,memo = ?"
					  + "where order_number = ? ";
		int beforeEa = 0;
		
		getConnect();

		int r = 0;
		try {
			//1차쿼리 [변동전 기존재고] 
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, oderNumber);
			rs = psmt.executeQuery();
			if (rs.next()) {
				beforeEa = rs.getInt("ea");	
				System.out.println("기존주문수량 추출완료");
				System.out.println( beforeEa);
			}
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, pCode);
			if(ea < 0) {
				psmt.setString(2, "OUT"); 
			} else if(ea > 0){
				psmt.setString(2, "IN");
			}
			psmt.setInt(3, ea);
			psmt.setString(4, location);
			psmt.setString(5, "Y");
			psmt.setInt(6, empNO);
			psmt.setString(7, memo);
			psmt.setInt(8, oderNumber);
						
			r = psmt.executeUpdate();
			if (r == 1) {
				System.out.println("수정완료.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		moodifytotal(beforeEa, pCode, ea);
		
	}

	@Override
	public void removeStock(int oderNumber) {// 삭제
		String sql = "delete from stock_t" + "   where order_number = ?";

		getConnect();

		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, oderNumber);
			r = psmt.executeUpdate();
			if (r == 1) {
				System.out.println("삭제완료.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void stockList() {// 목록
		String sql = "select * from stock_t order by order_number desc";
		List<Stock> inoutlist = new ArrayList<>();

		getConnect();		
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Stock stock = new Stock();
				stock.setOrderNumber(rs.getInt("order_number"));
				stock.setpCode(rs.getString("p_code"));
				stock.setInOut(rs.getString("in_out"));
				stock.setEa(rs.getInt("ea"));
				stock.setLocation(rs.getString("location"));
				stock.setEmpno(rs.getInt("emp_no"));
				stock.setTotal(rs.getInt("total"));
				stock.setIssueDate(rs.getString("issue_date"));
				stock.setModifyCheck(rs.getString("modifyCheck"));
				stock.setEmpno(rs.getInt("modify_emp"));
				stock.setMemo(rs.getString("memo"));

				inoutlist.add(stock);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		System.out.println(" 목록번호   상품코드   입고/출고   수량   입/발주처   등록일   재고수량    수정여부    비고");
		System.out.println("---------------------------------------------------------------------");
		for (int i = 0; i < inoutlist.size(); i++) {
			System.out.printf("   %d    %s    %s     %d    %s    %s    %d    %d    %s     %s\n", //
					inoutlist.get(i).getOrderNumber(), inoutlist.get(i).getpCode(), inoutlist.get(i).getInOut(),
					inoutlist.get(i).getEa(), //
					inoutlist.get(i).getLocation(), inoutlist.get(i).getIssueDate(), inoutlist.get(i).getEmpno(),
					inoutlist.get(i).getTotal(), //
					inoutlist.get(i).getModifyCheck(), inoutlist.get(i).getMemo());
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");
	}// end of stockList.

	@Override
	public void total(String pCode, int ea) {  //상품등록시 재고변동
		int total = 0;
		String sql = "select total from product_t where p_code = ?";
		String sql2 = "update product_t set total = ? where p_code = ?";
		
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pCode);
			rs = psmt.executeQuery();
			if (rs.next()) {
				 total = rs.getInt("total");	
				 System.out.println("재고 수정완료.");
				}
			
			psmt = conn.prepareStatement(sql2); 
			psmt.setInt(1, ea + total);
			psmt.setString(2, pCode);
			rs = psmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
		
		public void moodifytotal(int beforeEa, String pCode, int ea) {  
			//상품등록시 재고변동[해당주문번호 수랑추출, 기존재고 추출, 주문수량 + 기존재고 반영, 수정값 반영]
			int beforTotal = 0;
			int total = 0;
			int nowTotal = 0;
			String sql = "select total from product_t where p_code = ?";
			String sql2 = "update product_t set total = ? where p_code = ?";
			String sql3 = "update product_t set total = ? where p_code = ?";
			
			getConnect();
			
			try {//1차쿼리
				psmt = conn.prepareStatement(sql); 
				psmt.setString(1, pCode);
				rs = psmt.executeQuery();
				if(rs.next()) {
					beforTotal = rs.getInt("total");
					System.out.println("현재고 추출");
					System.out.println(beforTotal);
				}
				//2차쿼리
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, nowTotal = total-(beforeEa));
				psmt.setString(2, pCode);
				rs = psmt.executeQuery();
				System.out.println(nowTotal);
				//3차쿼리
				psmt = conn.prepareStatement(sql3);
				psmt.setInt(1, nowTotal + ea);
				psmt.setString(2, pCode);
				rs = psmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		
		
	}// end of total
}

