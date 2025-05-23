package com.yedam.api;

public class SystemExe {
	public static void main(String[] args) {
		
		
	long now = System.currentTimeMillis(); //현재시간을 밀리세컨으로 나타내기
	
	// 출력된 밀리세컨으로 일(60 * 60 * 24), 시(60 * 60), 분(60), 초(1)로 반환
	System.out.println(now);   //=> 60초 1분, 360000 1일  
	
//	long years = now / (60 * 60 * 24 * 365);
//	long day = (now /(60* 60 *24)/1000);
//	long hour = ((now % day)/(60 * 60));
//	long min = (now % hour) / 60;
//	long sec = now % 60 ;
//	System.out.println(day);
//	System.out.println(hour);
	
//	 System.out.printf("%년 %d일 %d시 %d분 %d초", years, day, hour, min, sec);
	
	}
	
	
	public static void exe() { //sum을 계산하는데 걸리는 시간. 

	long start = System.currentTimeMillis();
	long nstart = System.nanoTime();
	
	int sum = 0;
	for (int i = 0; i < 100000000; i++) {
		sum += i;
	}
	long end = System.currentTimeMillis();
	long nend = System.nanoTime();
	System.out.printf("합계: %d, 걸린시간: %d 나노: %d \n", sum, (end - start), (nend - nstart));  //sum을 계산하는 시간을 나노와 밀리세컨으로 계산. 
	
	}
}
