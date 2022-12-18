<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/18/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h3>Product Discount Calculator</h3>
    <form action="/display-discount" method="post">
        <label for="">Product Description</label>
        <input type="text"  name="description">
        <label for="">List Price</label>
        <input type="text" name="price">
        <label for="">Discount Percent</label>
        <input type="text" name="percent">

        <input type="submit" value="Calculate Discount">
    </form>
</div>
</body>
</html>
