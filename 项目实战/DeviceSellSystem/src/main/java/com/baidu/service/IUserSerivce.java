package com.baidu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.baidu.dto.Department;
import com.baidu.dto.Login;
import com.baidu.dto.Role;

public interface IUserSerivce {
//查询用户密码正确
	int loginFind(Login login, HttpSession session);

	List<Department> departmentFind(String modelname, String startTime, String endTime);

	int createdepartment(Department department);

	int departmentdel(String id);

	Department departmenthx(String id);

	List<Department> departmentfind();

	int updatedepartment(Department department);

	List<Role> findRole(String modelName, String startTime, String endTime);

	int addrole(Role role2);

	int delrole(String id);

	Role rolehx(String id);

	int changerole(Role role);
}
