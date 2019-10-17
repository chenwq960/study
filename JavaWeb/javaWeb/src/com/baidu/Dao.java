package com.baidu;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Service.Dase;
import com.Service.Dase1;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public interface Dao {
	public static int add(String name,String password) throws SQLException {
		Connection con = Dase.getConnection();
		
		String sql = "insert into admin values(null,?,?)";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2,password);
		int i = ps.executeUpdate();
		Dase.close(null, ps, con);
		return i;	
	}
	public static int select(String name,String password) throws SQLException {
		Connection con = Dase1.getConnection();
		String sel = "select count(*) from admin where adminName = ? and adminPwd = ?";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sel);
		ps.setString(1, name);
		ps.setString(2, password);
		int count = 0;
		ResultSet set = ps.executeQuery();
		if(set.next()) {
			count = set.getInt(1);
		}
		Dase1.close(set, ps, con);
		System.out.println(count);
		return count;
		
	}

}
