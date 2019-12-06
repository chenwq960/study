package com.baidu;

public class OracleCom implements Computer {

	@Override
	public int sum(int i, int j) {
		// TODO Auto-generated method stub
		return i+j;
	}

	@Override
	public int jian(int i, int j) {
		// TODO Auto-generated method stub
		return i-j;
	}

	@Override
	public int cheng(int i, int j) {
		// TODO Auto-generated method stub
		return i*j;
	}

	@Override
	public int chu(int i, int j) {
		// TODO Auto-generated method stub
		return i/j;
	}

}
