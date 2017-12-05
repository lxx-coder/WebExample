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
		response.setCharacterEncoding("UTF-8");//���ý��ַ���UTF-8����������ͻ��������
		//ͨ��������Ӧͷ�����������UTF-8������ʾ����
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Enumeration<String> reqHeadInfos = request.getHeaderNames();//��ȡ��������ͷ
		out.write("��ȡ���Ŀͻ�����������ͷ��Ϣ���£�");
		out.write("<hr/>");
		while(reqHeadInfos.hasMoreElements()){
			String headName = (String)reqHeadInfos.nextElement();
			String headValue = request.getHeader(headName);//��������ͷ��ȡ��Ӧ��ֵ
			out.write(headName+":"+headValue);
			out.write("<br/>");			
		}
		out.write("<br/>");
		out.write("��ȡ���ͻ��˵�Accept-Encoding����ͷ��ֵ");
		out.write("<hr/>");
		String value = request.getHeader("Accept-Encoding");//��ȡAccept-Encoding����ͷ��Ӧ��ֵ
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
