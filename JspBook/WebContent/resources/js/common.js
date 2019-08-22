function chkFormRegistMember(){
	var id = document.getElementById("id");
	var name = document.getElementById("name");
	var passwd = document.getElementById("passwd");
	var email = document.getElementById("email");
	
	var regid = /^[a-zA-Z]([0-9|a-z|A-Z]){7,11}$/; 
	// 영문자로시작, 영숫자포함 8-12글자
	var regname = /^[a-z|A-Z|가-힣]{1,20}$/;
	//영문자 한글 1-20글자
	var regpasswd = /^[a-z|A-Z][a-z|A-Z|0-9|!|@|#|$|%|^|&|*|-|_|+|=|?]{7,14}$/; 
	//영문자로 시작, 영숫자 및 특수기호 !@#$%^&*-_+=? 포함 8-15글자
	var regemail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	
	var form = document.newMemberRegist;
	
	var id = form.id.value;
	var name = form.name.value;
	var passwd = form.passwd.value;
	var cpasswd = form.cpasswd.value;
	var email = form.email.value;
	
	if(!regid.test(id)){
		alert("아이디는 문자로시작하고 영숫자 8-12글자로 입력하세요.");
		form.id.select();
		form.id.focus();
		return;
	}
	
	if(!regname.test(name)){
		alert("이름은 영문자 또는 한글로 20글자 이하로 입력하세요.");
		form.name.select();
		form.name.focus();
		return;
	}
	
	if(passwd != cpasswd){
		alert("비밀번호가 일치하지 않습니다.");
		form.passwd.select();
		form.passwd.focus();
		return;
	}
	
	if(!regpasswd.test(passwd)){
		alert("비밀번호는 영문자로 시작, 영숫자 및 특수기호 !@#$%^&*-_+=? 포함 8-15 글자입니다.");
		form.passwd.select();
		form.passwd.focus();
		return;
	}
	
	if(!regemail.test(email)){
		alert("이메일을 확인하세요.");
		form.email.select();
		form.email.focus();
		return;
	}
	
	
	document.newMemberRegist.submit();
}