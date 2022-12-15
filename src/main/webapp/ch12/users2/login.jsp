<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!	
private static final String LIST = "/ch12/users2/list", LIST_VIEW = "/ch12/users2/list.jsp",
LOGIN = "/ch12/users2/login", LOGIN_VIEW = "/ch12/users2/login.html", LOGOUT = "/ch12/users2/logout",
REG = "/ch12/users2/register", REG_VIEW = "/ch12/users2/register.jsp", UPDATE = "/ch12/users2/update",
UPDATE_VIEW = "/ch12/users2/update.jsp", DEL = "/ch12/users2/delete", MSG = "/ch12/users2/msg.jsp";
%>    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>사용자 로그인</title>
  </head>
  <style>
    * {
      font-family: -apple-system, BlinkMacSystemFont, 'Apple SD Gothic Neo',
        'Pretendard Variable', Pretendard, Roboto, 'Noto Sans KR', 'Segoe UI',
        'Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji',
        'Segoe UI Symbol', sans-serif;
      color: #333;
    }
    tr,
    td,
    th {
      padding: 25px;
      border-bottom: solid 1px #eee;
      text-align: left;
    }

    tr:last-child,
    td:last-child {
      border: none;
    }

    input[type='text'],
    [type='date'],
    [type='number'],
    [type='password'] {
      background-color: #e8f0fd8c;
      font-size: 14px;
      border: none;
      padding-inline: 20px;
      padding-block: 12px;
      border-radius: 5px;
      width: 90%;
    }
    table {
      margin: 0 auto;
      border-collapse: collapse;
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
      align-items: flex-end;
    }
    input[type='submit'] {
      font-size: 15px;
      height: 49px;
      border: none;
      background-color: #4880ee;
      color: white;
      padding-inline: 32px;
      border-radius: 5px;
      width: 100%;
    }
    input[type='button'] {
      background-color: #e8f0fd;
      /* border: 1px solid #d7d7d7; */
      height: 28px;
      color: #4880ee;
      border: none;
      border-radius: 5px;
      font-weight: 600;
      padding-inline: 10px;
    }
    h1 {
      margin: 0;
    }

    body {
      margin-top: 80px;
      margin-bottom: 100px;
    }
  </style>
  <body>
    <div class="contain-01">
      <div class="contain-02">
        <div class="title">
          <h1>로그인</h1>
          <input
            type="button"
            value="Home"
            onclick="location.href ='<%= LIST %>'"
          />
        </div>

        <form action="<%= LOGIN %>" method="post">
          <table>
            <tr>
              <th>아이디</th>
              <td>
                <input
                  type="text"
                  name="uid"
                  placeholder="아이디"
                  maxlength="12"
                  required
                />
              </td>
            </tr>
            <tr>
              <th>패스워드</th>
              <td>
                <input
                  type="password"
                  name="pwd"
                  placeholder="패스워드"
                  maxlength="60"
                  required
                />
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <input type="submit" value="로그인" />
              </td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  </body>
</html>
