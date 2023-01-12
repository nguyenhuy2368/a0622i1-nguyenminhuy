<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 1/8/2023
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
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
                    <form class="d-flex" role="search" style="margin-bottom: auto; height: 38px;">
                        <label><input class="form-control me-2" type="search" placeholder="Search"></label>
                        <button class="btn bg-light text-success ms-1" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container-fluid">
    <div class="col-lg-12 gradient-header">
        <div class="col-lg-8 border border-2 text-center gradient-custom" style="width: 100%; height: auto">
            <form method="post" class="d-flex justify-content-center">
                <fieldset>
                    <legend><h4>Edit Hộ Khẩu Information</h4></legend>
                    <table>
                        <tr>
                            <td>
                                <div class="input-group flex-nowrap">
                                    <span class="input-group-text">Tên Chủ Hộ</span>
                                    <input type="text" class="form-control" name="tenChuHo"
                                           value="${hoKhau.getTenChuHo()}">
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div class="input-group flex-nowrap">
                                    <span class="input-group-text">So Thanh Vien</span>
                                    <input type="text" class="form-control" name="soThanhVien"
                                           value="${hoKhau.getSoThanhVien()}">
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div class="input-group flex-nowrap">
                                    <span class="input-group-text">Ngày Lập Hộ Khẩu</span>
                                    <input type="date" class="form-control" name="ngayLapHoKhau"
                                           value="${hoKhau.getNgayLapHoKhau()}">
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div class="input-group flex-nowrap">
                                    <span class="input-group-text">Địa CHỉ</span>
                                    <input type="text" class="form-control" name="diaChi" value="${hoKhau.getDiaChi()}">
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <div class="col-12">
                                <td>
                                    <div class="vstack gap-2 col-12 mx-6">
                                        <input type="submit" class="btn btn-secondary" value="Edit">
                                        <a href="/hokhaus?action=list">
                                            <button type="button" class="btn btn-outline-secondary col-12"
                                                    class="text-decoration-none text-secondary">Cancel
                                            </button>
                                        </a>
                                    </div>
                                </td>
                            </div>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="col-lg-12 border border-1 text-center fw-bold gradient-footer">Footer</div>
</div>

<script src="/bootstrap520/js/bootstrap.bundle.min.js"></script>
</body>
</html>
