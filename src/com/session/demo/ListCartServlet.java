package com.session.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListCartServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
		List<Book> list = (List<Book>)session.getAttribute("list");
        if(list==null || list.size()==0){
            out.write("�Բ�������û�й����κ���Ʒ!!");
            return;
        }
        
        //��ʾ�û��������Ʒ
        out.write("�����������Ʒ:<br>");
        for(Book book : list){
        	if(book != null)
        		out.write(book.getName() + "<br/>");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
