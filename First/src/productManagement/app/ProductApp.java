package productManagement.app;

import java.util.Scanner;

import productManagement.common.InquiryService;
import productManagement.common.ProductService;
import productManagement.common.StockService;
import productManagement.common.login;
import productManagement.vo.Product;
import productManagement.vo.Stock;

public class ProductApp {
	public void ManagerExe() {
		Scanner scn = new Scanner(System.in);

		login login = new login();
		StockService stsvc = new StockService();
		ProductService ptsvc = new ProductService();
		InquiryService qr = new InquiryService();
	

		String position;//
		boolean run = true;
		int selectTask = 0;
		//로그인변수
		int empNO;
		String empPw;
		//생성자변수
		String pCode, pName, patner, location, info, partner;
		int price, ea;
		
		
		
		System.out.println(" ==============================================");
		System.out.println("               00상사 상품관리 프로그램");
		System.out.print(" ==============================================\n");

		System.out.println();
		System.out.print(" 사원번호입력 >>  ");
		empNO = Integer.parseInt(scn.nextLine());
		System.out.print(" 비밀번호입력 >>  ");
		empPw = scn.nextLine();
		
			// 로그인창[]
			while (run) {
				position = login.loginM(empNO, empPw); //  position 리턴값: back, admin, staff
				if (position.equals("back")) {
					break;
				}

			System.out.println("\n                   📝 업무 📝               ");
			System.out.println(" -----------------------------------------------");
			System.out.println("  1. 조회 | 2. 재고관리 | 3. 상품관리 | 4. 프로그램 종료 ");
			System.out.println(" -----------------------------------------------");
			System.out.print("\n  진행할 업무를 선택하세요 >>  ");
			selectTask = Integer.parseInt(scn.nextLine());
			System.out.println("");
			System.out.println("");

			switch (selectTask) {
			case 1: // 조회 [월별재고조회, 입고조회, 출고조회]//[상품코드조회, 상품명조회]
				System.out.println("                👀 조회  👀              ");
				System.out.println(" -----------------------------------------------");
				System.out.println("           1. 재고조회    |   2. 상품조회  ");
				System.out.println(" -----------------------------------------------");
				System.out.print("\n  진행할 업무를 선택하세요 >>  ");
				selectTask = Integer.parseInt(scn.nextLine());

				switch (selectTask) {
				case 1: // 재고조회
					System.out.println("                👀 조회  👀              ");
					System.out.println(" -----------------------------------------------");
					System.out.println("      1. 월별조회   |   2. 입고조회 | 3.출고조회 ");
					System.out.println(" -----------------------------------------------");
					System.out.print("\n  진행할 업무를 선택하세요 >>  ");
					selectTask = Integer.parseInt(scn.nextLine());
					switch(selectTask) {
					case 1: //월별조회
						System.out.println("조회할 년도와 월을 입력해주세요. (25-01)");
						String inputDate = scn.nextLine();
						qr.monthInquiry(inputDate);
						break;
					case 2: //입고조회
						break;
					case 3: //출고조회
						break;
					}
					break;
				case 2:// 상품조회
					System.out.println("                👀 조회  👀              ");
					System.out.println(" -----------------------------------------------");
					System.out.println("      1. 상품코드조회   |   2. 상품명조회 | 3. 거래처조회 ");
					System.out.println(" -----------------------------------------------");
					System.out.print("\n  진행할 업무를 선택하세요 >>  ");
					selectTask= Integer.parseInt(scn.nextLine());
					switch(selectTask) {
					case 1://상품코드조회
						System.out.print("조회할 상품코드를 입력해주세요.>>");
						break;
					case 2://상품명조회
						System.out.print("조회할 상품명을 입력해주세요.>>");
						break;
					case 3://상품명조회
						System.out.print("조회할 거래처을 입력해주세요.>>");
						break;
					}
					break;
				}// 조회선택.
				break;

			// ===================================
			case 2: // 재고관리 권한으로 진입! 동일화면출력. 수정삭제불가.
				System.out.println("                   📦 재고관리 📦            ");
				System.out.println(" ------------------------------------------------");
				System.out.println(" 1. 입/출고등록 | 2. 입/출고수정 | 3. 입/출고삭제 | 4. 목록 ");
				System.out.println(" ------------------------------------------------");
				System.out.println("");
				System.out.print("  진행할 업무를 선택하세요 >>  ");
				selectTask = Integer.parseInt(scn.nextLine());
				System.out.println("");
				System.out.println("");
				
				
				int oderNumber = 0;//컬럼상 order_number
				switch (selectTask) {
				case 1: // 등록
					System.out.print(" 상품코드  >>  ");
					pCode = scn.nextLine();
					System.out.print("    수량  >>  ");
					ea = Integer.parseInt(scn.nextLine());
					System.out.print("    입/발주처  >>  ");
					location = scn.nextLine();
					
					
					Stock stock = new Stock(pCode, ea, location, empNO);
					
					stsvc.addStock(stock);
					
					continue;
				case 2: // 수정(권한)
					if ( position.equals("admin")) {
						System.out.print(" 주문번호  >>  ");
						oderNumber = Integer.parseInt(scn.nextLine());
						System.out.print(" 상품코드  >>  ");
						pCode = scn.nextLine();
						System.out.print(" 변경수량  >>  ");
						ea = Integer.parseInt(scn.nextLine());
						System.out.println(" 변경할 업체명 >>");
						location = scn.nextLine();
						System.out.print(" 수정사유  >>  ");
						String memo = scn.nextLine();
						
						stsvc.modifyStock(oderNumber, pCode, ea, location, empNO, memo);
					} else {
						System.out.println("🔏 수정권한이 없습니다. ");
						continue;
					}
					continue;
				case 3: // 삭제(권한)
					if(position.equals("admin")) {
						System.out.println(" 삭제주문번호 >> ");
						oderNumber = Integer.parseInt(scn.nextLine());
						stsvc.removeStock(oderNumber);
					}else {
						System.out.println("🔏 삭제권한이 없습니다. ");
						continue;
					}
					break;
				case 4://목록
					 stsvc.stockList();
					 continue;
				}
				break;
			case 3: // 상품관리
				System.out.println("                   📦 상품관리 📦            ");
				System.out.println(" ------------------------------------------------");
				System.out.println(" 1. 상품등록 | 2. 상품수정 | 3. 상품삭제 | 4. 목록 ");
				System.out.println(" ------------------------------------------------");
				System.out.println("");
				System.out.print("  진행할 업무를 선택하세요 >>  ");
				selectTask = Integer.parseInt(scn.nextLine());
				System.out.println("");
				System.out.println("");
				
				switch(selectTask) {
				case 1: //상품등록
					System.out.print(" 상품코드>>");
					pCode = scn.nextLine();
					System.out.print(" 상품명 >>");
					pName = scn.nextLine();
					System.out.print(" 단가 >>");
				    price = Integer.parseInt(scn.nextLine());
					System.out.print(" 거래처 >>");
					patner = scn.nextLine();
					System.out.println("상품정보>>");
					info = scn.nextLine();
					Product product = new Product(pCode, pName, price, patner, info);
					ptsvc.addProduct(product);
					
					continue;
				case 2: //상품수정 (코드를 기준으로 상품명 & 단가 수정가능)
					if(position.equals("admin")) {
						System.out.print("상품코드 >>");
						pCode = scn.nextLine();
						System.out.print("상품명 >>");
						pName = scn.nextLine();
						System.out.print("단가 >>");
						price = Integer.parseInt(scn.nextLine());
						System.out.println("거래처");
						partner = scn.nextLine();
						System.out.println("상품정보");
						info =  scn.nextLine();
						
						ptsvc.modifyProduct(pCode, pName, price, partner, info);
					}else {
						System.out.println("담당자에게 문의하세요.");
					}
					continue;
				case 3: //상품삭제 - 상품코드
					if(position.equals("admin")) {
						System.out.print(" 삭제상품코드 >> ");
						pCode = scn.nextLine();
						ptsvc.removeProduct(pCode);
					}else {
						System.out.println("🔏 삭제권한이 없습니다. ");
						continue;
					}
					break;
				case 4: //상품목록
					ptsvc.ProductList();
					continue;	
				}
			case 4: // 종료
				run = false;
				System.out.println("\n             프로그램을 종료합니다.😄 ");
				break;

			}// end of select.
			
		} // end of while.
	}// end of ManagerExe
}
