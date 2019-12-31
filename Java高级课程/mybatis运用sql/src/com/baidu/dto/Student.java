package com.baidu.dto;

public class Student {
	private int id;
	private double base_pay;
	private String nerit_pay;
	private String pay_date;
	private int eid;
	private String name;
	private String sex;
	private String address;
	private String idNo;
	@Override
	public String toString() {
		return "Student [id=" + id + ", base_pay=" + base_pay + ", nerit_pay=" + nerit_pay + ", pay_date=" + pay_date
				+ ", eid=" + eid + ", name=" + name + ", sex=" + sex + ", address=" + address + ", idNo=" + idNo + "]";
	}
	public Student(int id, double base_pay, String nerit_pay, String pay_date, int eid, String name, String sex,
			String address, String idNo) {
		super();
		this.id = id;
		this.base_pay = base_pay;
		this.nerit_pay = nerit_pay;
		this.pay_date = pay_date;
		this.eid = eid;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.idNo = idNo;
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
	 * @return the base_pay
	 */
	public double getBase_pay() {
		return base_pay;
	}
	/**
	 * @param base_pay the base_pay to set
	 */
	public void setBase_pay(double base_pay) {
		this.base_pay = base_pay;
	}
	/**
	 * @return the nerit_pay
	 */
	public String getNerit_pay() {
		return nerit_pay;
	}
	/**
	 * @param nerit_pay the nerit_pay to set
	 */
	public void setNerit_pay(String nerit_pay) {
		this.nerit_pay = nerit_pay;
	}
	/**
	 * @return the pay_date
	 */
	public String getPay_date() {
		return pay_date;
	}
	/**
	 * @param pay_date the pay_date to set
	 */
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	/**
	 * @return the eid
	 */
	public int getEid() {
		return eid;
	}
	/**
	 * @param eid the eid to set
	 */
	public void setEid(int eid) {
		this.eid = eid;
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
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the idNo
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * @param idNo the idNo to set
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public Student() {
		super();
	}
	
}
