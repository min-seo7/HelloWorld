package productManagement.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import productManagement.vo.Stock;

public class StockService extends Dbconnect implements StockDAO {

	@Override
	public void addStock(Stock stock) {// 추가
		
		int last = total( );
		
		String sql = "insert into stock_t(p_code, in_out, ea, location, total)" + "values(?,?,?,?,?)";   
		getConnect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stock.getpCode());
			psmt.setInt(3, stock.getEa());
			psmt.setString(4, stock.getLocation());
			psmt.setInt(5,stock.getEa() + last );
			
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

	}

	@Override   
	public void modifyStock(String pCode, int ea, int orderNo, int empNo, String memo) {// 수정   
		String sql = "update stock_t" + "  set p_code = ?" +"    ,in_out = ?" +"	,ea = ?" +"    ,updateCheck = ?"+"    ,emp_no = ?"+"    ,memo = ?"+ "where order_number = ? ";

		getConnect();

		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pCode);
			if(ea < 0) {
				psmt.setString(2, "OUT"); 
			} else if(ea > 0){
				psmt.setString(2, "IN");
			}
			psmt.setInt(3, ea);
			psmt.setString(4, "Y");
			psmt.setInt(5, empNo);
			psmt.setString(6, memo);
			psmt.setInt(7, orderNo);
						
			r = psmt.executeUpdate();
			if (r == 1) {
				System.out.println("수정완료.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}

	@Override
	public void removeStock(int orderNo) {// 삭제
		String sql = "delete from stock_t" + "   where order_number = ?";

		getConnect();

		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, orderNo);
			r = psmt.executeUpdate();
			if (r == 0) {
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
		String sql = "select * from stock_t";
		List<Stock> inoutlist = new ArrayList<>();

		getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Stock stock = new Stock();
				stock.setorderNo(rs.getInt("order_number"));
				stock.setpCode(rs.getString("p_code"));
				stock.setInOut(rs.getString("in_out"));
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
		System.out.println(" 목록번호   상품코드   입고/출고   수량   입/발주처   등록일   재고수량    수정여부    비고");
		System.out.println("---------------------------------------------------------------------");
		for (int i = 0; i < inoutlist.size(); i++) {
			System.out.printf("   %d    %s    %s     %d    %s    %s    %d    %d    %s     %s\n", //
					inoutlist.get(i).getorderNo(), inoutlist.get(i).getpCode(), inoutlist.get(i).getInOut(),
					inoutlist.get(i).getEa(), //
					inoutlist.get(i).getLocation(), inoutlist.get(i).getRegistdate(), inoutlist.get(i).getEmpno(),
					inoutlist.get(i).getTotal(), //
					inoutlist.get(i).getUpdatecheck(), inoutlist.get(i).getMemo());
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");
	}// end of stockList.

	@Override
	public int total( ) {  //total 컬럼 마지막 값 받아서 리턴.
		String sql = "select total from stock_t where register_date in(select MAX(register_date)from stock_t)";
		
		getConnect();
		
		int total_row = 0;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				total_row = rs.getInt("total");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return total_row;
	}// end of total
}

