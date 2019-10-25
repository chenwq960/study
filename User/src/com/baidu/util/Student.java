package com.baidu.util;

public class Student {
	private int id;
	private String title;
	private String name;
	@Override
	public String toString() {
		return "Student [id=" + id + ", title=" + title + ", name=" + name + "]";
	}
	public Student(int id, String title, String name) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	

}
