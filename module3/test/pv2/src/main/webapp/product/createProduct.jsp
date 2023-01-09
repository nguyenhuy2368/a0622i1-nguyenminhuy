<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/07/2021
  Time: 12:53 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ADD Product</title>
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css">
</head>
<div class="content_table">
    <div class="container">
        <div class="row col-lg-12">
            <form method="post">
                <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                    <tr>
                        <th>ProductName</th>
                        <th>ProductPrice</th>
                        <th>ProductQuantity</th>
                        <th>ProductColor</th>
                        <th>ProductDescription</th>
                        <th>ProductCategoryID</th>
                    </tr>
                    <tr>
                        <td><input type="text" name="productName" size="20" value="${requestScope["product"].getProductName()}"></td>
                        <td><input type="text" name="productPrice" size="20" value="${requestScope["product"].getProductPrice()}"></td>
                        <td><input type="text" name="productQuantity" size="20" value="${requestScope["product"].getProductQuantity()}"></td>
                        <td><input type="text" name="productColor" size="20" value="${requestScope["product"].getColor()}"></td>
                        <td><input type="text" name="productDescription" size="20" value="${requestScope["product"].getProductDescription()}"></td>
                        <td><input type="text" name="productCategoryId" size="20" value="${requestScope["product"].getCategoryId()}"></td>
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