package productManagement.vo;

public class Product {
	// 필드
	private String pCode;
	private String pName;
	private int price;
	private String patner;
	private String redate; // 등록일 sysdate
	private String memo; // 수성지

	// 생성자
	public Product() {
	}

	public Product(String pCode, String pName, int price, String patner) {
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.patner = patner;
	}

	public Product(String pCode, String pName, int price, String patner, String redate, String memo) {
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.patner = patner;
		this.redate = redate;
		this.memo = memo;
	}

	// getter&setter
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

	public String getpatner() {
		return patner;
	}

	public void setpatner(String patner) {
		this.patner = patner;
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
