<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
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
  	<%
  		String userId =request.getParameter("userId");
  	%>
    <form action="login/doAdd.jsp" method="post">
    	<input type="hidden" name="userId" value="<%=userId %>">
    	<label>用户名</label>
    	<input type="text" name="userName" ><br/>
    	<label>密&nbsp;&nbsp;码</label>
    	<input type="text" name="pwd"><br/>
    	<label>昵&nbsp;&nbsp;称</label>
    	<input type="text" name="nickName"><br/>
    	<input type="submit" value="提交"/><br/>
    </form>
  </body>
</html>
