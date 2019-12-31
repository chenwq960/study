package com.baidu.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import com.baidu.dto.AverPrice;
import com.baidu.dto.Price;
import com.baidu.dto.Student;
import com.baidu.mapper.UserMapper;

public class Demo {
	private SqlSession sqlsession;
	@Before
	public void find() {
		try {
			sqlsession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//查询工资明细，包含员工姓名、基本工资、绩效工资和发放日期
	@Test
	public void all() {
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		List<Student> findAll = mapper.findAll();
		findAll.stream().forEachOrdered(System.out::println);
		
	}
//照员工姓名模糊查询工资明细
	@Test
	public void findModelByName() {
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		List<Student> findByName = mapper.findByName("李");
		findByName.forEach(System.out::println);
	}
//（8）查询某个时间段内的工资发放情况
	@Test
	public void findByTime() {
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		List<Student> findByName = mapper.findByTime("1998-04-01","2002-01-01");
		findByName.forEach(System.out::println);
	}
//查询工龄和姓名
	@Test
	public void findByNameAndAge() {
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		List<Price> findPriceAndAge = mapper.findPriceAndAge();
		findPriceAndAge.forEach(System.out::println);
	}
//（10）查询每位员工的月平均薪资，包含员工姓名、工龄、月平均工资
	@Test
	public void findByAverPrice() {
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		List<AverPrice> findByNameAndAVg = mapper.findByNameAndAVg();
		findByNameAndAVg.forEach(System.out::println);
	}
//（12）查询月平均工资高于10000的员工信息
	@Test
	public void findByPrivaceAve() {
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		List<AverPrice> findByNameAndAVg = mapper.findByPrivaceAverage();
		findByNameAndAVg.forEach(System.out::println);
	}
//刪除員工屬性
	@Test
	public void deleteByEmpMesssage() {
		String id = "1";
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		int findByNameAndAVg = mapper.deleteByEmpMes(id);
		sqlsession.commit();
		System.out.println(findByNameAndAVg);
	}
	@Test
	public void changByempMes() {
		//UPDATE emp set name ='陈文庆',sex="女",address="河北邯郸",idNo="12345545" where id = 2
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name","嘻嘻嘻");
		map.put("sex","男");
		map.put("address","嘻嘻嘻111111");
		map.put("idNo","454554");
		map.put("id","2");
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		int findByNameAndAVg = mapper.changByemp(map);
		sqlsession.commit();
		System.out.println(findByNameAndAVg);
	}
//刪除薪資
	@Test
	public void changPrivateto() {
		String id = "3";
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		int findByNameAndAVg = mapper.changPrivateTO(id);
		sqlsession.commit();
		System.out.println(findByNameAndAVg);
	}
//最高的工資
	@Test
	public void BestPerson() {
		String id = "3";
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		List<AverPrice> bestPerson = mapper.BestPerson();
		bestPerson.forEach(System.out::println);
	}
}
