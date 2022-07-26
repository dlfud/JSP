<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 실습1</title>
</head>
<body>
<!-- 사용자에게 이름을 입력받고 확인 버튼을 눌렀을 떄 
		admin일 경우 "관리자", member일 경우 "일반회원 member(param객체 사용)", 그 외에는 비회원을 출력한다.
		
		※다른 페이지 없이 현재 페이지에서만 처리하고, 결과가 출력될 때에는 input태그와 submit버튼이 나오게 해서는 안된다.
		※form태그의 속성은 action을 생략하면 현재 페이지로 이동이 된다.
		※EL과 JSTL만 사용한다.(JS 금지)
-->
	<c:choose>
		<c:when test="${empty param.name}">
			<form>
				<input type="text" name="name">
				<input type="submit" value="확인">		
			</form>	 
		</c:when>
		<c:choose>
	 		<c:when test="${param.name == 'admin'}">
		 		<h1>관리자</h1>
		 	</c:when>
		 	<c:when test="${param.name == 'member'}">
		 		<h1>일반회원<c:out value="${param.name}"/></h1>
		 	</c:when>
		 	<c:otherwise>
		 		<h1>비회원</h1>
		 	</c:otherwise>
		</c:choose>
	 </c:choose>
</body>
</html>