<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 예제</title>
</head>
<body>
	<%--이름을 join으로 정함 --%>
	<form action="object_ok.jsp" name="join">
		<fieldset>
			<legend>개인정보</legend>
			<input type="text" name="name">
			<input type="date" name="birthday">
			<%--위에있는 정보 검사하고 발사 --%>
			<input type="button" value="확인" onclick="send()">
			 
		</fieldset>
	</form>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$("input[name='name']").on("click", function(){
		$(this).removeAttr("style");
		$(this).removeAttr("placeholder");
	});
	$("input[name='birthday']").on("click", function(){
		$(this).removeAttr("style");		
	});
	
	function send(){
		var frm = document.join;
		if(!frm.name.value){//없으면
			$("input[name='name']").css("border-color", 'red');
			$("input[name='name']").attr("placeholder", '성함을 입력하세요');
			return;
		}
		
		if(!frm.birthday.value){
			$("input[name='birthday']").css("border-color", 'red');
			return;
		}
		frm.submit();
	}
</script>
</html>