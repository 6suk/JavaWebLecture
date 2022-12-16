<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	pageContext.setAttribute("pid", "페이지 아이디");
%>
<c:set var ="cid" value="코어 아이디"></c:set>


<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
    <title>JSTL (JSP Satandard Tag Library)</title>
  </head>
  <style>
    * {
      font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo',
        'Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI',
        'Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji',
        'Segoe UI Symbol', sans-serif;
      color: #333;
      text-align: center;
    }
    h2{
      margin-bottom : 0;
    }
    body {
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      margin-top: 80px;
    }
    tr,
    td,
    th {
      padding: 20px;
      border: solid 1px #eee;
      text-align: center;
    }

    th {
      background-color: #e8f0fd56;
    }

    table {
      margin: 10px;
      border-collapse: collapse;
    }

    .content {
      margin-bottom: 10px;
    }
    
    .desc{
    	display: flex;
    	flex-direction: row;
    	align-items: flex-start;
    	padding: 25px 0;
        justify-content: center;
        /* border-top: solid 1px #eee; */
    }
    
    .border {
	    border-bottom: solid 1px #eee;
	    width: 800px;
	    margin-top: 40px;
    }
    
  </style>
  <body>
    <div class="content">
      <h2>JSTL (JSP Satandard Tag Library)</h2>
      <p>1. Core</p>
      <div class = "border"></div>
    </div>
    <div class="content desc">
      <table>
        <tr><th>표현식</th><th>결과</th></tr>
        <tr><td>\${pid}</td><td>${pid}</td></tr>
        <tr><td>\${cid}</td><td>${cid}</td></tr>
        <c:set var ="cid2" value="코어 아이디2" />
        <tr><td>\${cid2}</td><td>${cid2}</td></tr>
      </table>
      </div>
  </body>
</html>