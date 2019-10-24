package com.baidu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.BaseDao.Student;
import com.baidu.BaseDao.ViewServlet;

@SuppressWarnings("serial")
public class Showmessage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Student> list = ViewServlet.showmessage();

		request.setAttribute("list", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
