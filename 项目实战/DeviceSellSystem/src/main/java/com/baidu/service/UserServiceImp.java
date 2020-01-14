package com.baidu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dto.Department;
import com.baidu.dto.Login;
import com.baidu.dto.Role;
import com.baidu.mapper.UserMapper;

@Service
public class UserServiceImp implements IUserSerivce{
	@Autowired
	private UserMapper mapper;
//查询用户密码正确
	@Override
	public int loginFind(Login login,HttpSession session) {
		int flag = 0;
		Login loginModel = mapper.loginFind(login);
		
		if(loginModel != null) {
			session.setAttribute("name",loginModel.getLogin_user());
			session.setAttribute("number", loginModel.getLogin_id());
			if(loginModel.getLogin_pwd().equals(login.getLogin_pwd())) {
				flag = 1;
			}else {
				flag = 2;
			}
		}
		return flag;
	}
//部门表的查询方式
	@Override
	public List<Department> departmentFind(String modelname,String startTime, String endTime) {
		return mapper.dedepartmentFind(modelname,startTime,endTime);
	}
//部门表的增加方法
	@Override
	public int createdepartment(Department department) {
		return mapper.createdepartment(department);
	}
//部门表格删除的方法
	@Override
	public int departmentdel(String id) {
		return mapper.departmentdel(id);
	}
//部门表格回显的方法
	@Override
	public Department departmenthx(String id) {
		return mapper.departmenthx(id);
	}
//查找所有的部门名称
	@Override
	public List<Department> departmentfind() {
		return mapper.departmentfind();
	}
//部门表修改的方法
	@Override
	public int updatedepartment(Department department) {
		return mapper.updatedepartment(department);
	}
//

	
	
	
//角色的查询
	@Override
	public List<Role> findRole(String modelName, String startTime, String endTime) {
		return mapper.findRole(modelName,startTime,endTime);
	}
//角色的增加方法
	@Override
	public int addrole(Role role2) {
		return mapper.addrole(role2);
	}
//角色删除的方法
	@Override
	public int delrole(String id) {
		return mapper.delrole(id);
	}
//用户回显的方法
	@Override
	public Role rolehx(String id) {
		return mapper.rolehx(id);
	}
//用户
	@Override
	public int changerole(Role role) {
		return mapper.changerole(role);
	}
	

}
