<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET 방식의  요청</title>
</head>
<body>
	<%
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		
		if(city == null || zipcode == null){
			response.sendRedirect("post_test.jsp");//이 경로로 보내버림, 응답 페이지를 요기로 해라
		}else{
	%>
	
	<h1>GET방식의 요청</h1>
	<%-- form 태그에서 action생략시 내페이지로 옴, method생략시 GET방식 --%>
	<form>
		<input type="text" value="Seoul" name="city" readonly>
		<input type="text" value="12355" name="zipcode" readonly>
		<button>GET방식으로 요청 보내기!</button>		
	</form>
	
	<p>
		<%--request.getParameter("city") --%>
		<%--request.getParameter("zipcode") --%>
		<%=city %>
		<%=zipcode %>
	</p>
	<%} %>
</body>
</html>