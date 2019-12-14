package com.baidu.dao.BaseDao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.baidu.dao.JdbcUtils;

public class BaseDao {
	private static DataSource datasource;
	
	public static void findmessage(String finding) {
		try {
			InitialContext initialContext = new InitialContext();
			datasource = (DataSource) initialContext.lookup("java:comp/env/"+finding);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnetion() {
		try {
			return datasource == null?JdbcUtils.getConnetion():datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
//查询所有并且模糊查询	
	public static <T> List<T> findAllmessage(String sql,Class<T> c,Object...obj) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		List<T> list = new ArrayList<T>();
		try {
			con = getConnetion();
			ps = con.prepareStatement(sql);
			for(int i = 0 ; i < obj.length; i ++) {
				ps.setObject(i+1,obj[i]);
			}
			set = ps.executeQuery();
			while(set.next()){
				T t = c.newInstance();
				core(t,set);
				list.add(t);
				
			}
		} catch (Exception e) {
		}
		JdbcUtils.close(ps,set,con);
		return list;
	}
	public static <T> void core(T t,ResultSet set){
		Class<? extends Object> class1 = t.getClass();
		try {
			ResultSetMetaData metaData = set.getMetaData();
			for(int i = 1 ; i <= metaData.getColumnCount(); i ++) {
				String name = metaData.getColumnName(i);
				Field declaredField = class1.getDeclaredField(name);
				declaredField.setAccessible(true);
				declaredField.set(t,set.getObject(i));
			}
		} catch (SQLException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
//添加的功能
	public static int message(String sql,Object...obj) {
		System.out.println(sql);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		int count = 0;
		try {
			con = getConnetion();
			ps = con.prepareStatement(sql);
			for(int i = 0 ; i < obj.length; i ++) {
				ps.setObject(i+1,obj[i]);
			}
			count = ps.executeUpdate();
		} catch (Exception e) {
		}
		JdbcUtils.close(ps,set,con);
		return count;
	}
}
