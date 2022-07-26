<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL test(출력의 종류)</title>
</head>
<body>
	<%--<c:set var="name" value="홍길동"/>
	${name}
	<c:out value="${name}"/>--%>
	
	<!-- 팝업창으로 나옴 -->
	${"<script>alert('안녕');</script>"}
	<c:out value="<script>alert('안녕');</script>" escapeXml="false"/>
	<!-- 문자열로 나옴 -->
	<c:out value="<script>alert('안녕');</script>"/>
	
	
	
</body>
</html>