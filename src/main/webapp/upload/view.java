<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, lecture1.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>lecture1</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
<style>
    thead tr { background: #eee; }
    tbody tr:hover { background-color: #ffa; cursor: pointer; }
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
    $(function() {
        $("tbody tr").click(function() {
            location.href = "userEdit.jsp?id=" + $(this).attr("data-id");
        });
    });
</script>
</head>
<%
    ArrayList<User> list = UserDAO4.selectAll();
%>
<body>

<div class="container">

    <h1>사용자 목록</h1>
    <hr />

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>loginId</th>
                <th>passwd</th>
                <th>name</th>
                <th>email</th>
                <th>enabled</th>
            </tr>
        </thead>
        <tbody>        
            <% for (User user : list) { %>
                <tr data-id="<%= user.getId() %>">
                    <td><%= user.getId() %></td>
                    <td><%= user.getLoginId() %></td>
                    <td><%= user.getPasswd() %></td>
                    <td><%= user.getName() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.isEnabled() %></td>
                </tr>
            <% } %>
        </tbody>        
    </table>
</div>

</body>
</html>
