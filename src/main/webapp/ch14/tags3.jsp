<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
    <title>JSTL (JSP Satandard Tag Library)</title>
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
      margin: 80px 0;
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
    .blue {
    	background-color: #4880ee;
        color: white;
    }
    .red {
    	background-color: coral;
        color: white;
    }
    
  </style>
  <body>
    <div class="content">
      <h2>JSTL (JSP Satandard Tag Library)</h2>
      <p>2. Formatting</p>
      <div class = "border"></div>
    </div>
    <c:set var="price" value="100000000"/>
    <fmt:formatNumber value="${price}" type="number" var="priceNumber"/>
    
    <div class="content desc">
      <table>
        <tr><th>표현 방법</th><th>값</th></tr>
        <tr>
        	<td>숫자</td>
        	<td><fmt:formatNumber value="${price}"/></td>
        </tr>
        <tr>
            <td>통화</td>
        	<td><fmt:formatNumber type="currency" currencySymbol="KRW " value="${price}"/></td>
      	</tr>
        <tr>
            <td>퍼센트</td>
        	<td><fmt:formatNumber type="percent" groupingUsed="false" value="${price}"/></td>
      	</tr>
      </table>
      
      <c:set var="now" value="<%= new Date() %>"/>
      <table>
        <tr><th>표현 방법</th><th>값</th></tr>
        <tr>
        	<td>Date full</td>
        	<td><fmt:formatDate value = "${now }" type="date" dateStyle="full" /></td>
        </tr>
        <tr>
        	<td>Date short</td>
        	<td><fmt:formatDate value = "${now }" type="date" dateStyle="short" /></td>
        </tr>
        <tr>
        	<td>Type time</td>
        	<td><fmt:formatDate value = "${now }" type="time" /></td>
        </tr>
        <tr>
        	<td>Type both</td>
        	<td><fmt:formatDate value = "${now }" type="both" dateStyle="full" timeStyle="full"/></td>
        </tr>
        <tr>
        	<td>Custom</td>
        	<td><fmt:formatDate value = "${now }" pattern="YYYY-MM-dd HH:mm:ss"/></td>
        </tr>
      </table>
      </div>
  </body>
</html>