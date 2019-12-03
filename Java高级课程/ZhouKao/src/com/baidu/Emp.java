package com.baidu;

public class Emp extends Person{
	private String workNo;
	String stageName;
	protected String workYear;
	public String dept;

	/**
	 * @return the workNo
	 */
	public String getWorkNo() {
		return workNo;
	}

	/**
	 * @param workNo the workNo to set
	 */
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	/**
	 * @return the stageName
	 */
	public String getStageName() {
		return stageName;
	}

	/**
	 * @param stageName the stageName to set
	 */
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	/**
	 * @return the workYear
	 */
	public String getWorkYear() {
		return workYear;
	}

	/**
	 * @param workYear the workYear to set
	 */
	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}

	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [workNo=" + workNo + ", stageName=" + stageName + ", workYear=" + workYear + ", dept=" + dept + "]";
	}

	public Emp(String workNo, String stageName, String workYear, String dept) {
		super();
		this.workNo = workNo;
		this.stageName = stageName;
		this.workYear = workYear;
		this.dept = dept;
	}

	public Emp() {
		super();
	}
	
	
//提供无参无返的方法
	public void print() {
		System.out.println("Emp的成员信息"+workNo+"\t"+workYear+"\t"+stageName+"\t"+dept);
	}
//提供有参有返回值的方式
	public String sayHi(String name) {
		System.out.println("name的属性值是"+name);
		return name;
	}
	
	

}
