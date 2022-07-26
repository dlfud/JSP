<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form>
		아이디<input type="text" name="id" id="id">
		<input type="button" onclick="checkId()" value="중복검사">
		<p id="check"></p>
		비밀번호<input type="password" name="pw">
	</form>
</body>
<script>
	function checkId(){
		let id = document.getElementById("id").value;
		let p = document.getElementById("check");
		
		var xhr = new XMLHttpRequest();
		
		xhr.open("POST", "checkid.jsp", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("id="+id);//id라는 이름으로 id보냄
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){		
				//콘솔창으로 확인
				var result = xhr.responseText.trim();
				consol.log(result);
				
				//checkid.jsp에서 받아온 문자가 '성공'이라면
				if(xhr.responseText.trim() == '성공'){
					p.innerHTML = "사용가능한 아이디 입니다.";
				}else{
					p.innerHTML = "중복된 아이디 입니다.";
				}
			}
		}
	}
</script>
</html>