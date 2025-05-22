package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * Calendar: 날짜, 시간관련.
 * Date: 날짜, 시간.
 *
 */
public class CalendarExe {
	public static void main(String[] args) {
		markeCalendar(2025, 5);
		//cal();
	}
	
	
	public static void markeCalendar(int year, int month) {    //첫째날(1일의 요일을 알면 공란크기를 찾을 수 있음.)
		Calendar mon = Calendar.getInstance();
		mon.set(year, month-1, 1);  //매개변수 3개여요! 1월이 0으로 됨. 
		System.out.printf("            <%02d월>            \n", month); 
		System.out.println("===============================");
		System.out.println(" Sun Mon Tue Wen Thu Fri Sat");
		System.out.println("===============================");
		
		int fday = mon.get(Calendar.DAY_OF_WEEK);    // 1일로 매개변수 고정해둬서 첫째날 요일이 숫자로 출력.(일=1, 월=2, 화=3, 수=4, 목=5, 금=6, 토=7)
		int laday = mon.getActualMaximum(Calendar.DATE);
		for (int i = 1; i < fday; i++ ) {
			System.out.printf("%4s", " ");
		} 
		for (int j = 1; j < laday+1; j++) {
			System.out.printf("%4d", j);
			if((j + fday-1 ) % 7 == 0) {
				System.out.println();
			}
		}
	}
	
	public static void date() {
		Date today = new Date();   //java.util => import
		System.out.println(today.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss"); //생성자의 매개값으로 포맷지정. 
		String timeStr = sdf.format(today); //Date-> String으로 변환.
		System.out.println(timeStr);
			
		try {
			today = sdf.parse("2025-08-01 09:00:00");   //String -> Date
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(today);
	}
	
		
	public static void cal() {
		//Calendar 클래스.
		Calendar now = Calendar.getInstance();
		
		//시간변경
		now.set(2025, 0, 1);
		//now.set(Calendar.YEAR, 2024);
		
		
		//요일. 
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		switch(dayOfWeek) {
		case 1: System.out.println("일요일"); break;
		case 2: System.out.println("월요일"); break;
		case 3: System.out.println("화요일"); break;
		case 4: System.out.println("수요일"); break;
		case 5: System.out.println("목요일"); break;
		case 6: System.out.println("금요일"); break;
		case 7: System.out.println("토요일"); break;
		}
		
		
		System.out.printf("년: %d, 월: %d, 날짜: %d, 요일: %d \n",//
				now.get(Calendar.YEAR)	//
				, now.get(Calendar.MONTH)	//
				, now.get(Calendar.DATE)	//
				, now.get(Calendar.DAY_OF_WEEK)	//
				, now.getActualMaximum(Calendar.DATE)	//
				);
	}
}
