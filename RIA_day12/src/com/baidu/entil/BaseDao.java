package com.baidu.entil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnectiong() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("JDBC:mysql:///ria_day12","root","960879872chenwq");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(AutoCloseable ...arge) {
		for (AutoCloseable able : arge) {
			if(able!= null) {
				try {
					able.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
