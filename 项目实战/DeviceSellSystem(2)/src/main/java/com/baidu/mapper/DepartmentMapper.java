package com.baidu.mapper;

import java.util.List;

import com.baidu.dto.Department;

public interface DepartmentMapper {
	int deleteByPrimaryKey(Integer departmentId);

	int insert(Department record);

	int insertSelective(Department record);

	Department selectByPrimaryKey(Integer departmentId);

	List<Department> selectList();

	int updateByPrimaryKeySelective(Department record);

	int updateByPrimaryKey(Department record);

}