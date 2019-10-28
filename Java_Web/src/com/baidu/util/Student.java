package com.baidu.util;

public class Student {
	private int id;
	private String name;
	private String price;
	private String color;
	private String type;
	private String typeid;
	private String date;
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", price=" + price + ", color=" + color + ", type=" + type
				+ ", typeid=" + typeid + ", date=" + date + "]";
	}
	public Student(int id, String name, String price, String color, String type, String typeid, String date) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.color = color;
		this.type = type;
		this.typeid = typeid;
		this.date = date;
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
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the typeid
	 */
	public String getTypeid() {
		return typeid;
	}
	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	

}
