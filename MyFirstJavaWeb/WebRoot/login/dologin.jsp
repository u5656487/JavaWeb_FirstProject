<%@page import="com.dao.impl.UserDaoImpl2"%>
<%@page import="com.dao.impl.UserDaoImpl"%>
<%@page import="com.dao.impl.UserDaoImpl"%>
<%@page import="com.dao.UserDao"%>
<%@page import="com.entity.SysUser"%>
<%@page import="com.user.UserLogin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	//创建访问人数在application中
	Object fwrs = application.getAttribute("fwrs");
	//获取用户输入的用户名和密码
	String userName = request.getParameter("userName");
	String pwd = request.getParameter("pwd");
	
	//调用登录逻辑
	UserDao ud = new UserDaoImpl2();
	SysUser user = ud.login(userName, pwd);
	
	if(user != null){
		session.setAttribute("loginUser", user);
		if(fwrs == null){
	application.setAttribute("fwrs", 1);
		}else{
	int rs = (int) fwrs;
    		application.setAttribute("fwrs", ++rs);
		}
		response.sendRedirect("index.jsp");
	}else{
		response.sendRedirect(basePath+"userLogin.jsp?message=-1");
	}
%>