package productManagement.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import productManagement.vo.EmpInfo;

public class login extends Dbconnect {
	Scanner scn = new Scanner(System.in);

	public List<EmpInfo> emplist() {
		String sql = "select * from emp";
		List<EmpInfo> emplist = new ArrayList<>();

		getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				EmpInfo employee = new EmpInfo();
				employee.setNo(rs.getInt("emp_no"));
				employee.setName(rs.getString("emp_name"));
				employee.setPw(rs.getString("emp_pw"));
				employee.setLevel(rs.getString("emp_level"));

				emplist.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emplist;
	}// end of emplist.

	public String login() {
		List<EmpInfo> emplist = emplist();
		

		System.out.println();
		System.out.print(" 사원번호입력 >>  ");
		int empNO = Integer.parseInt(scn.nextLine());
		System.out.print(" 비밀번호입력 >>  ");
		String empPw = scn.nextLine();
		
		
		boolean isTrue = false;
		for (int i = 0; i < emplist.size(); i++) {
			if (empNO == emplist.get(i).getNo() && empPw.equals(emplist.get(i).getPw())) {
				if (emplist.get(i).getLevel().equals("manager")) {
					return "manager";
				} else if (emplist.get(i).getLevel().equals("staff")) {
					return "staff";
				}
				isTrue = true;
			}
		} 
		
		if(!isTrue){
			System.out.println("\n           📞 관리자에게 문의하세요.");
			System.out.println("");
			return "back";
		}
		
		
		return "";
	}// end of login.


}// end of class.
