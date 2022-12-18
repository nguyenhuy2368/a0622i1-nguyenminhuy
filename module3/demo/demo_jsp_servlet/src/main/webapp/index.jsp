<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 12/9/2022
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Đây là trang index</h1>
  <a href="/sum?num1=20&num2=30">Vào do get</a>
  <form action="/sum" method="get">
    <input name="num1">
    <input name="num2">
    <button type="submit">Send</button>
  </form>
  </body>
</html>
