package productManagement.vo;

public class EmpInfo {  
	//필드
	private int empno;
	private String name;
	private String pw;
	private String level;
	
	//생성자
	public EmpInfo(){}
	public EmpInfo(int empno, String name, String pw, String level) {
		this.empno = empno;
		this.name = name;
		this.pw = pw;
		this.level = level;
	}
	//getter&setter
	public int getNo() {
		return empno;
	}

	public void setNo(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
}
