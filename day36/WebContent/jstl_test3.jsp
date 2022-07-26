<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(제어문 - 조건식)</title>
</head>
<body>
	<c:set var="id">admin</c:set>
	<c:if test="${id eq 'admin'}">
		현재 로그인된 계정은 <c:out value="${id}"/>계정입니다.
	</c:if>
	
	<c:set var="id">member</c:set><!-- 값 변경 -->
	<c:if test="${id == 'member'}">
		현재 로그인된 계정은 일반 계정입니다.
	</c:if>
	
	<c:set var="id">hds1234</c:set>
	<c:choose>
		<c:when test="${id eq 'admin'}">관리자</c:when>
		<c:when test="${id eq 'member'}">회원</c:when>
		<c:when test="${id eq 'hds1234'}">비회원</c:when>
	</c:choose>
	
	
	<c:set var="gender" value="male"/>
	<c:choose>
		<c:when test="${gender eq 'male'}">남자입니다.</c:when>
		<c:when test="${gender eq 'female'}">여자입니다.</c:when>
	</c:choose>
		
</body>
</html>