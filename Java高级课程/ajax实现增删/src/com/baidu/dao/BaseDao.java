package com.baidu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	public static Connection getConnecon() {
		Connection con= null;
		try {
			con = DriverManager.getConnection("JDBC:mysql:///ria_day17","root","960879872chenwq");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	public static void close(AutoCloseable...obj) {
		for (AutoCloseable auto : obj) {
			if(auto != null) {
				try {
					auto.close();
				} catch (Exception e) {
					throw new RuntimeException("关闭对象发生异常");
				}
			}
		}
	}
	
	//负责的sql
	public static int find(String sql,Object ...obj) {
		Connection con = null;
		PreparedStatement ps = null;
	//	System.out.println(sql);
		int count = 0;
		try {
			con = getConnecon();
			ps = con.prepareStatement(sql);
			for (int i = 1; i <= obj.length; i++) {
				ps.setObject(i,obj[i-1]);
			}
			count = ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("负责的可变参数代码块发生异常");
		}
		return count;
	}
}
