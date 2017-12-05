package com.session.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Book book = DB.getAll().get(id);  //�õ��û��������
        HttpSession session = request.getSession();
        List<Book> list = (List)session.getAttribute("list");  //�õ��û����ڱ��������������
        if(list==null){
            list = new ArrayList<Book>();
            session.setAttribute("list", list);
        }
        list.add(book);
        //response. encodeRedirectURL(java.lang.String url)���ڶ�sendRedirect�������url��ַ������д
        String url = response.encodeRedirectURL(request.getContextPath()+"/ListCartServlet");
        System.out.println(url);
        response.sendRedirect(url);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
