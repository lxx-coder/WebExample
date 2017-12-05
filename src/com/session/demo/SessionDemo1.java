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
		
		//ʹ��request�����getSession������ȡsession�����session�����ھʹ���һ��
		HttpSession session = request.getSession();
		session.setAttribute("data", "���ط���");
		//��ȡsession��id
		String sessionID = session.getId();
		//�ж�session�ǲ����´�����
		if(session.isNew()){
			response.getWriter().print("session�����ɹ���session��ID�ǣ�"+sessionID);
		}else{
			response.getWriter().print("�������Ѿ����ڸ�session�ˣ�session��id�ǣ�"+sessionID);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
