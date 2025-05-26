package com.yedam.collection;
/*
 * 
 * 순서x, 중복불가, 
 * 
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		//set 컬렉션 생성. 
		Set<String> set = new HashSet<>(); // Set<String> set = new HashSet<String>()  동일한 의미. 뒤에 타입써도되고 안써도 됨. 
		
		//요소추가
		set.add("홍길동");
		set.add("금요일");
		set.add("토요일");
		
		//삭제
		// set.remove("홍길동");
		
		if (set.contains("홍길동")) {  //set컬랙션의 홍길동 contain 유무 확인후 ~~~    
			System.out.println(set.remove("홍길동"));			
		}
		
		//반복.
		Iterator<String> iter = set.iterator(); //반복자 획득.
		while(iter.hasNext()) {
			String result = iter.next();
			System.out.println(result);
		}
		
		
	}
}
