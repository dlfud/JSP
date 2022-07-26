<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--한글이 깨진경우 --%>
<%-- <%request.setCharacterEncoding("UTF-8");%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 request 예제</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>이름</th>
			<th>생일</th>
		</tr>
		<tr>
			<%--<input type="text" name="name">이므로 name이라는 키값을 전달, name으로 값을 찾음--%>
			<td><%=request.getParameter("name") %></td>
			<td><%=request.getParameter("birthday") %></td>
		</tr>
	</table>
</body>
</html>