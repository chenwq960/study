package com.baidu.test;

import java.util.List;

import com.baidu.dao.MyppingUtils;
import com.baidu.dao.database.Database;
import com.baidu.dto.Stu;

public class Test {
	public static void main(String[] args) {
		List<Stu> executequeryone = Database.executequeryone(MyppingUtils.getSql("findsql"),Stu.class);
		executequeryone.forEach(System.out::println);
		
	}
}
