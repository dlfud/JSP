<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1></h1>
</body>
<script src = "https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$.ajax({
		url : "https://infuser.odcloud.kr/oas/docs?namespace=15053336/v1",
		success: function(result){
			//consloe.log(result);
			//console.log(result.swagger);//swagger라는 것의 값을 알고 싶음
			console.log(result.info.title);
			$("h1").html(result.info.title);//h1태그에 원하는 데이터를 꽂아넣음
		}
	});
</script>
</html>