package com.baidu.service;

import java.util.List;

import com.baidu.dto.Stu;

public interface IServlet {
	List<Stu> findAll(String name);

	int addmessage(String name, String username);

	int deleteId(Integer i);

	int deleteAllmessage(String name);
}
