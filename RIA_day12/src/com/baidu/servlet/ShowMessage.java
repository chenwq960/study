package com.baidu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.baidu.dao.ViewMessage;
import com.baidu.util.Student;

@WebServlet(urlPatterns = { "/list" })
public class ShowMessage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();
		switch (url) {
		case "/list":
			list(request, response);
			break;

		default:
			break;
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		
		ArrayList<Student> list = ViewMessage.showmessage();
		String jsonString = JSON.toJSONString(list);
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.getWriter().print(list);
		
		

	}
}
