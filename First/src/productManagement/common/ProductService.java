package productManagement.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import productManagement.vo.Product;

//상품, 등록, 수정, 삭제
public class ProductService extends Dbconnect implements ProductDAO {

	@Override
	public void addProduct(Product product) {  
		String sql = "insert into product_t(p_code, p_name, price, partner, info)" + "values(?,?,?,?,?)";
		getConnect();
		int r = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, product.getpCode());
			psmt.setString(2, product.getpName());
			psmt.setInt(3, product.getPrice());
			psmt.setString(4, product.getPartner());
			psmt.setString(5, product.getInfo());
					
			r = psmt.executeUpdate();
			if (r == 1) {
				System.out.println("\n                📌 상품등록완료.");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void modifyProduct(String pCode, String pname, int price, String info ) {
		String sql = "update product_t" 
	                 + " set p_name = ?" 
				     + "     ,price = ?" 
	                 + "     ,info = ?"
	                 + " where p_code = ?";
		getConnect();
		
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pname);	
			psmt.setInt(2, price);	
			psmt.setString(3, info);
			psmt.setString(4, pCode);
			
			r = psmt.executeUpdate();
			if(r == 1) {
				System.out.println("\n           🙅‍♂️ 해당기간 데이터가 없습니다.");
				System.out.println("\n                  ✏ 수정완료.");	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void removeProduct(String pCode) {
		String sql = "delete from product_t" + " where lower(p_code) = ?";

		getConnect();

		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pCode);
			r = psmt.executeUpdate();
			
			if (r == 1) {
				System.out.println("\n                   ✂ 삭제완료.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void ProductList() {
		String sql = "select * from product_t";
		List<Product> productlist = new ArrayList<>();
		
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
			Product product = new Product();
			product.setpCode(rs.getString("p_code"));
			product.setpName(rs.getString("p_name"));
			product.setPrice(rs.getInt("price"));
			product.setTotal(rs.getInt("total"));
			product.setPartner(rs.getString("partner"));
			product.setReDate(rs.getString("re_date"));
			product.setInfo(rs.getString("info"));
			
			productlist.add(product);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		System.out.println("");
		System.out.println("");
		System.out.printf("                       상품 LIST    ");
		System.out.println("");
		System.out.printf(" %-5s %-20s    %-7s  %-7s %-7s %-10s %-15s\n","상품코드","상품명","단가","재고수량","거래처","등록일","비고");
		System.out.println(" --------------------------------------------------------------------------------------------");
		for (int i = 0; i < productlist.size(); i++) {
			System.out.printf(" %-5s  %-25s %-7s %-7s  %-7s  %-10s   %-15s\n", productlist.get(i).getpCode(), productlist.get(i).getpName(),productlist.get(i).getPrice()//
					,productlist.get(i).getTotal(), productlist.get(i).getPartner(), productlist.get(i).getReDate(), productlist.get(i).getInfo());
			
		}//end of for.
		
	}//end of ProductList().



}//end of class
