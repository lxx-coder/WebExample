package com.example.demo;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public class ServletContextDemo1 extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String data = "lxx_demo";
		/**
		 * ServletConfig������ά����ServletContext��������ã�������Ա�ڱ�дservletʱ��
		 * ����ͨ��ServletConfig.getServletContext�������ServletContext����
		 */
		ServletContext context = this.getServletConfig().getServletContext();//���ServletContext����
		context.setAttribute("data", data);//��data�洢��ServletContext������
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		ServletContext context = this.getServletConfig().getServletContext();//���ServletContext����
		System.out.println(context.getAttribute("data"));
		doGet(request, response);
	}
}
