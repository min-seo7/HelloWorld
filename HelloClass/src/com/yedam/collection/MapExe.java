package com.yedam.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

/*
 * Map 컬랙션.
 * Entry타입, {키 : value} 구성.
 * 키값으로 value출력.  
 */

class Student2 {
	private String studentName;
	private int score;

	// 생성자
	public Student2(String studentName, int Score) {
		this.studentName = studentName;
		this.score = score;
	}
	//Hashcod, equals.  => 이름과 점수가 같으면 동등한 객체로.
	@Override
	public int hashCode() { //학번과 이름이 같으면 점수리턴. 
		return score;		
	}
	@Override
	public boolean equals(Object obj) {  //학번과 이름이 동일하다면 t/f 리턴. 
		if (obj instanceof Student2) {
			Student2 std = (Student2) obj;
			return this.studentName.equals(std.getStudentName()) && this.score == std.getScore();
		}
		return false;
	}
	
	
	// getter
	public String getStudentName() {
		return studentName;
	}

	public int getScore() {
		return score;
	}
}

public class MapExe {
	public static void main(String[] args) {
		// 학생, 반
		//map 생성. 
		Map<Student2, String> map;
		map = new HashMap<Student2, String>();
		//추가
		map.put(new Student2("홍길동", 70), "1반");
		map.put(new Student2("김민규", 80), "2반");

		map.put(new Student2("박철승", 75), "1반");
		map.put(new Student2("최승철", 85), "2반");

		// Student 객체(필드:이름/점수)를 키 값으로 반 출력. 
		String keyword = "홍길동";
		int score = 70;
		// System.out.println(new Student2(keyword, score) == new Student2(keyword, score));  //생성된 두 객체는 (논리값 홍길동, 70점은 같아도) 다름 ==> false. 
		
		if (map.containsKey(new Student2(keyword, score))) {   // 주어진 이름과 점수로 [새로운 객체①를 생성]해서 [map 컬랙션의 키값 비교] 후
			System.out.println("반:" + map.get(new Student2(keyword, score)));// 해당 키값을 갖는 value 출력. [새로운 Student2 클래스 객체②를 생성]해서 객체②필드를 사용. 
		}
		
		

//==============================교재 p.597참고 // 키값 컬랙션 출력하는 반복자를 활용해서 객체의 필드 check! =================================================		
//		String keyword = "홍길동";
//		Set<Student2> set = map.keySet();  
		
//		Iterator<Student2> iter = set.iterator();   //
//		while (iter.hasNext()) { // 다음 객체가 있는지 판별 후 t/f 반환.
//			Student2 std = iter.next(); //  while반복문으로 Student객체로 키값 획득.
//			if (std.getStudentName().equals(keyword)) { //이름 비교후 점수 출력. 
//				System.out.println("점수: " + std.getScore());
//				//이름, 점수
//				String cls = map.get(std);  //map 컬랙션의 획득한 객체 std를 cls에 할당. 
//				System.out.printf("이름: %s, 점수: %d, 반: %s\n", std.getStudentName(), std.getScore(), std.getClass());
//		}
//		
//		} // end of while.
// =====================================================================================================================		
		
		
		
}// end of main.

//	public static void exe2() {// 아이디(키값), 비밀번호(value)로 키값 대조 후 value 일치 확인.
//		Map<String, String> map;
//		map = new HashMap<String, String>();
//
//		map.put("user01", "1111");
//		map.put("user02", "2222");
//		map.put("user03", "3333");
//		map.put("user04", "4444");
//
//		while (true) {
//			Scanner scn = new Scanner(System.in);
//			System.out.println("아이디를 입력>> ");
//			String id = scn.nextLine();
//			System.out.println("비밀번호 입력>> ");
//			String pw = scn.nextLine();
//
//			if (map.containsKey(id)) { // 키값(아이디)가 있는지 확인하고 비밀번호 비교.
//				if (map.get(id).equals(pw)) { // get(id)는 키값으로 value 출력으로 입력된 pw랑 비교.
//					System.out.println("로그인되었습니다.");
//					break;
//				}
//				System.out.println("비밀번호가 일치하지 않습니다."); // 첫번째 if문(id)true, 두번째 if문 false.
//			} else {
//				System.out.println("입력하신 아이디가 없습니다.");
//			}
//		}
//
//		// 자바객체(map)을 json형식 문자열 출력.
////		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String json = gson.toJson(map);
//		System.out.println(json);
//
//	}
//
//	public static void exe() {
//
//		Map<String, Integer> map = new HashMap<String, Integer>();
//
//		// 객체추가.
//		map.put("홍길동", 80);
//		map.put("김민수", 70);
//		map.put("홍길동", 85); // 키값은 중복불가. --> 기존 "홍길동"에 점수가 변경됨. 새로운 추가xxxxxxxxxxxx
//		map.put("박철민", 90);
//		map.put("박민철", 60);
//
//		// 자바객체(map)를 JSON형식의 문자열 출력. ==> 외부 Gson라이브러리 추가해 둠!
////		Gson gson = new GsonBuilder()/* .setPrettyPrinting() */.create(); // .setPrettyPrinting() 출력형태 변경가능.
//		String json = gson.toJson(map);
//		System.out.println(json); // {"박민철":60,"홍길동":85,"김민수":70,"박철민":90}형식으로 출력됨.
//
//		// 조회.(키로 값출력)
//		Integer score = map.get("김민수"); // 출력할 값의 타입으로 저장될 변수지정.
//		score = map.get("홍길동");
//		System.out.println(score); // 85가 출력됨.
//
//		// 삭제.
//		map.remove("홍길동");
//
//		// 반복 2가지방식.
//		// 1)value만 획득방식
//		// ①키값을 set 컬랙션으로 획득하고, ②획득한 key값으로 value 획득. (키값으로 조회x)
//		Set<String> keyset = map.keySet(); // 키값으로 타입지정. set컬랙션 활용됨.
//		// set컬랙션의 반복자를 활용해 키값 출력.
//		Iterator<String> iter = keyset.iterator();
//
//		while (iter.hasNext()) { // .hasNext : 다음값이 있는지 체크하는 메소드.
//			String key = iter.next(); // 반복요소 획득.
//			Integer value = map.get(key);
//			System.out.printf("키: %s, 값: %d\n", key, value);
//
//		}
//
//		// 2) {키 : value}(=map.enty타입)구성으로 반환.
//		// ①map.enty타입을 set 컬랙션으로 획득 후 {키와 value}획득.
//		Set<Entry<String, Integer>> entryset = map.entrySet();
//		Iterator<Entry<String, Integer>> iter2 = entryset.iterator();
//		while (iter2.hasNext()) {
//			Entry<String, Integer> entry = iter2.next();
//			System.out.printf("키: %s, 값: %d\n", entry.getKey(), entry.getValue());
//		}
//	}
}
