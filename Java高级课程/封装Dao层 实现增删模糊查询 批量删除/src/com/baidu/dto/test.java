package com.baidu.dto;

import java.util.List;

import com.baidu.dao.MappUtils;
import com.baidu.dao.BaseDao.BaseDao;

public class test {
	public static void main(String[] args) {
		
		int message = BaseDao.message(MappUtils.getSql("delete"),1);
		System.out.println(message);
	}
}
