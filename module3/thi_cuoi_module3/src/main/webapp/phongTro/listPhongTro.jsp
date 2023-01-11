<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 1/9/2023
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List Phong</title>
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css">
    <style>
        .content_table{
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-auto">
            <form>
                <input type="text" name="searchName" placeholder="searchname">
                <input type="hidden" name="action" value="search">
                <button class="btn btn-info">Search</button>
                <p></p>
                <a class="btn btn-outline-secondary" href="/testModule3?action=add">Create New Product</a>
            </form>
        </div>
    </div>
</div>

<div class="content_table"></div>
<form action="/testModule3" >
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h3 style="color: darkred;padding-bottom: 20px">List phong</h3>
                <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                    <tr>
                        <th>Ma phong tro</th>
                        <th>Ten nguoi thue</th>
                        <th>So dien thoai</th>
                        <th>Ngay thue</th>
                        <th>Hinh thuc thanh toan</th>
                        <th>Ghi chu</th>
                        <th ></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${phongTros}" var="phongTro">
                        <tr>
                            <td>${phongTro.getMaPhongTro()}</td>
                            <td>${phongTro.getTenNguoiThue()}</td>
                            <td>${phongTro.getSdt()}</td>
                            <td>${phongTro.getNgayBatDau()}</td>
                            <td>${phongTro.getIdThanhToan()}</td>
                            <c:choose>
                                <c:when test="${phongTro.getIdThanhToan()==1}">
                                    <td>Thang</td>
                                </c:when>
                                <c:when test="${phongTro.getIdThanhToan()==2}">
                                    <td>Quy</td>
                                </c:when>
                                <c:when test="${phongTro.getIdThanhToan()==3}">
                                    <td>Nam</td>
                                </c:when>
                            </c:choose>
                            <td>${phongTro.getGhiChu()}</td>
                            <td>
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#exampleModal" onclick="xoa(${phongTro.getMaPhongTro()},'${phongTro.getTenNguoiThue()}')">
                                    Delete
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
<!-- Modal -->
<form action="/testModule3">
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Bạn có chắc chắn muốn xóa <span id="nameUser"></span> ????
                    <input hidden name="id" id = "idDelete">
                    <input hidden name="action" value="delete">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                    </button>
                    <button type="submit" class="btn btn-primary">Ok</button>
                </div>
            </div>
        </div>
    </div>
</form>

</div>
<script>
    function xoa(id,name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameUser").innerText = name;
    }
</script>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>

<script src="/bootstrap520/js/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableStudent').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
</body>
</html>
