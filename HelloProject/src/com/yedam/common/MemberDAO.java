package com.yedam.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Member;

/*
 * Database 에 insert, update, delete, select 기능구현. 
 */
public class MemberDAO extends DAO {

	public int insert(Member member) {
		String sql = "insert into tbl_member(member_id, member_name, phone, point)" + " values(?,?,?,?)";
		// DB접속을 위해서 메소드 getConnect 호출
		getConnect();

		// insert====================================================================
		try { // stmt = conn.createStatement(); //stmt대신 psmt로 아이디랑, 이름 받아오는것 간단하게 작성.
			psmt = conn.prepareStatement(sql); //
			psmt.setString(1, member.getMemberId()); // sql변수의 values(?, ?)에 1번 매개변수는 -> 1번째 위치에 아이디
			psmt.setString(2, member.getMemberName());// 2번째 위치에 이름.
			psmt.setString(3, member.getPhone());
			psmt.setInt(4, member.getPoint());
			
			int r = psmt.executeUpdate();
			return r; // insert 한 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(); // 접속끊음.
		}
		return 0; // insert 가 반영이 안되었을때 0건 반환.
	}// end of insert

	// DB수정======================================================
	public int update(Member member) {
		String sql = "update tbl_member" + "   set phone = ?" + "    ,point = ?" + " where member_id = ?";
		// 접속
		getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getPhone());
			psmt.setInt(2, member.getPoint());
			psmt.setString(3, member.getMemberId());
			int r = psmt.executeUpdate();
			return r; // update 한 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(); // 접속끊음.
		}
		return 0; // update 가 반영이 안되었을때 0건 반환.
	} // end of

	// DB삭제=============================================
	public int delete(String memberId) {
		String sql = "delete form tbl_member" + "    where member_id = ?";

		getConnect();

		try { // stmt = conn.createStatement();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);
			int r = psmt.executeUpdate();
			return r; // delete 한 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(); // 접속끊음.
		}
		return 0; // update 가 반영이 안되었을때 0건 반환.
	}// end of delete.

	// 목록출력====================================================
	public List<Member> select() {
		String sql = "select * from tlb_member";
		getConnect();
		List<Member> list = new ArrayList<>(); // 리스트컬렉션에 데이터 저장용도. [sql 한행한행의 값을 받아와서 리스트 컬랙션에 추가하기 위새 생성함!]
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // 조회.
			
			while (rs.next()) {  //db데이터를 조회해서 리스트에 추가하는 반복문. 
				Member member = new Member();
				member.setMemberId(rs.getString("member_id")); //rs에서 조회된 결과에서 아이디만 get하여서 아이디필드에 저장. 
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setPoint(rs.getInt("point")); //rs에서 조회된 결과에서 포인트만 get하여서 포인트필드에 저장. 
				
				//
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}// end of class.
