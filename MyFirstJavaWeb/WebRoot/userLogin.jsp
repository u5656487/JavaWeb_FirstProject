<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
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
	  	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String message = request.getParameter("message");
		
		String uname = "";
		String upwd = "";
		Cookie[] cks = request.getCookies();
		for(Cookie c:cks){
			if("ckUserName".equals(c.getName())){
				uname = c.getValue();
			}else if("ckpwd".equals(c.getName())){
				upwd = c.getValue();
			}
		}
		 /* if(uname.length()>0){
			response.sendRedirect(basePath+"login/loginSuccess.jsp?"+
			"userName="+URLEncoder.encode(uname,"utf-8")+"&pwd="+upwd);
		}  */
  	%>
  	
    <form action="login/dologin.jsp" method="get">
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 用户登录<br>
    	用户名<input type="text" name="userName" value="<%=uname%>"/><br>
		密码&nbsp; <input type="text" name="pwd" value="<%=upwd%>"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="登录"/>
    </form>
	<%
		if(message != null){
			if("-1".equalsIgnoreCase(message)){
				out.print("登陆失败，用户名或密码输入不正确");
			}	
		}
	%>
  </body>
</html>
