<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!	
private static final String LIST = "/ch12/users2/list", LIST_VIEW = "/ch12/users2/list.jsp",
LOGIN = "/ch12/users2/login", LOGIN_VIEW = "/ch12/users2/login.html", LOGOUT = "/ch12/users2/logout",
REG = "/ch12/users2/register", REG_VIEW = "/ch12/users2/register.jsp", UPDATE = "/ch12/users2/update",
UPDATE_VIEW = "/ch12/users2/update.jsp", DEL = "/ch12/users2/delete", MSG = "/ch12/users2/msg.jsp";
%>
<%
	String msg = (String) request.getAttribute("msg");
	String url = (String) request.getAttribute("url");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
    <script>
    	let msg = '<%= msg %>';
    	let url = '<%= url %>';
    	alert(msg);
    	location.href = url;
    </script>
</head>
<body>
</body>
</html>