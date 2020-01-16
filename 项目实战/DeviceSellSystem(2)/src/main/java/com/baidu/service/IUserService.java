package com.baidu.service;

import java.util.List;

import com.baidu.dto.User;

public interface IUserService {

	List<User> showUser();
	
	User queryDetailByAccount(String account);

	//根据部门名称查询部门的ID
	int selectUserDepartment(String departmentName);

}
