<%@page import="com.dao.impl.UserDaoImpl2"%>
<%@page import="com.dao.impl.UserDaoImpl"%>
<%@page import="com.dao.UserDao"%>
<%@page import="com.entity.SysUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	//在MySQL添加数据
	String userId = request.getParameter("userId");


	
	UserDao ud = new UserDaoImpl2();
	boolean bool = ud.deleteUser(Integer.valueOf(userId));
	if(bool){
		response.sendRedirect("index.jsp");
	}
%>