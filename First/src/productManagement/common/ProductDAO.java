package productManagement.common;

import productManagement.vo.Product;

//상품등록, 수정, 삭제, 목록
public interface ProductDAO { 
	public void addProduct(Product product);
	public void modifyProduct(String mdpCode, String pname, int price, String info );
	public void removeProduct(String pCode);
	public void ProductList();
}
