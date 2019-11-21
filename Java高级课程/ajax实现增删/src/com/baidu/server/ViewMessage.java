package com.baidu.server;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.dao.BaseDao;
import com.baidu.servier.MethodIMP;
import com.baidu.util.Student;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/list","/add","/del"})
public class ViewMessage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("1111");
		String url = request.getServletPath();
		switch (url) {
		case "/list":
			list(request, response);
			break;
		case "/add":
			add(request, response);
			break;
		case "/del":
			del(request, response);
			break;

		default:
			list(request, response);
			break;
		}
	}
//负责显示所有的
	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MethodIMP method = new MethodIMP();
		ArrayList<Student> findAll = method.findAll();
		//findAll.forEach(System.out::println);
		request.setAttribute("list", findAll);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
//负责添加的
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String[] val = request.getParameterValues("val");
		String birth = request.getParameter("birth");
		String department = request.getParameter("department");
		String result = "";
		if(val != null) {
			for (String string : val) {
				result += ","+string;
			}
			result = result.substring(1);
			
		}
		//Student student = new Student(0, name, sex, result.substring(1), birth, department);
		String sql = "insert into doctor values(null,?,?,?,?,?)";
		int find = BaseDao.find(sql,name,sex,result,birth,department);
		response.getWriter().println(find);
	}
//负责删除所有的
		protected void del(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String id = request.getParameter("id");
			//System.out.println("啥才能胡的四大皆空进口量发生的离开"+id);
			id = id.substring(1);
			String sql = "delete from doctor where id in("+id+")";
		//	System.out.println(sql);
			int find = BaseDao.find(sql);
			response.getWriter().println(find);
		}
}
