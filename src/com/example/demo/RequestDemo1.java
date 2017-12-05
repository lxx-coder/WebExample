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
		String requestUrl = request.getRequestURL().toString();//�õ������URL��ַ
		String requestUri = request.getRequestURI().toString();//�õ��������Դ
		String queryString = request.getQueryString();//�õ������URL��ַ�и����Ĳ���
		String remoteAddr = request.getRemoteAddr();//�õ������ߵ�IP��ַ
		String remoteHost = request.getRemoteHost();
		int remotePort = request.getRemotePort();
		String remoteUser = request.getRemoteUser();
		String method = request.getMethod();//�õ�����URL��ַ��ʹ�õķ���
		String pathInfo = request.getPathInfo();
		String localAddr = request.getLocalAddr();//��ȡWEB��������IP��ַ
		String localName = request.getLocalName();//��ȡWEB��������������
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("��ȡ���Ŀͻ�����Ϣ����"+"<hr/>");
		out.write("�����URL��ַ��"+requestUrl+"<br/>");
		out.write("�������Դ��"+requestUri+"<br/>");
		out.write("�����URL��ַ�и����Ĳ�����"+queryString+"<br/>");
		out.write("�����ߵ�IP��ַ��"+remoteAddr+"<br/>");
		out.write("�����ߵ���������"+remoteHost+"<br/>");
		out.write("ʹ�õĶ˿ںţ�"+remotePort+"<br/>");
		out.write("remoteUser��"+remoteUser+"<br/>");
		out.write("����ʹ�õķ�����"+method+"<br/>");
		out.write("pathInfo��"+pathInfo+"<br/>");
		out.write("localAddr��"+localAddr+"<br/>");
		out.write("localName��"+localName+"<br/>");		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
