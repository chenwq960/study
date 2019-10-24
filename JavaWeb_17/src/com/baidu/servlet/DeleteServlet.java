package com.baidu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.BaseDao.ViewServlet;

@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		int count = ViewServlet.delete(id);
		if(count != 0) 
			response.sendRedirect("show");
		else 
			throw new RuntimeException("没有找到合数的删除数据内容");
	}
}
