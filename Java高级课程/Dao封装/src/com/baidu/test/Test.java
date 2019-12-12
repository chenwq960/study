package com.baidu.test;

import com.baidu.dto.BaseDao;
import com.baidu.util.MappingUtils;

public class Test {
	public static void main(String[] args) {
//		List<Stu> execurequery = BaseDao.execurequery(MappingUtils.getsql("findsql"),Stu.class,"陈");
//		execurequery.forEach(System.out::println);
//		int delete = BaseDao.delete(MappingUtils.getsql("delsql"),Integer.valueOf(2));
//		System.out.println(delete);
		
		int delete = BaseDao.delete(MappingUtils.getsql("addmessage"),"辛苦辛苦辛苦姐","不辛苦",Integer.valueOf(10));
		System.out.println(delete);
	}
}
