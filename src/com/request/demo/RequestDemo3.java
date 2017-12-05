package com.request.demo;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ͻ�������UTF-8�����ύ�����ݵģ�������Ҫ���÷�������UTF-8�ı�����н��գ���������������ݾͻ��������
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");//��ȡ��д�ı�ţ�userid���ı�������֣�<input type="text" name="userid">
		String userName = request.getParameter("username");//��ȡ��д���û���
		String userpass = request.getParameter("userpass");//��ȡ��д������
		String sex = request.getParameter("sex");
		String dept = request.getParameter("dept");
		String[] insts = request.getParameterValues("inst");
		String note = request.getParameter("note");
		String hiddenField = request.getParameter("hiddenField");
		
		String instsString = "";
		for(int i = 0; insts != null && i < insts.length;i++){
			if(i == insts.length-1){
				instsString += insts[i];
			}else{
				instsString += insts[i]+",";
			}
		}
		String htmlString = "<table>" +
									"<tr><td>��д�ı�ţ�</td><td>{0}</td></tr>"+
									"<tr><td>��д���û�����</td><td>{1}</td></tr>"+
									"<tr><td>��д�����룺</td><td>{2}</td></tr>"+
									"<tr><td>ѡ�е��Ա�</td><td>{3}</td></tr>"+
									"<tr><td>ѡ�еĲ��ţ�</td><td>{4}</td></tr>"+
									"<tr><td>ѡ�е���Ȥ��</td><td>{5}</td></tr>"+
									"<tr><td>��д��˵����</td><td>{6}</td></tr>"+
									"<tr><td>����������ݣ�</td><td>{7}</td></tr>"+
							"</table>";
		htmlString = MessageFormat.format(htmlString, userid,userName,userpass,sex,dept,instsString,note,hiddenField);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(htmlString);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
