package productManagement.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import productManagement.vo.EmpInfo;

public class Dbconnect {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "user01";
	String pass = "tiger";
	Connection conn;
	PreparedStatement psmt;  //용도???? Statement stmt??? 
	ResultSet rs;
	
	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}    
	} //end of getConnect.
	
	public void disconnect() {
		try {
			if(conn != null) conn.close();
			if(psmt != null) psmt.close();
			if(rs != null) rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}// end of disconnect.
	
	
	public List<EmpInfo> emplist(){
		String sql = "select * from emp";
		getConnect();
		List<EmpInfo> emplist = new ArrayList<>();
 		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				EmpInfo employee = new EmpInfo();
				employee.setNo(rs.getInt("emp_no"));
				employee.setName(rs.getString("emp_name"));
				employee.setPw(rs.getString("emp_pw"));
				employee.setLevel(rs.getString("emp_level"));
				
				emplist.add(employee);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emplist;
		
	}//end of emplist.
	
	public String login() {//로그인 확인.
		String idpw; 
		
		return "manager";
	}
	
	
	
}
