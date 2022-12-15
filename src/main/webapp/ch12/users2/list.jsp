<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import = "ch12.users2.*" %>
<%@ page import = "java.util.*" %>
<%
	String ssuid = (String) session.getAttribute("uid");
	List<Users> list = (List<Users>) request.getAttribute("userList");
%>
<%!	
private static final String LIST = "/ch12/users2/list", LIST_VIEW = "/ch12/users2/list.jsp",
LOGIN = "/ch12/users2/login", LOGIN_VIEW = "/ch12/users2/login.html", LOGOUT = "/ch12/users2/logout",
REG = "/ch12/users2/register", REG_VIEW = "/ch12/users2/register.jsp", UPDATE = "/ch12/users2/update",
UPDATE_VIEW = "/ch12/users2/update.jsp", DEL = "/ch12/users2/delete", MSG = "/ch12/users2/msg.jsp";
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
          <% if(ssuid == null){ %>
            <input
              class="mainbtn"
              type="button"
              value="로그인"
              onclick="location.href ='<%= LOGIN %>'"
            />
           <% } else { %> 
            <input
              class="mainbtn"
              type="button"
              value="로그아웃"
              onclick="location.href ='<%= LOGOUT %>'"
            />
            <% } %>
            <input
              class="subbtn"
              type="button"
              value="회원가입"
              onclick="location.href ='<%= REG_VIEW %>'"
              <% if(ssuid != null) {%>
              style="display: none"
              <% } else { %><% } %>
            />
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
          <% for(Users u : list) { %>
          <tr>
            <td><%= u.getUid() %></td>
            <td><%= u.getUname() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getRegdate() %></td>
            <td>
            <%-- 수정 버튼 시작 --%>
              <button
                class="subbtn"
                type="button"
                onclick="location.href='<%= UPDATE %>?uid=<%= u.getUid() %>'"
                <% if(ssuid == null || !ssuid.equals(u.getUid())){ %>
                disabled
                <% } else {} %>
              >
                수정
              </button>
              <%-- 삭제 버튼 시작 --%>
              <button
                class="subbtn"
                type="button"
                onclick="location.href = '<%= DEL %>?uid=<%= u.getUid() %>'"
                <% if(ssuid == null || !ssuid.equals("admin")){ %>
                disabled
                <% } else {} %>
              >
                삭제
              </button>
            </td>
          </tr>
          <% } %>
        </table>
      </div>
    </div>
  </body>
</html>
