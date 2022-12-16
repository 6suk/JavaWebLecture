<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	pageContext.setAttribute("pid", "페이지 아이디");
%>
<c:set var ="cid" value="코어 아이디"></c:set>


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
      <p>1. Core - forEach, If</p>
      <div class = "border"></div>
    </div>
    <div class="content desc">
    	
      <table>
        <tr><th>ID</th><th>이름</th><th>주소</th></tr>
    <c:forEach var = "member" items= "${members}">
        <tr>
        <td>${member.id}</td>
        <td>${member.name}</td>
        <td>${member.addr}</td>
        </tr>
     </c:forEach>
      </table>
      </div>
      
      
      <div class="content">
      <table>
        <tr><th>No</th><th>ID</th><th>이름</th><th>주소</th></tr>
    <c:forEach var = "member" items= "${members}" varStatus="loop">
        <tr>
        <td>${loop.index} / ${loop.count}</td>
        
        <!-- 아이디 첫번째 값일 때 -->
        <c:if test="${loop.first}">
        	<td class = "blue">
        		${member.id}
        	</td>
        </c:if>
        <!-- else -->
        <c:if test="${not loop.first}">
	        <td>
	        	${member.id}
	        </td>
        </c:if>
        
        <c:if test="${member.addr.county eq '한국'}">
        	<td class = "red">${member.name}</td>
        </c:if>
        <c:if test="${member.addr.county eq '미국'}">
        	<td class = "blue">${member.name}</td>
        </c:if>
        
        <!-- 주소 마지막 값일 때 -->
        <c:if test="${loop.last}">
	        <td class = "red">
	        	${member.addr}
	        </td>
        </c:if>
        <!-- else -->
        <c:if test="${not loop.last}">
        	<td>
        	${member.addr}
        	</td>
        </c:if>
        </tr>
     </c:forEach>
     
      </table>
      </div>
      <div class="content">
      <table>
        <tr><th>No</th><th>ID</th><th>이름</th><th>주소</th></tr>
    <c:forEach var = "member" items= "${members}" varStatus="loop" begin="0" end="2">
        <tr>
        <td>${loop.index} / ${loop.count}</td>
        <td>${member.id}</td>
        <td>${member.name}</td>
        <td>${member.addr}</td>
        </tr>
     </c:forEach>
      </table>
      </div>
  </body>
</html>




