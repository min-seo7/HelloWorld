package productManagement.vo;

public class Product {
	//필드
	private String pCode;
	private String pName;
	private int price;
	//생성자
	public Product() {}
	public Product(String pCode, String pName, int price) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
	}	
	//getter&setter
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
