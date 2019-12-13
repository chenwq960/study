package com.baidu.dao.database;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.baidu.dao.JdbcUtils;

public class Database {
	private static DataSource datasource;
	public static void findmessage(String joining) {
			try {
				InitialContext context = new InitialContext();
				datasource = (DataSource) context.lookup("java:comp/env/"+joining);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static Connection getConnection() {
		return JdbcUtils.getConnetion();
	}
	
	public static <T> List<T> executequeryone(String sql,Class<T> c) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		List<T> array = new ArrayList<T>();
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			set = ps.executeQuery();
			while(set.next()) {
				T t = c.newInstance();
				core(t,set);
				array.add(t);
			}
		} catch (Exception e) {

		}
		return array;
	}
	
	
	public static <T> void core(T t,ResultSet set) {
		Class<? extends Object> class1 = t.getClass();
		
		try {
			ResultSetMetaData metaData = set.getMetaData();
			for(int i = 1 ;  i<= metaData.getColumnCount(); i ++) {
				String name = metaData.getColumnName(i);
				Field declaredField = class1.getDeclaredField(name);
				declaredField.setAccessible(true);
				declaredField.set(t,set.getObject(i));
			}
		} catch (SQLException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
