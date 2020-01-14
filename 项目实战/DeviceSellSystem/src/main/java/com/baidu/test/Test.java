package com.baidu.test;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
	}
}
