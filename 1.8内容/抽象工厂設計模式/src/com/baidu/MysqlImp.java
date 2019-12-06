package com.baidu;

public class MysqlImp implements Count{

	public DatabaseName getname() {
		return new Mysql();
	}

	@Override
	public Computer getcomputer() {
		// TODO Auto-generated method stub
		return new MysqlCom();
	}

}
