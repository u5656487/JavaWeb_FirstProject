<%@page import="com.dao.impl.UserDaoImpl2"%>
<%@page import="com.entity.SysUser"%>
<%@page import="com.dao.impl.UserDaoImpl"%>
<%@page import="com.dao.UserDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%
	String userId = request.getParameter("userId");
	String userName = request.getParameter("userName");
	String pwd = request.getParameter("pwd");
	String nickName = request.getParameter("nickName");
	
	SysUser user = new SysUser();
	user.setId(Integer.valueOf(userId));
	user.setUserName(userName);
	user.setPassword(pwd);
	user.setNickName(nickName);
	
	UserDao ud = new UserDaoImpl2();
	boolean bool = ud.updateUser(user);
	if(bool){
		response.sendRedirect("index.jsp");
	}
%>
