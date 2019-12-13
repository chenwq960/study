package com.baidu.test;

import java.util.List;

import com.baidu.dao.MyppingUtils;
import com.baidu.dao.database.Database;
import com.baidu.dto.Stu;

public class EmpImp implements IEmp{

	@Override
	public List<Stu> find() {
		List<Stu> executequeryone = Database.executequeryone(MyppingUtils.getSql("findsql"),Stu.class);
		return executequeryone;
	}

}
