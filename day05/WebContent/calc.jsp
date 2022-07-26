<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기 - JSP 페이지</title>
</head>
<body>
	<h1>JSP로 만든 페이지</h1>
	<!-- 사용자가 입력한 값이 request라는 공간에 담겨서 Oper로 이동 -->
	<form action="Oper" method="post">
		<p>수식을 입력하세요(두 정수의 사칙연산)</p>
		<!-- 사용자 입력(1+1) -->
		<input type = "text" name = "input">
		<button>확인</button>
	</form>
</body>
</html>