package com.baidu.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.baidu.dao.BaseDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ViewMessagesServlet {
//注册信息
	public static int firstmessage(String name, String pass) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into user values(null,?,?,null)";
		int count = 0;
		try {
			con = BaseDao.getConnectiong();
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			count = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseDao.close(null, ps, con);
		return count;
	}

//登录信息
	public static int againmessage(String name, String pass) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select count(*) from user where uname = ? and upassword = ?";
		int count = 0;
		ResultSet set = null;
		try {
			con = BaseDao.getConnectiong();
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			set = ps.executeQuery();
			if (set.next()) {
				count = set.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseDao.close(null, ps, con);
		return count;
	}

//显示所有的信息
	public static ArrayList<Student> showmessage() {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from car";
		//int count = 0;
		ResultSet set = null;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			con = BaseDao.getConnectiong();
			ps = (PreparedStatement) con.prepareStatement(sql);
			set = ps.executeQuery();
			while(set.next()) {
				Student s = new Student(set.getInt("cid"),set.getString("cname"),set.getString("cprice"),set.getString("color"),set.getString("ctype"),set.getString("typeid"),set.getString("cdate"));
				list.add(s);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseDao.close(null, ps, con);
		return list;
	}
//显示查询的内容
	public static ArrayList<Student> seach(String name,int up,int end) {
		System.out.println("程");
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from car where 1 = 1";
		//int count = 0;
		ResultSet set = null;
		if(name != null && !"".equals(name)) {
			sql += " and cname like '%"+name+"%'";
		}
		if(up != 0 && !"".equals(up)) {
			sql += " and cprice >= "+up;
		}
		if(end !=0 && !"".equals(end)) {
			sql += " and cprice <="+end;
		}
	
		System.out.println(sql);
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			con = BaseDao.getConnectiong();
			ps = (PreparedStatement) con.prepareStatement(sql);
		
			set = ps.executeQuery();
			while(set.next()) {
				Student s = new Student(set.getInt("cid"),set.getString("cname"),set.getString("cprice"),set.getString("color"),set.getString("ctype"),set.getString("typeid"),set.getString("cdate"));
				list.add(s);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseDao.close(null, ps, con);
		return list;
	}

}
