<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  href="assets/css/login.css" />

<title>이것은 제목</title>
</head>

<body>
		<div class='container'>
			<div class="wrapper">
				<div class="image"></div>
				<div class="login">
					<h2 class="title">당신의 공부를 응원합니다!</h2>
					<h4 class="subtitle">IT학생끼리 소통을 할수 있어요!<br>
					공부에 도움이 되는 정보를 볼 수 있어요.</h4>
					<a scope="public_profile,email" onlogin="checkLoginState();" href="#"><div class="facebook">페이스북으로 로그인하기</div></a>
					<div class="or"></div>
					<form method="post" action="loginPro.do">
						<div class="input">
							<input type="text" name="studentNum" placeholder="ID" class="box" autofocus>
							<div class="logo"></div>
						</div>
						<div class="input">
							<input type="password" name="password" placeholder="PW" class="box" autofocus>
							<div class="logo"></div>
						</div>
						<div class="login_btn"><input type = "submit" class = "login_btn" value = "로그인">
						</div>
					</form>
					<div class="option">
						<a href="signUp.do"><div class="box">가입하기</div></a><a href="#"><div class="box">비밀번호 찾기</div></a>
					</div>
				</div>

				<div class="join"></div>
				<div class="ok"></div>
			</div>
		</div>
	</body>
	
</html>

