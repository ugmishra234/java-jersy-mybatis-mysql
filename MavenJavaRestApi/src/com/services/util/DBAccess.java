package com.services.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {
	private static SqlSessionFactory sqlMapper;
	private static Reader reader;
	private static String myBatisConfigFile = "MyBatisConfig.xml";

	public static SqlSessionFactory getSession() {
		try {
			reader = Resources.getResourceAsReader(myBatisConfigFile);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlMapper;
	}

}