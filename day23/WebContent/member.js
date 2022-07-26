/**
 * 회원가입 유효성 검사
 */

var form = document.joinForm;

function join(){
	//value를 조건식 안에서 사용하면 값이 있을 때 ture 없을 떄 false
	if(!form.id.value){//값이 없을 때 
		alert("아이디를 입력해주세요.");
		form.id.focus();//커서가 아이디에 위치함
		return;//return을 만나면 해당 함수는 무조건 종료함
	}
	if(form.id.value.length < 4 || form.id.value.length > 16){
		alert("아이디는 4자 이상 16자 이하로 입력해 주세요.");
		form.id.focus();
		return;
	}
	
	
	
	if(!form.name.value){
		alert("이름을 입력해 주세요.");
		form.name.focus();
		return;
	}
	
	
	
	if(!form.password.value){
		alert("비밀번호를 입력해 주새요.");
		form.password.focus();
		return;
	}
	
	//8자리 이상, 대문자, 소문자, 숫자, 특수문자 모두 포함되어 있는지 검사
	let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	let hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/
	
	if(!reg.test(form.password.value)){//사용자가 입력한 비밀번호를 test에 넣었을 때 위 조건에 맞으면 true, 틀리면 false
		alert("비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
		form.password.focus();
		return;
	}
	
	//같은 문자를 4번 사용할 수 없다.
	if(/(\w)\1\1\1/.test(form.password.value)){
		alert("같은 문자를 4번이상 사용할 수 없습니다.");
		form.password.focus();
		return;
	}
	
	//비밀번호 안에 아이디가 포함되어 있지 않을 때 -1을 반환함
	if(form.password.value.search(form.id.value) != -1){
		alert("비밀번호에 아이디를 포함할 수 없습니다.");
		form.password.focus();
		return;
	}
	
	//비밀번호에 한글이 있으면 안된다.
	if(hangleCheck.test(form.password.value)){
		alert("비밀번호에 한글을 사용할 수 없습니다.");
		form.password.focus();
		return;
	}
	
	//비밀번호에 공백을 포함할 수 없다.
	if(form.password.value.search(/\s/) != -1){//공백을 찾았을 때 들어옴
		alert("비밀번호에 공백을 포함할 수 없습니다.");
		form.password.focus();
		return;
	}
	
	if(form.password.value != form.password_re.value){
		alert("비밀번호를 확인해 주세요.");
		form.password.focus();
		return;
	}
	
	
	if(!form.id.readonly){
		alert("아이디 중복 검사를 진행해주세요.");
		return;
	}
	form.submit();//위에 있는게 다 정상이라면 전송해라
}

//readonly에 따라서 중복검사를 했냐 안했냐로 나뉨
//다시 누르면 수정가능 하도록 false로 만듬
$("input[name='id']").on("click", function(){
	form.id.readonly = false;
})

function checkId(){//아이디 중복 검사를 위해서 ajax사용
	var xhr = new XMLHttpRequest();
	
	xhr.open("GET", "join_ok.jsp?id="+document.getElementById("id").value, true);
	xhr.send();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
//			console.log(xhr.responseText);
			//xhr.responseText : join_ok함수에서 응답값 받아옴
			//trim() : 공백 제거
			//join.jsp에 result(15줄)태그로 값 넣음
			document.getElementById("result").innerHTML = xhr.responseText.trim();
			if(xhr.responseText.search("가능") != -1){//가능이라는 문구가 있다면
				form.id.readonly = true;//수정불가능하게 만듬
			}
		}
	}
}