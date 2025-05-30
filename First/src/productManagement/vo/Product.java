package productManagement.vo;

public class Product {
	// 필드
	private String pCode;
	private String pName;
	private int price;
	private String partner;
	private String reDate; // 등록일 sysdate
	private String info;
	
	// 생성자
	public Product() {};
	public Product(String pCode, String pName, int price, String patner, String info) {
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.partner = patner;
		this.info = info;
	}
	public Product(String pCode, String pName, int price, String partner, String reDate, String info) {
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.partner = partner;
		this.reDate = reDate;
		this.info = info;
	}
	
	
	//getter
	public String getpCode() {
		return pCode;
	}
	public String getpName() {
		return pName;
	}
	public int getPrice() {
		return price;
	}
	public String getPartner() {
		return partner;
	}
	public String getReDate() {
		return reDate;
	}
	public String getInfo() {
		return info;
	}
	//setter
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public void setReDate(String reDate) {
		this.reDate = reDate;
	}
	public void setInfo(String info) {
		this.info = info;
	} 
		
}
