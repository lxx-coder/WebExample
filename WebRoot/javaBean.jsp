<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%--
在jsp中使用jsp:useBean标签来实例化一个Java类的对象
<jsp:useBean id="person" class="gacl.javabean.study.Person" scope="page"/>
    ┝<jsp:useBean>：表示在JSP中要使用JavaBean。
    ┝id:表示生成的实例化对象，凡是在标签中看见了id，则肯定表示一个实例对象。
    ┝class：此对象对应的包.类名称
    ┝scope：此javaBean的保存范围，四种范围：page、request、session、application
 --%>
 
 <jsp:useBean id="person" class="com.example.demo.Person" scope="page"/>
 <%
    //person对象在上面已经使用jsp:useBean标签实例化了，因此在这里可以直接使用person对象
    //使用setXxx方法为对象的属性赋值
    //为person对象的name属性赋值
    person.setName("绝地反击");
    //为Person对象的Sex赋值
    person.setSex("男");
    //为Person对象的Age赋值
    person.setAge(24);
    //为Person对象的married属性赋值
    person.setMarried(false);
    person.setNum(20);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'javaBean.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%--使用getXxx()方法获取对象的属性赋值 --%>
    <h2>姓名：<%=person.getName() %></h2>
    <h2>性别：<%=person.getSex() %></h2>
    <h2>年龄：<%=person.getAge() %></h2>
    <h2>婚否：<%=person.isMarried() %></h2>
    <h2>数值：<%=person.getNum() %></h2>
  </body>
</html>
