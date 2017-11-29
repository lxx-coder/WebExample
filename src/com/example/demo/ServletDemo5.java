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
		 * 设置数据合理的缓存时间值，以避免浏览器频繁向服务器发送请求，提升服务器的性能
		 * 这里设置的数据缓存时间为1天
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
