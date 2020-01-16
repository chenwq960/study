package com.baidu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dto.Department;
import com.baidu.mapper.DepartmentMapper;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	// 部门表的查询方式
	@Override
	public List<Department> departmentFind(String searchKey) {
		// TODO 尚未实现模糊查询
		return departmentMapper.selectList();
	}

	// 部门表的增加方法
	@Override
	public int createdepartment(Department department) {
		return departmentMapper.insert(department);
	}

	// 部门表格删除的方法
	@Override
	public void departmentdel(Integer departmentId) {
		// TODO 进行逻辑删除
//		return mapperDepartmentMapper.deleteByPrimaryKey(departmentId);
	}

	// 部门表格回显的方法
	@Override
	public Department departmenthx(Integer departmentId) {
		return departmentMapper.selectByPrimaryKey(departmentId);
	}

	// 部门表修改的方法
	@Override
	public int updatedepartment(Department department) {
		return departmentMapper.updateByPrimaryKeySelective(department);
	}

}
