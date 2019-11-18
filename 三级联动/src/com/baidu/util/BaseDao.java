package com.baidu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.baidu.entil.City;

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
			con = DriverManager.getConnection("JDBC:mysql:///city", "root", "960879872chenwq");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	// 关闭流对象的
	public static void close(AutoCloseable... agrs) {
		for (AutoCloseable auto : agrs) {
			if (auto != null) {
				try {
					auto.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static ArrayList<City> find(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		ArrayList<City> arr = new ArrayList<City>();
		try {
			con = getConnectiong();
			ps = con.prepareStatement("select * from city where pid = ?");
			ps.setString(1, id);
			set = ps.executeQuery();
			while (set.next()) {
				City city = new City(set.getInt("id"), set.getString("pid"), set.getString("cityname"));
				arr.add(city);
			}

		} catch (Exception e) {
			throw new RuntimeException("发生异常");
		}
		close(con, ps, set);
		return arr;
	}
}
