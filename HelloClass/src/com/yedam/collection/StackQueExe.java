package com.yedam.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 큐: 선입선출, offer
 * 스택: 후입선출, push/pop
 */
public class StackQueExe {
	public static void main(String[] args) {
		
		//큐생성
		Queue<String> orders = new LinkedList<String>();
		//추가
		orders.offer("카페라떼");
		orders.offer("아메리카노");
		orders.offer("녹차");
		//입출력순서 확인.
		while(!orders.isEmpty()) {
			System.out.println(orders.poll());
		}
		
		
		
		
		//스택생성.
		Stack<String> books = new Stack<String>();
		//추가
		books.push("이것이 자바다");
		books.push("HTML, CSS");
		books.push("자바스크립트기초");
		//입/출력순서 출력해서 확인. 
		while(!books.isEmpty()) {
			System.out.println(books.pop());
		}
		
	}
}
