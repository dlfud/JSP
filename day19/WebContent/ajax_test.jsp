<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET, POST 방식의 요청</title>
</head>
<body>
	<h1>GET방식의 요청</h1>
	<button onclick="sendRequest()">GET방식으로 요청 보내기!</button>
	<!-- 3. 현재 여기에 꽃아 넣음 -->
	<p id="text"></p>
</body>
<script>
	function sendRequest(){
		var xhr = new XMLHttpRequest();
		
		//1. 요청보내기
		//만약 연산이 안되면 true를 false로 바꿔봐~
		xhr.open("GET", "request_ajax.jsp?city=Seoul&zipcode=45645", true);//GET방식, request_ajax.jsp경로, 동기식
		xhr.send();
		
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){//요청이 다 끝났냐?, 성공했냐?
				//여기 들어오면 상태 좋음 응답받을 준비가 되어있음
															//2. 다시 갖고오기
				document.getElementById("text").innerHTML = xhr.responseText;
			}
		}//상태가 변할때마다 실행이 됨
	}
</script>
</html>