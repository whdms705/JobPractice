<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="http://netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

<center><h1>로그인</h1></center>
		<hr>
		<form method="post" action="loginPro.do">
			<table>
				<tr>
					<th>학번</th>
					<td><input type="text" name="studentNum" placeholder="ID" class="form-control" autofocus></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password" placeholder="PW" class="form-control"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-default" value="로그인"></td>
				</tr>
			</table>
		</form>

</body>
</html>