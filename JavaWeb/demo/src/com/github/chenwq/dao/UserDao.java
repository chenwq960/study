package com.github.chenwq.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.github.chenwq.po.User;

public class UserDao {
private static String FILE_NAME="111";
	public List<User> getList() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.DRIVER");
		String url ="jdbc:mysql://localhost:3306/test";
		String sql = "select id,name,age from tb_user";
		
		List<User> list = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, "root", "960879872chenwq")) {
			PreparedStatement prest = conn.prepareStatement(sql);
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setAge(rs.getInt(3));
				list.add(u);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return list;
		
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao userDao = new UserDao();
		
		List<User> list = userDao.getList();
		Iterator<User> iterator = list.iterator();
		Map<String,User> map = new HashMap<>();
		
		System.out.println(new UserDao().getList());
	}
	
}
