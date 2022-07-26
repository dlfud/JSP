<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답 페이지</title>
</head>
<body>
	<!-- 이름 전달 받기 -->
	<%-- out.println : 형식적으로 쓰는 메소드 전달하고 싶은 값을 body태그에 출력할수 있게 도와줌 --%>
	<%--<%out.println(request.getParameter("name"));%> --%>
	
	<!-- 2. 전달받은 이름을 다시 request_test.jsp로 전달 -->
	<%--<form action="request_test.jsp">
													<!-- name으로 받음 -->
		<input type="text" name="name" value="<%=request.getParameter("name") %>">
		<button>전송</button>
	</form>--%>
	
	<%
		String name=request.getParameter("name");
	%>
	
	<%response.sendRedirect("request_test.jsp?name="+URLEncoder.encode(name, "UTF-8")); %>
</body>
</html>