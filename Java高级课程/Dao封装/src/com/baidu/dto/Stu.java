package com.baidu.dto;

public class Stu {
	private String name1;
	private String name2;
	private Integer id;
	@Override
	public String toString() {
		return "Stu [name1=" + name1 + ", name2=" + name2 + ", id=" + id + "]";
	}
	/**
	 * @return the name1
	 */
	public String getName1() {
		return name1;
	}
	/**
	 * @param name1 the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}
	/**
	 * @return the name2
	 */
	public String getName2() {
		return name2;
	}
	/**
	 * @param name2 the name2 to set
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	public Stu(String name1, String name2, Integer id) {
		super();
		this.name1 = name1;
		this.name2 = name2;
		this.id = id;
	}
	public Stu() {
		super();
	}
	
}
