<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="http://netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<title>Hello1</title>
<style>
    label { margin-top: 20px; }
</style>
</head>
<div class="container">

    <h1>학생 수정</h1>
    
    <form method="post">
        
        <label>학번</label>
        <input type="text" name="name" value="${ club.name }" />
    
        <label>이름</label>
        <input type="text" name="event" value="${ club.clubevent }" />
    
      
    
        <div>
            <input type="submit" class="btn btn-primary" value="저장" />
        </div>
    </form>
    
    <c:if test="${ not empty error }">
        <div class="alert alert-error">${ error }</div>
    </c:if>        
    <c:if test="${ not empty success }">
        <div class="alert alert-success">${ success }</div>
    </c:if>        

</div>

</body>
</html>
