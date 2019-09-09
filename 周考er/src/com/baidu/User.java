package com.baidu;

public class User implements Comparable<User>{
	//private int num;
	private String name;
	private int age;
	private char sex;
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the sex
	 */
	public char getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}
	public User(String name, int age, char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.age - o.age;
	}
	
	

}
