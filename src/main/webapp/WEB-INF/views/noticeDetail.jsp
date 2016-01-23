<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="assets/js/notice.js"></script>
<title>Insert title here</title>
</head>
<body>

<c:set var="notice" value="${notice}" scope="request"/>
<c:set var="nid" value="${notice.notice_id }"/>
<c:set var="title" value="${notice.notice_title }"/>
<c:set var="content" value="${notice.notice_content}"/>
<c:set var="file" value="${notice.notice_file }"/>


<c:if test="${file==null}">
  
  </c:if>
  <c:if test="${file!=null}">
 
   <form id="downloadForm" action="fileDownload.do" method="post">
   <input type="hidden" value="${file}" name="file">
   </form>
   
  </c:if>

<div id="article" >

<form id="frm" action="boardInsert.do" method="post" >
<table width="100%" class="table">

		<tr>
			<th>제목</th>
			<td>${title}</td>
		</tr>
		<tr>
		<th>첨부파일</th>
		<td><a onclick="fileDownLoad()">${file}</a></td>
		</tr>
		<tr id="boardContent">
		
			<th>내용</th>
			
			
	
	<td>

		${content}
	</td>

	
		
		</tr>
		
		<tr>
		<td></td>
		<td></td>
		</tr>
		
</table>
</form>


<div>

<!-- 나중에 관리자만 할수 있도록 수정 -->

<form class="boardDetail" action="boardUpdateBefore.do"  method="post">
<input type="hidden" name="nId" value="${nId}"/>
<input type="submit"  class="btn btn-primary" value="수정" onclick="if(!confirm('정말로 수정하시겠습니까?')){return false;}"/>
</form>




<form class="boardDetail" action="boardDelete.do"  method="post">
<input type="hidden" name="nId" value="${nId}"/>

<input type="submit" class="btn btn-default" value="삭제" onclick="if(!confirm('정말 삭제 하시겠습니까?')){return false;}">

</form>


</div>




<button class="btn btn-default" onclick="history.back()">목록</button>


</body>
</html>