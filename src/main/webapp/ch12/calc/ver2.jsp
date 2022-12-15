<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name,id="viewport" content="width=device-width, initial-scale=1.0" />
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
      transition: all 0.3s cubic-bezier(0, 0, 0.5, 1);
    }

    #num {
      background-color: rgba(250, 235, 215, 0.521);
    }
    #num:hover {
      transform: scale3d(1.02, 1.02, 1.02);
    }
    #op {
      background-color: antiquewhite;
    }
    #op:hover {
      transform: scale3d(1.02, 1.02, 1.02);
    }
    #result {
      background-color: rgba(255, 255, 255, 0.521);
      font-size: 26px;
      font-weight: 600;
      text-align: left;
      border: 2px solid antiquewhite;
      height: 80px;
      padding-left: 20px;
    }
    #re {
      background-color: coral;
      color: white;
    }
    #re:hover {
      color: white;
      transform: scale3d(1.02, 1.02, 1.02);
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
    <form action="/ch12/calc/ver2" method="post">
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

