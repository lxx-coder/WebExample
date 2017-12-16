<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:useBean id="calculator" class="com.example.demo.CalculatorBean"/>
<jsp:setProperty name="calculator" property="*"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>javaBean开发计算器</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <br/>
   	 计算结果是：
   	 <jsp:getProperty name="calculator" property="firstNum"/>
   	 <jsp:getProperty name="calculator" property="operator"/>
   	 <jsp:getProperty name="calculator" property="secondNum"/>
   	 	=
   	 <jsp:getProperty name="calculator" property="result"/>
   	 <br/><br/>
   	 <form action="${pageContext.request.contextPath}/calculator.jsp" method="post">
   	 	<table border="1px">
   	 		<tr><td colspan="2">简单的计算器</td></tr>
   	 		<tr>
   	 			<td>第一个参数</td>
   	 			<td><input type="text" name="firstNum"></td>
   	 		</tr>
   	 		<tr>
   	 			<td>运算符</td>
   	 			<td><select name="operator">
   	 				<option value="+">+</option>
   	 				<option value="-">-</option>
   	 				<option value="*">*</option>
   	 				<option value="/">/</option>
   	 			</select></td>
   	 		</tr>
   	 		<tr>
   	 			<td>第二个参数</td>
   	 			<td><input type="text" name="secondNum"></td>
   	 		</tr>
   	 		<tr><td colspan="2"><input type="submit" value="计算"></td></tr>
   	 	</table>
   	 </form>
   	 
  </body>
</html>
