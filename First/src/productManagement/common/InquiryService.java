package productManagement.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import productManagement.vo.Product;
import productManagement.vo.StockDetail;




public class InquiryService extends Dbconnect implements InquiryDAO {
	
	
	String sql;

	@Override
	public void monthInquiry(String inputDate) {
	//[등록일, 주문번호, 상품코드, 상품명, 입출고, 수량] -날짜 오름차순
		sql = "select substr(s.issue_date,3,5) as issue_date, s.order_number, s.p_code, "
				     + "p.p_name, s.In_Out, s.ea  from emp e join stock_t s on (e.emp_no = s.emp_no)  "
				     + "join product_t p on(p.p_code = s.p_code) where substr(s.issue_date,3,5) = ?"
					+ "order by issue_date asc";

		List<StockDetail> detailList = new ArrayList<>();
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, inputDate);
			rs = psmt.executeQuery();		
			
			while(rs.next()) {
				StockDetail stockdetail = new StockDetail();
				stockdetail.setIssueDate(rs.getString("issue_date"));
				stockdetail.setOrderNumber(rs.getInt("order_number"));
				stockdetail.setpCode(rs.getString("p_code"));
				stockdetail.setpName(rs.getString("p_name"));
				stockdetail.setInOut(rs.getString("In_Out"));
				stockdetail.setEa(rs.getInt("ea"));
				
				detailList.add(stockdetail);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
		System.out.println("등록일     주문번호   상품코드   상품명   입/출고     수량");
		System.out.println("-------------------------------------------------");
		for (int i = 0; i < detailList.size(); i++) {
			System.out.printf(" %s, %d, %s,  %s, %s, %d\n", detailList.get(i).getIssueDate(), detailList.get(i).getOrderNumber()//
					, detailList.get(i).getpCode(),detailList.get(i).getpName()//
					, detailList.get(i).getInOut(), detailList.get(i).getEa());
		}
		
		
	}

	@Override
	public void inputInquiry(String chooseInOut) {
	//[입고, 두문번호, 상품코드, 상품명, 수량, 지역, 등록일] -날짜 오름차순	
		// [출고, 두문번호, 상품코드, 상품명, 수량, 지역, 등록일]  -날짜 오름차순
		
		sql = "select s.in_out, s.order_number, s.p_code, p.p_name, s.ea, s.location, s.issue_date "
				+ "from stock_t s join product_t p on (s. p_code = p.p_code) "
				+ "where lower(s.in_out) = ? order by s.issue_date asc";
		List<StockDetail> detailList = new ArrayList<>();
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, chooseInOut);
			rs = psmt.executeQuery();
			
			while(rs.next()) {  //생성자 넣기.
				StockDetail stockdetail = new StockDetail();
				stockdetail.setInOut(rs.getString("in_out"));
				stockdetail.setOrderNumber(rs.getInt("order_number"));
				stockdetail.setpCode(rs.getString("p_code"));
				stockdetail.setpName(rs.getString("p_name"));
				stockdetail.setEa(rs.getInt("ea"));
				stockdetail.setLocation(rs.getString("location"));
				stockdetail.setIssueDate(rs.getString("issue_date"));
				
				detailList.add(stockdetail);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		System.out.println("입/출고     주문번호     상품코드    상품명   수량    지역     등록일");
		System.out.println("--------------------------------------------------------");
		for (int i = 0; i < detailList.size(); i++) {
			System.out.printf("%s    %d    %s   %s   %d    %s    %s\n", detailList.get(i).getInOut(), detailList.get(i).getOrderNumber()//
					,detailList.get(i).getpCode(), detailList.get(i).getpName(), detailList.get(i).getEa()
					,detailList.get(i).getLocation(), detailList.get(i).getIssueDate() );
			
		}
		
	}
	@Override
	public void modifyputInquiry() {
		 //[주분번호, 입/출고, 상품코드, 상품명, 수량, 지역, 수정직원이름, 메모, 등록일] -날짜 오름차순
			sql= "select s.in_out,  s.order_number, s.p_code, p.p_name, s.ea, s.location, e.emp_name, s.memo, s.issue_date "
				+ "from stock_t s join product_t p on (s.p_code = p.p_code)  join emp e on (s.modify_emp = e.emp_no) "
				+ "where modifycheck ='Y' order by issue_date asc";
			List<StockDetail> detailList = new ArrayList<>();
			getConnect();
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					StockDetail stockdetail = new StockDetail();
					stockdetail.setInOut(rs.getString("in_out"));
					stockdetail.setOrderNumber(rs.getInt("order_number"));
					stockdetail.setpCode(rs.getString("p_code"));
					stockdetail.setpName(rs.getString("p_name"));
					stockdetail.setEa(rs.getInt("ea"));
					stockdetail.setLocation(rs.getString("location"));
					stockdetail.setName(rs.getString("emp_name"));
					stockdetail.setMemo(rs.getString("memo"));
					stockdetail.setIssueDate(rs.getString("issue_date"));
					
					detailList.add(stockdetail);
						
				}
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				getConnect();
			}
			System.out.println("입/출고   주문번호   상품코드    상품명    수량    지역    수정직원      사유     등록일");
			System.out.println("-----------------------------------------------------------------------");
			for (int i = 0; i < detailList.size(); i++) {
				System.out.printf(" %s   %d    %s     %s    %d    %s   %s   %s    %s\n", detailList.get(i).getInOut(), detailList.get(i).getOrderNumber()//
						,detailList.get(i).getpCode(), detailList.get(i).getpName(), detailList.get(i).getEa(), detailList.get(i).getLocation()//
						, detailList.get(i).getName(), detailList.get(i).getMemo(), detailList.get(i).getIssueDate());
				
			}
			
	}

	@Override
	public void pCodeInquiry(String pcode) {
		// [상품코드, 상품명,  단가, 재고수량, 거래처, 상품등록일, info]
		List<Product> productList = new ArrayList<>();
		String sql = "select * "
				     + "from product_t"
				     + "where lower(p_code) = ?";
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pcode);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
			Product product = new Product();
			product.setpCode(rs.getString("p_code"));
			product.setpName(rs.getString("p_name"));
			product.setPrice(rs.getInt("price"));
			product.setTotal(rs.getInt("total"));
			product.setPartner(rs.getString("patner"));
			product.setReDate(rs.getString("re_date"));
			product.setInfo(rs.getString("info"));
			
			productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		System.out.println("상품코드   상품명   단가   재고수량    거래처    등록일    상세정보");
		for (int i = 0; i < productList.size(); i++) {	
			System.out.printf("%s    %s   %d   %d   %s   %s   %s", productList.get(i).getpCode()//
					,productList.get(i).getpName(), productList.get(i).getPrice(), productList.get(i).getTotal()//
					, productList.get(i).getPartner(), productList.get(i).getReDate(), productList.get(i).getInfo());
		}
		
	}

	@Override
	public void pNameInquiry(String pname) {
		// productList.get(i).
		List<Product> productList = new ArrayList<>();
		String sql = "select * from product_t where p_name like ?";
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + pname + "%");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
			Product product = new Product();
			product.setpCode(rs.getString("p_code"));
			product.setpName(rs.getString("p_name"));
			product.setPrice(rs.getInt("price"));
			product.setPartner(rs.getString("partner"));
			product.setReDate(rs.getString("re_date"));
			product.setInfo(rs.getString("info"));
			
			productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		System.out.println("상품코드   상품명   단가   재고수량    거래처    등록일    상세정보");
		for (int i = 0; i < productList.size(); i++) {	
			System.out.printf("%s    %s   %d   %d   %s   %s   %s\n", productList.get(i).getpCode()//
					,productList.get(i).getpName(), productList.get(i).getPrice(), productList.get(i).getTotal()//
					, productList.get(i).getPartner(), productList.get(i).getReDate(), productList.get(i).getInfo());
		}
		
	}


	

}// end of class.
