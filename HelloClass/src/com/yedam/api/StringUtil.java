package com.yedam.api;

public class StringUtil {

	public static String getGender(String number) { 	
		int gen = Integer.parseInt(number.substring(number.length() - 7, number.length()));
		
		if (gen % 2 == 0) {
			return "여자";
		} 
		return"남자";
	}
	
	public static String getExtName(String name) {
		// int lo = name.indexOf("."); 
		 //String exname = name.substring(lo);
		
		String exname = name.substring(name.indexOf(".") + 1);
		return exname;
	}	
}//end class
