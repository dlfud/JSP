<%@page import="com.jspex.beans.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 객체화 해주는 태그, 기본 생성자만 호출, id는 객체명 class는 해당 객체의 풀 경로 (패키지까지 다 써줘야 함) -->
<jsp:useBean class="com.jspex.beans.MemberVO" id="vo"/>
<jsp:useBean class="com.jspex.beans.MemberDAO" id="dao"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML주석을 사용자에게 보여지는걸 막는것, 컴파일을 막는 것이 아님 -->
<%--jsp주석은 컴파일도 주석처리된다. --%>	
<!--  						필드 이름, 위에서 만든 객체의 이름, 넣을 값-->
<%--<jsp:setProperty property="name" name="vo" value="이름"/>
	<jsp:setProperty property="birthday" name="vo" value="12-04"/> --%>
	
	<%
		ArrayList<MemberVO> members = dao.select("이름");
	%>
	<table border=1>
		<%for(int i = 0;i<members.size();i++) {%>
		<jsp:setProperty property="name" name="vo" value="<%=members.get(i).getName() %>"/>
		<jsp:setProperty property="birthday" name="vo" value="<%=members.get(i).getBirthday() %>"/>
			<tr>
			<%--<td><%=members.get(i).getName()%></td>
				<td><%=members.get(i).getBirthday()%></td> --%>
				<td><jsp:getProperty property="name" name="vo"/></td>
				<td><jsp:getProperty property="birthday" name="vo"/></td>
			</tr>
		<%} %>
	</table>
	
	<jsp:getProperty property="name" name="vo"/>
	<jsp:getProperty property="birthday" name="vo"/>
</body>
</html>