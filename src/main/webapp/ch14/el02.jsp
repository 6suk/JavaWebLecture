<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("pName", "pageContext");
	pageContext.setAttribute("name", "pageContext");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>JSP EL(Expression Language, 표현 언어)</title>
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
      min-height: 100vh;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      margin: 40px 0;
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
        border-top: solid 1px #eee;
    }
    
  </style>
  <body>
    <div class="content">
      <h2>JSP EL(Expression Language, 표현 언어)</h2>
      <p>3. 컬렉션</p>
    </div>
    <div class="content desc">
      <table>
        <tr><th>표현식</th><th>결과</th></tr>
        <tr><td>\${fruits[0]}</td><td>${fruits[0]}</td></tr>
        <tr><td>\${fruits[1]}</td><td>${fruits[1]}</td></tr>
        <tr><th>표현식</th><th>결과</th></tr>
        <tr><td>\${list[0]}</td><td>${list[0]}</td></tr>
        <tr><td>\${list[1]}</td><td>${list[1]}</td></tr>
      </table>
    </div>
  </body>
</html>