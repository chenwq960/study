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
public class ShowmessageServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Student> list = ViewMessagesServlet.showmessage();
		if(list != null) {
			request.setAttribute("list",list);
			//request.getRequestDispatcher("Access.jsp").forward(request, response);
			request.getRequestDispatcher("Access.jsp").forward(request, response);
		}else
			throw new RuntimeException("显示所有信息的异常");
	}
}
