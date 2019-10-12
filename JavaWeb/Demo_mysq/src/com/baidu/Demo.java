package com.baidu;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.mysql.jdbc.Connection;

public class Demo {
	public static void main(String [] agrs) throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement s = null;
		
			Class.forName("com.mysql.jdbc.Driver");
			
			con = (Connection) DriverManager.getConnection("JDBC:mysql:///news", "root","960879872chenwq");
			
			s = con.createStatement();
			//String sql = "insert into name values(null,'cwq')";
		//	String sql = "insert into name values(null,'hhh'),(null,'cch')";
			String sql = "select * from news";
			ResultSet set = s.executeQuery(sql);
			
			ArrayList<Student> list = new ArrayList<Student>();
			
			while(set.next()) {
				Student stu = new Student(set.getInt("newsId"), set.getString("NEWSaUTHOR"), set.getString("newsTitle"));
				list.add(stu);
			}
			
			
			Iterator<Student> it = list.listIterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
			
			
			
			
			
			
			
//			while(set.next()) {
//				System.out.println(set.getObject(1)+"\t"+set.getObject(2)+"\t"+set.getObject(3));
//			}
			s.close();
			con.close();
		
		
		
		
	}

}
