<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>
		<table>
	
		
	
		
		
		<c:forEach var="info" items="${infoList}">
		<div>
		<tr>
			${info.name}<br>
			</tr>
			<tr>
		    ${info.url}<br> 
		 </tr>
		</div>
		
			
		</c:forEach>


		
	</table>
</body>
</html>