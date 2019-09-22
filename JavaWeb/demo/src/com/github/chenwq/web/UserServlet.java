package com.github.chenwq.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.chenwq.dao.UserDao;
import com.github.chenwq.po.User;

public class UserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	
	public void service(HttpServletRequest request, HttpServletResponse response){
				//获取ip
				String ip = request.getLocalAddr();
				//判断进那个方法----->控制器
				String m = request.getParameter("m");
				String str = "ip="+ip+"进入了service的"+m+"--";
				System.out.println(str);
				if (m!=null) {
					try {
						if ("toAdd".equals(m)) {//------------->到添加页面
							toAdd(request,response);
						}else if("toList".equals(m)) {
							toList(request, response);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
	
	/**
	 * 功能：到添加页面
	 * 时间：2015/07/14
	 */
	private void toAdd(HttpServletRequest request, HttpServletResponse response) 
	throws  Exception{
		request.getRequestDispatcher("WEB-INF/user2.jsp").forward(request, response);
	}
	
	private void toList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<User> list = userDao.getList();
			System.out.println(list);
			request.setAttribute("list", list);	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/list.jsp").forward(request, response);
	}
	
}
