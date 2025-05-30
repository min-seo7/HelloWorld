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
	private String orderNO;
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
		return orderNO;
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
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	public void setPromemo(String promemo) {
		this.promemo = promemo;
	}
	public void setCoutnNO(String orderNo) {
		this.orderNO = orderNo;
	}
	public void setInOut(String inOut) {
		this.inOut = inOut;
	}
	public void setInoutdate(String inoutdate) {
		this.inoutdate = inoutdate;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void setRegistdate(String registdate) {
		this.registdate = registdate;
	}
	public void setUpdatecheck(String updatecheck) {
		this.updatecheck = updatecheck;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
