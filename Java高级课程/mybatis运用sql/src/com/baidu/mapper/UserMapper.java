package com.baidu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baidu.dto.AverPrice;
import com.baidu.dto.Price;
import com.baidu.dto.Student;

public interface UserMapper {
	List<Student> findAll();
	
	List<Student> findByName(@Param("name")String name);
	
	List<Student> findByTime(@Param("beg")String beg,@Param("small")String small);
	
	List<Price> findPriceAndAge();
	
	List<AverPrice> findByNameAndAVg();
	
	List<AverPrice> findByPrivaceAverage();
	
	int deleteByEmpMes(@Param("id")String id);
	
	int changByemp(Map<String,Object> map);
	
	int changPrivateTO(@Param("id")String id);
	
	List<AverPrice> BestPerson();
}
