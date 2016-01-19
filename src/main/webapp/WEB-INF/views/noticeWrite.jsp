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

<form action="noticeInsert.do" method="post" enctype="multipart/form-data">

<table width="100%">
			<tr>
			
				<td></td>
				<td>
				<input type="text" id="title" name="notice_title" class="form-control"/>
				<input type="hidden" name="member_id" value="${studentNum}"/>
			    </td>
			</tr>
			
			<tr>
			<td>첨부파일</td>
			<td>
			<input type="file" class="form-control" name="notice_file" >
			</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea class="form-control" rows="10" cols="30" id="#" name="notice_content"
						style="width: 850px; height: 500px;">
			
				</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input class="btn btn-primary" type="submit" id="save" value="확인" />
				 <input class="btn btn-default" type="button" value="취소" />
				 </td>
			</tr>
		</table>


</form>


</body>
</html>