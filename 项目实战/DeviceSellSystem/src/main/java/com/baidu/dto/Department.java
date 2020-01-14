package com.baidu.dto;

import java.sql.Date;

public class Department {
	private Integer department_id;
	private String department_name;
	private Date create_time;
	private Integer create_user;
	private Date update_time;
	private Integer update_user;
	private Integer is_delete;
	/**
	 * @return the department_id
	 */
	public Integer getDepartment_id() {
		return department_id;
	}
	/**
	 * @param department_id the department_id to set
	 */
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	/**
	 * @return the department_name
	 */
	public String getDepartment_name() {
		return department_name;
	}
	/**
	 * @param department_name the department_name to set
	 */
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	/**
	 * @return the create_time
	 */
	public Date getCreate_time() {
		return create_time;
	}
	/**
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	/**
	 * @return the create_user
	 */
	public Integer getCreate_user() {
		return create_user;
	}
	/**
	 * @param create_user the create_user to set
	 */
	public void setCreate_user(Integer create_user) {
		this.create_user = create_user;
	}
	/**
	 * @return the update_time
	 */
	public Date getUpdate_time() {
		return update_time;
	}
	/**
	 * @param update_time the update_time to set
	 */
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	/**
	 * @return the update_user
	 */
	public Integer getUpdate_user() {
		return update_user;
	}
	/**
	 * @param update_user the update_user to set
	 */
	public void setUpdate_user(Integer update_user) {
		this.update_user = update_user;
	}
	/**
	 * @return the is_delete
	 */
	public Integer getIs_delete() {
		return is_delete;
	}
	/**
	 * @param is_delete the is_delete to set
	 */
	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}
	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name + ", create_time="
				+ create_time + ", create_user=" + create_user + ", update_time=" + update_time + ", update_user="
				+ update_user + ", is_delete=" + is_delete + "]";
	}
	public Department(Integer department_id, String department_name, Date create_time, Object attribute,
			Date update_time, Object attribute2, Integer is_delete) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.create_time = create_time;
		this.create_user = (Integer) attribute;
		this.update_time = update_time;
		this.update_user = (Integer) attribute2;
		this.is_delete = is_delete;
	}
	public Department() {
	}

}
