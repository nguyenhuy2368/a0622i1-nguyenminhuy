<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 1/8/2023
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nguyen Minh Huy</title>
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css">
    <style>
        [class*="col-"] {
            float: left;
            padding: 5px;
        }
        .avatar {
            display: inline-block;
            vertical-align: middle;
            position: relative;
            border-radius: 50%;
            height: 40px;
            width: 40px;
        }
        .avatar_letters {
            left: 50%;
            position: absolute;
            top: 50%;
            transform: translate(-50%, -50%);
        }
        .gradient-header {
            background: #6a85b6;
            background: -webkit-linear-gradient(to right, rgba(106, 133, 182, 0.5), rgba(186, 200, 224, 0.5));
            background: linear-gradient(to right, rgba(106, 133, 182, 0.5), rgba(186, 200, 224, 0.5))
        }
        .gradient-body {
            background: #30cfd0;
            background: -webkit-linear-gradient(to left, rgba(48, 207, 208, 0.5), rgba(51, 8, 103, 0.5));
            background: linear-gradient(to left, rgba(48, 207, 208, 0.5), rgba(51, 8, 103, 0.5))
        }
        .gradient-footer {
            background: #30cfd0;
            background: -webkit-linear-gradient(to right, rgba(48, 207, 208, 0.5), rgba(51, 8, 103, 0.5));
            background: linear-gradient(to right, rgba(48, 207, 208, 0.5), rgba(51, 8, 103, 0.5))
        }
        .list-group-item a:hover {
            color: red;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-12 gradient-header p-2 text-light bg-opacity-25">
        <div class="col-lg-3 px-5 py-2">
        </div>
        <div class="col-lg-3 text-success py-3">
        </div>
        <div class="col-lg-3 text-success py-4">
        </div>
        <div class="col-lg-3 text-end p-5 fw-bold text-success">Nguyen Minh Huy
            <div class="avatar bg-success ms-2">
                <div class="avatar_letters text-light">H</div>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="col-lg-12 bg-success gradient-body">
        <nav class="navbar navbar-expand-lg bg-success p-2 text-light gradient-body">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarTogglerDemo03"
                        aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href="#"> </a>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                    <a class="nav-link text-light" href="/hokhaus">Ho Khau</a>
                    <form class="d-flex" style="margin-bottom: auto; height: 38px;">
                        <label><input class="form-control me-2" type="search" placeholder="Search"
                                      name="nameFind"></label>
                        <input class="btn bg-light text-success ms-1" type="submit" name="action" value="Search">
                    </form>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container-fluid">
    <div class="col-lg-12 gradient-header">
        <div class="text-center gradient-custom" style="width: 100%; height: auto">
            <div align="center">
                <caption><h2>List of Ho Khau</h2>
                    <a class="btn btn-outline-secondary"
                       href="/hokhaus?action=create">Create New Ho Khau</a>
                </caption>
                <table id="tableStudent" class="container-fluid table table-hover">
                    <thead>
                    <tr>
                        <th>Ma Ho Khau</th>
                        <th>Tên Chủ Hộ</th>
                        <th>Số Thành Viên</th>
                        <th>Ngày Lập Hộ Khẩu</th>
                        <th>Địa Chỉ</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${hoKhaus}" var="hoKhau">
                        <tr>
                            <td>${hoKhau.maHoKhau}</td>
                            <td>${hoKhau.tenChuHo}</td>
                            <td>${hoKhau.soThanhVien}</td>
                            <td>${hoKhau.ngayLapHoKhau}</td>
                            <td>${hoKhau.diaChi}</td>
                            <td>
                                <a class="btn btn-outline-secondary" style="width: 71px">Edit</a>
                                <button class="btn btn-outline-secondary" type="button"
                                        onclick="infoDelete('${hoKhau.maHoKhau}','${hoKhau.tenChuHo}')"
                                        data-bs-toggle="modal" data-bs-target="#exampleModal">Delete
                                </button>
                            </td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%--Modal--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form method="post" action="/hokhaus?action=delete">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Are You Sure ?</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden name="idDelete" id="idDelete">
                    <input type="text" hidden name="action" value="delete">
                    <span>Do You Want To Delete Customer: </span>
                    <span id="nameDelete"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="container-fluid">
    <div class="col-lg-12 border border-1 text-center fw-bold gradient-footer">Sdt:0123456789</div>
</div>

<script>
    function infoDelete(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText = name;
    }
</script>

<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>

<script src="/bootstrap520/js/bootstrap.bundle.min.js"></script>

<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        });
    });
</script>
</body>
</html>
