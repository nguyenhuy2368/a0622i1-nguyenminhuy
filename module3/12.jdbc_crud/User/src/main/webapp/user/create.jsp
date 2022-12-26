<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/26/2022
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<h1>Create User</h1>
<p><a href="/user">Back to list User</a></p>
<form method="post" action="user?action=create">
    <div>
        <span>Name:</span>
        <input type="text" name="name">
    </div>
    <div>
        <span>Email:</span>
        <input type="text" name="email">
    </div>
    <div>
        <span>Country:</span>
        <input type="text" name="country">
    </div>
    <button type="submit" >Create</button>
</form>
</body>
</html>
