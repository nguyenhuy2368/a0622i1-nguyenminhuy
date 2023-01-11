<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 1/9/2023
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Them moi</title>
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css">
</head>
<body>
<div class="content_table">
    <div class="container">
        <div class="row col-lg-12">
            <form method="post">
                <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                    <tr>
                        <th>Ten nguoi thue</th>
                        <th>So dien thoai</th>
                        <th>Ngay thue</th>
                        <th>Hinh thuc thanh toan</th>
                        <th>Ghi chu</th>
                    </tr>
                    <tr>
                        <td><input type="text" name="tenNguoiThue" size="20" value="${requestScope["phongTro"].getProductName()}"></td>
                        <td><input type="text" name="sdt" size="20" value="${requestScope["phongTro"].getProductPrice()}"></td>
                        <td><input type="date" required name="ngayBatDau" size="20" value="${requestScope["phongTro"].getProductQuantity()}"></td>
                        <td><input type="text" name="idThanhToan" size="20" value="${requestScope["phongTro"].getColor()}"></td>
                        <td><input type="text" name="ghiChu" size="20" value="${requestScope["phongTro"].getProductDescription()}"></td>
                    </tr>
                    <tr>
                        <td colspan="6"><input type="submit" value="Create" class="btn btn-success"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>

<script src="/bootstrap520/js/bootstrap.bundle.min.js"></script>
</body>
</html>
