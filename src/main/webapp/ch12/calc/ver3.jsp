<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>계산기 Ver2</title>
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
    button {
      border: none;
      width: 100%;
      height: 100%;
      font-size: 18px;
      font-weight: 600;
      border-radius: 15px;
      /* box-shadow: 2px 4px 12px rgb(0 0 0 / 8%); */
      transition: all 0.2s cubic-bezier(0, 0, 0.5, 1);
    }

    #num {
      background-color: #e8f0fd;
      color: #4880ee;
    }
    #num:hover {
      transform: scale3d(1.05, 1.05, 1.05);
    }
    #op {
      background-color: #e8f0fd;
      color: #4880ee;
    }
    #op:hover {
      transform: scale3d(1.05, 1.05, 1.05);
    }
    #result {
      color: #4880ee;
      border: 2px solid #487fee2c;
      background-color: #e8f0fd65;
      font-size: 26px;
      font-weight: 600;
      text-align: left;
      height: 100px;
      padding-left: 20px;
    }
    #re {
      background-color: #4880ee;
      color: white;
    }
    #re:hover {
      color: white;
      transform: scale3d(1.05, 1.05, 1.05);
    }

    td {
      width: 70px;
      height: 90px;
      border-radius: 10px;
    }
    tr,
    td,
    th {
      padding: 2px;
    }
    .content {
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
    }
  </style>
  <body>
    <div class="content">
    <form action="/ch12/calc/ver3" method="post">
      <table>
        <tr>
          <td colspan="4" id="result"><%= request.getAttribute("eval") %></td>
        </tr>
        <tr>
          <td><button type="submit" name="op" id="op" value="C">BC</button></td>
          <td><button type="submit" name="op" id="op" value="/">÷</button></td>
          <td><button type="submit" name="op" id="op" value="*">×</button></td>
          <td><button type="submit" name="op" id="op" value="-">－</button></td>
        </tr>
        <tr>
          <td>
            <button type="submit" name="num" id="num" value="7">7</button>
          </td>
          <td>
            <button type="submit" name="num" id="num" value="8">8</button>
          </td>
          <td>
            <button type="submit" name="num" id="num" value="9">9</button>
          </td>
          <td rowspan="2">
            <button type="submit" name="op" id="op" value="+">＋</button>
          </td>
        </tr>
        <tr>
          <td>
            <button type="submit" name="num" id="num" value="4">4</button>
          </td>
          <td>
            <button type="submit" name="num" id="num" value="5">5</button>
          </td>
          <td>
            <button type="submit" name="num" id="num" value="6">6</button>
          </td>
        </tr>
        <tr>
          <td>
            <button type="submit" name="num" id="num" value="3">3</button>
          </td>
          <td>
            <button type="submit" name="num" id="num" value="2">2</button>
          </td>
          <td>
            <button type="submit" name="num" id="num" value="1">1</button>
          </td>
          <td rowspan="2">
            <button type="submit" name="op" id="re" value="=">=</button>
          </td>
        </tr>
      </table>
      </form>
    </div>
  </body>
</html>

