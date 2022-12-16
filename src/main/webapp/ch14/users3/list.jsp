<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import = "java.util.*"%>
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
    <meta charset="UTF-8" />
    <title>사용자 목록</title>
    <style>
      * {
        font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo',
          'Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI',
          'Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji',
          'Segoe UI Symbol', sans-serif;
        color: #333;
      }
      h1 {
        margin: 0;
      }
      .contain-01 {
        display: flex;
        justify-content: center;
      }
      .contain-02 {
        display: inline-block;
      }
      .title {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 20px;
        border-bottom: solid 1px #eee;
      }

      body {
        margin-top: 80px;
        margin-bottom: 100px;
      }
      tr,
      td,
      th {
        padding: 25px;
        border-bottom: solid 1px #eee;
        text-align: center;
      }
      table {
        margin: 0 auto;
        border-collapse: collapse;
      }
      button:disabled {
        background-color: #e9e9e9;
        color: #999;
        cursor: default;
      }
      input[type='text'] {
        font-size: 14px;
        border: none;
        background-color: rgba(250, 235, 215, 0.493);
        height: 30px;
        padding-inline: 15px;
      }
      button {
        height: 28px;
        font-weight: 600;
        padding-inline: 10px;
        margin: 2px;
      }
      input[type='button'] {
        font-size: 15px;
        height: 41px;
        padding-inline: 28px;
      }
      .mainbtn {
        background-color: #4880ee;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }
      .subbtn {
        background-color: #e8f0fd;
        color: #4880ee;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }
    </style>
  </head>
  <body>
    <div class="contain-01">
      <div class="contain-02">
        <div class="title">
          <h1>사용자 목록</h1>
          <div>
          
          <c:choose>
          	<c:when test="${empty uid}">
          	<input
              class="mainbtn"
              type="button"
              value="로그인"
              onclick="location.href ='<%= LOGIN %>'"
            />
            <input
              class="subbtn"
              type="button"
              value="회원가입"
              onclick="location.href ='<%= REG_VIEW %>'"
            />            
          	</c:when>
          	
          	<c:otherwise>
            <input
              class="mainbtn"
              type="button"
              value="로그아웃"
              onclick="location.href ='<%= LOGOUT %>'"
            />
            <input
              class="subbtn"
              type="button"
              value="회원가입"
              onclick="location.href ='<%= REG_VIEW %>'"
              style="display: none"
            />                      	
          	</c:otherwise>
          </c:choose>

          </div>
        </div>

        <table>
          <tr style="background-color: #e8f0fd42">
            <th>아이디</th>
            <th>이름</th>
            <th>email</th>
            <th>가입일</th>
            <th>수정 / 삭제</th>
          </tr>
          <c:forEach var="u" items="${userList}">
          <tr>
            <td>${u.uid}</td>
            <td>${u.uname}</td>
            <td>${u.email}</td>
            <td>${u.regdate}</td>
            <td>
            <%-- 수정 버튼 시작 --%>
			<c:choose>
			<c:when test="${empty uid or not(uid eq u.uid)}">
              <button class="subbtn" type="button" disabled >수정</button>				
			</c:when>
			<c:otherwise>
              <button class="subbtn" type="button"
              	onclick="location.href='<%= UPDATE %>?uid=${u.uid}'">수정</button>				
			</c:otherwise>
			</c:choose>
			
			<%-- 삭제 버튼 시작 --%>
			<c:choose>
			<c:when test="${empty uid or not(uid eq 'admin')}">
              <button class="subbtn" type="button" disabled >삭제</button>				
			</c:when>
			<c:otherwise>
              <button class="subbtn" type="button"
              	onclick="location.href='<%= DEL %>?uid=${u.uid}'">삭제</button>				
			</c:otherwise>
			</c:choose>  
            </td>
          </tr>          
          </c:forEach>
        </table>
      </div>
    </div>
  </body>
</html>
