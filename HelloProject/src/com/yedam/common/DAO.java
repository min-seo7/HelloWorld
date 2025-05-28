package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 데이터베이스 연결정보를 활용해서 세션획득.
 */
public class DAO {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pass = "tiger";
		Connection conn;
		Statement stmt;
		PreparedStatement psmt;  //용도????
		ResultSet rs;
		
		//connection 생성하는 메소드.
		public void getConnect() {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, id, pass);
			} catch (Exception e) {
				e.printStackTrace();
			}    
		} //end of getConnect.
		
		
		//connection 반환하는 메소드
		public void disconnect() {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}// end of disconnect.
		
}
 