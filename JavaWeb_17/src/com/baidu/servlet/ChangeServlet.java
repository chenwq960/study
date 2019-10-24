package com.baidu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.BaseDao.Student;
import com.baidu.BaseDao.ViewServlet;

@SuppressWarnings("serial")
public class ChangeServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		Student s = ViewServlet.change(id);
		request.setAttribute("stu",s);
		request.getRequestDispatcher("change.jsp").forward(request,response);
	}
}
