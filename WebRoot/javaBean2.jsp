<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:useBean id = "person" class="com.example.demo.Person" scope="page"/>

<%--
	用所有的请求参数为bean的属性赋值
 --%>
<%--
	为一种属性设置参数
	<jsp:setProperty property="name" name="person" param="param_name">
	打开网页时在URL后面添加?param_name=绝地反击
 --%>
 <%--为所有属性设置参数 --%>
 <jsp:setProperty property="*" name="person"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'javaBean2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%--使用getXxx()方法获取对象的属性 --%>
    <h2>姓名：<%=person.getName() %></h2>
    <h2>性别：<%=person.getSex() %></h2>
    <h2>年龄：<%=person.getAge() %></h2>
    <%--z在网页URL后面添加 ?name=gca&sex=male&age=25 --%>
  </body>
</html>
