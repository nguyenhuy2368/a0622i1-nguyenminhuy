<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/4/2023
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h3>Calculator</h3>
<form action="/action">
    <input type="text" name="num1" value="${num1}">
    <input type="text" name="num2" value="${num2}">
    <br>
    <br>
    <input type="submit" value="addition +" name="action">
    <input type="submit" value="subtraction -" name="action">
    <input type="submit" value="multiplication x" name="action">
    <input type="submit" value="division /" name="action">
</form>
<h3> ${name} ${sum}</h3>
</body>
</html>
