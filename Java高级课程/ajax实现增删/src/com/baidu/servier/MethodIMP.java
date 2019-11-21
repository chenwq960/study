package com.baidu.servier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.baidu.dao.BaseDao;
import com.baidu.util.Student;

public class MethodIMP implements IMethod {

	public ArrayList<Student> findAll() {
		Connection con = BaseDao.getConnecon();
		String sql = "select * from doctor";
		PreparedStatement ps = null;
		ResultSet set = null;
		ArrayList<Student> arr = new ArrayList<Student>();
		try {
			ps = con.prepareStatement(sql);
			set = ps.executeQuery();
			while (set.next()) {
				Student stu = new Student(set.getInt("id"), set.getString("name"), set.getString("gender"),
						set.getString("hobby"), set.getString("birth"), set.getString("deptName"));
				arr.add(stu);
			}
		} catch (SQLException e) {
			throw new RuntimeException("没有查找到对象");
		}
		return arr;
	}

}
