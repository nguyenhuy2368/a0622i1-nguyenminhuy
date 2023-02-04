<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/4/2023
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vietnamese Dictionary</title>
</head>
<body>
<h3>Vietnamese Dictionary</h3>
<form action="search" method="post">
    <input type="text" placeholder="Enter your word:" name="word">
    <input type="submit" value="Search">
</form>
<h3>Keyword: ${word}</h3>
<h3>Result: ${result}</h3>
</body>
</html>
