<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();//세션 전체 삭제
	//session.removeAttribute("id");//특정 세션값 삭제
	
%>
<script>
	location.href = "login.jsp";
</script>