<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 forward 테스트</title>
</head>
<body>
	<!-- 사용자가 안에서 선택한 값을 해당 경로에 있는 파일로 전송해주는 일을 함 -->
	<form action="controller.jsp">
		보고싶은 페이지 선택 : 
		<select name="site">
			<option value="naver">네이버</option>
			<option value="daum">다음</option>
			<option value="google">구글</option>			
		</select>
		<input type="submit" value="전송"> 
		<!-- <input type="button" value="전송"> 
			버튼을 쓰면 폼을 전송시키는게 아니라 클릭을 했을 떄 내가 하고 싶은 함수를 실행시키는 것
		-->
	</form>
</body>
</html>