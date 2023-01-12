<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 1/9/2023
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css">
</head>
<body>
<div class="create-form">
    <div class="container w-50">
        <form action="/hokhau?action=update" method="post">
            <c:if test="${hokhau != null}">
                <input readonly name="stt" value="${hokhau.stt}"/>
            </c:if>
            <div class="form-group">
                <label for="exampleFormControlInput1">Tên chủ hộ:</label>
                <input type="text" name="ten_chu_ho" class="form-control" value="${hokhau.ten_chu_ho}"
                       id="exampleFormControlInput1" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput3">Ngày lập hộ khẩu:</label>
                <input type="date" name="ngay_lap_ho_khau" class="form-control" value="${hokhau.ngay_lap_ho_khau}"
                       id="exampleFormControlInput3" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput4">Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" value="${hokhau.dia_chi}"
                       id="exampleFormControlInput4" required>

            </div>

            <div class="w-100">
                <button type="submit" class="btn btn-success w-50" style="alignment: center">Sửa</button>
            </div>
        </form>
    </div>
</div>
<script src="/bootstrap520/js/bootstrap.bundle.min.js"></script>
<script src="/jquery/jquery-3.5.1.min.js"></script>
</body>
</html>
