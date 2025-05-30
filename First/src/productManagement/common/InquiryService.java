package productManagement.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import productManagement.vo.Stock;
import productManagement.vo.stockDetail;

public class InquiryService extends Dbconnect implements InquiryDAO {
	// 데이터추출+출력을 분리...
	@Override
	public void monthInquiry() { //날짜,   
		

	}

	@Override
	public void inputInquiry() {

	}

	@Override
	public void outputInquiry() {

	}

	@Override
	public void pCodeInquiry() {

	}

	@Override
	public void pNameInquiry() {

	}

	@Override
	public void partnerInuiry() {

	}

	@Override
	public void Inquiry() {
		String sql = "select * from stock_t";
		List<Stock> delist = new ArrayList<>();

		getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				stockDetail detail = new stockDetail();
				//emt_t
				detail.setEmpno(rs.getInt(""));
				detail.setName(rs.getString(""));
				detail.setPw(rs.getString(""));
				detail.setLevel(rs.getString(""));
				//product
				detail.setpCode(rs.getString(""));
				detail.setpName(rs.getString(""));
				detail.setPrice(rs.getInt(""));
				detail.setEnterprise(rs.getString(""));
				detail.setRegistdate(rs.getString(""));
				detail.setPromemo(rs.getString(""));
				//stock 
				detail.setCoutnNO(rs.getString(""));
				detail.setInOut(rs.getString(""));
				detail.setInoutdate(rs.getString(""));
				detail.setEa(rs.getInt(""));
				detail.setLocation(rs.getString(""));
				detail.setTotal(rs.getInt(""));
				detail.setRegistdate(rs.getString(""));
				detail.setUpdatecheck(rs.getString(""));
				detail.setMemo(rs.getString(""));
				
				delist.add(detail);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}// end of inquiry.

}// end of class.
