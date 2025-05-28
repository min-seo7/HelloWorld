package productManagement.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public String login() {//로그인 확인.
		String idpw; 
		
		return "manager";
	}
	
	
	
}
