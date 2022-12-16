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
    }
    
  </style>
  <body>
    <div class="content">
      <h2>JSP EL(Expression Language, 표현 언어)</h2>
      <p>1. 연산자</p>
    </div>
    <div class="content desc">
      <table>
        <tr><th>계산식</th><th>결과</th></tr>
        <tr><td>\${100}</td><td>${100}</td></tr>
        <tr><td>\${"안녕하세요"}</td><td>${"안녕하세요"}</td></tr>
        <tr><td>\${10 + 1}</td><td>${10 + 1}</td></tr>
        <tr><td>\${"10" + 1}</td><td>${"10" + 1}</td></tr>
        <tr><td>\${null + 100}</td><td>${null + 100}</td></tr>
        <%-- <td>\${"안녕" + 11}</td><td>${"안녕" + 11}</td>
        <td>\${"Hello" + "Hello"}</td><td>${"Hello" + "Hello"}</td> --%>
      </table>
      <table>
        <tr><th>계산식</th><th>결과</th>
        <tr><td>\${10 + 10}</td><td>${10 + 10}</td></tr>
        <tr><td>\${3 div 2}</td><td>${3 div 2}</td></tr>
        <tr><td>\${100 % 9}</td><td>${100 % 9}</td></tr>
        <tr><td>\${100 mod 9}</td><td>${100 mod 9}</td></tr>
      </table>
      <table>
        <tr><th>계산식</th><th>결과</th>
        <tr><td>\${10 == 10}</td><td>${10 == 10}</td></tr>
        <tr><td>\${10 eq 10}</td><td>${10 eq 10}</td></tr>
        <tr><td>\${10 > 8}</td><td>${10 > 8}</td></tr>
        <tr><td>\${10 gt 10}</td><td>${10 gt 10}</td></tr>
        <tr><td>\${"hello" == "hello"}</td><td>${"hello" == "hello"}</td></tr>
        <tr><td>\${"hello" eq "hello"}</td><td>${"hello" eq "hello"}</td></tr>
      </table>
    </div>
    <div class="content desc">
      <table>
        <tr><th>계산식</th><th>결과</th></tr>
        <tr><td>\${10 == 10 && 20 == 20}</td><td>${10 == 10 && 20 == 20}</td></tr>
        <tr><td>\${10 == 11 and 20 == 20}</td><td>${10 == 11 and 20 == 20}</td></tr>
        <tr><td>\${10 == 9 or 20 == 10}</td><td>${10 == 9 or 20 == 10}</td></tr>
        <tr><td>\${not(10==10)}</td><td>${not(10==10)}</td></tr>
      </table>
      <table>
        <tr><th>계산식</th><th>결과</th></tr>
        <tr><td>\${empty "hello"}</td><td>${empty "hello"}</td></tr>
        <tr><td>\${empty ""}</td><td>${empty ""}</td></tr>
        <tr><td>\${empty null}</td><td>${empty null}</td></tr>
      </table>
      <table>
        <tr><th>계산식</th><th>결과</th></tr>
        <tr><td>\${empty param.num?<br>"X" : param.num}</td><td>${empty param.num? "X" : param.num}</td></tr>
      </table>
     </div>
  </body>
</html>