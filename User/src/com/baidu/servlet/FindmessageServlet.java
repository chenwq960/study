package com.baidu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.dao.ViewShowServlet;
import com.baidu.util.Student;

@SuppressWarnings("serial")
public class FindmessageServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		ArrayList<Student> list = ViewShowServlet.findmessage(id, title, name);
		request.setAttribute("list",list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
}
