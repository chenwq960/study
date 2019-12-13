package com.baidu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.dto.Stu;
import com.baidu.serviet.IServiet;
import com.baidu.serviet.ServietImp;


@WebServlet(urlPatterns = {"/list"})
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

		default:
			break;
		}
	}
//显示的方法
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IServiet servlet = new ServietImp();
		List<Stu> find = servlet.find();
		find.forEach(System.out::println);
		request.setAttribute("list",find);
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
	}
}
