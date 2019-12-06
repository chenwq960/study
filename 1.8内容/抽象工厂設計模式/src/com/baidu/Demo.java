package com.baidu;

public class Demo {
	public static void main(String[] args) {
		Count count = new MysqlImp();
		DatabaseName getname = count.getname();
		getname.begin();
		getname.close();
		Computer getcomputer = count.getcomputer();
		int sum = getcomputer.sum(111,111);
		System.out.println(sum);
		
		Count count1 = new OracleIMP();
		DatabaseName getname2 = count1.getname();
		getname2.begin();
		getname2.close();
	}
}
