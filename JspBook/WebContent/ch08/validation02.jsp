<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Login Form</title>
</head>
<script type="text/javascript">
	function checkLogin(){
		var form = document.loginForm;
		if(form.id.value == ""){
			alert("아이디를 입력하지 않았습니다.");
			form.id.focus();
			return;
		}else if(form.passwd.value=""){
			alert("비밀번호를 입력하지 않았습니다.");
			form.passwd.focus();
			return;
		}else{
				form.submit();
		}
	}
</script>
<body>
<form name="loginForm" action="validation02_process.jsp" method="post">
	<p>아 이 디 : <input type="text" name="id">
	<p>비밀번호: <input type="password" name="passwd">
	<p><input type="submit" onclick="checkLogin()">
</form>
</body>
</html>