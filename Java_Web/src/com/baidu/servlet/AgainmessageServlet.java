package com.baidu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.util.ViewMessagesServlet;

@SuppressWarnings("serial")
public class AgainmessageServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("password");
		String pass = request.getParameter("password");
		int count = ViewMessagesServlet.againmessage(name, pass);
		if(count != 0) {
			response.sendRedirect("show");
			String [] cs = request.getParameterValues("cb");
			if(cs != null) {
				Cookie c1 = new Cookie("name",name);
				Cookie c2 = new Cookie("pass",pass);
				c1.setMaxAge(60*60);
				c2.setMaxAge(60*60);
				response.addCookie(c1);
				response.addCookie(c2);
			}
		}
			
		else
			throw new RuntimeException("登录错误");
	}
}
