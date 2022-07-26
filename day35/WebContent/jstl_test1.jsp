<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(변수)</title>
</head>
<body>
	<h2>JSTL TEST(변수)</h2>
	<!-- 변수이름 		변수 값		변수 생명주기(page : 다른 페이지에서는 이 변수 쓸수 없음) -->
	<c:set var="name" value="홍길동" scope="page"/>
	<c:out value="${name}"/>
	<!-- $를 출력하고 싶을 떄에는 \$ 또는 $dollar;를 사용한다. -->
	<br><!-- 한줄 띄우기(엔터) -->
	\${name} ====> $dollar;{name}
	<hr><!-- 줄쳐줌 -->
	
	<!-- value쓰지 않고 밖에 값 써도 값으로 nation에 들어감 -->
	<c:set var="nation" scope="session">한국</c:set>
	<!-- 변수 없앰  		scope도 정확히 알려주는게 좋음 -->
	<c:remove var="nation" scope="session"/>
	<!-- 지운 후 출력을 했으므로 default값이 나오게 됨 -->
	nation 삭제 후 값은 >> [<c:out value="${nation}" default="미국"/>] >> 변수 값이 삭제됨
	<br>
	
	<c:set var="data1" value="10"/>
	<c:set var="data2" value="${20}"/>
	<c:set var="data3">30.5</c:set>
	합 : <c:out value="${data1 + data2 + data3}"/>
	<%--컴파일 막는 주석 --%>
</body>
</html>