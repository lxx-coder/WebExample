package com.example.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletContextDemo4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = "<h1><font = color = 'red'>abcdefghijkl</font></h1>";
		response.getOutputStream().write(data.getBytes());
		ServletContext  context = this.getServletContext();//��ȡServletContext����
		RequestDispatcher rd = context.getRequestDispatcher("/ServletContextDemo5");//��ȡ����ת������
		rd.forward(request, response);//����forward����ʵ������ת��
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
