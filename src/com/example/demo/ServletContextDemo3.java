package com.example.demo;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo3 extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		ServletContext context = this.getServletContext();
		//获取整个Web站点的初始化参数
		String contextInitParam = context.getInitParameter("url");
		response.getWriter().print(contextInitParam);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		doGet(request, response);
	}

}
