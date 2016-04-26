<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String errorInfo = request.getParameter("errorInfo")!=null?request.getParameter("errorInfo"):"";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录失败</title>
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
    <div style="width:200px;height:35px;text-align:center;margin-left:auto; margin-right:auto;background-color:red;">
       <h3 style="text-align:center;"> *用户名或密码错误！</h3>
    <div>
  </div style="text-align:center;margin-left:100px;">
      <a  style="text-align:center;" href="/SimpleController/login.jsp">返回登录页面</a>
  <div>
   <br>
  </body>
</html>
