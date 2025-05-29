package productManagement.vo;

public class Stock {
	private int countNo;
	private String pCode;
	private String inOut;  //열거로???
	private String inoutdate;
	private int ea;
	private String location;
	private int total;
	private String registdate;
	private int empno;
	private String updatecheck;
	private String memo;
	
	//생성자
	public Stock() {}
	public Stock(String pCode, String inOut, String inoutdate, int ea, String location, int total, String registdate,
			int empno, String updatecheck, String memo) {
		this.pCode = pCode;
		this.inOut = inOut;
		this.inoutdate = inoutdate;
		this.ea = ea;
		this.location = location;
		this.total = total;
		this.registdate = registdate;
		this.empno = empno;
		this.updatecheck = updatecheck;
		this.memo = memo;
	}
	//(등록)용 생성자.
	public Stock(String pCode, String inOut, String inoutdate, int ea, String location) {
		this.pCode = pCode;
		this.inOut = inOut;
		this.inoutdate = inoutdate;
		this.ea = ea;
		this.location = location;
	}
	
	

	

	public int getcountNo() {
		return countNo;
	}
	public void setcountNo(int countNo) {
		this.countNo = countNo;
	}
	
	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getInOut() {
		return inOut;
	}

	public void setInOut(String inOut) {
		this.inOut = inOut;
	}

	public String getInoutdate() {
		return inoutdate;
	}

	public void setInoutdate(String inoutdate) {
		this.inoutdate = inoutdate;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getRegistdate() {
		return registdate;
	}

	public void setRegistdate(String registdate) {
		this.registdate = registdate;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getUpdatecheck() {
		return updatecheck;
	}

	public void setUpdatecheck(String updatecheck) {
		this.updatecheck = updatecheck;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
