package com.baidu.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	private static Properties pro = new Properties();
	static {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
		try {
			pro.load(is);
			Class.forName(pro.getProperty("driver"));
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException("加载properties文件没有找到");
		}
	}
//建立连接
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("username"),pro.getProperty("password"));
		} catch (SQLException e) {
			throw new RuntimeException("加载数据库的基本信息发生异常"+e);
		}
	}
//关闭流对象
	public static void close(AutoCloseable...able) {
		for (AutoCloseable a : able) {
			if(a != null) {
				try {
					a.close();
				} catch (Exception e) {
					throw new RuntimeException("关闭流对象发生异常");
				}
			}
		}
	}
}
