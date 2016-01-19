<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>
${name}(${studentNum})님 환영합니다
<h1>메인 홈페이지 </h1>

<a href="login.do">로그인 </a>
<a href="noticeList.do">공지사항</a>
<a href="#">게시판</a>
<a href="#">관심주제</a>

</body>
</html>