<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/19/2022
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User</title>
</head>
<body>
<div class="menu">
    <h1>List User</h1>
    <p><a href="user?action=create">Create new User</a></p>
    <p><a href="user?action=findCountry">Find User country</a></p>
    <p><a href="user?action=sortName">List sort name</a></p>
    <form method="post">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Action</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.country}</td>
                    <td><a href="user?action=edit&id=${user.getId()}">Edit</a></td>
                    <td><a href="user?action=delete&id=${user.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
