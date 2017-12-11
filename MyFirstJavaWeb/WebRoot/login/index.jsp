<%@page import="com.dao.impl.UserDaoImpl2"%>
<%@page import="com.dao.impl.UserDaoImpl"%>
<%@page import="com.dao.impl.UserDaoImpl"%>
<%@page import="com.dao.UserDao"%>
<%@page import="com.user.UserLogin"%>
<%@page import="com.entity.SysUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  		Object obj = session.getAttribute("loginUser");
  	  		SysUser user = (SysUser)obj;
  	  		
  	  		UserDao ud = new UserDaoImpl2();
  			List<SysUser> uls = ud.queryUsers();
  	%>
	欢迎你<%out.print(user.getNickName()); %>
	
	<table border="1" width="350px">
			<tr>
				<td>编号&nbsp;</td>
				<td>用户名&nbsp;</td>
				<td>密码&nbsp;</td>
				<td>昵称&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作</td>
			</tr>
			<%
				for(SysUser u:uls){
			%>		
				<tr>
					<td><%=u.getId() %></td>
					<td>&nbsp;<%=u.getUserName() %></td>
					<td><%=u.getPassword() %></td>
					<td><%=u.getNickName() %></td>
					<td>
						<a href="login/update.jsp?userId=<%=u.getId() %>">修改</a>
						<a href="login/add.jsp?userId=<%=uls.size()+1%>">添加</a>
						<a href="login/doDelete.jsp?userId=<%=u.getId()%>">删除</a>
					</td>
				</tr>
			<%
				}
			%>
		</table>
	<h4>当前访问人数：<%=application.getAttribute("fwrs") %></h4>
    <a href="login/tiao.jsp">注销</a>
    
  </body>
</html>
