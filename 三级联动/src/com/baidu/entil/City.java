package com.baidu.entil;

public class City {
	private int id;
	private String pid;
	private String name;

	@Override
	public String toString() {
		return "City [id=" + id + ", pid=" + pid + ", name=" + name + "]";
	}

	public City(int id, String pid, String name) {
		super();
		this.id = id;
		this.pid = pid;
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
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
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
