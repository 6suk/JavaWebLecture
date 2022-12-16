<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!	
private static final String LIST = "/ch14/users3/list", LIST_VIEW = "/ch14/users3/list.jsp",
LOGIN = "/ch14/users3/login", LOGIN_VIEW = "/ch14/users3/login.jsp", LOGOUT = "/ch14/users3/logout",
REG = "/ch14/users3/register", REG_VIEW = "/ch14/users3/register.jsp", UPDATE = "/ch14/users3/update",
UPDATE_VIEW = "/ch14/users3/update.jsp", DEL = "/ch14/users3/delete", MSG = "/ch14/users3/msg.jsp";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
    <script>
    	let msg = '${msg}';
    	let url = '${url}';
    	alert(msg);
    	location.href = url;
    </script>
</head>
<body>
</body>
</html>