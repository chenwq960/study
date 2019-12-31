package com.baidu.dto;

public class AverPrice {
	private int averger;
	private String name;
	private int base_pay;
	@Override
	public String toString() {
		return "AverPrice [平均薪資=" + averger + ", name=" + name + ", 工齡=" + base_pay + "]";
	}
	/**
	 * @return the average
	 */
	public int getAverage() {
		return averger;
	}
	/**
	 * @param average the average to set
	 */
	public void setAverage(int average) {
		this.averger = average;
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
	 * @return the base_pay
	 */
	public int getBase_pay() {
		return base_pay;
	}
	/**
	 * @param base_pay the base_pay to set
	 */
	public void setBase_pay(int base_pay) {
		this.base_pay = base_pay;
	}
	public AverPrice(int average, String name, int base_pay) {
		super();
		this.averger = average;
		this.name = name;
		this.base_pay = base_pay;
	}
	public AverPrice() {
		super();
	}
	
}
