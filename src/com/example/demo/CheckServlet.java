package com.example.demo;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 服务器接收到验证码后的处理
 * @author Administrator
 *
 */
public class CheckServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientCheckCode = request.getParameter("validateCode");//接收客户端提交上来的验证码
		String serverCheckCodeString = (String)request.getSession().getAttribute("checkcode");//从服务端的session提取出验证码
		String data;
		if(clientCheckCode.equals(serverCheckCodeString)){
			//将客户端验证码和服务端验证码比较，如果通过，则表示验证通过
			data="验证码验证通过！";
		}else{
			data = "验证码验证失败！";
		}
		OutputStream out = response.getOutputStream();
		byte[] dataBytes = data.getBytes("UTF-8");
		out.write(dataBytes);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
