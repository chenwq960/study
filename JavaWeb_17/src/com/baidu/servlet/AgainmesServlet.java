package com.baidu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.BaseDao.ViewServlet;

@SuppressWarnings("serial")
public class AgainmesServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("number"));
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int i = ViewServlet.againmessageUp(id, title, name);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		if(i != 0) 
			response.sendRedirect("show");
		else
			throw new RuntimeException("显示数据出现异常");
	}
}
