package productManagement.vo;

public class Stock {
	//필드
	private int orderNumber;
	private String pCode;
	private String inOut;
	private int ea;
	private String location;
	private int empno;
	private int total;
	private String issueDate;
	private String modifyCheck;
	private int mEmpno;
	private String memo;
	//생성자
	public Stock() {}
	public Stock(String pCode, int ea, String location, int empno) {

		this.pCode = pCode;
		this.ea = ea;
		this.location = location;
		this.empno = empno;
	}

	public Stock(int orderNumber, String pCode, String inOut, int ea, String location, int empno, int total,
			String issueDate, String modifyCheck, int mEmpno, String memo) {
		this.orderNumber = orderNumber;
		this.pCode = pCode;
		this.inOut = inOut;
		this.ea = ea;
		this.location = location;
		this.empno = empno;
		this.total = total;
		this.issueDate = issueDate;
		this.modifyCheck = modifyCheck;
		this.mEmpno = mEmpno;
		this.memo = memo;
	}
	//getter
	public int getOrderNumber() {
		return orderNumber;
	}
	public String getpCode() {
		return pCode;
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
	public int getEmpno() {
		return empno;
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
	//setter
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
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
	public void setEmpno(int empno) {
		this.empno = empno;
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
