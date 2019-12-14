package com.baidu.emp;

import java.util.List;

import com.baidu.dto.Stu;

public interface IEmp {
	List<Stu> findAll(String name);

	int addmess(String name, String username);

	int deleteId(Integer i);

	int deleteAll(String name);
}
