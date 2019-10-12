package com.baidu;

public class Student {
	private int id;
	private String name;
	private String mes;
	public Student(int id, String name, String mes) {
		this.id = id;
		this.name = name;
		this.mes = mes;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mes=" + mes + "]";
	}
	

}
