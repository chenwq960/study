package com.baidu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.baidu.util.BaseDao;
import com.baidu.util.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ViewShowServlet {
	public static ArrayList<Student> showmessage() {

		Connection con = BaseDao.getConnectiong();
		String sql = "select * from user";
		PreparedStatement ps = null;
		ResultSet set = null;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			set = ps.executeQuery();
			while (set.next()) {
				Student s = new Student(set.getInt("newsId"), set.getString("newsTitle"), set.getString("newsAuthor"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

//查找数据
	public static ArrayList<Student> findmessage(String id, String title, String name) {

		Connection con = BaseDao.getConnectiong();
		String sql = "select * from user where 1 = 1";
		if (id != null && !"".equals(id)) {
			sql += " and newsId like '%" + id + "%'";
			// " and p_name like '%"+name+"%' ";
		}
		if (title != null && !"".equals(title)) {
			sql += " and newsTitle like '%" + title + "%'";
		}
		if (name != null && !"".equals(name)) {
			sql += " and newsAuthor like '%" + name + "%'";
		}
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet set = null;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			set = ps.executeQuery();
			while (set.next()) {
				Student s = new Student(set.getInt("newsId"), set.getString("newsTitle"), set.getString("newsAuthor"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
