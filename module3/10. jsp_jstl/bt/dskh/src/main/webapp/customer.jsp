<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/12/2022
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Danh sách khách hàng</h1>
<table>
    <tr>
        <th>Name</th>
        <th>Birthday</th>
        <th>Address</th>
    </tr>
    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getBirthday()}</td>
            <td>${customer.getAddress()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
