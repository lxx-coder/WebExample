package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestUrl = request.getRequestURL().toString();//得到请求的URL地址
		String requestUri = request.getRequestURI().toString();//得到请求的资源
		String queryString = request.getQueryString();//得到请求的URL地址中附带的参数
		String remoteAddr = request.getRemoteAddr();//得到来访者的IP地址
		String remoteHost = request.getRemoteHost();
		int remotePort = request.getRemotePort();
		String remoteUser = request.getRemoteUser();
		String method = request.getMethod();//得到请求URL地址是使用的方法
		String pathInfo = request.getPathInfo();
		String localAddr = request.getLocalAddr();//获取WEB服务器的IP地址
		String localName = request.getLocalName();//获取WEB服务器的主机名
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("获取到的客户机信息如下"+"<hr/>");
		out.write("请求的URL地址："+requestUrl+"<br/>");
		out.write("请求的资源："+requestUri+"<br/>");
		out.write("请求的URL地址中附带的参数："+queryString+"<br/>");
		out.write("来访者的IP地址："+remoteAddr+"<br/>");
		out.write("来访者的主机名："+remoteHost+"<br/>");
		out.write("使用的端口号："+remotePort+"<br/>");
		out.write("remoteUser："+remoteUser+"<br/>");
		out.write("请求使用的方法："+method+"<br/>");
		out.write("pathInfo："+pathInfo+"<br/>");
		out.write("localAddr："+localAddr+"<br/>");
		out.write("localName："+localName+"<br/>");		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
