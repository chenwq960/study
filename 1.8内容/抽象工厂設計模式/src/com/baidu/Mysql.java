package com.baidu;

public class Mysql implements DatabaseName{

	@Override
	public void begin() {
		System.out.println("mysql  連接成功");
	}

	@Override
	public void close() {
		System.out.println("mysql  關閉成功");
	}

}
