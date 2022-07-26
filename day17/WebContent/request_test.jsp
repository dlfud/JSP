<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 페이지</title>
</head>
<body>
	<%-- 1. response_test.jsp여기 파일에서 이 파라미터를 전달받음, 메소드 쓰지 않았으므로 GET방식이 됨 --%>
	<form action="response_test.jsp">
		<input type="text" name="name"><!-- 이름을 입력 받음 -->
		<button>전송</button>
	</form>
	<%
								//name으로 받음
		String name = request.getParameter("name");
		if(name!=null){
			out.println(name);//그 이름을 출력해라
		}
	%>
</body>
</html>