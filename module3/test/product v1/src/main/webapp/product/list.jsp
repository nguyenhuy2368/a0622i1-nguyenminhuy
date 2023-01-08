<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 1/9/2023
  Time: 5:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="../lib/datatables/css/dataTables.bootstrap4.css">
    <style>
        .button_top {
            text-align: center;
            padding-top: 50px;
            padding-bottom: 50px;
        }

        .content_table {
            text-align: center;
        }

        .form_search {
            margin-left: 500px;
            margin-right: 500px;
        }
        tr,th,td{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="button_top">
    <a href="/product?action=create">
        <button type="button" class="btn btn-success" style="color: yellow">Create Product</button>
    </a>
    <%--<button type="button" class="btn btn-danger">Danger</button>--%>
    <%--<button type="button" class="btn btn-warning">Warning</button>--%>
    <%--<button type="button" class="btn btn-info">Info</button>--%>
    <%--<button type="button" class="btn btn-light">Light</button>--%>
    <%--<button type="button" class="btn btn-dark">Dark</button>--%>
</div>
<form class="d-flex form_search" method="post" action="/product?action=search">
    <input class="form-control me-2" type="text" placeholder="Search Name" name="name" value="${findName}"
           aria-label="Search">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>
<%--<c:if test="${id!=null}">--%>
<%--    <p>ok!! ${id}</p>--%>
<%--</c:if>--%>
<div class="content_table">
    <h3 style="color: darkred; padding-bottom: 20px">List service</h3>
    <table id="tableProduct" class="table table-hover table-bordered" style="width: 100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Count</th>
            <th>Amount</th>
            <th>Color</th>
            <th>Described</th>
            <th>Category</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="list">
            <tr>
                <td>${list.getId()}</td>
                <td>${list.getName()}</td>
                <td>${list.getCount()}</td>
                <td>${list.getAmount()}</td>
                <td>${list.getColor()}</td>
                <td>${list.getDescribed()}</td>
                <td>${list.getCategory().getName()}</td>
                <td>
                    <a href="/product?action=edit&id=${list.getId()}">
                        <button class="btn btn-warning">Edit</button>
                    </a>
                </td>
                <td>
                    <a class="btn btn-danger" href="#" role="button" data-toggle="modal"
                       data-target="#modelDelete"
                       onClick="onDelete('${list.getId()}');nameDelete('${list.getName()}')">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${listProductFindByName!=null}">
            <c:forEach items="${listProductFindByName}" var="list">
                <tr>
                    <td>${list.getId()}</td>
                    <td>${list.getName()}</td>
                    <td>${list.getCount()}</td>
                    <td>${list.getAmount()}</td>
                    <td>${list.getColor()}</td>
                    <td>${list.getDescribed()}</td>
                    <td>${list.getCategory().getName()}</td>
                    <td>
                        <a href="/product?action=edit&id=${list.getId()}">
                            <button class="btn btn-warning">Edit</button>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger" href="#" role="button" data-toggle="modal"
                           data-target="#modelDelete"
                           onClick="onDelete('${list.getId()}');nameDelete('${list.getName()}')">
                            Delete
                        </a>
                            <%--                        <a href="/product?action=delete&id=${list.getId()}">Delete</a>--%>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>

<div class="modal fade" id="model" tabindex="-1" role="dialog"
     aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Xác nhận xóa khách hàng</h5>

            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
        integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
        crossorigin="anonymous"></script>

<script src="../lib/js/jquery-3.5.1.min.js"></script>
<script src="../lib/js/bootstrap.js"></script>
<script src="../lib/datatables/js/jquery.dataTables.js"></script>
<script src="../lib/datatables/js/dataTables.bootstrap4.js"></script>
<script>
    $(document).ready(function () {
        $('#tableProduct').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            'pageLength': 3
        })
    });

    function onDelete(idDelete) {
        document.getElementById("idProduct").value = idDelete;
    }

    function nameDelete(nameDelete) {
        document.getElementById("body").innerText = "Bạn có muốn xóa: " + nameDelete + " ?";
    }
</script>
</body>
</html>
