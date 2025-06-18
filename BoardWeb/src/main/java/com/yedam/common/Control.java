package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control {
	public void exec(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
}

/*
 * 구글차트 - 파이차트
 *  
 * 테이블 - datatables  //글목록 - HTML DOM 방식
 * 댓글 Ajax방식
 * 
 * board.jsp
 * 
 * https://fullcalendar.io/
 * 
 * 
 * 
js.이벤트감지. 
fetch 파라미터와 함께 전송. 
.then 결과
 * 
 * 
 * 
 * 
 * 
 * 
 * =====================================6/18
 * 

enctype="multipart/form-data" - singup.jsp => form 태그

<setting name="jdbcTypeForNull" value="NULL"/> -->null값처리 
mybatis-config



아이디체크 확인


-url에서 가지고 오는 변수는 url에 나오는명칭과 동일, 
vo에서 받아서 db insert는 필드명과 동일하게



jsp필터



/서블릿생성
1)web.xml->front컨트롤러로 
2)클래스파일에서 어노테어션 부여.
 * 
 * 
 * json

->index.html => json데이터 출력


코비드API
index.html, covid.js/ covid_module
1)필터기능사용 => 지역명검색시 해당 지역 센터만 출력되도록


//querySelector&getElementById 차이

//reduce() 메소드
 * 
 * 
 * 
 */