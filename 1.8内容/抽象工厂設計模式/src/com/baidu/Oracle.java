package com.baidu;

public class Oracle implements DatabaseName{

	@Override
	public void begin() {
		System.out.println("oracle  連接成功");
	}
	@Override
	public void close() {
		System.out.println("oracle 連接成功");
	}

}
