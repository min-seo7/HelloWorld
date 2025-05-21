package com.yedam.board;

/*
 * User: 아이디, 비밀번호, 이름.
 */
class User {
	private String userId;
	private String passwd;
	private String userName;

	// 생성자.
	public User(String userId, String passwd, String userName) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
	}

	// getter
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

}// end of User.

public class UserExe {
	static User[] users = { new User("holy", "1111", "김영광"), 
			                new User("cutie", "2222", "홍예쁨"),
			                new User("guest", "3333", "밤손님")};
	static boolean login(String uname, String passwd) {
		boolean isExist = false;
		for (int i = 0; i < users.length; i++) {
			if (users[i] != null && uname.equals(users[i].getUserId())) {
				if (users[i] != null && passwd.equals(users[i].getPasswd())){
					isExist = true;
					return true;
				} 
			} 
		} //end of for.
		if (!isExist) {
			System.out.println("아이디 혹은 패스워드를 확인해주세요.");
		}
		return false;
	}
}//end of UserExe.
