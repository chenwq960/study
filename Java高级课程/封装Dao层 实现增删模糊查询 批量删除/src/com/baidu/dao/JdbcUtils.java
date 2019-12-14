package com.baidu.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	static Properties pro = new Properties();
	static {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
		try {
			
			pro.load(is);
			Class.forName(pro.getProperty("driver"));
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnetion() {
		try {
			return DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("username"),pro.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void close(AutoCloseable...able) {
		for (AutoCloseable a : able) {
			if(a != null) {
				try {
					a.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
