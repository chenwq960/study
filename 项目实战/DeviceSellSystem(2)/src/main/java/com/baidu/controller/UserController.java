package com.baidu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.dto.User;
import com.baidu.service.IUserService;
import com.baidu.util.BaiduUtil;
import com.baidu.util.CommonUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	// 登陆的验证方法
	@RequestMapping("/login")
	@ResponseBody
	public ModelAndView login(String account, String password, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		ModelAndView mav = new ModelAndView();
		try {
			User user = userService.queryDetailByAccount(account);
			if (Objects.isNull(user)) {
				throw new RuntimeException("当前账号不存在");
			} else if (Objects.equals(user.getPassword(), CommonUtil.md5(password)) == false) {
				throw new RuntimeException("密码错误");
			}
			request.getSession().setAttribute("currentUser", user);
//			mav.setViewName("layout/main");
			response.sendRedirect(request.getContextPath() + "/views/layout/main.jsp");
			return null;
		} catch (Exception e) {
			mav.addObject("msg", e.getMessage());
			mav.setViewName("user/login");
		}
		return mav;
	}

	@RequestMapping("/list")
	public ModelAndView list() {
		List<User> list = userService.showUser();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("user/list");
		return mav;
	}

	@RequestMapping("/detailed")
	public ModelAndView detailed() {
		List<User> list = userService.showUser();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("user/detailed");
		return mav;
	}

//增加的方法
	@RequestMapping("/create")
	public void create(User user, MultipartFile photo, HttpSession session,String dName) {
		System.out.println(dName+"名称\t\t\t\t\t");
	//根据部门的名称查询部门的ID
		int selectUserDepartment = userService.selectUserDepartment(dName);
		user.setDepartmentId(selectUserDepartment);
		
		System.out.println(user + "  人员的所有信息");
		String name = photo.getOriginalFilename();
		// 随机分配一个名字
		name = UUID.randomUUID().toString() + name.substring(name.lastIndexOf("."));
		System.out.println(name);
		// 存放位置
		String filePath = session.getServletContext().getRealPath("");

		// 吧图片和位置关联起来
		File file = new File(filePath, name);

		// all(file, user);
		//System.out.println(filePath +"\\"+name);
		BaiduUtil.seachPhoto(filePath +"\\"+name,user, session);
		
		// 渲染到文件夹的下面
		try {
			photo.transferTo(file);
			user.setIdCardFront(name);
			System.out.println();
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

	}
	
//查询部门的ID
	@RequestMapping("/selectDepartmentId")
	public void selectDepartmentId() {
		
	}

}
