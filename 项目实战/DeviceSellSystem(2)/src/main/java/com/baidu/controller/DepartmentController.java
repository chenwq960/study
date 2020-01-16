package com.baidu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.dto.Department;
import com.baidu.dto.User;
import com.baidu.service.IDepartmentService;
import com.baidu.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 部门相关Controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;

	// 部门表的查询
	@RequestMapping("/list")
	@ResponseBody
	public ModelAndView departmentList(
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(value = "searchKey", required = false) String searchKey) {
		PageHelper.startPage(pageNum, 5);
		List<Department> departmentFind = departmentService.departmentFind(searchKey);
		PageInfo<Department> pi = new PageInfo<Department>(departmentFind);
		ModelAndView mav = new ModelAndView();
		mav.addObject("department", departmentFind);
		mav.addObject("limitmodel", pi);
		mav.addObject("searchKey", searchKey);
		mav.setViewName("department/list");
		return mav;
	}

	// 部门表修改提交的方法
	@RequestMapping("/update")
	@ResponseBody
	public int updateDepartment(Department department, HttpSession session) {
		// 初始化时间.....修改的时间
		System.out.println("-----------------修改的方法");
		department.setUpdateTime(new Date());
		int userId = User.class.cast(session.getAttribute("currentUser")).getUserId();
		department.setUpdateUser(userId);
		// 当前用户
		Object attribute = session.getAttribute("number");
		department.setUpdateUser((Integer) attribute);
		System.out.println(department);
		int i = departmentService.updatedepartment(department);
		return i;
	}

	// 部门表添加的方法
	@RequestMapping("/createdepartment")
	@ResponseBody
	public int createdepartment(@Param("department_name") String department_name, HttpSession session) {
		// 当前用户
		int userId = User.class.cast(session.getAttribute("currentUser")).getUserId();
		Department department = new Department();
		department.setDepartmentName(department_name);
		department.setUpdateUser(userId);
		int i = departmentService.createdepartment(department);
		return i;
	}

	// 部门表删除的方法
	@RequestMapping("/departmentdel")
	@ResponseBody
	public int departmentdel(Integer id) {
		departmentService.departmentdel(id);
		return 1;
	}

	// 部门回显的方法
	@RequestMapping("/departmenthx")
	@ResponseBody
	public Department departmenthx(Integer id) {
		Department department = departmentService.departmenthx(id);
		return department;
	}

	// 查找所有的部门，回显的时候准备
	@RequestMapping("/departmentfind")
	@ResponseBody
	public List<Department> departmentfind() {
		List<Department> model = departmentService.departmentFind(null);
		return model;
	}

}
