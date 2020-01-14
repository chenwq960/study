package com.baidu.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.dto.Department;
import com.baidu.dto.Login;
import com.baidu.dto.Role;
import com.baidu.service.IUserSerivce;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class Do {
	@Autowired
	private IUserSerivce service;
	
	
	
//角色表的查询方式
	@RequestMapping("/roleFind")
	@ResponseBody
	public ModelAndView roleFind(
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(value = "modelName",defaultValue = "%")String modelName,
			@RequestParam(value = "startTime", defaultValue = "0") String startTime,
			@RequestParam(value = "endTime", defaultValue = "now()") String endTime,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		PageHelper.startPage(pageNum,5);
		
		List<Role> role = service.findRole(modelName,startTime,endTime);
		PageInfo<Role> pi = new PageInfo<Role>(role);
		System.out.println(modelName);
		ModelAndView mav = new ModelAndView();
		mav.addObject("role",role);
		mav.addObject("modelName",modelName);
		mav.addObject("startTime",startTime);
		mav.addObject("endTime",endTime);
		mav.addObject("limitmodel",pi);
		mav.setViewName("user/list");
		return mav;
	}
	
//角色增加的方法
	@RequestMapping("/adduser")
	@ResponseBody
	public int adduser(Role role,HttpSession session) {
		String name = role.getRole_name();
		role.setRole_id((int) session.getAttribute("number"));
		@SuppressWarnings("all")
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		Role role2 = new Role(0,name,date,session.getAttribute("number"),date,session.getAttribute("number"),0);
		System.out.println(role2);
		int i = service.addrole(role2);
		return i;
	}
//角色表格删除的方法
	@RequestMapping("/delrole")
	@ResponseBody
	public int delrole(String id) {
		int i = service.delrole(id);
		return i;
	}
//角色回显的方法
	@RequestMapping("/rolehx")
	@ResponseBody
	public Role rolehx(String id) {
		Role role = service.rolehx(id);
		return role;
		
	}
//角色的修改方法
	@RequestMapping("/changerole")
	@ResponseBody
	public int changerole(String name,int id,HttpSession session) {
		Role role = new Role();
		role.setRole_id(id);
		role.setRole_name(name);
		@SuppressWarnings("unused")
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		role.setUpdate_time(date);
		role.setUpdate_user((Integer) session.getAttribute("number"));
		role.setIs_delete(0);
		System.out.println(role);
		int i = service.changerole(role);
		return i;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 部门表添加的方法
	@RequestMapping("/createdepartment")
	@ResponseBody
	public int createdepartment(@Param("department_name") String department_name, HttpSession session) {
		// 当前用户
		Object attribute = session.getAttribute("number");
		@SuppressWarnings("unused")
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		Department department = new Department(1, department_name, date, attribute, date, attribute, 0);
		int i = service.createdepartment(department);
		return i;
	}

//部门表删除的方法
	@RequestMapping("/departmentdel")
	@ResponseBody
	public int departmentdel(String id) {
		int i = service.departmentdel(id);
		return i;
	}

//部门回显的方法
	@RequestMapping("/departmenthx")
	@ResponseBody
	public Department departmenthx(String id) {
		Department department = service.departmenthx(id);
		return department;
	}

//查找所有的部门，回显的时候准备
	@RequestMapping("/departmentfind")
	@ResponseBody
	public List<Department> departmentfind() {
		List<Department> model = service.departmentfind();
		return model;
	}

//部门表修改提交的方法
	@RequestMapping("/updatedepartment")
	@ResponseBody
	public int updatedepartment(Department department, HttpSession session, HttpServletRequest request,
			HttpServletResponse respongse) {
		// 解决乱码问题
		try {
			respongse.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 初始化时间.....修改的时间
		@SuppressWarnings("unused")
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		System.out.println("-----------------修改的方法");
		System.out.println(department);
		System.out.println(department.getDepartment_name());
		department.setUpdate_time(date);
		// 当前用户
		Object attribute = session.getAttribute("number");
		department.setUpdate_user((Integer) attribute);
		department.setIs_delete(0);
		int i = service.updatedepartment(department);
		return i;
	}

//部门表的查询
	@RequestMapping("/departmentFind")
	@ResponseBody
	public ModelAndView departmentFind(
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(value = "modelname", defaultValue = "%") String modelname,
			@RequestParam(value = "startTime", defaultValue = "0") String startTime,
			@RequestParam(value = "endTime", defaultValue = "now()") String endTime) {
		PageHelper.startPage(pageNum,5);
		List<Department> departmentFind = service.departmentFind(modelname, startTime, endTime);
		PageInfo<Department> pi = new PageInfo<Department>(departmentFind);
		ModelAndView mav = new ModelAndView();
		mav.addObject("department", departmentFind);
		mav.addObject("limitmodel", pi);
		if (modelname != "%") {
			mav.addObject("modelname", modelname);
		}
		if (startTime != "0") {
			mav.addObject("starttime", startTime);
		}
		if (endTime != "now()") {
			mav.addObject("endTime", endTime);
		}
		mav.setViewName("department/list");
		return mav;
	}

	// 登陆的验证方法
	@RequestMapping("/login")
	@ResponseBody
	public ModelAndView login(Login login, HttpSession session) {
		int i = service.loginFind(login, session);
		ModelAndView mav = new ModelAndView();
		if (i == 1) {// 密码没有问题
			session.setAttribute("user", login);
			mav.setViewName("layout/main");
		}
		return mav;
	}
}
