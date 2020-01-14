package com.baidu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baidu.dto.Department;
import com.baidu.dto.Login;
import com.baidu.dto.Role;

public interface UserMapper {
	
	@Select("select * from login where login_user = #{login_user}")
	Login loginFind(Login login);

	
//
	@Select("select * from tb_role where is_delete = 0  Order By create_time asc")
	List<Role> rolefind();

	
//部门表的查询方法
	List<Department> dedepartmentFind(@Param("modelname")String modelname, @Param("startTime")String startTime, @Param("endTime")String endTime);
//部门表插入的时候
	@Insert("insert into tb_department VALUES(null,#{department_name},#{create_time},#{create_user},#{update_time},#{update_user},0)")
	int createdepartment(Department department);
//部门表修改的时候
	@Update("update tb_department set is_delete = 1 where department_id = #{id}")
	int departmentdel(String id);
//回显用户选中的ID
	Department departmenthx(@Param("id")String id);

//查找所有的部门，回显的时候用
	@Select("SELECT department_name from tb_department where is_delete = 0")
	List<Department> departmentfind();
//修改部门信息
	@Update("update tb_department set department_name = ${department_name},create_user= ${create_user},UPDATE_time=${update_time} where department_id = ${department_id}")
	int updatedepartment(Department department);
	
	
//角色的查询方式
	List<Role> findRole(@Param("modelName")String modelName, @Param("startTime")String startTime, @Param("endTime")String endTime);

//角色的增加方法
	@Insert("insert into tb_role VALUES(null,#{role_name},#{create_time},#{create_user},#{update_time},#{update_user},0)")
	int addrole(Role role2);

//角色删除的方法
	@Update("update tb_role set is_delete = 1 where role_id = #{id}")
	int delrole(@Param("id")String id);
//角色回显的方式
	@Select("select * from tb_role where role_id = #{id}")
	Role rolehx(@Param("id")String id);
//角色修改的方法
	@Update("update tb_role set role_name = #{role_name},update_time=#{update_time},update_user=#{update_user},is_delete = 0 where role_id = #{role_id}")
	int changerole(Role role);
	
}
