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
        border-top: solid 1px #eee;
        justify-content: center;
    }
    
  </style>
  <body>
    <div class="content">
      <h2>JSP EL(Expression Language, 표현 언어)</h2>
      <p>2. 내장 객체</p>
    </div>
    <div class="content desc">
      <table>
        <tr><th>표현식</th><th>결과</th></tr>
        <tr><td>\${param.id}</td><td>${param.id}</td></tr>
        <tr><td>\${param.name}</td><td>${param.name}</td></tr>
      </table>
      <table>
        <tr><th>표현식</th><th>결과</th></tr>
        <tr><td>\${applicationScope.aName}</td><td>${applicationScope.aName}</td></tr>
        <tr><td>\${sessionScope.sName}</td><td>${sessionScope.sName}</td></tr>
        <tr><td>\${requestScope.rName}</td><td>${requestScope.rName}</td></tr>
        <tr><td>\${pageScope.pName}</td><td>${pageScope.pName}</td></tr>
      </table>
      <table>
      	<tr><th>표현식</th><th>결과</th></tr>
        <tr><td>\${aName}</td><td>${aName}</td></tr>
        <tr><td>\${sName}</td><td>${sName}</td></tr>
        <tr><td>\${rName}</td><td>${rName}</td></tr>
        <tr><td>\${pName}</td><td>${pName}</td></tr>
        <tr><td>\${name}</td><td>${name}</td></tr> <%-- 페이지의 우선순위가 높다 --%>
       </table>
    </div>
    <div class="content desc">
      <table>
        <tr><th>표현식</th><th>결과</th></tr>
        <tr><td>\${header.host}</td><td>${header.host}</td></tr>
        <tr><td>\${header["user-Agent"]}</td><td>${header["user-Agent"]}</td></tr>
        <tr><td>\${header.cookie}</td><td>${header.cookie}</td></tr>
      </table>
      <table>
        <tr><th>표현식</th><th>결과</th></tr>
        <tr><td>\${cookie.JSESSIONID.name}</td><td>${cookie.JSESSIONID.name}</td></tr>
        <tr><td>\${cookie.JSESSIONID.value}</td><td>${cookie.JSESSIONID.value}</td></tr>
      </table>
     </div>
  </body>
</html>