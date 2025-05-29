package productManagement.vo;

public class stockDetail {
     //emp_t
	private int empno;
	private String name;
	private String pw;
	private String level;
	
	//product
	private String pCode;
	private String pName;
	private int price;
	private String enterprise;
	private String redate;  //등록일, sysdata
	private String promemo;
	
	//stock
	private String coutnNO;
	//private String pCode; 공통값
	private String inOut;  //열거로???
	private String inoutdate;
	private int ea;
	private String location;
	private int total;
	private String registdate;
	//private int empno; 공통값
	private String updatecheck;
	private String memo;
	
	//조회항목 출력만 가능하도록 getter만! 
	public int getEmpno() {
		return empno;
	}
	public String getName() {
		return name;
	}
	public String getPw() {
		return pw;
	}
	public String getLevel() {
		return level;
	}
	public String getpCode() {
		return pCode;
	}
	public String getpName() {
		return pName;
	}
	public int getPrice() {
		return price;
	}
	public String getEnterprise() {
		return enterprise;
	}
	public String getRedate() {
		return redate;
	}
	public String getPromemo() {
		return promemo;
	}
	public String getCoutnNO() {
		return coutnNO;
	}
	public String getInOut() {
		return inOut;
	}
	public String getInoutdate() {
		return inoutdate;
	}
	public int getEa() {
		return ea;
	}
	public String getLocation() {
		return location;
	}
	public int getTotal() {
		return total;
	}
	public String getRegistdate() {
		return registdate;
	}
	public String getUpdatecheck() {
		return updatecheck;
	}
	public String getMemo() {
		return memo;
	}
	
	
}
