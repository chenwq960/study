package com.baidu.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.baidu.entil.BaseDao;
import com.baidu.util.Student;
import com.mysql.jdbc.PreparedStatement;

public class ViewMessage {
	public static ArrayList<Student> showmessage() {
		Connection connectiong = BaseDao.getConnectiong();
		String sql = "select * from user ORDER BY score DESC";
		PreparedStatement ps = null;
		ResultSet set = null;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			ps = (PreparedStatement) connectiong.prepareStatement(sql);
			set = ps.executeQuery();
			while (set.next()) {
				Student student = new Student(set.getInt("id"), set.getString("name"), set.getString("score"),
						set.getString("level"), set.getString("addr"));
				list.add(student);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseDao.close(ps,set,connectiong);
		return list;
	}
}
