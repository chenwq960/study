package com.baidu.dto;

import java.sql.Date;

public class Role {
	private int role_id;
	private String role_name;
	private Date create_time;
	private Integer create_user;
	private Date update_time;
	private Integer update_user;
	private int is_delete;
	/**
	 * @return the role_id
	 */
	public int getRole_id() {
		return role_id;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	/**
	 * @return the role_name
	 */
	public String getRole_name() {
		return role_name;
	}
	/**
	 * @param role_name the role_name to set
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
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
	public int getIs_delete() {
		return is_delete;
	}
	/**
	 * @param is_delete the is_delete to set
	 */
	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", create_time=" + create_time
				+ ", create_user=" + create_user + ", update_time=" + update_time + ", update_user=" + update_user
				+ ", is_delete=" + is_delete + "]";
	}
	public Role(int role_id, String role_name, Date create_time, Object object, Date update_time,
			Object object2, int is_delete) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.create_time = create_time;
		this.create_user = (Integer) object;
		this.update_time = update_time;
		this.update_user = (Integer) object2;
		this.is_delete = is_delete;
	}
	public Role() {
		super();
	}
	
	
}
