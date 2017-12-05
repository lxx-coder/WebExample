package com.request.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置将字符以UTF-8编码输出到客户端浏览器
		//通过设置响应头控制浏览器以UTF-8编码显示数据
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Enumeration<String> reqHeadInfos = request.getHeaderNames();//获取所有请求头
		out.write("获取到的客户端所有请求头信息如下：");
		out.write("<hr/>");
		while(reqHeadInfos.hasMoreElements()){
			String headName = (String)reqHeadInfos.nextElement();
			String headValue = request.getHeader(headName);//根据请求头获取对应的值
			out.write(headName+":"+headValue);
			out.write("<br/>");			
		}
		out.write("<br/>");
		out.write("获取到客户端的Accept-Encoding请求头的值");
		out.write("<hr/>");
		String value = request.getHeader("Accept-Encoding");//获取Accept-Encoding请求头对应的值
		out.write(value);
		
		Enumeration<String> e = request.getHeaders("Accept-Encoding");
		while(e.hasMoreElements()){
			String string = (String)e.nextElement();
			System.out.println(string);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
