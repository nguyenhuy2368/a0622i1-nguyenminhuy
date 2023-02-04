<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/17/2021
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Chuyển đổi tiền tệ</h3>
<form method="post" action="/exchange">
    <label>USD:</label>
    <input name="usd"/>
    <input type="submit" value="submit"/>
</form>
<p>VND: ${vnd}</p>
</body>
</html>
