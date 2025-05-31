package productManagement.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import productManagement.vo.Stock;

public class StockService extends Dbconnect implements StockDAO {

	@Override
	public void addStock(Stock stock) {// 추가

		String sql = "insert into stock_t(p_code, in_out, ea, location, emp_no)" + "values(?,?,?,?,?)";
		getConnect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stock.getpCode());
			psmt.setInt(3, stock.getEa());
			psmt.setString(4, stock.getLocation());
			psmt.setInt(5, stock.getEmpno());
			if (stock.getEa() < 0) {
				psmt.setString(2, "OUT");
			} else if (stock.getEa() > 0) {
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
		total(stock.getpCode(), stock.getEa()); // 기존재고량

	}

	@Override
	public void modifyStock(int orderNumber, int ea, int empNO, String memo) {
		String sql = "update stock_t" + "  set in_out = ?" + "	  ,ea = ?"
				     + "      ,modifyCheck = ?" + "      ,modify_emp= ?" + "      ,memo = ?"
			         + "where order_number = ? ";
		//재고수량변경 추출
		String pcode = findPcode(orderNumber);//상품코드.
		int ptotal = pCodeTotal(pcode); //상품재고.
		int beforeinOutEa = inOutEa(orderNumber); //변경전 기존 입/출고수량 		
		
		//stpck테이블에 변경
		getConnect();

		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			if (ea < 0) {
				psmt.setString(1, "OUT");
			} else if (ea > 0) {
				psmt.setString(1, "IN");
			}
			psmt.setInt(2, ea);
			psmt.setString(3, "Y");
			psmt.setInt(4, empNO);
			psmt.setString(5, memo);
			psmt.setInt(6, orderNumber);

			r = psmt.executeUpdate();
			if (r == 1) {
				System.out.println("수정완료.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		int resetTotal =  resetTotal(pcode, ptotal, beforeinOutEa);  //기존재고와 입출고수량 복원.
		updateTotal(pcode, resetTotal, ea);  //수정된 수량 최종반영.

	}  //end of modify.

	
	@Override
	public void removeStock(int orderNumber) {// 삭제  [삭제할 주문번호 상품코드 추출, 상품별재고추출, 삭제할 주문건 ea 추출, 상품벨재고에 반영 - 삭제 ]
		String sql = "delete from stock_t" + "   where order_number = ?";
		
		String pCode = findPcode(orderNumber); //주문번호로 상품코드찾기
		int pCodetotal = pCodeTotal(pCode); //상품잔량.
		int beforeEa = 	inOutEa(orderNumber); //입출고 수량.
		
		getConnect();

		int r = 0;
		try {	
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, orderNumber);
			r = psmt.executeUpdate();
			if (r == 1) {
				System.out.println("삭제완료.");
				resetTotal(pCode, pCodetotal, beforeEa);
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
		System.out.println(" 목록번호   상품코드   입고/출고   수량   입/발주처     등록일             등록사원    수정여부        비고");
		System.out.println("-------------------------------------------------------------------------------------------");
		for (int i = 0; i < inoutlist.size(); i++) {
			System.out.printf("   %d     %s      %s     %d      %s      %s        %s        %s     %s\n", //
					inoutlist.get(i).getOrderNumber(), inoutlist.get(i).getpCode(), inoutlist.get(i).getInOut(),
					inoutlist.get(i).getEa(), //
					inoutlist.get(i).getLocation(), inoutlist.get(i).getIssueDate(), inoutlist.get(i).getEmpno(),
					inoutlist.get(i).getModifyCheck(), inoutlist.get(i).getMemo());
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");
	}// end of stockList.

	//////////////////////////////////////////////////////////////////////////////////////////////// 세부기능

	@Override
	public void total(String pCode, int ea) { // 상품등록시 재고변동
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

	public int inOutEa(int orderNumber) { // 주문건별 입출고수량.
		int beforeEa = 0;
		String sql = "select ea from stock_t where order_number = ?";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, orderNumber);
			rs = psmt.executeQuery();
			if (rs.next()) {
				beforeEa = rs.getInt("ea");
				System.out.println("기존주문수량 추출완료");
				System.out.println(beforeEa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return beforeEa;
	}

	public int pCodeTotal(String pCode) { //상품별 재고량.
		int productTotal = 0;
		String sql = "select total from product_t where p_code = ?";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pCode);
			rs = psmt.executeQuery();
			if (rs.next()) {
				 productTotal = rs.getInt("total");
				System.out.println("상품별 재고추출");
				System.out.println(productTotal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return  productTotal;
	}

	public String findPcode(int orderNumber) { //주문번호로 상품코드추출.
		String pCode = null;
		String sql = "select p_code from stock_t where order_number = ?";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, orderNumber);
			rs = psmt.executeQuery();
			if (rs.next()) {
				pCode = rs.getString("p_code");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return pCode;
	}
	@Override
	public int resetTotal(String pcode, int num1, int num2) { //기존재고를 원래대로. 
		String sql = "update product_t set total = ? where p_code = ?";
		int retotal = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, retotal= (num1 - num2));  
			psmt.setString(2, pcode);
			rs = psmt.executeQuery();
			if(rs.next()) {
				System.out.println("기존재고로 복원되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return retotal;
	}//end of resetTotal
	@Override
	public void updateTotal(String pcode, int num1, int num2) { // 상품재고 + 입출고별 EA반영.
		String sql = "update product_t set total = ? where p_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num1 + num2);  
			psmt.setString(2, pcode);
			rs = psmt.executeQuery();
			if(rs.next()) {
				System.out.println("최종수정 변경.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}	
	}//end of resetTotal
}


