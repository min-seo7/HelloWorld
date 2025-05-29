package productManagement.app;

import java.util.Scanner;

import productManagement.common.ProductService;
import productManagement.common.StockService;
import productManagement.common.login;
import productManagement.vo.Product;
import productManagement.vo.Stock;

public class ProductApp {
	public void ManagerExe() {
		login login = new login();
		StockService stsvc = new StockService();
		ProductService ptsvc = new ProductService();
	

		String position;//

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		System.out.println(" ==============================================");
		System.out.println("               00상사 상품관리 프로그램");
		System.out.print(" ==============================================\n");

			// 로그인창[]
			while (run) {
				position = login.login(); //  position 리턴값: back, manager, staff
				if (position.equals("back")) {
					break;
				}

			System.out.println("\n                   📝 업무 📝               ");
			System.out.println(" -----------------------------------------------");
			System.out.println("  1. 조회 | 2. 재고관리 | 3. 상품관리 | 4. 프로그램 종료 ");
			System.out.println(" -----------------------------------------------");
			System.out.print("\n  진행할 업무를 선택하세요 >>  ");
			int select = Integer.parseInt(scn.nextLine());
			System.out.println("");
			System.out.println("");

			switch (select) {
			case 1: // 조회
				System.out.println(" -----------------------------------------------");
				System.out.println("           1. 재고조회    |   2. 상품조회  ");
				System.out.println(" -----------------------------------------------");

				int seleclist = Integer.parseInt(scn.nextLine());

				switch (seleclist) {
				case 1: // 재고조회
					break;
				case 2:// 상품조회
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
				int inoutTastk = Integer.parseInt(scn.nextLine());
				System.out.println("");
				System.out.println("");
				
				
				int listNo = 0;//목록번호
				switch (inoutTastk) {
				case 1: // 등록
					System.out.print(" 상품코드  >>  ");
					String pCode = scn.nextLine();
					System.out.print(" 입고/출고 >>  ");
					String inOut = scn.nextLine();
					System.out.print(" 입/출고일 >>  ");
					String inOutdate = scn.nextLine();
					System.out.print("    수량  >>  ");
					int ea = Integer.parseInt(scn.nextLine());
					System.out.print("    입/발주처  >>  ");
					String location = scn.nextLine();
					Stock stock = new Stock(pCode, inOut, inOutdate, ea, location);
					
					stsvc.addStock(stock);
					
					break;
				case 2: // 수정(권한)
					if ( position.equals("manager")) {
						System.out.print(" 수정할 목록번호  >>  ");
						listNo = Integer.parseInt(scn.nextLine());
						System.out.print(" 상품코드  >>  ");
						pCode = scn.nextLine();
						System.out.print(" 변경수량  >>  ");
						ea = Integer.parseInt(scn.nextLine());
						
						stsvc.modifyStock(pCode, ea, listNo );
					} else {
						System.out.println("🔏 수정권한이 없습니다. ");
						continue;
					}
					break;
				case 3: // 삭제(권한)
					if(position.equals("manager")) {
						System.out.println(" 삭제목록번호 >> ");
						listNo = Integer.parseInt(scn.nextLine());
						stsvc.removeStock(listNo);
					}else {
						System.out.println("🔏 삭제권한이 없습니다. ");
						continue;
					}
					break;
				case 4://목록
					 stsvc.stockList();
					break;
				}
				break;
			case 3: // 상품관리
				System.out.println("                   📦 상품관리 📦            ");
				System.out.println(" ------------------------------------------------");
				System.out.println(" 1. 상품등록 | 2. 상품수정 | 3. 상품삭제 | 4. 목록 ");
				System.out.println(" ------------------------------------------------");
				System.out.println("");
				System.out.print("  진행할 업무를 선택하세요 >>  ");
				int mdTask = Integer.parseInt(scn.nextLine());
				System.out.println("");
				System.out.println("");
				
				switch(mdTask) {
				case 1: //상품등록
					System.out.print(" 상품코드>>");
					String mdpCode = scn.nextLine();
					System.out.print(" 상품명 >>");
					String pname = scn.nextLine();
					System.out.print(" 단가 >>");
					int price = Integer.parseInt(scn.nextLine());
					System.out.print(" 거래처 >>");
					String patner = scn.nextLine();

					Product product = new Product(mdpCode, pname, price, patner);
					ptsvc.addProduct(product);
					
					break;
				case 2: //상품수정
					break;
				case 3: //상품삭제 - 상품코드
					if(position.equals("manager")) {
						System.out.println(" 삭제상품코드 >> ");
						mdpCode = scn.nextLine();
						ptsvc.removeProduct(mdpCode);
					}else {
						System.out.println("🔏 삭제권한이 없습니다. ");
						continue;
					}
					break;
				case 4: //목록
					break;	
				}
				break;
			case 4: // 종료
				run = false;
				System.out.println("\n             프로그램을 종료합니다.😄 ");
				break;

			}// end of select.

		} // end of while.
	}// end of ManagerExe
}
