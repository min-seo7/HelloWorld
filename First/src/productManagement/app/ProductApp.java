package productManagement.app;

import java.util.Scanner;

public class ProductApp {
	public void ManagerExe() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println(" ==============================================");
			System.out.println("               00상사 상품관리 프로그램");
			System.out.print(" ==============================================\n");

			// 로그인창[]
			System.out.print(" 사원번호입력 >>  ");
			int empNO = Integer.parseInt(scn.nextLine());
			System.out.print(" 비밀번호입력 >>  ");
			String empPw = scn.nextLine();

			System.out.println("\n                   업무                 ");
			System.out.println(" -----------------------------------------------");
			System.out.println(" | 1. 조회 | 2. 재고관리 | 3. 상품관리 | 4. 프로그램 종료 |");
			System.out.println(" -----------------------------------------------");
			System.out.print("  진행할 업무를 선택하세요 >>  ");
			int select = Integer.parseInt(scn.nextLine());

			switch (select) {
			case 1: // 조회
				System.out.println(" -----------------------------------------------");
				System.out.println("           1. 재고조회    |   2. 상품조회  ");
				System.out.println(" -----------------------------------------------");

				int seleclist = Integer.parseInt(scn.nextLine());

				switch (seleclist) {
				case 1: //재고조회
					break;
				case 2://상품조회
					break;
				}//조회선택. 

				break;
			case 2: //재고관리
				break;
			case 3: //상품관리
				break;
			case 4: //종료
				run = false;
				System.out.println("\n             프로그램을 종료합니다.😄 ");
				break;

			}// end of select.

		} // end of while.
	}// end of ManagerExe
}
