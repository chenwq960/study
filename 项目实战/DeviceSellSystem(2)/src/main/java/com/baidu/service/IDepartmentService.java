package com.baidu.service;

import java.util.List;

import com.baidu.dto.Department;

public interface IDepartmentService {

	List<Department> departmentFind(String searchKey);

	int createdepartment(Department department);

	void departmentdel(Integer id);

	Department departmenthx(Integer id);


	int updatedepartment(Department department);

}
