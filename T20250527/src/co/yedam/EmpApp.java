package co.yedam;

import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		// 앱을 실행하는 클래스.
		EmpDAO dao = new EmpDAO();

		// 사용자의 입력을 처리하도록 작성하세요.
		boolean run = true;
		Scanner scn = new Scanner(System.in);

		while (run) {
			// 이곳에 메뉴작성.
			// 1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(입사일자) 6.종료
			System.out.println("======================================================");
			System.out.println("1.등록  2.목록  3.수정(급여)  4.삭제  5.조회(입사일자)  6.종료");
			System.out.println("======================================================");
			System.out.print("선택>>  ");
			
			int select = Integer.parseInt(scn.nextLine());
			
			switch(select) {
			case 1://추가
				 dao.add();
				break;
			case 2://목록
				dao.list();
				break;
			case 3: //수정
				dao.modify();
				break;
			case 4: //삭제
				dao.delete();
				break;
			case 5: //조회
				dao.seleclist();
				break;
			case 6:
				run = false;
				break;
			}

		}
		System.out.println("end of prog.");
	} // end of main.
}
