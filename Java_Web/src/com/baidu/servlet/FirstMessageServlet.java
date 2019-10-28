package com.baidu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.util.ViewMessagesServlet;

@SuppressWarnings("serial")
public class FirstMessageServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("password");
		String pass = request.getParameter("password");
		int count = ViewMessagesServlet.firstmessage(name, pass);
		if(count != 0)
			response.sendRedirect("seconund.jsp");
		else
			throw new RuntimeException("注册委书记异常");
	}
}
