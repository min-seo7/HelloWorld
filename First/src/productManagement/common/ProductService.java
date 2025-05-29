package productManagement.common;

import java.sql.SQLException;

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
			psmt.setString(4, product.getpatner());

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
	public void modifyProduct() {

	}

	@Override
	public void removeProduct(String pCode) {
		System.out.println(pCode);
		String sql = "delete from product_t" + " where p_code = ? ";
		System.out.println(sql);
		
		getConnect();

		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pCode);
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
	public void ProductList() {

	}

}
