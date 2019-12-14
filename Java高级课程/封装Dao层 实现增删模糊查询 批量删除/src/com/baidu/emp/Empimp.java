package com.baidu.emp;

import java.util.List;

import com.baidu.dao.MappUtils;
import com.baidu.dao.BaseDao.BaseDao;
import com.baidu.dto.Stu;

public class Empimp implements IEmp{

	@Override
	public List<Stu> findAll(String name) {
		List<Stu> findAllmessage = BaseDao.findAllmessage(MappUtils.getSql("findsql"),Stu.class, name==null?"":name);
		return findAllmessage;
	}

	@Override
	public int addmess(String name, String username) {
		int message = BaseDao.message(MappUtils.getSql("addsql"),name,username);
		return message;
	}

	@Override
	public int deleteId(Integer i) {
		int message = BaseDao.message(MappUtils.getSql("delete"),i);
		return message;
	}

	@Override
	public int deleteAll(String name) {
		int message = BaseDao.message(MappUtils.getSql("delete"),name);
		return message;
	}


}
