package com.example.demo;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���������յ���֤���Ĵ���
 * @author Administrator
 *
 */
public class CheckServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientCheckCode = request.getParameter("validateCode");//���տͻ����ύ��������֤��
		String serverCheckCodeString = (String)request.getSession().getAttribute("checkcode");//�ӷ���˵�session��ȡ����֤��
		String data;
		if(clientCheckCode.equals(serverCheckCodeString)){
			//���ͻ�����֤��ͷ������֤��Ƚϣ����ͨ�������ʾ��֤ͨ��
			data="��֤����֤ͨ����";
		}else{
			data = "��֤����֤ʧ�ܣ�";
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
