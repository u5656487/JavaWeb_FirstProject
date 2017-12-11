<%@page import="com.dao.impl.UserDaoImpl2"%>
<%@page import="com.entity.SysUser"%>
<%@page import="com.dao.impl.UserDaoImpl"%>
<%@page import="com.dao.UserDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
        	String userId = request.getParameter("userId");
            	
            	UserDao ud = new UserDaoImpl2();
            	
            	SysUser user = ud.querySysUserById(Integer.valueOf(userId));
        %>
    
    <form action="login/doUpdate.jsp">
    	<input type="hidden" name="userId" value="<%=user.getId() %>"/>
    	<label>用户名</label>
    	<input type="text" name="userName" value="<%=user.getUserName() %>"/><br/>
    	<label>密码</label>
    	<input type="text" name="pwd" value="<%=user.getPassword() %>"/><br/>
    	<label>昵称</label>
    	<input type="text" name="nickName" value="<%=user.getNickName() %>"/><br/>
    	<input type="submit" value="保存"/><br/>
    </form>
    
  </body>
</html>
