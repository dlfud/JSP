<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag4</title>
</head>
<body>
	<p>
		<!-- 앞에 소속을 붙여줬기 때문에 오류가 나지 않음 -->
		Today's date ; <%=new java.util.Date() %>
	</p>
</body>
</html>