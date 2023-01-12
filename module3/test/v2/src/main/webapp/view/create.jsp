<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 1/9/2023
  Time: 1:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css">
</head>
<body>
<div class="create-form">
    <div class="container w-50">
        <form action="/hokhau?action=create" method="post">
            <div class="form-group">
                <label for="exampleFormControlInput1">Mã Hộ Khẩu</label>
                <input type="text" name="ma_ho_khau" class="form-control" value="${hokhau.ma_ho_khau}"
                       id="exampleFormControlInput1"
                       required>

            </div>
            <div class="form-group">
                <label for="exampleFormControlInput3">Tên chủ hộ:</label>
                <input type="text" name="ten_chu_ho" class="form-control" value="${hokhau.ten_chu_ho}"
                       id="exampleFormControlInput3"
                       placeholder="Vui lòng nhập tên chủ hộ" required>

            </div>
            <div class="form-group">
                <label for="exampleFormControlInput4">Số lượng thành viên</label>
                <input type="text" name="so_luong_thanh_vien" class="form-control" value="${hokhau.so_luong_thanh_vien}"
                       id="exampleFormControlInput4"
                       placeholder="Nhập số lượng thành viên" required>

            </div>
            <div class="form-group">
                <label for="exampleFormControlInput2">Ngày làm hộ khẩu:</label>
                <input type="date" name="ngay_lap_ho_khau" class="form-control" value="${hokhau.ngay_lap_ho_khau}"
                       id="exampleFormControlInput2" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput6">Địa chỉ:</label>
                <input type="text" name="dia_chi" class="form-control" value="${hokhau.dia_chi}"
                       id="exampleFormControlInput6"
                       placeholder="Nhập địa chỉ">
            </div>

            <div class="w-100">
                <button type="submit" class="btn btn-success w-50" style="alignment: center">Lưu</button>
            </div>
        </form>
    </div>
</div>
<script src="/bootstrap520/js/bootstrap.bundle.min.js"></script>
<script src="/jquery/jquery-3.5.1.min.js"></script>
</body>
</html>
