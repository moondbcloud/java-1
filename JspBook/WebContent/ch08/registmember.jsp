<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" 
      href="../resources/css/bootstrap.min.css">
<script type="text/javascript" src="../resources/js/common.js"></script>
<title>회원등록</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">회원 등록</h1>
		</div>
	</div>
	<div class="container-fluid">
		<form name="newMemberRegist" action="./registmember_process.jsp" class="form-horizontal" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-2">아이디</label><span class="text-danger">*</span>
				<div class="col-sm-3">
					<input type="text" id="id" name="id" class="form-control" >
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">이  름</label><span class="text-danger">*</span>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" class="form-control" >
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">비밀번호</label><span class="text-danger">*</span>
				<div class="col-sm-3">
					<input type="text" id="passwd" name="passwd" class="form-control" >
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">비밀번호확인</label><span class="text-danger">*</span>
				<div class="col-sm-3">
					<input type="text" id="cpasswd" name="cpasswd" class="form-control" >
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">전화번호(핸드폰)</label><span class="text-danger">*</span>
				<div class="col-sm-4">
					<select id="phone1" name="phone1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="019">019</option>
					</select>
					-
					<input type="text" maxlength="4" id="phone2" name="phone2">
					-
					<input type="text" maxlength="4" id="phone3" name="phone3">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">성별</label>
				<div class="col-sm-5">
					<input type="radio" name="gender" value="male"> 남자 
					<input type="radio" name="gender" value="female"> 여자
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">주소1</label>
				<div class="col-sm-3">
					<input type="text" id="addr1" name="addr1" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">주소2</label>
				<div class="col-sm-3">
					<input type="text" id="addr2" name="addr2" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">주소3</label>
				<div class="col-sm-3">
					<input type="text" id="addr3" name="addr3" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">E-Mail</label>
				<div class="col-sm-3">
					<input type="text" id="email" name="email" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-primary" value="등록" onclick="chkFormRegistMember()">
				</div>
			</div>
		</form>
	</div>
</body>
</html>