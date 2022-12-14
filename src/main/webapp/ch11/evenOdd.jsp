<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int num = (int) Math.floor(Math.random() * 11);
	String result = null;
	if(num % 2 == 0) result = "짝수";
	else result = "홀수";
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홀수 짝수</title>
</head>
<body>
	<h1>홀수 짝수</h1>
	<hr>
	<h3> 난수를 통해서 얻은 숫자 : <% out.print(num); %> </h3>
		<h3><%= result %>입니다.</h3>
	<hr>
	<% for(int i=0; i<num; i++){ %>
		<p>안녕하세요</p>
	<% } %>

</body>
</html>