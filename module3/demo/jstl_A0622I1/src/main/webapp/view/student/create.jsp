<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 12/14/2022
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới sinh viên</h1>
<a href="/student"> Quay lại trang danh sách</a>
<p style="color: red">${mess}</p>
<form method="post">
<%--    <input name="id" placeholder="nhập id"><br>--%>
    <input name="name" placeholder="nhập tên"><br>
    <input type="radio" name="gender" value="true">Nam
    <input type="radio" name="gender" value="false">Nữ<br>
    <input name="point" type="number" value="0" placeholder="nhập điểm"><br>
    <select name="classId">
        <option value="0">Chọn lớp</option>
        <c:forEach var="clazz" items="${clazzList}">
            <option value="${clazz.id}">${clazz.name}</option>
        </c:forEach>

    </select><br>
    <button type="submit">Save</button>
</form>
</body>
</html>
