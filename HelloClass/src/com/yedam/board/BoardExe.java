package com.yedam.board;

import java.util.Scanner;

/*
 * 추가.수정.삭제.목록
 */
public class BoardExe {
	// 필드
	private Board[] boards;
	private Scanner scn = new Scanner(System.in);
	private int bno = 2;   // 생성자 내 인덱스 [0], [1] 채워두었음. 


	// 생성자.
	public BoardExe() {
		boards = new Board[100];
		boards[0] = new Board(10, "날씨가 더워요", "더워더워더워", "길동쓰");
		boards[1] = new Board(20, "자바 어려워", "어려워어려워어려워", "재미없어요!");
	}

	void execute() {
		boolean run = true;
		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1. 추가 |2. 수정 | 3. 삭제 | 4. 목록 | 5. 종료 ");
			System.out.println("-----------------------------------------------");
			int selectNo = Integer.parseInt(scn.nextLine());
			switch (selectNo) {
			case 1: // 추가
				addBoard();
				break;
			case 2: // 수정
				modify();
				break;
			case 3: // 삭제
				delete();
				break;
			case 4:// 목록
				boardlist();
				break;
			case 5: // 종료
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}// end of switch
		} // end of while.

	}// end of execute.

	void addBoard() {
		System.out.println("글 번호를 입력하세요.>> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.println("제목을 입력하세요.>> ");
		String title = scn.nextLine();
		System.out.println("내용을 입력하세요.>> ");
		String content = scn.nextLine();
		System.out.println("작성자를 입력하세요.>> ");
		String writer = scn.nextLine();
		// Board 인스턴스 선언 후 값을 지정.
		Board board = new Board(no, title, content, writer);
		// 배열에 board인스턴스 저장.
		boards[bno++] = board;
		System.out.println("추가성공");
	}// end of addboard.

	void modify() {
		
	}
	
	void delete() {
		
	}
	
	// 글번호 제목  작성자
	// =================
	// 1.  날씨   홍길쓰
	// 2.  클래스  김민규
	//----------------------
	//상세보기: 글번호입력, 메뉴로 이동(q)
	//--------------------------
	
	
	//**등록된 글이 없습니다. **
	void boardlist() {
		System.out.println("글번호     제목                    작성자");
		System.out.println("======================================");
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				boards[i].showInfo();
			}
		}
		//상세보기
		System.out.println("-----------------------------------");
		System.out.println("상세보기: 글번호 입력, 메뉴로 이동(q)");
		String str = scn.nextLine();
		System.out.println("-----------------------------------");
		//메뉴이동? 상세이동 구분
		if(str.equals("q")) {
			return;
		} else {
			int no = Integer.parseInt(str);
			//배열에서 조회
			for (int i = 0; i < boards.length; i++) {
				if(boards[i] != null && boards[i].getBoardNo() == no) {  //배열은 null값을 생각해야함. 
					boards[i].showAllInfo();
				}
			}
		}
		
		System.out.println();
	}//end of boardlist.
}
