<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/23/2022
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="menu">
    <h1>List product</h1>
    <p><a href="product?action=create">Create new product</a></p>
    <p><a href="product?action=find">Find from Name product</a></p>
    <form method="post">
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Descrip</th>
                <th>Producer</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${product}" var="product">
                <tr>
                    <td>${product.getId()}</td>
                    <td>${product.getName()}</td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getDescrip()}</td>
                    <td>${product.getProducer()}</td>
                    <td><a href="product?action=edit&id=${product.getId()}">Edit</a></td>
                    <td><a href="product?action=delete&id=${product.getId()}">Delete</a></td>
                    <td><a href="product?action=view&id=${product.getId()}">View</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
