<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/23/2022
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create product</h1>
<p><a href="product">Back to list product</a></p>
<form method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <td>Descrip</td>
            <td><input type="text" name="descrip"></td>
        </tr>
        <tr>
            <td>Producer</td>
            <td><input type="text" name="producer"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="Create new product"></td>
        </tr>
    </table>
</form>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
</body>
</html>
