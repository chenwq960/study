package com.baidu.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.baidu.util.Dao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ViewServlet {
	public static ArrayList<Student> showmessage() {


		Connection con = Dao.getConnectiong();
		String sql = "select * from news";
		PreparedStatement ps = null;
		ResultSet set= null;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			set = ps.executeQuery();
			while(set.next()) {
				Student s = new Student(set.getInt("newsId"),set.getString("newsTitle"),set.getString("newsAuthor"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.close(set, ps, con);
		return list;
	}


//删除
	public static int delete(int id) {

		Connection con = Dao.getConnectiong();
		String sql = "delete from news where newsId = ?";
		PreparedStatement ps = null;
		ResultSet set= null;
		//ArrayList<Student> list = new ArrayList<Student>();
		int count = 0;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1,id);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.close(set, ps, con);
		return count;
	}

//显示修改一列的信息
	public static Student change(int id) {

		Connection con = Dao.getConnectiong();
		String sql = "select * from news where newsId = ?";
		PreparedStatement ps = null;
		ResultSet set= null;
		//ArrayList<Student> list = new ArrayList<Student>();
		//int count = 0;
		Student s = null;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1,id);
			set = ps.executeQuery();
			while(set.next()) {
				s = new Student(set.getInt("newsId"),set.getString("newsTitle"),set.getString("newsAuthor"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.close(set, ps, con);
		return s;
	}

//执行修改的信息上传
	public static int againmessageUp(int id,String title,String name) {
		Connection con = Dao.getConnectiong();
		String sql = "update news set newsTitle = ?,newsAuthor = ? where newsId = ?";
		PreparedStatement ps = null;
		ResultSet set= null;
	//	ArrayList<Student> list = new ArrayList<Student>();
		int count = 0;
		//Student s = null;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(3,id);
			ps.setString(1,title);
			ps.setString(2, name);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.close(set, ps, con);
		return count;
	}


}
