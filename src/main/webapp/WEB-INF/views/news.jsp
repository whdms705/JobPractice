<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>



</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach var="news" items="${newslist}">
			
				
				
					<div class='container'>
			<div class="wrapper">
				<div class="image"></div>
				<div class="login">
					
					<h4 class="subtitle">${news.news_title}</h4>
					<a scope="public_profile,email" onlogin="checkLoginState();" href="#"><div class="facebook">페이스북으로 로그인하기</div></a>
					<div class="or"></div>
					<form action = "login_do.php" method = "POST">
						<div class="input">
							${news.news_img}
						</div>
						<div class="input">
							<input class="box" type = "password" placeholder="password" name="user_password">
							<div class="logo"></div>
						</div>
						<a href="#"><div class="login_btn"><input type = "submit" class = "login_btn" value = "로그인">
						</div></a>
					</form>
					<div class="option">
						<a href="register_form.php"><div class="box">가입하기</div></a><a href="#"><div class="box">비밀번호 찾기</div></a>
					</div>
				</div>

				<div class="join"></div>
				<div class="ok"></div>
			</div>
		</div>
			
		</c:forEach>

		
	</table>
</body>
</html>