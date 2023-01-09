<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/07/2021
  Time: 12:55 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>View All</title>
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
                <h3 style="color: darkred;padding-bottom: 20px">List product</h3>
                <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                    <tr>
                        <th>ProductID</th>
                        <th>ProductName</th>
                        <th>ProductPrice</th>
                        <th>ProductQuantity</th>
                        <th>ProductColor</th>
                        <th>ProductDescription</th>
                        <th>ProductCategoryID</th>
                        <th colspan="2">Functions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.getProductId()}</td>
                            <td>${product.getProductName()}</td>
                            <td>${product.getProductPrice()}</td>
                            <td>${product.getProductQuantity()}</td>
                            <td>${product.getColor()}</td>
                            <td>${product.getProductDescription()}</td>
                            <td>${product.getCategoryId()}</td>
                            <td><a class="btn btn-secondary" href="/testModule3?action=update&productId=${product.getProductId()}">Update</a></td>
                            <td>
                                <a class="btn btn-danger" href="/testModule3?action=delete&productId=${product.getProductId()}">Delete</a>

                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
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
