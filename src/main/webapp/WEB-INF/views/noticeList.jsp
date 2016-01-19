<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>

<div id="noticeLine">



		
				<center><h1>공 지 사 항</h1></center>
			
			




		<table class="table">
			<tr>
				<th>No.</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
				
			</tr>
			
			<c:forEach var="notice" items="${list}">
			<tr>
			<td>${notice.notice_id }</td>
			<td>${notice.member_id }</td>
			<td><a href="noticeDetail.do?nid=${notice.notice_id}">${notice.notice_title }</a></td>
			<td>${notice.notice_date }</td>
			</tr>
			</c:forEach>

		</table>


	</div>
	
	<button class="btn btn-primary" onclick="location.href='noticeWrite.do'">작성하기</button>

</body>
</html>