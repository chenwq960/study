package com.baidu.serviet;

import java.util.List;

import com.baidu.dto.Stu;
import com.baidu.test.EmpImp;
import com.baidu.test.IEmp;

public class ServietImp implements IServiet{
	private IEmp emp = new EmpImp();

	@Override
	public List<Stu> find() {
		return emp.find();
	}

}
