package com.example.demo;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String data = "abcdefghijklmn";
		/**
		 * �������ݺ���Ļ���ʱ��ֵ���Ա��������Ƶ���������������������������������
		 * �������õ����ݻ���ʱ��Ϊ1��
		 */
		resp.setDateHeader("expires", System.currentTimeMillis()+24*3600*1000);
		resp.getOutputStream().write(data.getBytes());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
