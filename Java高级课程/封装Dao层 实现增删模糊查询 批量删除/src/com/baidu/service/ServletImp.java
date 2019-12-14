package com.baidu.service;

import java.util.List;

import com.baidu.dto.Stu;
import com.baidu.emp.Empimp;
import com.baidu.emp.IEmp;

public class ServletImp implements IServlet{
	private IEmp emp = new Empimp();
	@Override
	public List<Stu> findAll(String name) {
		return emp.findAll(name);
	}
	@Override
	public int addmessage(String name, String username) {
		// TODO Auto-generated method stub
		return emp.addmess(name,username);
	}
	@Override
	public int deleteId(Integer i) {
		return emp.deleteId(i);
	}
	@Override
	public int deleteAllmessage(String name) {
		// TODO Auto-generated method stub
		return emp.deleteAll(name);
	}

}
