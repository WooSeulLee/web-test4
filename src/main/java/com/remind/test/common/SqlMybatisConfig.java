package com.remind.test.common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SqlMybatisConfig {
	private  static SqlSessionFactory sqlSessionFactory;
	private final static String CONFIG_PATH = "resources/mybatis-config.xml";
	
	static {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(CONFIG_PATH);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSessionFactory() {
		return sqlSessionFactory;
	}
	

}
