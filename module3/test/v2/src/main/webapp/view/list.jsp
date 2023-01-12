<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 1/9/2023
  Time: 1:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css">
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body>
<h2>Danh Sách Hộ Khẩu</h2>
<a href="/hokhau?action=create"><input type="button" value="Thêm mới"></a>
<table id="tableHoKhau" class="table table-striped table-bordered col" style="width: 100%">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Mã Hộ Khẩu</th>
        <th scope="col">Tên chủ hộ</th>
        <th scope="col">Số Lượng thành viên</th>
        <th scope="col">Ngày lập hộ khẩu</th>
        <th scope="col">Địa chỉ nhà</th>
        <th scope="col">Chức năng</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hoKhauList}" var="hoKhau">
        <tr>
            <td scope="row">${hoKhau.stt}</td>
            <td>${hoKhau.ma_ho_khau}</td>
            <td>${hoKhau.ten_chu_ho}</td>
            <td>${hoKhau.so_luong_thanh_vien}</td>
            <td>${hoKhau.ngay_lap_ho_khau}</td>
            <td>${hoKhau.dia_chi}</td>
            <td>
                <a href="/hokhau?action=update&stt=${hoKhau.stt}"><input type="button"
                                                                         value="Sửa"></a>
            </td>
            <td>
                <a href="/hokhau?action=update&stt=${hoKhau.stt}"><input type="button"
                                                                         value="Xem thành viên"></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>


<script>
    $(document).ready(function () {
        $('#tableHoKhau').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
