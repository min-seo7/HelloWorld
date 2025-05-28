package productManagement.vo;

public class EmpInfo {
	//필드
	private int no;
	private String name;
	private String pw;
	private String level;
	
	//생성자
	public EmpInfo(){}
	public EmpInfo(int no, String name, String pw, String level) {
		this.no = no;
		this.name = name;
		this.pw = pw;
		this.level = level;
	}
	//getter&setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
