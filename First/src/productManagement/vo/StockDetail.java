package productManagement.vo;

public class StockDetail {
   //필드
	private int empno;
	private String name;
	private String pw;
	private String level;
	
	
	private String pCode;
	private String pName;
	private int price;
	private int total;
	private String partner;
	private String reDate; // 등록일 sysdate
	private String info;
	
	
	private int orderNumber;
	private String inOut;
	private int ea;
	private String location;
	private String issueDate;
	private String modifyCheck;
	private int mEmpno;
	private String memo;
	
	public StockDetail() {}
	public StockDetail(int empno, String name, String pw, String level, String pCode, String pName, int price,
			String partner, String reDate, String info, int orderNumber, String inOut, int ea, String location,
			int total, String issueDate, String modifyCheck, int mEmpno, String memo) {
		this.empno = empno;
		this.name = name;
		this.pw = pw;
		this.level = level;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.partner = partner;
		this.reDate = reDate;
		this.info = info;
		this.orderNumber = orderNumber;
		this.inOut = inOut;
		this.ea = ea;
		this.location = location;
		this.total = total;
		this.issueDate = issueDate;
		this.modifyCheck = modifyCheck;
		this.mEmpno = mEmpno;
		this.memo = memo;	
	}
	
	public StockDetail(String pCode, String pName, int orderNumber, String inOut, int ea, String issueDate) {
		this.pCode = pCode;
		this.pName = pName;
		this.orderNumber = orderNumber;
		this.inOut = inOut;
		this.ea = ea;
		this.issueDate = issueDate;
	}
	
	public StockDetail(String pCode, String pName, int orderNumber, String inOut, int ea, String location,
			String issueDate) {
		this.pCode = pCode;
		this.pName = pName;
		this.orderNumber = orderNumber;
		this.inOut = inOut;
		this.ea = ea;
		this.location = location;
		this.issueDate = issueDate;
	}
	
	public StockDetail(String name, String pCode, String pName, int orderNumber, String inOut, int ea, String location,
			String issueDate, String memo) {
		this.name = name;
		this.pCode = pCode;
		this.pName = pName;
		this.orderNumber = orderNumber;
		this.inOut = inOut;
		this.ea = ea;
		this.location = location;
		this.issueDate = issueDate;
		this.memo = memo;
	}
	//getter
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
	public String getPartner() {
		return partner;
	}
	public String getReDate() {
		return reDate;
	}
	public String getInfo() {
		return info;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public String getInOut() {
		return inOut;
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
	public String getIssueDate() {
		return issueDate;
	}
	public String getModifyCheck() {
		return modifyCheck;
	}
	public int getmEmpno() {
		return mEmpno;
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
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public void setReDate(String reDate) {
		this.reDate = reDate;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public void setInOut(String inOut) {
		this.inOut = inOut;
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
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public void setModifyCheck(String modifyCheck) {
		this.modifyCheck = modifyCheck;
	}
	public void setmEmpno(int mEmpno) {
		this.mEmpno = mEmpno;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
}
