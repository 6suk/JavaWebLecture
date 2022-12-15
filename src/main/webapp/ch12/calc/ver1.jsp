<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int result = (int)request.getAttribute("result");
%>    

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>계산기 ver1</title>
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
    input {
      width: 50px;
      font-size: 16px;
      height: 28px;
      border: none;
      background-color: rgba(250, 235, 215, 0.596);
    }
    input[type='submit'] {
      background-color: coral;
      cursor: pointer;
      color: white;
      height: 29px;
    }
    select {
      font-size: 16px;
      width: 50px;
      height: 28px;
      border: none;
      background-color: rgba(250, 235, 215, 0.596);
    }
    span {
      width: 50px;
      height: 28px;
      line-height: 28px;
      font-size: 18px;
      font-weight: 600;
    }
  </style>
  <body style="margin-top: 100px">
    <h1>계산기 Ver1</h1>
    <form action="/ch12/calc/ver1" method="post">
      <input type="number" name="num1" size="1" />
      <select name="op">
        <option value="+" selected>+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
      </select>
      <input type="number" name="num2" />
      <input type="submit" value=" = " />
      <span><%= result %></span>
    </form>
  </body>
</html>
