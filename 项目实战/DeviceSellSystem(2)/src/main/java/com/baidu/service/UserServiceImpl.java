package com.baidu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dto.User;
import com.baidu.mapper.UserMapper;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> showUser() {
		return userMapper.showUser();
	}

	@Override
	public User queryDetailByAccount(String account) {
		return userMapper.selectByAccount(account);
	}

//根据部门名称查询部门ID
	@Override
	public int selectUserDepartment(String departmentName) {
		// TODO Auto-generated method stub
		return userMapper.selectUserDepartment(departmentName);
	}
}
