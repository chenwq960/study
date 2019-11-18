package com.baidu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.baidu.entil.City;
import com.baidu.util.BaseDao;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/list" })
public class ViewMessage extends HttpServlet {
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

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ArrayList<City> find = BaseDao.find(id);
		String jsonString = JSON.toJSONString(find);
		response.getWriter().print(jsonString);
		
	}

}
