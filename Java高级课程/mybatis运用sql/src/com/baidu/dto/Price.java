package com.baidu.dto;

public class Price {
	private int count;
	private String name;
	@Override
	public String toString() {
		return "Price [count=" + count + ", name=" + name + "]";
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
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
	public Price(int count, String name) {
		super();
		this.count = count;
		this.name = name;
	}
	public Price() {
		super();
	}
	
}
