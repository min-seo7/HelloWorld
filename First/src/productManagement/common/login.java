package productManagement.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import productManagement.vo.EmpInfo;

public class login extends Dbconnect {

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

	public String loginM(int empNO, String empPw) {
		List<EmpInfo> emplist = emplist();
		
		boolean isTrue = false;
		for (int i = 0; i < emplist.size(); i++) {
			if (empNO == emplist.get(i).getNo() && empPw.equals(emplist.get(i).getPw())) {
				if (emplist.get(i).getLevel().equals("admin")) {
					return "admin";
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
