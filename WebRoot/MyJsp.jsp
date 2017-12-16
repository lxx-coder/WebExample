<%@ page language="java" import="java.util.*" errorPage="error.jsp" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在Form表单中使用验证码</title>
    
    <script type="text/javascript">
    //刷新验证码
     function changeImg(){
        document.getElementById("validateCodeImg").src="${basePath}/WebExample/DrawImage?"
        +Math.random();
    }
    </script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
        <form action="${bashPath}/WebExample/CheckServlet" method="post">
        验证码：<input type="text" name="validateCode"/>
            <img alt="验证码看不清，换一张" src="${basePath}/WebExample/DrawImage" id="validateCodeImg" onclick="changeImg()">
            <a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>
            <br/>
            <input type="submit" value="提交">
        </form>
<%
    int sum=0;//声明变量

    /*编写语句*/
    for (int i=1;i<=100;i++){
        sum+=i;
    }
    out.println("<h1>Sum="+sum+"</h1>");
    //这行代码肯定会出错，已运行就会抛出异常
    int x = 1/0;
%> 
  </body>
</html>
