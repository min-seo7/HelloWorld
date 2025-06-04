package com.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {    //최초 처음만 팩토리 빌터만 생성해주면 됨! https://mybatis.org/mybatis-3/getting-started.html
	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml";   //mybatis-config.XML파일을 생성해서 접속정보 등록. 
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}
