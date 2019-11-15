package com.baidu.util;

public class Student {
	private int id;
	private String name;
	private String score;
	private String level;
	private String addr;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + ", level=" + level + ", addr=" + addr
				+ "]";
	}

	public Student(int id, String name, String score, String level, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.level = level;
		this.addr = addr;
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
	 * @return the score
	 */
	public String getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

}
