package productManagement.common;

public interface InquiryDAO {//[월별재고조회, 입고조회, 출고조회]//[상품코드조회, 상품명조회]
	public void Inquiry();
	//재고조회
	public void monthInquiry();
	public void inputInquiry();
	public void outputInquiry();
	//상품조회
	public void pCodeInquiry();
	public void pNameInquiry();
	public void partnerInuiry();
}
