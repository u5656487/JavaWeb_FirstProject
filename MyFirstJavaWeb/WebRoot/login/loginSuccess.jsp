<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginSuccess.jsp' starting page</title>
    
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
    	
    	String s1 = request.getParameter("userName");
    	String s2 = request.getParameter("pwd");
    	
    %>
    <%
    	Object fwrs = application.getAttribute("fwrs");
    	if("系统管理员".equals(s1) && "123".equals(s2)){
    		session.setAttribute("ssName", s1);
    		session.setAttribute("ssPwd", s2);
    		if(fwrs == null){
    			application.setAttribute("fwrs", 1);
    		}else{
    			int rs = (int) fwrs;
        		application.setAttribute("fwrs", ++rs);
    		}
    		response.sendRedirect(basePath+"index.jsp");
    		
    	}else{
    		response.sendRedirect(basePath+"login/userLogin.jsp?message=-1");
    	}
    %>
    
  </body>
</html>
