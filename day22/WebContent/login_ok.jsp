<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		Cookie cookieId = new Cookie("id", request.getParameter("id"));
		Cookie cookiePw = new Cookie("pw", request.getParameter("pw"));
		//쿠키 유통기한을 설정함
		cookieId.setMaxAge(10000);
		cookiePw.setMaxAge(10000);
		response.addCookie(cookieId);
		response.addCookie(cookiePw);
	%>
	로그인 성공!
</body>
</html>