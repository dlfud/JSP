<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag2</title>
</head>
<body>
	<%!
		int count = 3;
		String makeItBeLover(String data){
			return data.toLowerCase();//전체문자 소문자로 바꿔줌
		}
	%>
	<%
		for(int i = 0;i<count;i++){
			out.println("Java Server Pages"+(i+1)+".<br>");
		}
	%>
	<!-- ;쓰면 안됨 -->
	<%=makeItBeLover("Hello World") %>
</body>
</html>