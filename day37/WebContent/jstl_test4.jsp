<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(제어문 - 반복문)</title>
</head>
<body>
	<h1>forEach 연습결과</h1>
	<!-- 		변수		시작값	끝값(포함) 	증가값(1이 디폴트 값) -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i}"></c:out> &nbsp;&nbsp;
	</c:forEach>
	
	<br>
	
	<c:forEach var="i" begin="0" end="10" step="2">
		<c:out value="${i}"></c:out> &nbsp;&nbsp;
	</c:forEach>
	
	<br>
	<hr>
	
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="status">
		index : <c:out value="${status.index}"/><br>
		count : <c:out value="${status.count}"/><br>
		begin : <c:out value="${status.begin}"/><br>
		end : <c:out value="${status.end}"/><br>
		step : <c:out value="${status.step}"/><br>
		<!-- 첫번째 반복일떄 -->
		first : <c:out value="${status.first}"/><br>
		<!-- 마지막 반복일떄 -->
		last : <c:out value="${status.last}"/><br>
		<hr>
	</c:forEach>
	
</body>
</html>