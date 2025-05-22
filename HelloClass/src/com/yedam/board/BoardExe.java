package com.yedam.board;

import java.util.Scanner;

/*
 * 새 글 생성시 제일 큰 글번호 +1로 부여.(입력x)
 * 
 * 
 * 추가 (addBoard)
 * 수정 (modifyBoard) - 글번호, 바뀔내용, 바꿀제목.
 * 삭제 (removeBoard) - 글번호
 * 목록 (boardList) 상세화면 조회
 * 조회기능(getBoard) -글번호 -> 글반환.
 */
public class BoardExe {
	// 필드
	private Board[] boards;
	private Scanner scn = new Scanner(System.in);
	private int bno = 2; // 생성자 내 인덱스 [0], [1] 채워두었음.

	// 생성자.
	public BoardExe() {
		boards = new Board[100];
		boards[0] = new Board(10, "날씨가 더워요", "더워더워더워", "길동쓰");
		boards[1] = new Board(11, "11 자바 어려워", "어려워어려워어려워", "재미없어요!");
		boards[2] = new Board(12, "12 자바 어려워", "어려워어려워어려워", "재미없어요!");
		boards[3] = new Board(13, "13 자바 어려워", "어려워어려워어려워", "재미없어요!");
		boards[4] = new Board(14, "14 자바 어려워", "어려워어려워어려워", "재미없어요!");
		boards[5] = new Board(15, "15 자바 어려워", "어려워어려워어려워", "재미없어요!");
		boards[6] = new Board(16, "16 자바 어려워", "어려워어려워어려워", "재미없어요!");
		boards[7] = new Board(17, "17 자바 어려워", "어려워어려워어려워", "재미없어요!");
		boards[8] = new Board(18, "18 자바 어려워", "어려워어려워어려워", "재미없어요!");
		boards[9] = new Board(19, "19 자바 어려워", "어려워어려워어려워", "재미없어요!");
		boards[10] = new Board(20, "20 자바 어려워", "어려워어려워어려워", "재미없어요!");
	}

	// logincheck().
	boolean loginCheck() {
		for (int i = 0; i < 3; i++) {
			String uid = userMessage("아이디를 입력해주세요.");
			String pw = userMessage("비밀번호를 입력해주세요.");
			if (UserExe.login(uid, pw)) {
				System.out.println("**** 환영합니다! ******");
				return true;
			}
			if (i == 2) {
				System.out.println("로그인시도 3회 실패로 종료됩니다.");
				return false;
			}
			continue;
		}
		return false;
	}// end of logincheck().

	void execute() {
		if (!loginCheck()) {
			return;
		}
		boolean run = true;
		int selectNo = 0;
		while (run) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1. 추가 |2. 수정 | 3. 삭제 | 4. 목록 | 5. 달력보기 | 6. 종료");
			System.out.println("-----------------------------------------------------");
			System.out.println("선택>> ");
			// 문자입력시 숫자 변경 예외발생.
			try {
				selectNo = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("잘못된 값을 입력했습니다.");
			}
			switch (selectNo) {
			case 1: // 추가
				addBoard();
				break;
			case 2: // 수정
				modifyBoard();
				break;
			case 3: // 삭제
				removeBoard();
				break;
			case 4:// 목록
				boardlist();
				break;
			case 5: // 달력

				break;
			case 6: // 종료
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}// end of switch
		} // end of while.

	}// end of execute.

	void addBoard() {
		int no = nextSequence();
		String title = userMessage("제목을 입력하세요.");
		String content = userMessage("내용을 입력하세요.");
		String writer = userMessage("작성자를 입력하세요.");
		// Board 인스턴스 선언 후 값을 지정.
		Board board = new Board(no, title, content, writer);
		// 배열에 board인스턴스 저장.
		boards[bno++] = board;
		System.out.println("추가성공");
	}// end of addboard.

	// 글번호 제목 작성자
	// =================
	// 1. 날씨 홍길쓰
	// 2. 클래스 김민규
	// ----------------------
	// 상세보기: 글번호입력, 메뉴로 이동(q)
	// --------------------------

	// **등록된 글이 없습니다. **
	void boardlist() {
		// sort();
		int page = 1;
		// while 반복문.
		while (true) {
			int start = (page - 1) * 5;
			int end = page * 5;
			System.out.println("글번호     제목                    작성자");
			System.out.println("======================================");
			for (int i = start; i < end; i++) {
				if (boards[i] != null) {
					boards[i].showInfo();
				}
			}
			// 상세보기
			System.out.println("-------------------------------------");
			System.out.println("상세보기: 글번호 입력, (다음:n || 이전:b) 메뉴로 이동(q)");
			System.out.println("-------------------------------------");
			System.out.println("선택 >>");
			String str = scn.nextLine();
			// 메뉴이동? 상세이동 구분
			if (str.equals("q")) {
				break;
			} else if (str.equals("n")) {
				page++;
			} else if (str.equals("b")) {
				page--;
			} else {
				int no = 0;
				try {
					no = Integer.parseInt(str);
				 } catch(NumberFormatException e) {
					 System.out.println("목록에 존해하는 글 번호를 입력하세요.");
					 continue;
				}
				// 배열에서 조회.
				Board sboard = getBoard(no);
				if (sboard == null) {
					System.out.println("조회결과 없습니다.");
					return;
				}
				sboard.showAllInfo(); // 상세보기
			} // end of while.
			System.out.println();
		}

	}// end of boardlist.

	void modifyBoard() {
		int bno = userMenu("수정할 글번호 입력");
		Board result = getBoard(bno);
		if (result == null) {
			System.out.println("조회한 결과가 없습니다.");
			return;
		}
		String title = userMessage("수정할 제목 입력");
		String content = userMessage("수정할 내용 입력");
		//
		result.setContent(content);
		result.setTitle(title);
		System.out.println("수정완료.");
	}// end of modify.

	void removeBoard() {
		int bno = userMenu("삭제할 글 번호 입력");
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				boards[i] = null;
				System.out.println("삭제완료.");
			}
		}
		return;
	}// end of removeBoard.

	// 단건조회(getboard)
	// 글번호를 활용해서 배열에서 조회하고 Board 반환.
	Board getBoard(int bno) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) { // 배열은 null도 주의해야 함.
				return boards[i];
			}
		}
		return null; // 조건에 맞는 글번호가 없으면 null 반환.
	}// end of getBoard

	// 사용자의 입력값을 반환.
	String userMessage(String msg) {
		System.out.print(msg + " >>");
		return scn.nextLine();
	}

	int userMenu(String msg) {
		System.out.print(msg + " >>");
		return Integer.parseInt(scn.nextLine());
		
	}

	// 순번생성.

	int nextSequence() {
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && max < boards[i].getBoardNo()) {
				max = boards[i].getBoardNo();
			}
		}
		return max + 1;
	}

	// 목록에서 정렬.
	void sort() {
		Board temp = null;
		for (int j = 0; j < boards.length - 1; j++) {
			for (int i = 0; i < boards.length - 1; i++) {
				if (boards[i + 1] == null) {
					continue;
				}
				if (boards[i] == null) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
					continue;
				}
				if (boards[i].getBoardNo() < boards[i + 1].getBoardNo()) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
				}
			}
		}
	} // end of sort.

}// end of class.
