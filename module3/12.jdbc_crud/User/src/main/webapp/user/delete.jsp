<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/26/2022
  Time: 12:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<h1>Delete User</h1>
<form action="/users?action=delete" method="post">
    <input type="hidden" name="id" value="${user.getId()}">
    <fieldset>
        <legend>Do you want to delete user</legend>
        <table>
            <tr>
                <td>Id</td>
                <td>${user.getId()}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${requestScope["user"].getName()}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${requestScope["user"].getEmail()}</td>
            </tr>
            <tr>
                <td>Country</td>
                <td>${requestScope["user"].getCountry()}</td>
            </tr>
            <tr>
                <td><input type="submit" name="name" value="Yes"></td>
                <td><input type="submit" name="name" value="No"></td>
            </tr>
            <tr>
                <td><a href="/user">Back to list user</a> </td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
