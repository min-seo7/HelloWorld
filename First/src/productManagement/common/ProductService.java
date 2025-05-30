package productManagement.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import productManagement.vo.Product;

//상품, 등록, 수정, 삭제
public class ProductService extends Dbconnect implements ProductDAO {

	@Override
	public void addProduct(Product product) {  
		String sql = "insert into product_t(p_code, p_name, price, partner)" + "values(?,?,?,?)";
		getConnect();
		int r = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, product.getpCode());
			psmt.setString(2, product.getpName());
			psmt.setInt(3, product.getPrice());
			psmt.setString(4, product.getPartner());
					
			
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
	public void modifyProduct(String mdpCode, String pname, int price ) {
		String sql = "update product_t" + " set p_name = ?" + "    ,price = ?" + " where p_code = ? ";
		getConnect();
		
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pname);	
			psmt.setInt(2, price);	
			psmt.setString(3, mdpCode);
			
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
	public void removeProduct(String pCode) {
		String sql = "delete from product_t" + " where p_code = ? ";

		getConnect();

		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pCode);
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
			product.setPartner(rs.getString("partner"));
			product.setRedate(rs.getString("re_date"));
			product.setMemo(rs.getString("memo"));
			
			productlist.add(product);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		System.out.println(" 상품코드  상품명   단가    거래처    등록일     비고");
		System.out.println(" ------------------------------------------");
		for (int i = 0; i < productlist.size(); i++) {
			System.out.printf(" %s  %s  %d   %s   %s   %s\n", productlist.get(i).getpCode(),  productlist.get(i).getpName(),productlist.get(i).getPrice()//
					,productlist.get(i).getPartner(), productlist.get(i).getRedate(), productlist.get(i).getMemo());
			
		}//end of for.
		
	}//end of ProductList().



}//end of class
