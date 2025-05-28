package co.yedam;

/*
 * 사원번호, 이름, 전화번호, 입사일자, 급여 항목을 필드로 선언하고
 * 필요한 메소드를 정의하세요.
 */
public class Employee {
	//필드
	private String no;
	private String name;
	private String phone;
	private String date;
	private int salary;
	//생성자
	public Employee() {}
	public Employee(String no, String name, String phone, String date, int salary) {
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.date = date;
		this.salary = salary;
	}
	
	//getter&setter
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
