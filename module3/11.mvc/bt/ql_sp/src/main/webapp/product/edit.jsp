<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/23/2022
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit product</h1>
<p><a href="product">Back to list product</a> </p>
<form method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${product.getName()}"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="number" name="price" value="${product.getPrice()}"></td>
        </tr>
        <tr>
            <td>Descrip</td>
            <td><input type="text" name="descrip" value="${product.getDescrip()}"></td>
        </tr>
        <tr>
            <td>Producer</td>
            <td><input type="text" name="producer" value="${product.getProducer()}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Edit product"></td>
        </tr>
    </table>
    <c:if test='${requestScope["message"] != null}'>
        <span>${requestScope["message"]}</span>
    </c:if>

</form>
</body>
</html>
