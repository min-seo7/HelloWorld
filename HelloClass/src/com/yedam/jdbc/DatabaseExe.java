package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * DB에서 가져오기.
 *  
 * 1.Driver Manager
 * 2.Connection
 * 3. Statement
 * 4. 실행
 * 5. ResultSet
 * 6. 출력
 */
public class DatabaseExe {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pass = "tiger";
		
		//세션
		Connection conn = null;
		Statement stmt = null ;
		ResultSet rs = null ;
		
		//연결. 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");    //클래스로 사용할 라이브러리 유무확인.
			conn = DriverManager.getConnection(url, id, pass);
			System.out.println("연결성공.");
			conn.setAutoCommit(false);   //자동커밋 안되게 설정. 
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 없음. 연결하쇼!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

//============================		추가		
		
//		//db 추가. insert
//		String sql = "insert into product (p_code, p_name, p_price)" + "values (205, '치토스', 1000)";
//		try {
//			stmt = conn.createStatement();
//			int r = stmt.executeUpdate(sql);  //insert, update, delete
//			if(r > 0) {
//				System.out.println(r + "건 등록됨.");
//							}
//		} catch (SQLException e){
//			e.printStackTrace();
//		}

		
//============================		삭제
		
		//delete
		String sql2 = "delete from product where p_code = 205";
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql2);  //insert, update, delete
			if(r > 0) {
				conn.commit();//커밋
				System.out.println(r + "삭제됨.");
			} else {
				conn.rollback();
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	
		
//============================		업데이트	
		//update.
		
		
//				String sql3 = "update product set p_name = '포테이토칩', p_price = 5000 where p_code = 205";
//				try {
//					stmt = conn.createStatement();
//					int r = stmt.executeUpdate(sql3);  //insert, update, delete
//					if(r > 0) {
//						System.out.println(r + "건 수정됨.");
//									}
//				} catch (SQLException e){
//					e.printStackTrace();
//				}
		
		
		
		//Statement 객체. DB목록출력. 
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from product");
			System.out.println(" 상품코드     상품이름          가격");
			System.out.println("==============================");
			while(rs.next()) {   // next() => 한줄씩 읽어옴. 
				System.out.println("  "+ rs.getInt("p_code") + "   " + rs.getString("p_name") +"    " + rs.getInt("p_price"));
			}
			System.out.println("----------------end of rows----------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs != null) rs.close();
			if(stmt != null)stmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
