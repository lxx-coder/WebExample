package com.session.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//使用request对象的getSession方法获取session，如果session不存在就创建一个
		HttpSession session = request.getSession();
		session.setAttribute("data", "绝地反击");
		//获取session的id
		String sessionID = session.getId();
		//判断session是不是新创建的
		if(session.isNew()){
			response.getWriter().print("session创建成功，session的ID是："+sessionID);
		}else{
			response.getWriter().print("服务器已经存在该session了，session的id是："+sessionID);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
