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
		//사용자가 요청한 거에 대한 정보를 갖고 있는 객체
		String site = request.getParameter("site");//해당 키에 저장된 값을 site에 넘김
		String url = null;
		
		switch(site){
		case "naver":
			url = "forward_naver.jsp";
			break;
		case "daum":
			url = "forward_daum.jsp";
			break;
		case "google":
			url = "forward_google.jsp";
			break;
		}
	%>
	<jsp:forward page="<%=url %>"/>
</body>
</html>