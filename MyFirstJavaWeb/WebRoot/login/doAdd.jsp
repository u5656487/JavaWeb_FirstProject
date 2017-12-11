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
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	//在MySQL添加数据
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
	boolean bool = ud.addUser(user);
	if(bool){
		response.sendRedirect("index.jsp");
	}
%>