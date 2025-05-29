package productManagement.vo;

public class Product {
	//필드
	private String pCode;
	private String pName;
	private int price;
	private String enterprise;
	private String redate;
	private String memo;
	
	//생성자
	public Product() {}
	public Product(String pCode, String pName, int price, String enterprise, String redate, String memo) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.enterprise = enterprise;
		this.redate = redate;
		this.memo = memo;
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
	public String getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
