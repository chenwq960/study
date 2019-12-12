package com.baidu.dto;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.baidu.util.JdbcUtils;

public class BaseDao {
	private static DataSource datasource;
	public static void findmessage(String finding) {
		try {
			InitialContext initialContext = new InitialContext();
			datasource = (DataSource) initialContext.lookup("java:comp/env/"+finding);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnetion() {
		try {
			return datasource == null?JdbcUtils.getConnection():datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static <T> List<T> execurequery(String sql,Class<T> c,Object...obj) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		List<T> array = new ArrayList<T>();
		try {
			con = getConnetion();
			ps = con.prepareStatement(sql);
			for(int i = 0 ; i < obj.length; i ++) {
				ps.setObject(i+1,obj[i]);
			}
			set = ps.executeQuery();
			while(set.next()) {
				T t = c.newInstance();
				core(t,set);
				array.add(t);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("查询所有的sql发生异常"+e);
		}
		JdbcUtils.close(con,ps,set);
		return array;
		
		
	}
//显示列表的方法
	public static <T> void core(T t,ResultSet set) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//删除的方法
	public static int delete(String sql,Object...obj) {
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			con = getConnetion();
			ps = con.prepareStatement(sql);
			for(int i = 0 ; i < obj.length ; i ++) {
				ps.setObject(i+1,obj[i]);
			}
		//	set = ps.executeQuery();
			count = ps.executeUpdate();
			
		} catch (Exception e) {
			throw new RuntimeException("删除数据发生异常"+e);
		}
		JdbcUtils.close(con,ps);
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
