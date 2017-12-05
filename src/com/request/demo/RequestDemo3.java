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
		//客户端是以UTF-8编码提交表单数据的，所以需要设置服务器以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");//获取填写的编号，userid是文本框的名字，<input type="text" name="userid">
		String userName = request.getParameter("username");//获取填写的用户名
		String userpass = request.getParameter("userpass");//获取填写的密码
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
									"<tr><td>填写的编号：</td><td>{0}</td></tr>"+
									"<tr><td>填写的用户名：</td><td>{1}</td></tr>"+
									"<tr><td>填写的密码：</td><td>{2}</td></tr>"+
									"<tr><td>选中的性别：</td><td>{3}</td></tr>"+
									"<tr><td>选中的部门：</td><td>{4}</td></tr>"+
									"<tr><td>选中的兴趣：</td><td>{5}</td></tr>"+
									"<tr><td>填写的说明：</td><td>{6}</td></tr>"+
									"<tr><td>隐藏域的内容：</td><td>{7}</td></tr>"+
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
