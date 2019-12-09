package com.baidu;

public class Test {
	public static void main(String[] args) {
		Change1 change1 = new Change();
		change1.listchange().forEach(System.out::print);
		System.out.println("-----------");
		Change2 change2 = new Change();
		change2.listchange2().forEach(System.out::print);;
	}
}
