package com.baidu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.dto.Stu;
import com.baidu.service.IServlet;
import com.baidu.service.ServletImp;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/list","/addmes","/delete","/deleteAll"})
public class Do extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = request.getServletPath();
		switch (url) {
		case "/list":
			list(request, response);
			break;
		case "/addmes":
			addmes(request, response);
			break;
		case "/delete":
			deletemessage(request, response);
			break;
		case "/deleteAll":
			deleteAll(request, response);
			break;
		default:
			break;
		}
	}
//显示列表的
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IServlet ser = new ServletImp();
		String parameter = request.getParameter("name");
		System.out.println(parameter);
		List<Stu> findAll = ser.findAll(parameter);
		request.setAttribute("name",parameter);
		request.setAttribute("list",findAll);
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);		
	}
//添加信息的
	private void addmes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IServlet ser = new ServletImp();
	//获取信息
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		int addmessage = ser.addmessage(name,username);
		response.getWriter().println(addmessage);
	}
//删除的信息
	private void deletemessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IServlet ser = new ServletImp();
	//获取信息
		String name = request.getParameter("delmes");
		Integer i = Integer.valueOf(name);
		int deleteId = ser.deleteId(i);
		response.getWriter().println(deleteId);
	}
//删除全部的信息
	private void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IServlet ser = new ServletImp();
	//获取信息
		String name = request.getParameter("id");
		name = name.substring(1);
		int deleteAllmessage = ser.deleteAllmessage(name);
		response.getWriter().print(deleteAllmessage);
	}
}
	
