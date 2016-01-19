<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="http://netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<title>Hello1</title>

</head>
<body>


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


</body>
</html>