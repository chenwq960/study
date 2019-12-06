package com.baidu;

public class OracleIMP implements Count{

	@Override
	public DatabaseName getname() {
		return new Oracle();
	}

	@Override
	public Computer getcomputer() {
		// TODO Auto-generated method stub
		return new OracleCom();
	}

}
