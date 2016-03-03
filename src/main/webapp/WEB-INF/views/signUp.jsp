<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="http://netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"  href="assets/css/login.css" />
<title>Hello1</title>

</head>
<body>


<div class='container'>
			<div class="wrapper">
				<div class="image"></div>
				<div class="join">
					<form name="signupForm" id="signupForm" method="post">
						<div class="input">
							<input type="text" class="box" placeholder="이름" name="name" required>
						</div>
						<div class="input">
							<input type="number" class="box" placeholder="학번" name="studentNum" required>
						</div>
						<div class="input">
							<input type="password" class="box" placeholder="비밀번호" name="password" required pattern="(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}">
						</div>
						<div class="input">
							<input type="password" class="box" placeholder="비밀번호 확인" name="passwordConfirm" required>
						</div>
						<div class="input">
							<input type="email" class="box" placeholder="이메일" name="email" required>
						</div>
						<a href="#"><div class="login_btn"><input type = "submit" class = "login_btn" value = "등록하기">
						</div></a>
						<div class="option">
						<a href="index.jsp"><div class="back">돌아가기</div></a>
					</div>
				</div>
			</div>
			<div class="policy">계정을 만들면 소울스트릿의 서비스 약관 및 개인정보 보호정책에<br>동의하는 것으로 간주합니다.</div>
		</div>

<!-- 
<div id="article">

	<center><h3>회원가입</h3></center><br>
	<form name="signupForm" id="signupForm" method="post" class="form-inline">
	
	<table id="signUp" class="table">
		<tr id="signUpHead" >
			<td colspan="3"><div></div></td>
		</tr>
		<tr>
		<td colspan="3"></td>
		</tr>
		<tr>
			<td>이름</td>
			<div></div><td><input type="text" class="form-control" placeholder="이름"
				name="name" required></td></div>
				<td></td>
		</tr>
		
		<tr>
			<td>학번</td>
			<td><input type="number" class="form-control" placeholder="학번"
				name="studentNum" required></td>
				<td></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" class="form-control"
				placeholder="비밀번호" name="password" required pattern="(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}"> &nbsp;영어,숫자,특수문자 조합(6~12)자리입니다.</td>
				<td></td>
		</tr>
		
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" class="form-control" placeholder="비밀번호 확인"
				name="passwordConfirm" required></td>
				<td></td>
		</tr>
		
		
	
		
		<tr>
			<td>이메일</td>
			<td><input type="email" class="form-control" placeholder="이메일"
				name="email" required></td>
				<td></td>
		</tr>

		
		<tr>
		<td colspan="3"></td>
		</tr>
		<tr id="signUpFooter">
			<td colspan="3"></td>
			<td></td>
		</tr>

	</table>

		<hr>


		<div>
			<input type="submit" class="btn btn-primary" id="join" value="가입하기" />
		</div>

	</form>

</div>
-->

</body>
</html>