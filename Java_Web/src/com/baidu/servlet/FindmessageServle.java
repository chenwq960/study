package com.baidu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.util.Student;
import com.baidu.util.ViewMessagesServlet;

@SuppressWarnings("serial")
public class FindmessageServle extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int up = Integer.valueOf(request.getParameter("priceUp"));
		int end = Integer.valueOf(request.getParameter("priceEnd"));
		ArrayList<Student> list = ViewMessagesServlet.seach(name, up, end);
		request.setAttribute("list",list);
		request.getRequestDispatcher("Access.jsp").forward(request, response);
		
		
	}
}
