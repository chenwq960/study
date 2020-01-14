package com.baidu.dto;

public class Login {
	private Integer login_id;
	private String login_user;
	private String login_pwd;
	/**
	 * @return the login_id
	 */
	public Integer getLogin_id() {
		return login_id;
	}
	/**
	 * @param login_id the login_id to set
	 */
	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}
	/**
	 * @return the login_user
	 */
	public String getLogin_user() {
		return login_user;
	}
	/**
	 * @param login_user the login_user to set
	 */
	public void setLogin_user(String login_user) {
		this.login_user = login_user;
	}
	/**
	 * @return the login_pwd
	 */
	public String getLogin_pwd() {
		return login_pwd;
	}
	/**
	 * @param login_pwd the login_pwd to set
	 */
	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}
	@Override
	public String toString() {
		return "Login [login_id=" + login_id + ", login_user=" + login_user + ", login_pwd=" + login_pwd + "]";
	}
	public Login(Integer login_id, String login_user, String login_pwd) {
		super();
		this.login_id = login_id;
		this.login_user = login_user;
		this.login_pwd = login_pwd;
	}
	public Login() {
	}
	

}
