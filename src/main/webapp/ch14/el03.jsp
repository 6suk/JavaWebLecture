<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
      <h2>JSP EL(Expression Language, 표현 언어)</h2>
      <p>4. POJO</p>
      <div class = "border"></div>
    </div>
    <div class="content desc">
      <table>
        <tr><th>표현식</th><th>결과</th></tr>
        <tr><td>\${m1.id}</td><td>${m1.id}</td></tr>
        <tr><td>\${m1.name}</td><td>${m1.name}</td></tr>
        <tr><td>\${m1.addr.city}</td><td>${m1.addr.city}</td></tr>
      </table>
      <table>
        <tr><th>표현식</th><th>결과</th></tr>
        <tr><td>\${m2.id}</td><td>${m2.id}</td></tr>
        <tr><td>\${m2.name}</td><td>${m2.name}</td></tr>
        <tr><td>\${m2.addr.city}</td><td>${m2.addr.city}</td></tr>
      </table>
      </div>
      <div class="content desc">
      <table>
        <tr><th>표현식</th><th>결과</th></tr>
        <tr><td>\${members[0].id}</td><td>${members[0].id}</td></tr>
        <tr><td>\${members[0].name}</td><td>${members[0].name}</td></tr>
        <tr><td>\$members[0].addr.city}</td><td>${members[0].addr.city}</td></tr>
      </table>
      <table>
        <tr><th>표현식</th><th>결과</th></tr>
        <tr><td>\${members[1].id}</td><td>${members[1].id}</td></tr>
        <tr><td>\${members[1].name}</td><td>${members[1].name}</td></tr>
        <tr><td>\$members[1].addr.city}</td><td>${members[1].addr.city}</td></tr>
      </table>
    </div>
  </body>
</html>